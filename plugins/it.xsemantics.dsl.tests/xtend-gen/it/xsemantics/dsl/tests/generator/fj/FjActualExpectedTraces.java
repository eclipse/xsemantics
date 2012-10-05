package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class FjActualExpectedTraces extends FjExpectedTraces {
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
    _builder.append("failed: cannot type new A(\'foo\')");
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
    _builder.append("failed: cannot type new C(10, \'foo\', new B(20, \'bar\', 1))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: new B(20, \'bar\', 1) is not assignable for A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: cannot type new B(20, \'bar\', 1)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("expected 2 arguments, but got 3");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: cannot type new C(10, \'foo\', new C(20, \'bar\', new D(...");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: new C(20, \'bar\', new D()) is not assignable for A");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: cannot type new C(20, \'bar\', new D())");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: invalid arguments for expected parameters");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: new D() is not assignable for A");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("failed: D is not a subtype of A");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("failed: superclasses(left.classref).contains(right.classref)");
    return _builder;
  }
  
  public CharSequence newCheckWrongSubtypeBasic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: cannot type new C(10, 10, new B(20, \'bar\'))");
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
    _builder.append("failed: new A(param).f is not assignable for int");
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
  
  public CharSequence methodCallType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A().m(\'foo\') : String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("fields(class A { String m(String param) { retur...) = []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class A { String m(String param) { retur...) = []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new A() ~> [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new A().m(\'foo\') ~> [\'foo\'] << [String param]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ExpressionAssignableToType: [] |- \'foo\' <| String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("TStringConstant: [] |- \'foo\' : String");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    return _builder;
  }
  
  public CharSequence fieldSelectionType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TSelection: [] |- new A(10).f : int");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A(10) : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("fields(class A { int f; }) = [int f;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class A { int f; }) = []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new A(10) ~> [10] << [int f;]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("ExpressionAssignableToType: [] |- 10 <| int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TIntConstant: [] |- 10 : int");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("BasicSubtyping: [] |- int <: int");
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
  
  public CharSequence classType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TExpressionClassType: [] |~ new A() : A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("fields(class A {}) = []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class A {}) = []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new A() ~> [] << []");
    return _builder;
  }
  
  public CharSequence newType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TNew: [] |- new B() : B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("fields(class B extends A { }) = []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class B extends A { }) = [class A { }]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- new B() ~> [] << []");
    return _builder;
  }
  
  public CharSequence castType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TCast: [] |- (B) new A() : B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("fields(class A { }) = []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("superclasses(class A { }) = []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- new A() ~> [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("superclasses(class B extends A { }) = [class A { }]");
    return _builder;
  }
  
  public CharSequence methodCheckOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckMethod: [] |- String m(String param) { return param; }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TParamRef: [this -> A] |- param : String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("BasicSubtyping: [] |- String <: String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckParamRef: [this -> A] |- param");
    return _builder;
  }
  
  public CharSequence methodCheckOkWithThis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckMethod: [] |- A m() { return this.n(); }");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TSelection: [this -> B] |- this.n() : B");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- B <: A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckSelection: [this -> B] |- this.n()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckThis: [this -> B] |- this");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [this -> B] |- [] << []");
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
    _builder.append("SubtypeSequence: [] |- [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("SubtypeSequence: [] |- [new B(), new B(), 10] << [B b, A a, int i]");
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
    _builder.append("SubtypeSequence: [] |- [] << []");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckNew: [] |- new B()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SubtypeSequence: [] |- [] << []");
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
    _builder.append("SubtypeSequence: [] |- [10, \'foo\', new B(20, \'bar\')] << [int i;, String s;, A c;]");
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
    _builder.append("SubtypeSequence: [] |- [20, \'bar\'] << [int i;, String s;]");
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
  
  public CharSequence castOk1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CheckCast: [] |- (C) new A()");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("TNew: [] |- new A() : A");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ClassSubtyping: [] |- C <: A");
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
    _builder.append("failed: m does not override the superclass method");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("cannot change return type of inherited method: int");
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
    _builder.append("TIntConstant: [this -> B] |- 100 : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicSubtyping: [] |- int <: int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CheckConstant: [this -> B] |- 100");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("CheckMethodOverride: [] ||- int m(String s) { return 100; } ~~ int m(String s) { return 10; }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicEquals: [] |- int ~~ int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("BasicEquals: [] |- String ~~ String");
    return _builder;
  }
  
  public CharSequence subclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("field already defined in superclass class A { int i; }");
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
    _builder.append("failed: cannot type (D) new C()");
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
    _builder.append("Diagnostic ERROR \"field already defined in superclass class A { int i; }\" at Program.classes[1]->Class\'B\'.members[1]->Field\'i\' ");
    return _builder;
  }
}
