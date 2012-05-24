package it.xsemantics.dsl.tests.runtime;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.EmfFactoryUtils;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class TraceUtilsTests extends XsemanticsBaseTest {
  @Inject
  private TraceUtils _traceUtils;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private EmfFactoryUtils _emfFactoryUtils;
  
  @Test
  public void testWithNodeModelSources() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    final List<RuleInvocation> ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = ruleInvocations.size();
    Assert.assertEquals(2, _size);
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    RuleInvocation _get = ruleInvocations.get(0);
    ErrorInformation _errorInformation = new ErrorInformation(_get);
    ex2.addErrorInformation(_errorInformation);
    EObject _createEObject = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_1 = new ErrorInformation(_createEObject);
    ex2.addErrorInformation(_errorInformation_1);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    RuleInvocation _get_1 = ruleInvocations.get(1);
    ErrorInformation _errorInformation_2 = new ErrorInformation(_get_1);
    ex1.addErrorInformation(_errorInformation_2);
    EObject _createEObject_1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_3 = new ErrorInformation(_createEObject_1);
    ex1.addErrorInformation(_errorInformation_3);
    LinkedList<ErrorInformation> _allErrorInformation = this._traceUtils.allErrorInformation(ex1);
    final LinkedList<ErrorInformation> list = this._traceUtils.removeNonNodeModelSources(_allErrorInformation);
    int _size_1 = list.size();
    Assert.assertEquals(2, _size_1);
    RuleInvocation _get_2 = ruleInvocations.get(1);
    ErrorInformation _get_3 = list.get(0);
    EObject _source = _get_3.getSource();
    Assert.assertSame(_get_2, _source);
    RuleInvocation _get_4 = ruleInvocations.get(0);
    ErrorInformation _get_5 = list.get(1);
    EObject _source_1 = _get_5.getSource();
    Assert.assertSame(_get_4, _source_1);
  }
  
  @Test
  public void testFilteredErrorInformation() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    final List<RuleInvocation> ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = ruleInvocations.size();
    Assert.assertEquals(2, _size);
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    RuleInvocation _get = ruleInvocations.get(0);
    ErrorInformation _errorInformation = new ErrorInformation(_get);
    ex2.addErrorInformation(_errorInformation);
    EObject _createEObject = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_1 = new ErrorInformation(_createEObject);
    ex2.addErrorInformation(_errorInformation_1);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    RuleInvocation _get_1 = ruleInvocations.get(1);
    ErrorInformation _errorInformation_2 = new ErrorInformation(_get_1);
    ex1.addErrorInformation(_errorInformation_2);
    RuleInvocation _get_2 = ruleInvocations.get(1);
    ErrorInformation _errorInformation_3 = new ErrorInformation(_get_2);
    ex1.addErrorInformation(_errorInformation_3);
    EObject _createEObject_1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_4 = new ErrorInformation(_createEObject_1);
    ex1.addErrorInformation(_errorInformation_4);
    final LinkedList<ErrorInformation> list = this._traceUtils.filteredErrorInformation(ex1);
    int _size_1 = list.size();
    Assert.assertEquals(2, _size_1);
    RuleInvocation _get_3 = ruleInvocations.get(1);
    ErrorInformation _get_4 = list.get(0);
    EObject _source = _get_4.getSource();
    Assert.assertSame(_get_3, _source);
    RuleInvocation _get_5 = ruleInvocations.get(0);
    ErrorInformation _get_6 = list.get(1);
    EObject _source_1 = _get_6.getSource();
    Assert.assertSame(_get_5, _source_1);
  }
  
  @Test
  public void testInnermostRuleFailedExceptionWithNodeModelSources() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    final List<RuleInvocation> ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = ruleInvocations.size();
    Assert.assertEquals(2, _size);
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex3 = _ruleFailedException;
    EObject _createEObject = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation = new ErrorInformation(_createEObject);
    ex3.addErrorInformation(_errorInformation);
    EObject _createEObject_1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_1 = new ErrorInformation(_createEObject_1);
    ex3.addErrorInformation(_errorInformation_1);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("prev", ex3);
    final RuleFailedException ex2 = _ruleFailedException_1;
    RuleInvocation _get = ruleInvocations.get(0);
    ErrorInformation _errorInformation_2 = new ErrorInformation(_get);
    ex2.addErrorInformation(_errorInformation_2);
    EObject _createEObject_2 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_3 = new ErrorInformation(_createEObject_2);
    ex2.addErrorInformation(_errorInformation_3);
    RuleFailedException _ruleFailedException_2 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_2;
    RuleInvocation _get_1 = ruleInvocations.get(1);
    ErrorInformation _errorInformation_4 = new ErrorInformation(_get_1);
    ex1.addErrorInformation(_errorInformation_4);
    RuleInvocation _get_2 = ruleInvocations.get(1);
    ErrorInformation _errorInformation_5 = new ErrorInformation(_get_2);
    ex1.addErrorInformation(_errorInformation_5);
    EObject _createEObject_3 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_6 = new ErrorInformation(_createEObject_3);
    ex1.addErrorInformation(_errorInformation_6);
    final RuleFailedException innerMost = this._traceUtils.innermostRuleFailedExceptionWithNodeModelSources(ex1);
    Assert.assertSame(ex2, innerMost);
    final LinkedList<ErrorInformation> list = this._traceUtils.filteredErrorInformation(innerMost);
    int _size_1 = list.size();
    Assert.assertEquals(1, _size_1);
    RuleInvocation _get_3 = ruleInvocations.get(0);
    ErrorInformation _get_4 = list.get(0);
    EObject _source = _get_4.getSource();
    Assert.assertSame(_get_3, _source);
  }
  
  @Test
  public void testFailureAsList() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    final LinkedList<RuleFailedException> list = this._traceUtils.failureAsList(ex1);
    RuleFailedException _get = list.get(0);
    this.assertMessage(_get, "first");
    RuleFailedException _get_1 = list.get(1);
    this.assertMessage(_get_1, "prev");
  }
  
  @Test
  public void testFailureAsListWithNullMessage() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    RuleFailedException _ruleFailedException_1 = new RuleFailedException(null, ex2);
    final RuleFailedException nullMsg = _ruleFailedException_1;
    RuleFailedException _ruleFailedException_2 = new RuleFailedException("first", nullMsg);
    final RuleFailedException ex1 = _ruleFailedException_2;
    final LinkedList<RuleFailedException> list = this._traceUtils.failureAsList(ex1);
    int _size = list.size();
    Assert.assertEquals(2, _size);
    RuleFailedException _get = list.get(0);
    this.assertMessage(_get, "first");
    RuleFailedException _get_1 = list.get(1);
    this.assertMessage(_get_1, "prev");
  }
  
  @Test
  public void testFailureAsString() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev2");
    final RuleFailedException ex3 = _ruleFailedException;
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("  prev", ex3);
    final RuleFailedException ex2 = _ruleFailedException_1;
    RuleFailedException _ruleFailedException_2 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_2;
    final String trace = this._traceUtils.failureTraceAsString(ex1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("first");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("prev");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prev2");
    this.assertEqualsStrings(_builder, trace);
  }
  
  @Test
  public void testTraceAsString() {
    RuleApplicationTrace _ruleApplicationTrace = new RuleApplicationTrace();
    final RuleApplicationTrace trace = _ruleApplicationTrace;
    trace.addToTrace("foo");
    trace.addToTrace("bar");
    RuleApplicationTrace _ruleApplicationTrace_1 = new RuleApplicationTrace();
    final RuleApplicationTrace trace2 = _ruleApplicationTrace_1;
    trace2.addToTrace("inner");
    RuleApplicationTrace _ruleApplicationTrace_2 = new RuleApplicationTrace();
    final RuleApplicationTrace trace3 = _ruleApplicationTrace_2;
    trace3.addToTrace("innerinner");
    trace2.addAsSubtrace(trace3);
    trace2.addToTrace("inner2");
    trace.addAsSubtrace(trace2);
    trace.addToTrace("foobar");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("inner");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("innerinner");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("inner2");
    _builder.newLine();
    _builder.append("foobar");
    String _traceAsString = this._traceUtils.traceAsString(trace);
    this.assertEqualsStrings(_builder, _traceAsString);
  }
  
  @Test
  public void testAllErrorInformation() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    final EObject source2 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation = new ErrorInformation(source2);
    ex2.addErrorInformation(_errorInformation);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    final EObject source1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_1 = new ErrorInformation(source1);
    ex1.addErrorInformation(_errorInformation_1);
    final LinkedList<ErrorInformation> list = this._traceUtils.allErrorInformation(ex1);
    ErrorInformation _get = list.get(0);
    EObject _source = _get.getSource();
    Assert.assertSame(source1, _source);
    ErrorInformation _get_1 = list.get(1);
    EObject _source_1 = _get_1.getSource();
    Assert.assertSame(source2, _source_1);
  }
  
  @Test
  public void testRemoveDuplicateErrorInformation() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    final EObject source2 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation = new ErrorInformation(source2);
    ex2.addErrorInformation(_errorInformation);
    ErrorInformation _errorInformation_1 = new ErrorInformation(source2);
    ex2.addErrorInformation(_errorInformation_1);
    EReference _eAttribute_EAttributeType = EcorePackage.eINSTANCE.getEAttribute_EAttributeType();
    ErrorInformation _errorInformation_2 = new ErrorInformation(source2, _eAttribute_EAttributeType);
    ex2.addErrorInformation(_errorInformation_2);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    final EObject source1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_3 = new ErrorInformation(source1);
    ex1.addErrorInformation(_errorInformation_3);
    LinkedList<ErrorInformation> _allErrorInformation = this._traceUtils.allErrorInformation(ex1);
    final List<ErrorInformation> list = this._traceUtils.removeDuplicateErrorInformation(_allErrorInformation);
    int _size = list.size();
    Assert.assertEquals(3, _size);
    ErrorInformation _get = list.get(0);
    EObject _source = _get.getSource();
    Assert.assertSame(source1, _source);
    ErrorInformation _get_1 = list.get(1);
    EObject _source_1 = _get_1.getSource();
    Assert.assertSame(source2, _source_1);
    ErrorInformation _get_2 = list.get(2);
    EObject _source_2 = _get_2.getSource();
    Assert.assertSame(source2, _source_2);
  }
  
  @Test
  public void testRemoveNonNodeModelSources() {
    RuleFailedException _ruleFailedException = new RuleFailedException("prev");
    final RuleFailedException ex2 = _ruleFailedException;
    final EObject source2 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation = new ErrorInformation(source2);
    ex2.addErrorInformation(_errorInformation);
    RuleFailedException _ruleFailedException_1 = new RuleFailedException("first", ex2);
    final RuleFailedException ex1 = _ruleFailedException_1;
    final EObject source1 = this._emfFactoryUtils.createEObject();
    ErrorInformation _errorInformation_1 = new ErrorInformation(source1);
    ex1.addErrorInformation(_errorInformation_1);
    LinkedList<ErrorInformation> _allErrorInformation = this._traceUtils.allErrorInformation(ex1);
    final LinkedList<ErrorInformation> list = this._traceUtils.removeNonNodeModelSources(_allErrorInformation);
    int _size = list.size();
    Assert.assertEquals(0, _size);
  }
  
  public void assertMessage(final RuleFailedException ex, final String message) {
    String _message = ex.getMessage();
    Assert.assertEquals(message, _message);
  }
}
