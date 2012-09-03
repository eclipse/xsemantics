package it.xsemantics.dsl.validation;

import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.util.XsemanticsXExpressionHelper;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class XsemanticsJavaValidator extends AbstractXsemanticsJavaValidator {

	@Inject
	protected XsemanticsTypeSystem typeSystem;

	@Inject
	protected XsemanticsUtils xsemanticsUtils;

	@Inject
	protected XsemanticsJavaValidatorHelper helper;

	@Inject
	protected XsemanticsXExpressionHelper xExpressionHelper;

	@Inject
	protected XsemanticsNodeModelUtils nodeModelUtils;

	public final static int maxOfOutputParams = 2;

	protected boolean enableWarnings = true;

	@Override
	@Check
	public void checkAssignment(XAssignment assignment) {
		// we allow assignment to output parameters
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof JvmFormalParameter) {
			if (xsemanticsUtils
					.isInputParam((JvmFormalParameter) assignmentFeature)) {
				error("Assignment to input parameter",
						Literals.XASSIGNMENT__ASSIGNABLE,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						IssueCodes.ASSIGNMENT_TO_INPUT_PARAM);
			}
			return;
		}
		super.checkAssignment(assignment);
	}

	@Override
	@Check
	public void checkReturn(XReturnExpression expr) {
		error("Return statements are not allowed here", expr, null,
				IssueCodes.RETURN_NOT_ALLOWED);
	}

	@Override
	@Check
	public void checkImplicitReturn(XExpression expr) {
		// we will deal with this during generation
		return;
	}

	@Check
	public void checkThrow(XThrowExpression expr) {
		error("Throw statements are not allowed here", expr, null,
				IssueCodes.THROW_NOT_ALLOWED);
	}

	@Override
	protected boolean isLocallyUsed(EObject target, EObject containerToFindUsage) {
		if (containerToFindUsage instanceof RuleInvocationExpression) {
			// we don't want warning when a variable declaration appears as
			// output argument: it is implicitly used for the result
			return true;
		}
		return super.isLocallyUsed(target, containerToFindUsage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.xbase.validation.XbaseJavaValidator#
	 * isValueExpectedRecursive(org.eclipse.xtext.xbase.XExpression)
	 */
	@Override
	protected boolean isValueExpectedRecursive(XExpression expr) {
		// this is used by Xbase validator to check expressions with
		// side effects, by inspecting expr's container
		// so we must customize it when the container is one of our
		// custom XExpressions
		final boolean valueExpectedRecursive = super
				.isValueExpectedRecursive(expr);
		return valueExpectedRecursive
				|| xExpressionHelper.isXsemanticsXExpression(expr.eContainer());
	}

	@Check
	public void checkJudgmentDescription(JudgmentDescription judgmentDescription) {
		checkNoDuplicateJudgmentDescriptionSymbols(judgmentDescription);
		checkNumOfOutputParams(judgmentDescription);
		checkNumOfInputParams(judgmentDescription);
	}

	@Check
	public void checkJudgmentDescriptionHasRules(
			JudgmentDescription judgmentDescription) {
		if (enableWarnings
				&& xsemanticsUtils.rulesForJudgmentDescription(
						judgmentDescription).isEmpty()) {
			warning("No rule defined for the judgment description",
					XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION
							.getEIDAttribute(),
					IssueCodes.NO_RULE_FOR_JUDGMENT_DESCRIPTION);
		}
	}

	@Check
	public void checkRuleParameter(RuleParameter param) {
		if (helper.findDuplicateParameter(param)) {
			error("Duplicate parameter '" + param.getParameter().getName()
					+ "'",
					XsemanticsPackage.Literals.RULE_PARAMETER__PARAMETER,
					IssueCodes.DUPLICATE_PARAM_NAME);
		}
	}

	@Check
	public void checkInputParameter(InputParameter param) {
		if (helper.findDuplicateParameter(param)) {
			error("Duplicate parameter '" + param.getParameter().getName()
					+ "'",
					XsemanticsPackage.Literals.INPUT_PARAMETER__PARAMETER,
					IssueCodes.DUPLICATE_PARAM_NAME);
		}
	}

	@Check
	public void checkNoDuplicateJudgmentDescription(
			JudgmentDescription judgmentDescription) {
		if (!helper.noJudgmentDescriptionsWithTheSameName(judgmentDescription)) {
			error("Duplicate judgment '" + judgmentDescription.getName() + "'",
					XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION__NAME,
					IssueCodes.DUPLICATE_JUDGMENT_NAME);
		}
	}

	protected void checkNoDuplicateJudgmentDescriptionSymbols(
			JudgmentDescription judgmentDescription) {
		String judgmentSymbol = judgmentDescription.getJudgmentSymbol();
		List<String> relationSymbols = judgmentDescription.getRelationSymbols();
		if (xsemanticsUtils.getJudgmentDescriptions(
				xsemanticsUtils.containingTypeSystem(judgmentDescription),
				judgmentSymbol, relationSymbols).size() > 1) {
			error("Duplicate JudgmentDescription symbols: "
					+ symbolsRepresentation(judgmentSymbol, relationSymbols),
					XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL,
					IssueCodes.DUPLICATE_JUDGMENT_DESCRIPTION_SYMBOLS);
		}
	}

	protected void checkNumOfOutputParams(
			JudgmentDescription judgmentDescription) {
		if (xsemanticsUtils.outputJudgmentParameters(judgmentDescription)
				.size() > maxOfOutputParams) {
			error("No more than " + maxOfOutputParams
					+ " output parameters are handled at the moment",
					XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS,
					IssueCodes.TOO_MANY_OUTPUT_PARAMS);
		}
	}

	protected void checkNumOfInputParams(JudgmentDescription judgmentDescription) {
		if (xsemanticsUtils.inputParams(judgmentDescription).isEmpty()) {
			error("No input parameter; at least one is needed",
					XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS,
					IssueCodes.NO_INPUT_PARAM);
		}
	}

	@Check
	public void checkRule(Rule rule) {
		JudgmentDescription judgmentDescription = checkRuleConformantToJudgmentDescription(rule);
		if (judgmentDescription != null) {
			List<JudgmentParameter> judgmentParameters = judgmentDescription
					.getJudgmentParameters();
			List<RuleConclusionElement> conclusionElements = rule
					.getConclusion().getConclusionElements();
			// judgmentParameters.size() == conclusionElements.size())
			// otherwise we could not find a JudgmentDescription for the rule
			Iterator<JudgmentParameter> judgmentParametersIt = judgmentParameters
					.iterator();
			for (RuleConclusionElement ruleConclusionElement : conclusionElements) {
				if (!xsemanticsUtils.isOutputParameter(judgmentParametersIt
						.next())
						&& !(ruleConclusionElement instanceof RuleParameter)) {
					error("Must be a parameter, not an expression",
							ruleConclusionElement,
							XsemanticsPackage.Literals.RULE_CONCLUSION_ELEMENT
									.getEIDAttribute(),
							IssueCodes.NOT_PARAMETER);
				}
			}
		}
	}

	@Check
	public void checkNoCheckRulesWithTheSameName(Rule rule) {
		if (!helper.noRulesWithTheSameName(rule)) {
			error("Duplicate rule '" + rule.getName() + "'", rule,
					XsemanticsPackage.Literals.RULE__NAME,
					IssueCodes.DUPLICATE_RULE_NAME);
		}

		if (!helper.noRulesWithTheSameNameOfCheckRule(rule)) {
			error("Duplicate checkrule with the same name", rule,
					XsemanticsPackage.Literals.RULE__NAME,
					IssueCodes.DUPLICATE_RULE_NAME);
		}
	}

	@Check
	public void checkNoRulesWithTheSameName(CheckRule rule) {
		if (!helper.noCheckRulesWithTheSameName(rule)) {
			error("Duplicate checkrule '" + rule.getName() + "'", rule,
					XsemanticsPackage.Literals.CHECK_RULE__NAME,
					IssueCodes.DUPLICATE_RULE_NAME);
		}

		if (!helper.noCheckRulesWithTheSameNameOfRule(rule)) {
			error("Duplicate rule with the same name", rule,
					XsemanticsPackage.Literals.CHECK_RULE__NAME,
					IssueCodes.DUPLICATE_RULE_NAME);
		}
	}

	@Check
	public void checkValidOverride(Rule rule) {
		XsemanticsSystem system = xsemanticsUtils.containingTypeSystem(rule);
		if (system != null) {
			if (rule.isOverride()) {
				XsemanticsSystem superSystem = xsemanticsUtils
						.superSystemDefinition(system);
				if (superSystem == null) {
					error("Cannot override rule without system 'extends'",
							rule, XsemanticsPackage.Literals.RULE__OVERRIDE,
							IssueCodes.OVERRIDE_WITHOUT_SYSTEM_EXTENDS);
				} else {
					List<Rule> rulesOfTheSameKind = xsemanticsUtils
							.allRulesOfTheSameKind(superSystem, rule);
					TupleType tupleType = typeSystem.getInputTypes(rule);
					Rule ruleToOverride = null;
					for (Rule rule2 : rulesOfTheSameKind) {
						TupleType tupleType2 = typeSystem.getInputTypes(rule2);
						if (typeSystem.equals(tupleType, tupleType2)) {
							ruleToOverride = rule2;
							break;
						}
					}
					if (ruleToOverride == null) {
						error("No rule of the same kind to override: "
								+ tupleTypeRepresentation(tupleType), rule,
								XsemanticsPackage.Literals.RULE__OVERRIDE,
								IssueCodes.NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND);
					} else if (!ruleToOverride.getName().equals(rule.getName())) {
						error("Must have the same name of the rule to override: "
								+ ruleToOverride.getName(),
								rule,
								XsemanticsPackage.Literals.RULE__OVERRIDE,
								IssueCodes.OVERRIDE_RULE_MUST_HAVE_THE_SAME_NAME);
					}
				}
			}
		}
	}

	@Check
	public void checkValidOverride(CheckRule rule) {
		XsemanticsSystem system = xsemanticsUtils.containingTypeSystem(rule);
		if (system != null) {
			if (rule.isOverride()) {
				XsemanticsSystem superSystem = xsemanticsUtils
						.superSystemDefinition(system);
				if (superSystem == null) {
					error("Cannot override checkrule without system 'extends'",
							rule,
							XsemanticsPackage.Literals.CHECK_RULE__OVERRIDE,
							IssueCodes.OVERRIDE_WITHOUT_SYSTEM_EXTENDS);
				} else {
					ArrayList<CheckRule> inheritedCheckRules = xsemanticsUtils
							.allCheckRules(superSystem);
					CheckRule inheritedRule = null;
					for (CheckRule checkRule2 : inheritedCheckRules) {
						if (typeSystem.equals(rule.getElement().getParameter()
								.getParameterType(), checkRule2.getElement()
								.getParameter().getParameterType())
								&& rule.getName().equals(checkRule2.getName())) {
							inheritedRule = checkRule2;
						}
					}
					if (inheritedRule == null)
						error("No checkrule to override: " + rule.getName(),
								rule,
								XsemanticsPackage.Literals.CHECK_RULE__OVERRIDE,
								IssueCodes.NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND);
				}
			}
		}
	}

	@Check
	public void checkRuleInvocation(RuleInvocation ruleInvocation) {
		JudgmentDescription judgmentDescription = checkRuleInvocationConformantToJudgmentDescription(ruleInvocation);
		if (judgmentDescription != null) {
			List<JudgmentParameter> judgmentParameters = judgmentDescription
					.getJudgmentParameters();
			List<RuleInvocationExpression> invocationExpressions = ruleInvocation
					.getExpressions();
			// judgmentParamters.size() == conclusionElements.size())
			// otherwise we could not find a JudgmentDescription for the rule
			Iterator<JudgmentParameter> judgmentParametersIt = judgmentParameters
					.iterator();
			for (RuleInvocationExpression ruleInvocationExpression : invocationExpressions) {
				if (xsemanticsUtils.isOutputParameter(judgmentParametersIt
						.next())) {
					if (!xsemanticsUtils
							.validOutputArgExpression(ruleInvocationExpression)) {
						error("Not a valid argument for output parameter: "
								+ nodeModelUtils
										.getProgramText(ruleInvocationExpression),
								ruleInvocationExpression,
								XsemanticsPackage.Literals.RULE_INVOCATION_EXPRESSION__EXPRESSION,
								IssueCodes.NOT_VALID_OUTPUT_ARG);
					}
				} else {
					if (!xsemanticsUtils
							.validInputArgExpression(ruleInvocationExpression)) {
						error("Not a valid argument for input parameter: "
								+ nodeModelUtils
										.getProgramText(ruleInvocationExpression),
								ruleInvocationExpression,
								XsemanticsPackage.Literals.RULE_INVOCATION_EXPRESSION__EXPRESSION,
								IssueCodes.NOT_VALID_INPUT_ARG);
					}
				}

			}
		}
	}

	@Check
	public void checkErrorSpecification(ErrorSpecification errorSpecification) {
		XExpression source = errorSpecification.getSource();
		if (source != null) {
			JvmTypeReference sourceType = typeSystem.getType(source);
			if (!typeSystem.isEObject(sourceType, errorSpecification)) {
				error("Not an EObject: " + getNameOfTypes(sourceType),
						XsemanticsPackage.Literals.ERROR_SPECIFICATION__SOURCE,
						IssueCodes.NOT_EOBJECT);
			}
		}
		XExpression feature = errorSpecification.getFeature();
		if (feature != null) {
			JvmTypeReference featureType = typeSystem.getType(feature);
			if (!typeSystem.isEStructuralFeature(featureType,
					errorSpecification)) {
				error("Not an EStructuralFeature: "
						+ getNameOfTypes(featureType),
						XsemanticsPackage.Literals.ERROR_SPECIFICATION__FEATURE,
						IssueCodes.NOT_ESTRUCTURALFEATURE);
			}
		}
	}

	@Check
	public void checkSystem(XsemanticsSystem system) {
		JvmParameterizedTypeReference validatorExtends = system
				.getValidatorExtends();
		if (validatorExtends != null) {
			if (!typeSystem.isAbstractDeclarativeValidator(validatorExtends,
					system)) {
				error("Not an AbstractDeclarativeValidator: "
						+ getNameOfTypes(validatorExtends),
						XsemanticsPackage.Literals.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS,
						IssueCodes.NOT_VALIDATOR);
			}
		}
		JvmParameterizedTypeReference superSystem = system.getSuperSystem();
		if (superSystem != null) {
			if (!typeSystem.isValidSuperSystem(superSystem, system)) {
				error("Not an Xsemantics system: "
						+ getNameOfTypes(superSystem),
						XsemanticsPackage.Literals.XSEMANTICS_SYSTEM__SUPER_SYSTEM,
						IssueCodes.NOT_VALID_SUPER_SYSTEM);
			}
			if (validatorExtends != null) {
				error("system 'extends' cannot coexist with 'validatorExtends'",
						XsemanticsPackage.Literals.XSEMANTICS_SYSTEM__SUPER_SYSTEM,
						IssueCodes.EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS);
				error("system 'extends' cannot coexist with 'validatorExtends'",
						XsemanticsPackage.Literals.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS,
						IssueCodes.EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS);
			}
		}
		List<XsemanticsSystem> superSystems = xsemanticsUtils
				.allSuperSystemDefinitions(system);
		if (superSystems.contains(system)) {
			error("Cycle in extends relation",
					XsemanticsPackage.Literals.XSEMANTICS_SYSTEM__SUPER_SYSTEM,
					IssueCodes.CYCLIC_HIERARCHY);
		}
	}

	@Check
	protected void checkNoDuplicateRulesWithSameArguments(Rule rule) {
		List<Rule> rulesOfTheSameKind = xsemanticsUtils
				.allRulesOfTheSameKind(rule);
		if (rulesOfTheSameKind.size() > 1) {
			TupleType tupleType = typeSystem.getInputTypes(rule);
			for (Rule rule2 : rulesOfTheSameKind) {
				if (rule2 != rule && !rule.isOverride()) {
					TupleType tupleType2 = typeSystem.getInputTypes(rule2);
					if (typeSystem.equals(tupleType, tupleType2)) {
						error("Duplicate rule of the same kind with parameters: "
								+ tupleTypeRepresentation(tupleType)
								+ ", in system: " + containingSystemName(rule2),
								XsemanticsPackage.Literals.RULE__CONCLUSION,
								IssueCodes.DUPLICATE_RULE_WITH_SAME_ARGUMENTS);
						break;
					}
				}
			}
		}
	}

	protected String containingSystemName(EObject object) {
		return xsemanticsUtils.containingTypeSystem(object).getName();
	}

	protected JudgmentDescription checkRuleConformantToJudgmentDescription(
			Rule rule) {
		RuleConclusion conclusion = rule.getConclusion();
		return checkConformanceAgainstJudgmentDescription(conclusion,
				conclusion.getJudgmentSymbol(),
				conclusion.getRelationSymbols(),
				conclusion.getConclusionElements(), "Rule conclusion",
				XsemanticsPackage.Literals.RULE__CONCLUSION,
				XsemanticsPackage.Literals.RULE_CONCLUSION_ELEMENT
						.getEIDAttribute());
	}

	protected JudgmentDescription checkRuleInvocationConformantToJudgmentDescription(
			RuleInvocation ruleInvocation) {
		return checkConformanceAgainstJudgmentDescription(
				ruleInvocation,
				ruleInvocation.getJudgmentSymbol(),
				ruleInvocation.getRelationSymbols(),
				ruleInvocation.getExpressions(),
				"Rule invocation",
				XsemanticsPackage.Literals.RULE_INVOCATION.getEIDAttribute(),
				XsemanticsPackage.Literals.RULE_INVOCATION_EXPRESSION__EXPRESSION);
	}

	protected JudgmentDescription checkConformanceAgainstJudgmentDescription(
			EObject element, String judgmentSymbol,
			Iterable<String> relationSymbols,
			Iterable<? extends EObject> elements,
			final String elementDescription, EStructuralFeature elementFeature,
			EStructuralFeature conformanceFeature) {
		JudgmentDescription judgmentDescription = xsemanticsUtils
				.judgmentDescription(element, judgmentSymbol, relationSymbols);
		if (judgmentDescription == null) {
			error("No Judgment description for: "
					+ symbolsRepresentation(judgmentSymbol, relationSymbols),
					elementFeature, IssueCodes.NO_JUDGMENT_DESCRIPTION);
		} else {
			List<JudgmentParameter> judgmentParameters = judgmentDescription
					.getJudgmentParameters();
			Iterator<? extends EObject> elementsIt = elements.iterator();
			for (JudgmentParameter judgmentParameter : judgmentParameters) {
				checkConformance(judgmentParameter, elementsIt.next(),
						elementDescription, conformanceFeature);
			}
		}
		return judgmentDescription;
	}

	protected void checkConformance(JudgmentParameter judgmentParameter,
			EObject element, final String elementDescription,
			EStructuralFeature feature) {
		JvmTypeReference expected = typeSystem.getType(judgmentParameter);
		JvmTypeReference actual = typeSystem.getType(element);
		if (!typeSystem.isConformant(expected, actual)) {
			error(elementDescription + " type " + getNameOfTypes(actual)
					+ " is not subtype of JudgmentDescription declared type "
					+ getNameOfTypes(expected), element, feature,
					IssueCodes.NOT_SUBTYPE);
		}
	}

	protected String symbolsRepresentation(String judgmentSymbol,
			Iterable<String> relationSymbols) {
		return judgmentSymbol + " "
				+ IterableExtensions.join(relationSymbols, " ");
	}

	protected String tupleTypeRepresentation(TupleType tupleType) {
		StringBuilder builder = new StringBuilder();
		Iterator<JvmTypeReference> it = tupleType.iterator();
		while (it.hasNext()) {
			builder.append(getNameOfTypes(it.next()));
			if (it.hasNext())
				builder.append(", ");
		}
		return builder.toString();
	}

	public boolean isEnableWarnings() {
		return enableWarnings;
	}

	public void setEnableWarnings(boolean enableWarnings) {
		this.enableWarnings = enableWarnings;
	}

}
