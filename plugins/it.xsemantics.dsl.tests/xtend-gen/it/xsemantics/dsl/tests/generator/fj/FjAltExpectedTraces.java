package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class FjAltExpectedTraces extends FjExpectedTraces {
  public CharSequence failSubclasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: A is not a subclass of B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence failSubtypesBasic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: String is not a subtype of int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence failSubtypesClasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: A is not a subtype of B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: A is not a subclass of B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: class1.superclass != null");
    return _builder;
  }
  
  public CharSequence failClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: \'foo\' has not a class type");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("String cannot be assigned to ClassType");
    return _builder;
  }
  
  public CharSequence methodCheckBodyNotSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckMethod: [] |- int m(String param) { return new A(param...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: String is not a subtype of int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: left.basic.equals(right.basic)");
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
    _builder.append("failed: String is not a subtype of int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: left.basic.equals(right.basic)");
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
    _builder.append("failed: D is not a subtype of A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: D is not a subclass of A");
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
    _builder.append("failed: int is not a subtype of String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence castWrong() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckCast: [] |- (D) new C()");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: C is not a subtype of D");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: C is not a subclass of D");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: B is not a subclass of D");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: A is not a subclass of D");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: class1.superclass != null");
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
    _builder.append("SubtypeSequence: [] |- new B() : [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
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
  
  public CharSequence subclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckClass: [] |- class B extends A { String s; int i; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("field already defined in superclass class A { int i; }");
    return _builder;
  }
  
  public CharSequence subclassOkWRTFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { String s; }");
    return _builder;
  }
  
  public CharSequence subclassOverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { int m(String s) { re...");
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
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.first.rules.SubtypeSequence \"failed: SubtypeSequence: [] |- new A(\'foo\') : [\'foo\'] << [int i;]\" at Program.main->New");
    return _builder;
  }
  
  public CharSequence validateCyclicClassHierarchy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass \"failed: CheckClass: [] |- class A extends C { }\" at Program.classes[0]->Class\'A\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass \"failed: CheckClass: [] |- class B extends A { }\" at Program.classes[1]->Class\'B\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass \"failed: CheckClass: [] |- class C extends B { }\" at Program.classes[2]->Class\'C\' ");
    return _builder;
  }
  
  public CharSequence validateSubclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass \"failed: CheckClass: [] |- class B extends A { String s; int i; }\" at Program.classes[1]->Class\'B\' ");
    return _builder;
  }
}
