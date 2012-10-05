package it.xsemantics.dsl.tests.generator.fj

import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces

class FjActualExpectedTraces extends FjExpectedTraces {

	override okSubtypesClasses()
'''ClassSubtyping: [] |- B <: A
 superclasses(class B extends A { }) = [class A { }]'''

	override failSubtypesClasses()
'''failed: A is not a subtype of B
 failed: superclasses(left.classref).contains(right.classref)'''

	override failSubtypesBasic()
'''failed: String is not a subtype of int
 failed: left.basic.equals(right.basic)'''

	override newCheckWrongSubtypeSimpler()
'''failed: cannot type new A('foo')
 failed: invalid arguments for expected parameters
  failed: 'foo' is not assignable for int
   failed: String is not a subtype of int
    failed: left.basic.equals(right.basic)'''

	override newCheckWrongArgNum()
'''failed: cannot type new C(10, 'foo', new B(20, 'bar', 1))
 failed: invalid arguments for expected parameters
  failed: new B(20, 'bar', 1) is not assignable for A
   failed: cannot type new B(20, 'bar', 1)
    failed: invalid arguments for expected parameters
     expected 2 arguments, but got 3'''

	override newCheckWrongSubtype()
'''failed: cannot type new C(10, 'foo', new C(20, 'bar', new D(...
 failed: invalid arguments for expected parameters
  failed: new C(20, 'bar', new D()) is not assignable for A
   failed: cannot type new C(20, 'bar', new D())
    failed: invalid arguments for expected parameters
     failed: new D() is not assignable for A
      failed: D is not a subtype of A
       failed: superclasses(left.classref).contains(right.classref)'''

	override newCheckWrongSubtypeBasic()
'''failed: cannot type new C(10, 10, new B(20, 'bar'))
 failed: invalid arguments for expected parameters
  failed: 10 is not assignable for String
   failed: int is not a subtype of String
    failed: left.basic.equals(right.basic)'''

	override failEqualsBasicType()
'''failed: String is not the same type as int
 failed: left.basic.equals(right.basic)'''

	override failEqualsClassType()
'''failed: A is not the same type as B
 failed: left.classref == right.classref'''

	override methodCheckBodyNotSubtype()
'''failed: new A(param).f is not assignable for int
 failed: String is not a subtype of int
  failed: left.basic.equals(right.basic)'''

	override variableType()
'''TParamRef: [] |- param : String'''

	override failThisDueToNullEnvironment()
'''failed: cannot type this
 access to null environment'''

	override failThisDueToNotClassType()
'''failed: cannot type this
 mapped value foo cannot be assigned to ClassType'''

	override methodCallType()
'''TSelection: [] |- new A().m('foo') : String
 TNew: [] |- new A() : A
  fields(class A { String m(String param) { retur...) = []
   superclasses(class A { String m(String param) { retur...) = []
  SubtypeSequence: [] |- new A() ~> [] << []
 SubtypeSequence: [] |- new A().m('foo') ~> ['foo'] << [String param]
  ExpressionAssignableToType: [] |- 'foo' <| String
   TStringConstant: [] |- 'foo' : String
   BasicSubtyping: [] |- String <: String'''

	override fieldSelectionType()
'''TSelection: [] |- new A(10).f : int
 TNew: [] |- new A(10) : A
  fields(class A { int f; }) = [int f;]
   superclasses(class A { int f; }) = []
  SubtypeSequence: [] |- new A(10) ~> [10] << [int f;]
   ExpressionAssignableToType: [] |- 10 <| int
    TIntConstant: [] |- 10 : int
    BasicSubtyping: [] |- int <: int'''

	override failClassType()
'''failed: 'foo' has not a class type
 String cannot be assigned to ClassType'''

	override classType()
'''TExpressionClassType: [] |~ new A() : A
 TNew: [] |- new A() : A
  fields(class A {}) = []
   superclasses(class A {}) = []
  SubtypeSequence: [] |- new A() ~> [] << []'''

	override newType()
'''TNew: [] |- new B() : B
 fields(class B extends A { }) = []
  superclasses(class B extends A { }) = [class A { }]
 SubtypeSequence: [] |- new B() ~> [] << []'''

	override castType()
'''TCast: [] |- (B) new A() : B
 TNew: [] |- new A() : A
  fields(class A { }) = []
   superclasses(class A { }) = []
  SubtypeSequence: [] |- new A() ~> [] << []
 ClassSubtyping: [] |- B <: A
  superclasses(class B extends A { }) = [class A { }]'''

	override methodCheckOk()
'''CheckMethod: [] |- String m(String param) { return param; }
 TParamRef: [this -> A] |- param : String
 BasicSubtyping: [] |- String <: String
 CheckParamRef: [this -> A] |- param'''

	override methodCheckOkWithThis()
'''CheckMethod: [] |- A m() { return this.n(); }
 TSelection: [this -> B] |- this.n() : B
 ClassSubtyping: [] |- B <: A
 CheckSelection: [this -> B] |- this.n()
  CheckThis: [this -> B] |- this
  SubtypeSequence: [this -> B] |- [] << []'''

	override methodCallCheckOk()
'''CheckSelection: [] |- new B().m(new B(), new B(), 10)
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- [] << []
 SubtypeSequence: [] |- [new B(), new B(), 10] << [B b, A a, int i]
  ExpressionAssignableToType: [] |- new B() <| B
   TNew: [] |- new B() : B
   ClassSubtyping: [] |- B <: B
  ExpressionAssignableToType: [] |- new B() <| A
   TNew: [] |- new B() : B
   ClassSubtyping: [] |- B <: A
  ExpressionAssignableToType: [] |- 10 <| int
   TIntConstant: [] |- 10 : int
   BasicSubtyping: [] |- int <: int
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- [] << []
 CheckNew: [] |- new B()
  SubtypeSequence: [] |- [] << []
 CheckConstant: [] |- 10'''

	override newCheckOk()
'''CheckNew: [] |- new C(10, 'foo', new B(20, 'bar'))
 SubtypeSequence: [] |- [10, 'foo', new B(20, 'bar')] << [int i;, String s;, A c;]
  ExpressionAssignableToType: [] |- 10 <| int
   TIntConstant: [] |- 10 : int
   BasicSubtyping: [] |- int <: int
  ExpressionAssignableToType: [] |- 'foo' <| String
   TStringConstant: [] |- 'foo' : String
   BasicSubtyping: [] |- String <: String
  ExpressionAssignableToType: [] |- new B(20, 'bar') <| A
   TNew: [] |- new B(20, 'bar') : B
   ClassSubtyping: [] |- B <: A
 CheckConstant: [] |- 10
 CheckConstant: [] |- 'foo'
 CheckNew: [] |- new B(20, 'bar')
  SubtypeSequence: [] |- [20, 'bar'] << [int i;, String s;]
   ExpressionAssignableToType: [] |- 20 <| int
    TIntConstant: [] |- 20 : int
    BasicSubtyping: [] |- int <: int
   ExpressionAssignableToType: [] |- 'bar' <| String
    TStringConstant: [] |- 'bar' : String
    BasicSubtyping: [] |- String <: String
  CheckConstant: [] |- 20
  CheckConstant: [] |- 'bar' '''

	override castOk1()
'''CheckCast: [] |- (C) new A()
 TNew: [] |- new A() : A
 ClassSubtyping: [] |- C <: A'''

	override castOk2()
'''CheckCast: [] |- (A) new C()
 TNew: [] |- new C() : C
 ClassSubtyping: [] |- C <: A'''

	override subclassOkWRTFields()
'''CheckClass: [] |- class B extends A { String s; }
 CheckTypedElement: [] |- String s;'''

	override subclassNotOvverrideMethod()
'''failed: m does not override the superclass method
 cannot change return type of inherited method: int'''

	override subclassOverrideMethod()
'''CheckClass: [] |- class B extends A { int m(String s) { re...
 CheckMethod: [] |- int m(String s) { return 100; }
  TIntConstant: [this -> B] |- 100 : int
  BasicSubtyping: [] |- int <: int
  CheckConstant: [this -> B] |- 100
 CheckMethodOverride: [] ||- int m(String s) { return 100; } ~~ int m(String s) { return 10; }
  BasicEquals: [] |- int ~~ int
  BasicEquals: [] |- String ~~ String'''

	override subclassDeclaresSameFieldOfSuperClass()
'''field already defined in superclass class A { int i; }'''

	override validateCheckNewWrongArgNum()
'''Diagnostic ERROR "expected 2 arguments, but got 3" at Program.main->New.args[2]->New'''

	override validateCheckNewWrongSubtypeSimpler()
'''Diagnostic ERROR code=it.xsemantics.example.fj.typing.rules.ExpressionAssignableToType "failed: 'foo' is not assignable for int" at Program.main->New.args[0]->StringConstant'''

	override castWrong()
'''failed: cannot type (D) new C()
 failed: C is not a subtype of D
  failed: superclasses(left.classref).contains(right.classref)'''

	override validateSubclassNotOverrideMethodChangingReturnType()
'''Diagnostic ERROR "cannot change return type of inherited method: B" at Program.classes[2]->Class'C'.members[0]->Method'm'.type==((instanceof ClassType: it.xsemantics.example.fj.fj.impl.ClassTypeImpl)'''

	override validateCyclicClassHierarchy()
'''Diagnostic ERROR "Cyclic hierarchy for A" at Program.classes[0]->Class'A'
Diagnostic ERROR "Cyclic hierarchy for B" at Program.classes[1]->Class'B'
Diagnostic ERROR "Cyclic hierarchy for C" at Program.classes[2]->Class'C' '''

	override validateSubclassDeclaresSameFieldOfSuperClass()
'''Diagnostic ERROR "field already defined in superclass class A { int i; }" at Program.classes[1]->Class'B'.members[1]->Field'i' '''
}