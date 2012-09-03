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
}
