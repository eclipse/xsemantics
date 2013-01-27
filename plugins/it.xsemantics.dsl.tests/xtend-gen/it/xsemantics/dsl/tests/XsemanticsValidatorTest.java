package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.validation.IssueCodes;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProviderCustom.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsValidatorTest extends XsemanticsBaseTest {
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testCyclicHierarchy() {
    CharSequence _testSystemBaseWithCycle = this.testFiles.testSystemBaseWithCycle();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_testSystemBaseWithCycle, _testSystemExtendsSystemWithJudgmentsReferringToEcore);
    CharSequence _testSystemBaseWithCycle2 = this.testFiles.testSystemBaseWithCycle2();
    XsemanticsSystem _parseWithBaseSystem_1 = this.parseWithBaseSystem(_parseWithBaseSystem, _testSystemBaseWithCycle2);
    EClass _xsemanticsSystem = XsemanticsPackage.eINSTANCE.getXsemanticsSystem();
    this._validationTestHelper.assertError(_parseWithBaseSystem_1, _xsemanticsSystem, 
      IssueCodes.CYCLIC_HIERARCHY, 
      "Cycle in extends relation");
  }
  
  @Test
  public void testSystemExtendsWithValidatorExtends() {
    CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
    CharSequence _testSystemExtendsWithValidatorExtends = this.testFiles.testSystemExtendsWithValidatorExtends();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_testJudgmentDescriptions, _testSystemExtendsWithValidatorExtends);
    EClass _xsemanticsSystem = XsemanticsPackage.eINSTANCE.getXsemanticsSystem();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _xsemanticsSystem, 
      IssueCodes.EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS, 
      "system \'extends\' cannot coexist with \'validatorExtends\'");
  }
  
  @Test
  public void testInvalidRuleOverrideWithoutSystemExtends() {
    CharSequence _testInvalidRuleOverrideWithoutSystemExtends = this.testFiles.testInvalidRuleOverrideWithoutSystemExtends();
    final XsemanticsSystem ts = this.parse(_testInvalidRuleOverrideWithoutSystemExtends);
    EClass _rule = XsemanticsPackage.eINSTANCE.getRule();
    this._validationTestHelper.assertError(ts, _rule, 
      IssueCodes.OVERRIDE_WITHOUT_SYSTEM_EXTENDS, 
      "Cannot override rule without system \'extends\'");
    EClass _checkRule = XsemanticsPackage.eINSTANCE.getCheckRule();
    this._validationTestHelper.assertError(ts, _checkRule, 
      IssueCodes.OVERRIDE_WITHOUT_SYSTEM_EXTENDS, 
      "Cannot override checkrule without system \'extends\'");
  }
  
  @Test
  public void testDuplicateRuleOfTheSameKindFromBaseSystem() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testDuplicateRuleOfTheSameKindFromSuperSystem = this.testFiles.testDuplicateRuleOfTheSameKindFromSuperSystem();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testDuplicateRuleOfTheSameKindFromSuperSystem);
    EClass _rule = XsemanticsPackage.eINSTANCE.getRule();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _rule, 
      IssueCodes.DUPLICATE_RULE_WITH_SAME_ARGUMENTS, 
      "Duplicate rule of the same kind with parameters: org.eclipse.emf.ecore.EObject, in system: it.xsemantics.test.ExtendedTypeSystem2");
  }
  
  @Test
  public void testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName = this.testFiles.testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName);
    EClass _rule = XsemanticsPackage.eINSTANCE.getRule();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _rule, 
      IssueCodes.DUPLICATE_RULE_WITH_SAME_ARGUMENTS, 
      "Duplicate rule of the same kind with parameters: org.eclipse.emf.ecore.EObject, in system: it.xsemantics.test.ExtendedTypeSystem2");
  }
  
  @Test
  public void testDuplicateCheckRuleOfTheSameKindFromBaseSystem() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testDuplicateCheckRuleOfTheSameKindFromSuperSystem = this.testFiles.testDuplicateCheckRuleOfTheSameKindFromSuperSystem();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testDuplicateCheckRuleOfTheSameKindFromSuperSystem);
    EClass _checkRule = XsemanticsPackage.eINSTANCE.getCheckRule();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _checkRule, 
      IssueCodes.DUPLICATE_RULE_NAME, 
      "Duplicate checkrule with the same name, in system: it.xsemantics.test.ExtendedTypeSystem2");
  }
  
  @Test
  public void testNoRuleOfTheSameKindToOverride() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testNoRuleOfTheSameKindToOverride = this.testFiles.testNoRuleOfTheSameKindToOverride();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testNoRuleOfTheSameKindToOverride);
    EClass _rule = XsemanticsPackage.eINSTANCE.getRule();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _rule, 
      IssueCodes.NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND, 
      "No rule of the same kind to override: org.eclipse.emf.ecore.EClass");
  }
  
  @Test
  public void testOverrideRuleWithDifferentName() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testOverrideRuleWithDifferentName = this.testFiles.testOverrideRuleWithDifferentName();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testOverrideRuleWithDifferentName);
    EClass _rule = XsemanticsPackage.eINSTANCE.getRule();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _rule, 
      IssueCodes.OVERRIDE_RULE_MUST_HAVE_THE_SAME_NAME, 
      "Must have the same name of the rule to override: FromTypeSystem");
  }
  
  @Test
  public void testNoCheckRuleToOverride() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testNoCheckRuleToOverride = this.testFiles.testNoCheckRuleToOverride();
    final XsemanticsSystem ts = this.parseWithBaseSystem(_loadBaseSystems, _testNoCheckRuleToOverride);
    EClass _checkRule = XsemanticsPackage.eINSTANCE.getCheckRule();
    this._validationTestHelper.assertError(ts, _checkRule, 
      IssueCodes.NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND, 
      "No checkrule to override: WrongCheckEObject");
    EClass _checkRule_1 = XsemanticsPackage.eINSTANCE.getCheckRule();
    this._validationTestHelper.assertError(ts, _checkRule_1, 
      IssueCodes.NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND, 
      "No checkrule to override: CheckEObject");
  }
  
  @Test
  public void testInvalidJudgmentWithTheSameNameOfBaseSystem() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testInvalidJudgmentWithTheSameNameOfBaseSystem = this.testFiles.testInvalidJudgmentWithTheSameNameOfBaseSystem();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_loadBaseSystems, _testInvalidJudgmentWithTheSameNameOfBaseSystem);
    EClass _judgmentDescription = XsemanticsPackage.eINSTANCE.getJudgmentDescription();
    this._validationTestHelper.assertError(_parseWithBaseSystem, _judgmentDescription, 
      IssueCodes.DUPLICATE_JUDGMENT_NAME, 
      "Duplicate judgment \'type\', in system: it.xsemantics.test.TypeSystem");
  }
  
  @Test
  public void testInvalidJudgmentOverrideWithoutSystemExtends() {
    CharSequence _testInvalidJudgmentOverrideWithoutSystemExtends = this.testFiles.testInvalidJudgmentOverrideWithoutSystemExtends();
    final XsemanticsSystem ts = this.parse(_testInvalidJudgmentOverrideWithoutSystemExtends);
    EClass _judgmentDescription = XsemanticsPackage.eINSTANCE.getJudgmentDescription();
    this._validationTestHelper.assertError(ts, _judgmentDescription, 
      IssueCodes.OVERRIDE_WITHOUT_SYSTEM_EXTENDS, 
      "Cannot override judgment without system \'extends\'");
  }
  
  @Test
  public void testInvalidOverrideJudgment() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testInvalidOverrideJudgment = this.testFiles.testInvalidOverrideJudgment();
    final XsemanticsSystem ts = this.parseWithBaseSystem(_loadBaseSystems, _testInvalidOverrideJudgment);
    EClass _judgmentDescription = XsemanticsPackage.eINSTANCE.getJudgmentDescription();
    this._validationTestHelper.assertError(ts, _judgmentDescription, 
      IssueCodes.NO_JUDGMENT_TO_OVERRIDE_OF_THE_SAME_KIND, 
      "No judgment of the same kind to override: override type |- EObject obj : EClass c");
    EClass _judgmentDescription_1 = XsemanticsPackage.eINSTANCE.getJudgmentDescription();
    this._validationTestHelper.assertError(ts, _judgmentDescription_1, 
      IssueCodes.OVERRIDE_JUDGMENT_MUST_HAVE_THE_SAME_NAME, 
      "Must have the same name of the judgment to override: subtype");
  }
  
  @Test
  public void testNoRuleForJudgmentDescriptionOverridden() {
    XsemanticsSystem _systemExtendsSystemWithJudgmentOverride = this.systemExtendsSystemWithJudgmentOverride();
    this._validationTestHelper.assertNoIssues(_systemExtendsSystemWithJudgmentOverride);
  }
  
  @Test
  public void testDuplicateAuxiliaryDescriptions() {
    try {
      CharSequence _testDuplicateAuxiliaryDescriptions = this.testFiles.testDuplicateAuxiliaryDescriptions();
      XsemanticsSystem _parse = this.parser.parse(_testDuplicateAuxiliaryDescriptions);
      EClass _auxiliaryDescription = XsemanticsPackage.eINSTANCE.getAuxiliaryDescription();
      this._validationTestHelper.assertError(_parse, _auxiliaryDescription, 
        IssueCodes.DUPLICATE_AUXILIARY_NAME, 
        "Duplicate auxiliary description \'foo\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAuxiliaryFunctionWithWrongReturnExpression() {
    try {
      CharSequence _testAuxiliaryFunctionWithWrongReturnExpression = this.testFiles.testAuxiliaryFunctionWithWrongReturnExpression();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryFunctionWithWrongReturnExpression);
      EClass _xBlockExpression = XbasePackage.eINSTANCE.getXBlockExpression();
      this._validationTestHelper.assertError(_parse, _xBlockExpression, 
        org.eclipse.xtext.xbase.validation.IssueCodes.INCOMPATIBLE_RETURN_TYPE, 
        "Incompatible implicit return type. Expected java.lang.Boolean or boolean but was org.eclipse.emf.ecore.EClass");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAuxiliaryDescriptionWithTheSameNameOfJudgment() {
    try {
      CharSequence _testAuxiliaryDescriptionWithTheSameNameOfJudgment = this.testFiles.testAuxiliaryDescriptionWithTheSameNameOfJudgment();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryDescriptionWithTheSameNameOfJudgment);
      EClass _auxiliaryDescription = XsemanticsPackage.eINSTANCE.getAuxiliaryDescription();
      this._validationTestHelper.assertError(_parse, _auxiliaryDescription, 
        IssueCodes.DUPLICATE_AUXILIARY_NAME, 
        "Duplicate judgment with the same name \'foo\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAuxiliaryFunctionWithoutAuxiliaryDescription() {
    try {
      CharSequence _testAuxiliaryFunctionWithoutAuxiliaryDescription = this.testFiles.testAuxiliaryFunctionWithoutAuxiliaryDescription();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryFunctionWithoutAuxiliaryDescription);
      EClass _auxiliaryFunction = XsemanticsPackage.eINSTANCE.getAuxiliaryFunction();
      this._validationTestHelper.assertError(_parse, _auxiliaryFunction, 
        IssueCodes.NO_AUXDESC_FOR_AUX_FUNCTION, 
        "No auxiliary description for auxiliary function \'foobar\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNonConformantAuxiliaryFunction() {
    try {
      CharSequence _testNonConformantAuxiliaryFunction = this.testFiles.testNonConformantAuxiliaryFunction();
      final XsemanticsSystem s = this.parser.parse(_testNonConformantAuxiliaryFunction);
      EClass _auxiliaryFunction = XsemanticsPackage.eINSTANCE.getAuxiliaryFunction();
      this._validationTestHelper.assertError(s, _auxiliaryFunction, 
        IssueCodes.PARAMS_SIZE_DONT_MATCH, 
        "expected 1 parameter(s), but was 2");
      EClass _jvmFormalParameter = TypesPackage.eINSTANCE.getJvmFormalParameter();
      this._validationTestHelper.assertError(s, _jvmFormalParameter, 
        IssueCodes.NOT_SUBTYPE, 
        "parameter type org.eclipse.emf.ecore.EObject is not subtype of AuxiliaryDescription declared type org.eclipse.emf.ecore.EClass");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
