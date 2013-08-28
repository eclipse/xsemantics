package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class FjSepExpectedTraces extends FjExpectedTraces {
  public CharSequence okSubtypesClasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("superclasses(class B extends A { }) = [class A { }]");
    return _builder;
  }
  
  public CharSequence failSubtypesClasses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: A is not a subtype of B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: superclasses(left.classref).contains(right.classref)");
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
  
  public CharSequence newCheckWrongSubtypeSimpler() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new A(\'foo\')");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: \'foo\' is not assignable for int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: String is not a subtype of int");
    _builder.newLine();
    _builder.append("    ");
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
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("expected 2 arguments, but got 3");
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
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: new D() is not assignable for A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: D is not a subtype of A");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: superclasses(left.classref).contains(right.classref)");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtypeBasic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckNew: [] |- new C(10, 10, new B(20, \'bar\'))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: 10 is not assignable for String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: int is not a subtype of String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence failEqualsBasicType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: String is not the same type as int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence failEqualsClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: A is not the same type as B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: left.classref == right.classref");
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
  
  public CharSequence variableType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TParamRef: [] |- param : String");
    return _builder;
  }
  
  public CharSequence failThisDueToNullEnvironment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: cannot type this");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("access to null environment");
    return _builder;
  }
  
  public CharSequence failThisDueToNotClassType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: cannot type this");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("mapped value foo cannot be assigned to ClassType");
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
  
  public CharSequence methodCallType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A().m(\'foo\') : String");
    return _builder;
  }
  
  public CharSequence fieldSelectionType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A(10).f : int");
    return _builder;
  }
  
  public CharSequence classType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TExpressionClassType: [] |~ new A() : A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    return _builder;
  }
  
  public CharSequence methodCheckOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckMethod: [] |- String m(String param) { return param; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TParamRef: [this <- A] |- param : String");
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
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class B extends A { A m() { return this....) = [class A { }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckSelection: [this <- B] |- this.n()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckThis: [this <- B] |- this");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [this <- B] |- this.n() ~> [] << []");
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
    _builder.append("SubtypeSequence: [] |- new B() ~> [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new B().m(new B(), new B(), 10) ~> [new B(), new B(), 10] << [B b, A a, int i]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- new B() <| B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TNew: [] |- new B() : B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ClassSubtyping: [] |- B <: B");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- new B() <| A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TNew: [] |- new B() : B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- 10 <| int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B() ~> [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new B() ~> [] << []");
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
    _builder.append("SubtypeSequence: [] |- new C(10, \'foo\', new B(20, \'bar\')) ~> [10, \'foo\', new B(20, \'bar\')] << [int i;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- 10 <| int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- \'foo\' <| String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TStringConstant: [] |- \'foo\' : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- new B(20, \'bar\') <| A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TNew: [] |- new B(20, \'bar\') : B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("superclasses(class B extends A { String s; }) = [class A { int i; }]");
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
    _builder.append("SubtypeSequence: [] |- new B(20, \'bar\') ~> [20, \'bar\'] << [int i;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- 20 <| int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TIntConstant: [] |- 20 : int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- \'bar\' <| String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TStringConstant: [] |- \'bar\' : String");
    _builder.newLine();
    _builder.append("    ");
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
    _builder.append("SubtypeSequence: [] |- new C(10, true, \'foo\', new B(20, false, ... ~> [10, true, \'foo\', new B(20, false, \'bar\')] << [int i;, boolean b;, String s;, A c;]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- 10 <| int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- true <| boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TBoolConstant: [] |- true : boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- boolean <: boolean");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- \'foo\' <| String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TStringConstant: [] |- \'foo\' : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- new B(20, false, \'bar\') <| A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TNew: [] |- new B(20, false, \'bar\') : B");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("superclasses(class B extends A { String s; }) = [class A { int i; boolean b; }]");
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
    _builder.append("SubtypeSequence: [] |- new B(20, false, \'bar\') ~> [20, false, \'bar\'] << [int i;, boolean b;, String s;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- 20 <| int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TIntConstant: [] |- 20 : int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- false <| boolean");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TBoolConstant: [] |- false : boolean");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("BasicSubtyping: [] |- boolean <: boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- \'bar\' <| String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TStringConstant: [] |- \'bar\' : String");
    _builder.newLine();
    _builder.append("    ");
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
    _builder.append("superclasses(class C extends B { }) = [class B extends A { }, class A { }]");
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
    _builder.append("superclasses(class C extends B { }) = [class B extends A { }, class A { }]");
    return _builder;
  }
  
  public CharSequence subclassOkWRTFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { String s; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckTypedElement: [] |- String s;");
    return _builder;
  }
  
  public CharSequence subclassNotOvverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: CheckClass: [] |- class C extends A { boolean m(String s) ...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: CheckMethod: [] |- boolean m(String s) { return 100; }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: int is not a subtype of boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: left.basic.equals(right.basic)");
    return _builder;
  }
  
  public CharSequence subclassOverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckClass: [] |- class B extends A { int m(String s) { re...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckMethod: [] |- int m(String s) { return 100; }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("TIntConstant: [this <- B] |- 100 : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [this <- B] |- 100");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("overrides(int m(String s) { return 100; }, int m(String s) { return 10; }) = true");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicEquals: [] |- int ~~ int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicEquals: [] |- String ~~ String");
    return _builder;
  }
  
  public CharSequence validateCheckNewWrongArgNum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR \"expected 2 arguments, but got 3\" at Program.main->New.args[2]->New");
    return _builder;
  }
  
  public CharSequence validateCheckNewWrongSubtypeSimpler() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.example.fj.typing.rules.ExpressionAssignableToType \"failed: \'foo\' is not assignable for int\" at Program.main->New.args[0]->StringConstant");
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
    _builder.append("failed: superclasses(left.classref).contains(right.classref)");
    return _builder;
  }
  
  public CharSequence validateSubclassNotOverrideMethodChangingReturnType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR \"cannot change return type of inherited method: B\" at Program.classes[2]->Class\'C\'.members[0]->Method\'m\'.type==((instanceof ClassType: it.xsemantics.example.fj.fj.impl.ClassTypeImpl)");
    return _builder;
  }
  
  public CharSequence validateCyclicClassHierarchy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR \"Cyclic hierarchy for A\" at Program.classes[0]->Class\'A\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR \"Cyclic hierarchy for B\" at Program.classes[1]->Class\'B\'");
    _builder.newLine();
    _builder.append("Diagnostic ERROR \"Cyclic hierarchy for C\" at Program.classes[2]->Class\'C\' ");
    return _builder;
  }
  
  public CharSequence validateSubclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Diagnostic ERROR code=it.xsemantics.example.fj.typing.rules.CheckClass \"failed: CheckClass: [] |- class B extends A { String s; int i; }\" at Program.classes[1]->Class\'B\' ");
    return _builder;
  }
}
