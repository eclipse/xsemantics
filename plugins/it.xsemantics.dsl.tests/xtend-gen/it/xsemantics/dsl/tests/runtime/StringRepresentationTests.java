package it.xsemantics.dsl.tests.runtime;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.classes.CustomStringRepresentation;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.runtime.RuleEnvironment;
import java.util.ArrayList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class StringRepresentationTests extends XsemanticsBaseTest {
  @Inject
  private CustomStringRepresentation _customStringRepresentation;
  
  @Test
  public void testRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _string = this._customStringRepresentation.string(_firstRule);
    this.assertEqualsStrings("rule EClassEObject derives G |- EClass e...", _string);
  }
  
  @Test
  public void testSimpleJavaObject() {
    String _string = this._customStringRepresentation.string("foo");
    this.assertEqualsStrings("foo", _string);
  }
  
  @Test
  public void testList() {
    ArrayList<Comparable<? extends Object>> _newArrayList = CollectionLiterals.<Comparable<? extends Object>>newArrayList("foo", Integer.valueOf(10), Boolean.valueOf(true));
    String _string = this._customStringRepresentation.string(_newArrayList);
    this.assertEqualsStrings("[foo, 10, true]", _string);
  }
  
  @Test
  public void testEmptyEnvironment() {
      CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
      this.getFirstRule(_testSimpleRule);
      RuleEnvironment _ruleEnvironment = new RuleEnvironment();
      String _string = this._customStringRepresentation.string(_ruleEnvironment);
      this.assertEqualsStrings("[]", _string);
  }
  
  @Test
  public void testEnvironmentWithMappings() {
      RuleEnvironment _ruleEnvironment = new RuleEnvironment();
      final RuleEnvironment env = _ruleEnvironment;
      env.add("foo", Integer.valueOf(1));
      EDataType _createEDataType = EcoreFactory.eINSTANCE.createEDataType();
      final EDataType e = _createEDataType;
      e.setName("myEDataType");
      env.add(e, Boolean.valueOf(true));
      String _string = this._customStringRepresentation.string(env);
      this.assertEqualsStrings("[foo <- 1, myEDataType <- true]", _string);
  }
  
  @Test
  public void testForCustom() {
      EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
      final EClass eClass = _createEClass;
      eClass.setName("myEClass");
      String _string = this._customStringRepresentation.string(eClass);
      this.assertEqualsStrings("EClass(name=myEClass)", _string);
  }
  
  @Test
  public void testProcessOnString() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("no new line");
      _builder.newLine();
      _builder.append("some new");
      _builder.newLine();
      _builder.append("lines");
      _builder.newLine();
      final CharSequence testString = _builder;
      String _string = testString.toString();
      String _string_1 = this._customStringRepresentation.string(_string);
      this.assertEqualsStrings(testString, _string_1);
  }
  
  @Test
  public void testForLongEClassifierRep() {
      EDataType _createEDataType = EcoreFactory.eINSTANCE.createEDataType();
      final EDataType e = _createEDataType;
      e.setName("myEDataType with very very very very very long desc");
      String _name = e.getName();
      String _string = this._customStringRepresentation.string(e);
      this.assertEqualsStrings(_name, _string);
  }
}
