/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package it.xsemantics.dsl.tests.generator.fj.common

import com.google.inject.Inject
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.StringRepresentation
import it.xsemantics.runtime.TraceUtils
import org.junit.Assert

class FjExpectedTraces {
	
	@Inject extension TraceUtils
	
	@Inject extension StringRepresentation
	
	def successTraceAsString(RuleApplicationTrace t) {
		t.traceAsString
	}

	def assertEqualsStrings(Object expected, Object actual) {
		Assert::assertEquals(
			("" + expected).replaceAll("\r", ""), 
			("" + actual).replaceAll("\r", "")
		)
	}
	
	def void assertFailureTrace(RuleFailedException e, CharSequence expectedTrace) {
		assertEqualsStrings(expectedTrace.toString.trim,
			e.failureTraceAsString
		)
	}
	
	def void assertErrorInformation(RuleFailedException e, CharSequence expectedErrorInformation) {
		assertEqualsStrings(expectedErrorInformation.toString,
			e.filteredErrorInformation.map [
				it.source.string + 
				if (it.feature !== null) {
					" feature: " + it.feature.name
				} else {
					""
				}
			].join(" -- ")
		)
	}

	def void assertTrace(RuleApplicationTrace trace, CharSequence expectedTrace) {
		assertEqualsStrings(expectedTrace.toString.trim,
			trace.traceAsString
		)
	}
	
	def okSubclasses()
'''
Subclassing: [] |- class B extends A { } <| class A { }
 Subclassing: [] |- class A { } <| class A { }'''
	
	def failSubclasses()
'''
failed: Subclassing: [] |- class A { } <| class B extends A { }
 failed: class1.superclass != null'''
	
	def failSubtypesBasic()
'''
failed: BasicSubtyping: [] |- String <: int
 failed: left.basic.equals(right.basic)'''
	
	def failSubtypesClasses()
'''
failed: ClassSubtyping: [] |- A <: B
 failed: Subclassing: [] |- class A { } <| class B extends A { }
  failed: class1.superclass != null'''

	def failEqualsBasicType()
'''failed: BasicEquals: [] |- String ~~ int
 failed: left.basic.equals(right.basic)'''

	def failEqualsClassType()
'''failed: ClassEquals: [] |- A ~~ B
 failed: left.classref == right.classref'''

  	def okSubtypesClasses()
'''
ClassSubtyping: [] |- B <: A
 Subclassing: [] |- class B extends A { } <| class A { }
  Subclassing: [] |- class A { } <| class A { }'''
	
	def variableType()
'''
TParamRef: [] |- param : String
 TTypedElement: [] ||- String param : String'''
 
	def failThisDueToNullEnvironment()
'''
failed: TThis: [] |- this : ClassType
 access to null environment'''

	def failThisDueToNotClassType()
'''
failed: TThis: [this <- foo] |- this : ClassType
 mapped value foo cannot be assigned to ClassType'''

	def methodCallType() {
'''
TSelection: [] |- new A().m('foo') : String
 TTypedElement: [] ||- String m(String param) { return param; } : String'''
 	}
 	
 	def fieldSelectionType() {
'''
TSelection: [] |- new A(10).f : int
 TTypedElement: [] ||- int f; : int'''
 	}
 	
 	def newType()
'''TNew: [] |- new B() : B'''
 	
 	def failClassType()
'''failed: TExpressionClassType: [] ||~ 'foo' : ClassType
 String cannot be assigned to ClassType'''
 
	def classType()
'''TExpressionClassType: [] ||~ new A() : A
 TNew: [] |- new A() : A'''

	def castType()
'''TCast: [] |- (B) new A() : B'''
 	
 	def methodCheckOk() 
'''CheckMethod: [] |- String m(String param) { return param; }
 TParamRef: [this <- A] |- param : String
  TTypedElement: [this <- A] ||- String param : String
 BasicSubtyping: [] |- String <: String
 CheckParamRef: [this <- A] |- param'''

	def methodCheckOkWithThis()
'''CheckMethod: [] |- A m() { return this.n(); }
 TSelection: [this <- B] |- this.n() : B
  TTypedElement: [this <- B] ||- B n() { return new B(); } : B
 ClassSubtyping: [] |- B <: A
  Subclassing: [] |- class B extends A { A m() { return this.... <| class A { }
   Subclassing: [] |- class A { } <| class A { }
 CheckSelection: [this <- B] |- this.n()
  CheckThis: [this <- B] |- this
  SubtypeSequence: [this <- B] |- this.n() : [] << []'''

	def methodCheckBodyNotSubtype()
'''failed: CheckMethod: [] |- int m(String param) { return new A(param...
 failed: BasicSubtyping: [] |- String <: int
  failed: left.basic.equals(right.basic)'''
  
	def methodCallCheckOk()
'''CheckSelection: [] |- new B().m(new B(), new B(), 10)
 CheckNew: [] |- new B()
  Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []
   superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]
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
  Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []
   superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]
  SubtypeSequence: [] |- new B() : [] << []
 CheckNew: [] |- new B()
  Fields: [] ||- class B extends A { int m(B b, A a, int ... >> []
   superclasses(class B extends A { int m(B b, A a, int ...) = [class A { }]
  SubtypeSequence: [] |- new B() : [] << []
 CheckConstant: [] |- 10'''

	def newCheckOk() {
'''CheckNew: [] |- new C(10, 'foo', new B(20, 'bar'))
 Fields: [] ||- class C extends B { A c; } >> [int i;, String s;, A c;]
  superclasses(class C extends B { A c; }) = [class B extends A { String s; }, class A { int i; }]
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
  Fields: [] ||- class B extends A { String s; } >> [int i;, String s;]
   superclasses(class B extends A { String s; }) = [class A { int i; }]
  SubtypeSequence: [] |- new B(20, 'bar') : [20, 'bar'] << [int i;, String s;]
   TIntConstant: [] |- 20 : int
   TTypedElement: [] ||- int i; : int
   BasicSubtyping: [] |- int <: int
   TStringConstant: [] |- 'bar' : String
   TTypedElement: [] ||- String s; : String
   BasicSubtyping: [] |- String <: String
  CheckConstant: [] |- 20
  CheckConstant: [] |- 'bar' '''
	}

	def newCheckOk2() {
'''CheckNew: [] |- new C(10, true, 'foo', new B(20, false, ...
 Fields: [] ||- class C extends B { A c; } >> [int i;, boolean b;, String s;, A c;]
  superclasses(class C extends B { A c; }) = [class B extends A { String s; }, class A { int i; boolean b; }]
 SubtypeSequence: [] |- new C(10, true, 'foo', new B(20, false, ... : [10, true, 'foo', new B(20, false, 'bar')] << [int i;, boolean b;, String s;, A c;]
  TIntConstant: [] |- 10 : int
  TTypedElement: [] ||- int i; : int
  BasicSubtyping: [] |- int <: int
  TBoolConstant: [] |- true : boolean
  TTypedElement: [] ||- boolean b; : boolean
  BasicSubtyping: [] |- boolean <: boolean
  TStringConstant: [] |- 'foo' : String
  TTypedElement: [] ||- String s; : String
  BasicSubtyping: [] |- String <: String
  TNew: [] |- new B(20, false, 'bar') : B
  TTypedElement: [] ||- A c; : A
  ClassSubtyping: [] |- B <: A
   Subclassing: [] |- class B extends A { String s; } <| class A { int i; boolean b; }
    Subclassing: [] |- class A { int i; boolean b; } <| class A { int i; boolean b; }
 CheckConstant: [] |- 10
 CheckConstant: [] |- true
 CheckConstant: [] |- 'foo'
 CheckNew: [] |- new B(20, false, 'bar')
  Fields: [] ||- class B extends A { String s; } >> [int i;, boolean b;, String s;]
   superclasses(class B extends A { String s; }) = [class A { int i; boolean b; }]
  SubtypeSequence: [] |- new B(20, false, 'bar') : [20, false, 'bar'] << [int i;, boolean b;, String s;]
   TIntConstant: [] |- 20 : int
   TTypedElement: [] ||- int i; : int
   BasicSubtyping: [] |- int <: int
   TBoolConstant: [] |- false : boolean
   TTypedElement: [] ||- boolean b; : boolean
   BasicSubtyping: [] |- boolean <: boolean
   TStringConstant: [] |- 'bar' : String
   TTypedElement: [] ||- String s; : String
   BasicSubtyping: [] |- String <: String
  CheckConstant: [] |- 20
  CheckConstant: [] |- false
  CheckConstant: [] |- 'bar' '''
	}
	
	def newCheckWrongSubtypeSimpler()
'''failed: CheckNew: [] |- new A('foo')
 failed: SubtypeSequence: [] |- new A('foo') : ['foo'] << [int i;]
  failed: BasicSubtyping: [] |- String <: int
   failed: left.basic.equals(right.basic)'''

	def newCheckWrongArgNum()
'''failed: CheckNew: [] |- new C(10, 'foo', new B(20, 'bar', 1))
 failed: CheckNew: [] |- new B(20, 'bar', 1)
  failed: SubtypeSequence: [] |- new B(20, 'bar', 1) : [20, 'bar', 1] << [int i;, String s;]
   failed: expressions.size == typedElements.size'''

   def newCheckWrongSubtype()
'''failed: CheckNew: [] |- new C(10, 'foo', new C(20, 'bar', new D(...
 failed: CheckNew: [] |- new C(20, 'bar', new D())
  failed: SubtypeSequence: [] |- new C(20, 'bar', new D()) : [20, 'bar', new D()] << [int i;, String s;, A c;]
   failed: ClassSubtyping: [] |- D <: A
    failed: Subclassing: [] |- class D {} <| class A { int i; }
     failed: class1.superclass != null'''

	def newCheckWrongSubtypeBasic()
'''failed: CheckNew: [] |- new C(10, 10, new B(20, 'bar'))
 failed: SubtypeSequence: [] |- new C(10, 10, new B(20, 'bar')) : [10, 10, new B(20, 'bar')] << [int i;, String s;, A c;]
  failed: BasicSubtyping: [] |- int <: String
   failed: left.basic.equals(right.basic)'''

   def subclassDeclaresSameFieldOfSuperClass()
'''failed: CheckClass: [] |- class B extends A { String s; int i; }
 failed: field.name != inheritedField.name'''

	def subclassOkWRTFields()
'''CheckClass: [] |- class B extends A { String s; }
 superclasses(class B extends A { String s; }) = [class A { int i; }]
 Fields: [] ||- class A { int i; } >> [int i;]
  superclasses(class A { int i; }) = []
 Methods: [] ||~ class A { int i; } >> []'''

	def castOk1()
'''CheckCast: [] |- (C) new A()
 TNew: [] |- new A() : A
 ClassSubtyping: [] |- C <: A
  Subclassing: [] |- class C extends B { } <| class A { }
   Subclassing: [] |- class B extends A { } <| class A { }
    Subclassing: [] |- class A { } <| class A { }'''
    
    def castOk2()
'''CheckCast: [] |- (A) new C()
 TNew: [] |- new C() : C
 ClassSubtyping: [] |- C <: A
  Subclassing: [] |- class C extends B { } <| class A { }
   Subclassing: [] |- class B extends A { } <| class A { }
    Subclassing: [] |- class A { } <| class A { }'''
    
    def castWrong()
'''failed: CheckCast: [] |- (D) new C()
 failed: ClassSubtyping: [] |- C <: D
  failed: Subclassing: [] |- class C extends B { } <| class D {}
   failed: Subclassing: [] |- class B extends A { } <| class D {}
    failed: Subclassing: [] |- class A { } <| class D {}
     failed: class1.superclass != null'''
     
	def subclassNotOvverrideMethod()
'''failed: CheckClass: [] |- class C extends A { boolean m(String s) ...
 failed: BasicEquals: [] |- boolean ~~ int
  failed: left.basic.equals(right.basic)'''

	def subclassOverrideMethod()
'''CheckClass: [] |- class B extends A { int m(String s) { re...
 superclasses(class B extends A { int m(String s) { re...) = [class A { int m(String s) { return 10; }...]
 Fields: [] ||- class A { int m(String s) { return 10; }... >> []
  superclasses(class A { int m(String s) { return 10; }...) = []
 Methods: [] ||~ class A { int m(String s) { return 10; }... >> [int m(String s) { return 10; }]
 BasicEquals: [] |- int ~~ int
 BasicEquals: [] |- String ~~ String'''

	def validateCheckNewWrongSubtypeSimpler()
'''Diagnostic ERROR code=it.xsemantics.test.fj.first.BasicSubtyping "failed: BasicSubtyping: [] |- String <: int" at Program.classes[0]->Class'A'.members[0]->Field'i'.type->BasicType'''

	def validateCheckNewWrongArgNum()
'''Diagnostic ERROR code=it.xsemantics.test.fj.first.SubtypeSequence "failed: SubtypeSequence: [] |- new B(20, 'bar', 1) : [20, 'bar', 1] << [int i;, String s;]" at Program.main->New.args[2]->New'''
	
	def validateSubclassNotOverrideMethodChangingReturnType()
'''NOT IMPLEMENTED'''

	def validateCyclicClassHierarchy()
'''Diagnostic ERROR code=it.xsemantics.test.fj.first.CheckClass "failed: CheckClass: [] |- class A extends C { }" at Program.classes[0]->Class'A'
Diagnostic ERROR code=it.xsemantics.test.fj.first.CheckClass "failed: CheckClass: [] |- class B extends A { }" at Program.classes[1]->Class'B'
Diagnostic ERROR code=it.xsemantics.test.fj.first.CheckClass "failed: CheckClass: [] |- class C extends B { }" at Program.classes[2]->Class'C' '''

	def validateSubclassDeclaresSameFieldOfSuperClass()
'''Diagnostic ERROR code=it.xsemantics.test.fj.first.CheckClass "failed: CheckClass: [] |- class B extends A { String s; int i; }" at Program.classes[1]->Class'B' '''
}