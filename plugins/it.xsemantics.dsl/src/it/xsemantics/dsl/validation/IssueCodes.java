package it.xsemantics.dsl.validation;

/**
 * @author Lorenzo Bettini
 */
public class IssueCodes {

	public static final String PREFIX = "it.xsemantics.dsl.validation.";

	public static final String DUPLICATE_JUDGMENT_DESCRIPTION_SYMBOLS = PREFIX
			+ "DuplicateJudgmentDescriptionSymbols";

	public static final String NO_JUDGMENT_DESCRIPTION = PREFIX + "NoJudgmentDescription";

	public static final String NOT_SUBTYPE = PREFIX + "NotSubtype";

	public static final String DUPLICATE_RULE_WITH_SAME_ARGUMENTS = PREFIX
			+ "DuplicateRulesWithSameArguments";

	public static final String DUPLICATE_AUXFUN_WITH_SAME_ARGUMENTS = PREFIX
			+ "DuplicateAuxFunWithSameArguments";
	
	public static final String MUST_OVERRIDE = PREFIX
			+ "MustOverride";

	public static final String DUPLICATE_NAME = PREFIX
			+ "DuplicateName";
	
	public static final String NOT_VALIDATOR = PREFIX + "NotAbstractDeclarativeValidator";
	
	public static final String NOT_PARAMETER = PREFIX + "NotParameter";
	
	public static final String NOT_VALID_OUTPUT_ARG = PREFIX + "NotValidOutputArg";
	
	public static final String NOT_VALID_INPUT_ARG = PREFIX + "NotValidInputArg";
	
	public static final String TOO_MANY_OUTPUT_PARAMS = PREFIX + "TooManyOutputParams";
	
	public static final String NO_INPUT_PARAM = PREFIX + "NoInputParam";

	public static final String ASSIGNMENT_TO_INPUT_PARAM = PREFIX + "AssignmentToInputParam";

	public static final String NO_RULE_FOR_JUDGMENT_DESCRIPTION = PREFIX + "NoRuleForJudgmentDescription";

	public static final String NO_AUXFUN_FOR_AUX_DESCRIPTION = PREFIX + "NoAuxFunForAuxiliaryDescription";

	public static final String RETURN_NOT_ALLOWED = PREFIX + "ReturnNotAllowed";

	public static final String THROW_NOT_ALLOWED = PREFIX + "ThrowNotAllowed";

	public static final String NOT_VALID_SUPER_SYSTEM = PREFIX + "NotValidSuperSystem";

	public static final String CYCLIC_HIERARCHY = PREFIX + "CyclicHierarchy";

	public static final String EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS = PREFIX + "ExtendsCannotCoexistWithValidatorExtends";

	public static final String OVERRIDE_WITHOUT_SYSTEM_EXTENDS = PREFIX + "OverrideWithoutSystemExtends";

	public static final String NOTHING_TO_OVERRIDE = PREFIX + "NothingToOverride";

	public static final String DUPLICATE_AUXILIARY_NAME = PREFIX + "DuplicateAuxiliaryDescription";

	public static final String NO_AUXDESC_FOR_AUX_FUNCTION = PREFIX + "NoAuxDescForAuxiliaryFunction";

	public static final String PARAMS_SIZE_DONT_MATCH = PREFIX + "ParamsSizeDontMatch";
	
	public static final String ACCESS_TO_OUTPUT_PARAM_WITHIN_CLOSURE = PREFIX + "AccessToOutputParamWithinClosure";
}
