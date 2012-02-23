package it.xsemantics.dsl.tests.generator.fj

import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces

class FjAltExpectedTraces extends FjExpectedTraces {
	override failSubclasses()
'''
failed: A is not a subclass of B
 failed: class1.superclass != null'''
	
	override failSubtypesBasic()
'''
failed: String is not a subtype of int
 failed: left.basic.equals(right.basic)'''
	
	override failSubtypesClasses()
'''
failed: A is not a subtype of B
 failed: A is not a subclass of B
  failed: class1.superclass != null'''
	
	override failClassType()
'''failed: 'foo' has not a class type
 String cannot be assigned to ClassType'''
	
	override methodCheckBodyNotSubtype()
'''failed: CheckMethod: [] |- int m(String param) { return new A(param...
 failed: String is not a subtype of int
  failed: left.basic.equals(right.basic)'''
	
	override newCheckWrongSubtypeSimpler()
'''failed: CheckNew: [] |- new A('foo')
 failed: SubtypeSequence: [] |- new A('foo') : ['foo'] << [int i;]
  failed: String is not a subtype of int
   failed: left.basic.equals(right.basic)'''
	
	override newCheckWrongSubtype()
'''failed: CheckNew: [] |- new C(10, 'foo', new C(20, 'bar', new D(...
 failed: CheckNew: [] |- new C(20, 'bar', new D())
  failed: SubtypeSequence: [] |- new C(20, 'bar', new D()) : [20, 'bar', new D()] << [int i;, String s;, A c;]
   failed: D is not a subtype of A
    failed: D is not a subclass of A
     failed: class1.superclass != null'''

	override newCheckWrongSubtypeBasic()
'''failed: CheckNew: [] |- new C(10, 10, new B(20, 'bar'))
 failed: SubtypeSequence: [] |- new C(10, 10, new B(20, 'bar')) : [10, 10, new B(20, 'bar')] << [int i;, String s;, A c;]
  failed: int is not a subtype of String
   failed: left.basic.equals(right.basic)'''

	override castWrong()
'''failed: CheckCast: [] |- (D) new C()
 failed: C is not a subtype of D
  failed: C is not a subclass of D
   failed: B is not a subclass of D
    failed: A is not a subclass of D
     failed: class1.superclass != null'''

	override methodCallCheckOk()
'''CheckSelection: [] |- new B().m(new B(), new B(), 10)
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- new B() : [] << []
 SubtypeSequence: [] |- new B().m(new B(), new B(), 10) : [new B(), new B(), 10] << [B b, A a, int i]
  TNew: [] |- new B() : B
  TTypedElement: [] ||- B b : B
  ClassSubtyping: [] |- B <: B
   Subclassing: [] |- class B extends A { int m(B b, A a, int ... <| class B extends A { int m(B b, A a, int ...
  TNew: [] |- new B() : B
  TTypedElement: [] ||- A a : A
  ClassSubtyping: [] |- B <: A
   Subclassing: [] |- class B extends A { int m(B b, A a, int ... <| class A { }
    Subclassing: [] |- class A { } <| class A { }
  TIntConstant: [] |- 10 : int
  TTypedElement: [] ||- int i : int
  BasicSubtyping: [] |- int <: int
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- new B() : [] << []
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- new B() : [] << []
 CheckConstant: [] |- 10'''
  
	override newCheckOk()
'''CheckNew: [] |- new C(10, 'foo', new B(20, 'bar'))
 SubtypeSequence: [] |- new C(10, 'foo', new B(20, 'bar')) : [10, 'foo', new B(20, 'bar')] << [int i;, String s;, A c;]
  TIntConstant: [] |- 10 : int
  TTypedElement: [] ||- int i; : int
  BasicSubtyping: [] |- int <: int
  TStringConstant: [] |- 'foo' : String
  TTypedElement: [] ||- String s; : String
  BasicSubtyping: [] |- String <: String
  TNew: [] |- new B(20, 'bar') : B
  TTypedElement: [] ||- A c; : A
  ClassSubtyping: [] |- B <: A
   Subclassing: [] |- class B extends A { String s; } <| class A { int i; }
    Subclassing: [] |- class A { int i; } <| class A { int i; }
 CheckConstant: [] |- 10
 CheckConstant: [] |- 'foo'
 CheckNew: [] |- new B(20, 'bar')
  SubtypeSequence: [] |- new B(20, 'bar') : [20, 'bar'] << [int i;, String s;]
   TIntConstant: [] |- 20 : int
   TTypedElement: [] ||- int i; : int
   BasicSubtyping: [] |- int <: int
   TStringConstant: [] |- 'bar' : String
   TTypedElement: [] ||- String s; : String
   BasicSubtyping: [] |- String <: String
  CheckConstant: [] |- 20
  CheckConstant: [] |- 'bar' '''
  
	override subclassOkWRTFields()
'''CheckClass: [] |- class B extends A { String s; }'''

	override subclassOverrideMethod()
'''CheckClass: [] |- class B extends A { int m(String s) { re...
 BasicEquals: [] |- int ~~ int
 BasicEquals: [] |- String ~~ String'''

	override validateCheckNewWrongArgNum()
'''Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.SubtypeSequence "failed: SubtypeSequence: [] |- new B(20, 'bar', 1) : [20, 'bar', 1] << [int i;, String s;]" at Program.main->New.args[2]->New'''

	override validateCheckNewWrongSubtypeSimpler()
'''Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.SubtypeSequence "failed: SubtypeSequence: [] |- new A('foo') : ['foo'] << [int i;]" at Program.main->New'''

	override validateCyclicClassHierarchy()
'''Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass "failed: CheckClass: [] |- class A extends C { }" at Program.classes[0]->Class'A'
Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass "failed: CheckClass: [] |- class B extends A { }" at Program.classes[1]->Class'B'
Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass "failed: CheckClass: [] |- class C extends B { }" at Program.classes[2]->Class'C' '''

	override validateSubclassDeclaresSameFieldOfSuperClass()
'''Diagnostic ERROR code=it.xsemantics.test.fj.alt.rules.CheckClass "failed: CheckClass: [] |- class B extends A { String s; int i; }" at Program.classes[1]->Class'B' '''
}