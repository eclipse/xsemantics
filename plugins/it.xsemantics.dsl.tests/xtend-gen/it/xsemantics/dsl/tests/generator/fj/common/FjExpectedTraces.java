package it.xsemantics.dsl.tests.generator.fj.common;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.util.TraceUtils;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FjExpectedTraces {
  @Inject
  @Extension
  private TraceUtils _traceUtils;
  
  @Inject
  @Extension
  private StringRepresentation _stringRepresentation;
  
  public void assertFailureTrace(final RuleFailedException e, final CharSequence expectedTrace) {
    String _string = expectedTrace.toString();
    String _trim = _string.trim();
    String _failureTraceAsString = this._traceUtils.failureTraceAsString(e);
    Assert.assertEquals(_trim, _failureTraceAsString);
  }
  
  public void assertErrorInformation(final RuleFailedException e, final CharSequence expectedErrorInformation) {
    String _string = expectedErrorInformation.toString();
    LinkedList<ErrorInformation> _filteredErrorInformation = this._traceUtils.filteredErrorInformation(e);
    final Function1<ErrorInformation,String> _function = new Function1<ErrorInformation,String>() {
        public String apply(final ErrorInformation it) {
          EObject _source = it.getSource();
          String _string = FjExpectedTraces.this._stringRepresentation.string(_source);
          String _xifexpression = null;
          EStructuralFeature _feature = it.getFeature();
          boolean _notEquals = (!Objects.equal(_feature, null));
          if (_notEquals) {
            EStructuralFeature _feature_1 = it.getFeature();
            String _name = _feature_1.getName();
            String _plus = (" feature: " + _name);
            _xifexpression = _plus;
          } else {
            _xifexpression = "";
          }
          String _plus_1 = (_string + _xifexpression);
          return _plus_1;
        }
      };
    List<String> _map = ListExtensions.<ErrorInformation, String>map(_filteredErrorInformation, _function);
    String _join = IterableExtensions.join(_map, " -- ");
    Assert.assertEquals(_string, _join);
  }
  
  public void assertTrace(final RuleApplicationTrace trace, final CharSequence expectedTrace) {
    String _string = expectedTrace.toString();
    String _trim = _string.trim();
    String _traceAsString = this._traceUtils.traceAsString(trace);
    Assert.assertEquals(_trim, _traceAsString);
  }
  
  public CharSequence okSubclasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Subclassing: [] |- class B extends A { } <| class A { }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    return _builder;
  }
  
  public CharSequence failSubclasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: Subclassing: [] |- class A { } <| class B extends A { }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence failSubtypesBasic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: BasicSubtyping: [] |- String <: int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence failSubtypesClasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: ClassSubtyping: [] |- A <: B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: Subclassing: [] |- class A { } <| class B extends A { }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence failEqualsBasicType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: BasicEquals: [] |- String ~~ int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence failEqualsClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: ClassEquals: [] |- A ~~ B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.classref == right.classref");
    return _builder;
  }
  
  public CharSequence okSubtypesClasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Subclassing: [] |- class B extends A { } <| class A { }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    return _builder;
  }
  
  public CharSequence variableType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TParamRef: [] |- param : String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TTypedElement: [] ||- String param : String");
    return _builder;
  }
  
  public CharSequence failThisDueToNullEnvironment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: TThis: [] |- this : ClassType");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("access to null environment");
    return _builder;
  }
  
  public CharSequence failThisDueToNotClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: TThis: [this <- foo] |- this : ClassType");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("mapped value foo cannot be assigned to ClassType");
    return _builder;
  }
  
  public CharSequence methodCallType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A().m(\'foo\') : String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TTypedElement: [] ||- String m(String param) { return param; } : String");
    return _builder;
  }
  
  public CharSequence fieldSelectionType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A(10).f : int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TTypedElement: [] ||- int f; : int");
    return _builder;
  }
  
  public CharSequence newType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TNew: [] |- new B() : B");
    return _builder;
  }
  
  public CharSequence failClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: TExpressionClassType: [] ||~ \'foo\' : ClassType");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("String cannot be assigned to ClassType");
    return _builder;
  }
  
  public CharSequence classType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TExpressionClassType: [] ||~ new A() : A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    return _builder;
  }
  
  public CharSequence castType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TCast: [] |- (B) new A() : B");
    return _builder;
  }
  
  public CharSequence methodCheckOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckMethod: [] |- String m(String param) { return param; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TParamRef: [this <- A] |- param : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [this <- A] ||- String param : String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckParamRef: [this <- A] |- param");
    return _builder;
  }
  
  public CharSequence methodCheckOkWithThis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckMethod: [] |- A m() { return this.n(); }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TSelection: [this <- B] |- this.n() : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [this <- B] ||- B n() { return new B(); } : B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Subclassing: [] |- class B extends A { A m() { return this.... <| class A { }");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckSelection: [this <- B] |- this.n()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckThis: [this <- B] |- this");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [this <- B] |- this.n() : [] << []");
    return _builder;
  }
  
  public CharSequence methodCheckBodyNotSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckMethod: [] |- int m(String param) { return new A(param...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: BasicSubtyping: [] |- String <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence methodCallCheckOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckSelection: [] |- new B().m(new B(), new B(), 10)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B() : [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new B().m(new B(), new B(), 10) : [new B(), new B(), 10] << [B b, A a, int i]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TNew: [] |- new B() : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- B b : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ClassSubtyping: [] |- B <: B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { int m(B b, A a, int ... <| class B extends A { int m(B b, A a, int ...");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TNew: [] |- new B() : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- A a : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { int m(B b, A a, int ... <| class A { }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- int i : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B() : [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B() : [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- 10");
    return _builder;
  }
  
  public CharSequence newCheckOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckNew: [] |- new C(10, \'foo\', new B(20, \'bar\'))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Fields: [] ||- class C extends B { A c; } >> [int i;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class C extends B { A c; }) = [class B extends A { String s; }, class A { int i; }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new C(10, \'foo\', new B(20, \'bar\')) : [10, \'foo\', new B(20, \'bar\')] << [int i;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- int i; : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TStringConstant: [] |- \'foo\' : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- String s; : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TNew: [] |- new B(20, \'bar\') : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- A c; : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { String s; } <| class A { int i; }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Subclassing: [] |- class A { int i; } <| class A { int i; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- 10");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- \'foo\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B(20, \'bar\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Fields: [] ||- class B extends A { String s; } >> [int i;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class B extends A { String s; }) = [class A { int i; }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B(20, \'bar\') : [20, \'bar\'] << [int i;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TIntConstant: [] |- 20 : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TTypedElement: [] ||- int i; : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TStringConstant: [] |- \'bar\' : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TTypedElement: [] ||- String s; : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [] |- 20");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [] |- \'bar\' ");
    return _builder;
  }
  
  public CharSequence newCheckOk2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckNew: [] |- new C(10, true, \'foo\', new B(20, false, ...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Fields: [] ||- class C extends B { A c; } >> [int i;, boolean b;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class C extends B { A c; }) = [class B extends A { String s; }, class A { int i; boolean b; }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new C(10, true, \'foo\', new B(20, false, ... : [10, true, \'foo\', new B(20, false, \'bar\')] << [int i;, boolean b;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- int i; : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TBoolConstant: [] |- true : boolean");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- boolean b; : boolean");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- boolean <: boolean");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TStringConstant: [] |- \'foo\' : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- String s; : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TNew: [] |- new B(20, false, \'bar\') : B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TTypedElement: [] ||- A c; : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { String s; } <| class A { int i; boolean b; }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Subclassing: [] |- class A { int i; boolean b; } <| class A { int i; boolean b; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- 10");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- true");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckConstant: [] |- \'foo\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B(20, false, \'bar\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Fields: [] ||- class B extends A { String s; } >> [int i;, boolean b;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class B extends A { String s; }) = [class A { int i; boolean b; }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B(20, false, \'bar\') : [20, false, \'bar\'] << [int i;, boolean b;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TIntConstant: [] |- 20 : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TTypedElement: [] ||- int i; : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TBoolConstant: [] |- false : boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TTypedElement: [] ||- boolean b; : boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- boolean <: boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TStringConstant: [] |- \'bar\' : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TTypedElement: [] ||- String s; : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [] |- 20");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [] |- false");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [] |- \'bar\' ");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtypeSimpler() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new A(\'foo\')");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: SubtypeSequence: [] |- new A(\'foo\') : [\'foo\'] << [int i;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: BasicSubtyping: [] |- String <: int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence newCheckWrongArgNum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new C(10, \'foo\', new B(20, \'bar\', 1))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: CheckNew: [] |- new B(20, \'bar\', 1)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: SubtypeSequence: [] |- new B(20, \'bar\', 1) : [20, \'bar\', 1] << [int i;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: expressions.size == typedElements.size");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new C(10, \'foo\', new C(20, \'bar\', new D(...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: CheckNew: [] |- new C(20, \'bar\', new D())");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: SubtypeSequence: [] |- new C(20, \'bar\', new D()) : [20, \'bar\', new D()] << [int i;, String s;, A c;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: ClassSubtyping: [] |- D <: A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: Subclassing: [] |- class D {} <| class A { int i; }");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtypeBasic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new C(10, 10, new B(20, \'bar\'))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: SubtypeSequence: [] |- new C(10, 10, new B(20, \'bar\')) : [10, 10, new B(20, \'bar\')] << [int i;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: BasicSubtyping: [] |- int <: String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence subclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckClass: [] |- class B extends A { String s; int i; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: field.name != inheritedField.name");
    return _builder;
  }
  
  public CharSequence subclassOkWRTFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { String s; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("superclasses(class B extends A { String s; }) = [class A { int i; }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Fields: [] ||- class A { int i; } >> [int i;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class A { int i; }) = []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Methods: [] ||~ class A { int i; } >> []");
    return _builder;
  }
  
  public CharSequence castOk1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckCast: [] |- (C) new A()");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- C <: A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Subclassing: [] |- class C extends B { } <| class A { }");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { } <| class A { }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    return _builder;
  }
  
  public CharSequence castOk2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckCast: [] |- (A) new C()");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new C() : C");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- C <: A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Subclassing: [] |- class C extends B { } <| class A { }");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Subclassing: [] |- class B extends A { } <| class A { }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Subclassing: [] |- class A { } <| class A { }");
    return _builder;
  }
  
  public CharSequence castWrong() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckCast: [] |- (D) new C()");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: ClassSubtyping: [] |- C <: D");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: Subclassing: [] |- class C extends B { } <| class D {}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: Subclassing: [] |- class B extends A { } <| class D {}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: Subclassing: [] |- class A { } <| class D {}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence subclassNotOvverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckClass: [] |- class C extends A { boolean m(String s) ...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: BasicEquals: [] |- boolean ~~ int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence subclassOverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { int m(String s) { re...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("superclasses(class B extends A { int m(String s) { re...) = [class A { int m(String s) { return 10; }...]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Fields: [] ||- class A { int m(String s) { return 10; }... >> []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class A { int m(String s) { return 10; }...) = []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Methods: [] ||~ class A { int m(String s) { return 10; }... >> [int m(String s) { return 10; }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("BasicEquals: [] |- int ~~ int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("BasicEquals: [] |- String ~~ String");
    return _builder;
  }
  
  public CharSequence validateCheckNewWrongSubtypeSimpler() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.BasicSubtyping \"failed: BasicSubtyping: [] |- String <: int\" at Program.classes[0]->Class\'A\'.members[0]->Field\'i\'.type->BasicType");
    return _builder;
  }
  
  public CharSequence validateCheckNewWrongArgNum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.SubtypeSequence \"failed: SubtypeSequence: [] |- new B(20, \'bar\', 1) : [20, \'bar\', 1] << [int i;, String s;]\" at Program.main->New.args[2]->New");
    return _builder;
  }
  
  public CharSequence validateSubclassNotOverrideMethodChangingReturnType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("NOT IMPLEMENTED");
    return _builder;
  }
  
  public CharSequence validateCyclicClassHierarchy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.CheckClass \"failed: CheckClass: [] |- class A extends C { }\" at Program.classes[0]->Class\'A\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.CheckClass \"failed: CheckClass: [] |- class B extends A { }\" at Program.classes[1]->Class\'B\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.CheckClass \"failed: CheckClass: [] |- class C extends B { }\" at Program.classes[2]->Class\'C\' ");
    return _builder;
  }
  
  public CharSequence validateSubclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.CheckClass \"failed: CheckClass: [] |- class B extends A { String s; int i; }\" at Program.classes[1]->Class\'B\' ");
    return _builder;
  }
}
