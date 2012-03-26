package it.xsemantics.dsl.tests.generator.fj.common;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class FjInputFilesForTyping {
  public CharSequence testClassHierarchy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C extends B { }");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testClassHierarchyWithObject() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchy = this.testClassHierarchy();
    _builder.append(_testClassHierarchy, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testCyclicClassHierarchy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A extends C { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C extends B { }");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _string;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int _int;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _string2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A a;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B b;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A a2;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForNew() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchy = this.testClassHierarchy();
    _builder.append(_testClassHierarchy, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new B()");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForVariable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String m(String param) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return param;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForThis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this");
    return _builder;
  }
  
  public CharSequence testForMethodCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String m(String param) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return param;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A().m(\'foo\')");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForFieldSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int f;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(10).f");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForCast() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchy = this.testClassHierarchy();
    _builder.append(_testClassHierarchy, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("(B) new A()");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForMethodBodyNotSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String f;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int m(String param) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new A(param).f;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForMethodBodyUsingThis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.n();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B n() { return new B(); }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testMethodsForMethodCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int m(B b, A a, int i) { return i; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testMethodCallOk() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testMethodsForMethodCall = this.testMethodsForMethodCall();
    _builder.append(_testMethodsForMethodCall, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new B().m(new B(), new B(), 10)");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testClassHierarchyForFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { int i; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A { String s; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C extends B { A c; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class D {}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testClassHierarchyForMethods() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { String i() { return \'A.i\'; } }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B extends A { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String j() { return \'B.j\'; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String k() { return \'B.k\'; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C extends B { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String i() { return \'C.i\'; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String j() { return \'C.j\'; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class D {}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testNewOk() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchyForFields = this.testClassHierarchyForFields();
    _builder.append(_testClassHierarchyForFields, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new C(10, \'foo\', new B(20, \'bar\'))");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testNewWrongArgNum() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchyForFields = this.testClassHierarchyForFields();
    _builder.append(_testClassHierarchyForFields, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new C(10, \'foo\', new B(20, \'bar\', 1))");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testNewWrongArgSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchyForFields = this.testClassHierarchyForFields();
    _builder.append(_testClassHierarchyForFields, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new C(10, \'foo\', new C(20, \'bar\', new D()))");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testNewWrongArgSubtypeSimpler() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchyForFields = this.testClassHierarchyForFields();
    _builder.append(_testClassHierarchyForFields, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new A(\'foo\')");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testNewWrongArgSubtypeBasic() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchyForFields = this.testClassHierarchyForFields();
    _builder.append(_testClassHierarchyForFields, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("new C(10, 10, new B(20, \'bar\'))");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSubclassDeclaresSameFieldOfSuperClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { int i; }");
    _builder.newLine();
    _builder.append("class B extends A { String s; int i; }");
    _builder.newLine();
    _builder.append("class C extends A { String s; int j; }");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSubclassOkWRTFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { int i; }");
    _builder.newLine();
    _builder.append("class B extends A { String s; }");
    _builder.newLine();
    _builder.append("class C extends A { int j; }");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSubclassNotOverrideMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { int m(String s) { return 10; } }");
    _builder.newLine();
    _builder.append("class B extends A { int m(String s) { return 100; } /* OK */ }");
    _builder.newLine();
    _builder.append("class C extends A { boolean m(String s) { return 100; } /* NO! */ }");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSubclassNotOverrideMethodChangingReturnType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { B m(String s) { return new B(); } }");
    _builder.newLine();
    _builder.append("class B extends A { }");
    _builder.newLine();
    _builder.append("class C extends A { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A m(String s) { return new A(); } /* NO! */");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence testCastOk1() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchy = this.testClassHierarchy();
    _builder.append(_testClassHierarchy, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("(C) new A()");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testCastOk2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testClassHierarchy = this.testClassHierarchy();
    _builder.append(_testClassHierarchy, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("(A) new C()");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testCastWrong() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A { }");
    _builder.newLine();
    _builder.append("class B extends A {  }");
    _builder.newLine();
    _builder.append("class C extends B {  }");
    _builder.newLine();
    _builder.append("class D {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("(D) new C()");
    _builder.newLine();
    return _builder;
  }
}
