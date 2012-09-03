package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.validation.IssueCodes;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
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
  
  public XsemanticsSystem loadBaseSystems() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    CharSequence _testSystemExtendsExtendedTypeSystem = this.testFiles.testSystemExtendsExtendedTypeSystem();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification, _testSystemExtendsSystemWithJudgmentsReferringToEcore, _testSystemExtendsExtendedTypeSystem);
    return _parseWithBaseSystemAndAssertNoError;
  }
}
