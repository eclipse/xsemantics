package it.xsemantics.dsl.tests.generator.fj.common

class FjInputFilesForTyping {
	
	def testClassHierarchy()
'''
class A { }

class B extends A { }

class C extends B { }
'''

	def testClassHierarchy2()
'''
«testClassHierarchy»

class D extends C { }

class E extends D { }
'''

	def testClassHierarchyWithObject()
'''
«testClassHierarchy»

class Object {
	
}
'''

	def testCyclicClassHierarchy()
'''
class A extends C { }

class B extends A { }

class C extends B { }
'''

	def testForSubtyping()
'''
class A { }

class B extends A { }

class Test {
	String _string;
	int _int;
	String _string2;
	A a;
	B b;
	A a2;
}
'''

	def testForNew()
'''
«testClassHierarchy»

new B()
'''

	def testForVariable()
'''
class A {
	String m(String param) {
		return param;
	}
}
'''

	def testForThis() '''this'''
	
	def testForMethodCall()
'''
class A {
	String m(String param) {
		return param;
	}
}

new A().m('foo')
'''

	def testForFieldSelection()
'''
class A {
	int f;
}

new A(10).f
'''

	def testForCast()
'''
«testClassHierarchy»

(B) new A()
'''

	def testForMethodBodyNotSubtype()
'''
class A {
	String f;
	int m(String param) {
		return new A(param).f;
	}
}
'''

	def testForMethodBodyUsingThis()
'''
class A {
	
}

class B extends A {
	A m() {
		return this.n();
	}
	B n() { return new B(); }
}
'''

	def testMethodsForMethodCall()
'''
class A {
	
}

class B extends A {
	int m(B b, A a, int i) { return i; }
}
'''

	def testMethodCallOk()
'''
«testMethodsForMethodCall»

new B().m(new B(), new B(), 10)
'''

	def testClassHierarchyForFields()
'''
class A { int i; }

class B extends A { String s; }

class C extends B { A c; }

class D {}
'''

	def testClassHierarchyForFields2()
'''
class A { int i; boolean b; }

class B extends A { String s; }

class C extends B { A c; }

class D {}
'''

	def testClassHierarchyForMethods()
'''
class A { String i() { return 'A.i'; } }

class B extends A { 
	String j() { return 'B.j'; }
	String k() { return 'B.k'; }
}

class C extends B { 
	String i() { return 'C.i'; }
	String j() { return 'C.j'; }
}

class D {}
'''

	def testNewOk()
'''
«testClassHierarchyForFields»

new C(10, 'foo', new B(20, 'bar'))
'''

	def testNewOk2()
'''
«testClassHierarchyForFields2»

new C(10, true, 'foo', new B(20, false, 'bar'))
'''

	def testNewWrongArgNum()
'''
«testClassHierarchyForFields»

new C(10, 'foo', new B(20, 'bar', 1))
'''

	def testNewWrongArgSubtype()
'''
«testClassHierarchyForFields»

new C(10, 'foo', new C(20, 'bar', new D()))
'''

	def testNewWrongArgSubtypeSimpler()
'''
«testClassHierarchyForFields»

new A('foo')
'''

	def testNewWrongArgSubtypeBasic()
'''
«testClassHierarchyForFields»

new C(10, 10, new B(20, 'bar'))
'''

	def testSubclassDeclaresSameFieldOfSuperClass()
'''
class A { int i; }
class B extends A { String s; int i; }
class C extends A { String s; int j; }
'''
	
	def testSubclassOkWRTFields()
'''
class A { int i; }
class B extends A { String s; }
class C extends A { int j; }
'''

	def testSubclassNotOverrideMethod()
'''
class A { int m(String s) { return 10; } }
class B extends A { int m(String s) { return 100; } /* OK */ }
class C extends A { boolean m(String s) { return 100; } /* NO! */ }
'''

	def testSubclassNotOverrideMethodChangingReturnType()
'''
class A { B m(String s) { return new B(); } }
class B extends A { }
class C extends A { 
	A m(String s) { return new A(); } /* NO! */
}'''

	def testCastOk1()
'''
«testClassHierarchy»

(C) new A()
'''
	def testCastOk2()
'''
«testClassHierarchy»

(A) new C()
'''
	def testCastWrong()
'''
class A { }
class B extends A {  }
class C extends B {  }
class D {}

(D) new C()
'''

}