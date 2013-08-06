package it.xsemantics.dsl.tests.input

class XsemanticsTestFiles {
	def typeSystemQualifiedName() '''
	system it.xsemantics.test.TypeSystem
	'''

	def typeSystemNoQualifiedName() '''
	system TypeSystem
	'''
	
	def testFileWithImports() '''
	«typeSystemQualifiedName»
	
	import java.util.List
	import java.net.*
	'''
	
	def testJudgmentDescriptions() '''
	«typeSystemQualifiedName»
	
	import java.util.List
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set
	}
	'''
	
	def testJudgmentDescriptions3() '''
	«testFileWithImports»
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set : Boolean b
	}
	'''
	
	def testJudgmentDescriptionsWithDuplicates() '''
	«typeSystemQualifiedName»
	
	import java.util.List
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set
		type ||- List<String> list2 : java.util.Set<Integer> set2
	}
	'''
	
	def testJudgmentDescriptionsWithDuplicateSymbols() '''
	«typeSystemQualifiedName»
	
	import java.util.List
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set
		type2 |- List<String> list : Object o
		type3 ||- List<String> list : Object o
	}
	'''

	def testJudgmentDescriptionsRelatedToXsemantics() '''
	«testFileWithImports»
	
	import it.xsemantics.dsl.xsemantics.Rule
	
	judgments {
		type |- List<Rule> list : 
			java.util.Set<it.xsemantics.dsl.xsemantics.JudgmentDescription> set
	}
	'''
	
	def testJudgmentDescriptionsReferringToUnknownTypes() '''
	«testFileWithImports»
	
	judgments {
		type |- List<foo.bar.FooBar> list : it.unknown.MyClass foo
	}
	'''

	def testJudgmentDescriptionsReferringToEcore() '''
	«typeSystemQualifiedName»
	
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	import org.eclipse.emf.ecore.EcoreFactory
	
	judgments {
		type |- EClass c : EObject o
	}
	'''
	
	def testJudgmentDescriptionsReferringToEClassEObject() '''
	«typeSystemQualifiedName»
	
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	
	judgments {
		type |- EClass c : EObject o
	}
	'''
	
	def testJudgmentDescriptionsReferringToEcoreWithOutput() '''
	«typeSystemQualifiedName»
	
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	
	judgments {
		type |- EClass c : output EObject
	}
	'''
	
	def testJudgmentDescriptionsEObjectEClass() '''
	«typeSystemQualifiedName»
	
	import org.eclipse.emf.ecore.EObject
	import org.eclipse.emf.ecore.EClass
	
	judgments {
		type |- EObject c : output EClass
	}
	'''
	
	def testJudgmentDescriptionsWithErrorSpecification() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
			error "this " + c + " made an error!"
			source c
			feature c.eClass.eContainingFeature
	}
	'''
	
	def testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
			error "this " + c + " made an error!"
			
	}
	'''
	
	def testRuleJudgmentDescriptionsWithErrorSpecification() '''
	«testJudgmentDescriptionsWithErrorSpecification»
	
	rule TestRule
		G |- EObject o : EClass c
	from {
		
	}
	'''
	
	def testJudgmentDescriptionsWithCollectionOutput() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : output java.util.List<EStructuralFeature>
	}
	'''
	
	def testJudgmentDescriptionsReferringToEcore3() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : EObject o : EStructuralFeature f
		subtype ||- EObject o <: EClass c :> EStructuralFeature f
	}
	'''
	
	def testJudgmentDescriptionsReferringToEcore3WithOutput() '''
	«typeSystemQualifiedName»
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	import org.eclipse.emf.ecore.EStructuralFeature
	
	judgments {
		type |- EClass c : output EObject : EStructuralFeature f
		type2 ||- EClass c : output EObject : output EStructuralFeature
		subtype ||- output EObject <: EClass c :> EStructuralFeature f
	}
	'''
	
	def testJudgmentDescriptionsWith2OutputParams() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : output EObject : output EStructuralFeature
	}
	'''
	
	def testJudgmentDescriptionsWith3OutputParams() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : output EObject : 
			output EStructuralFeature : output String
	}
	'''

	def testJudgmentDescriptionsWith4OutputParams() '''
	«typeSystemQualifiedName»
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	import org.eclipse.emf.ecore.EStructuralFeature
	import org.eclipse.emf.common.notify.Notifier
	
	judgments {
		type |- EClass c : output EObject : 
			output EStructuralFeature : output String : output Notifier
	}
	'''
	
	def testJudgmentDescriptionsWithNoInputParam() '''
	«typeSystemQualifiedName»
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	
	judgments {
		type |- output EClass : output EObject
	}
	'''
	
	def testRuleWithOutputParams() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		G |- eClass : object : feat
	}
	'''
	
	def testRuleWithCollectionOutputParam() '''
	«testJudgmentDescriptionsWithCollectionOutput»
	
	rule Features derives
		G |- EClass eClass : List<EStructuralFeature> features
	from {
		G |- eClass : features
	}
	'''
	
	def testRuleWithTwoOutputParams() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G ||- EClass eClass : EObject object : EStructuralFeature feat
	from {
		G ||- eClass : object : feat
	}
	'''

	def testRuleWith3OutputParams() '''
	«testJudgmentDescriptionsWith3OutputParams»
	
	rule EClassEObjectEStructuralFeatureString derives
		G |- EClass eClass : EObject object : 
			EStructuralFeature feat : String s
	from {
		G |- eClass : object : feat : s
	}
	'''
	
	def testRuleWithOutputParamsAndExplicitAssignment() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		var EObject objectResult
		G |- eClass : object : feat
		object = objectResult
	}
	'''
	
	def testRuleWithOutputArgAsLocalVariable() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		var EObject objectResult
		G |- eClass : objectResult : feat
		var EObject myObject
		myObject = objectResult
	}
	'''
	
	def testRuleWithAssignmentToOutputParam() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		var EObject objectResult
		G |- eClass : objectResult : feat
		object = objectResult
	}
	'''
	
	def testRuleWithAssignmentToInputParam() '''
	«testJudgmentDescriptionsReferringToEcore3WithOutput»
	
	rule EClassEObjectEStructuralFeature derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		eClass = object.eClass
	}
	'''

	def testSimpleAxiom() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	axiom eClassEObject
		G |- EClass eClass : EObject object
	'''
	
	def testAxiomWithExpressionInConclusion() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	axiom EObjectEClass
		G |- EObject object : object.eClass
	'''

	def testSimpleRule() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() + "bar".toFirstUpper
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
	}
	'''
	
	def testDuplicateRuleNames() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	axiom Foo
		G |- EClass eClass : EObject object

	axiom Foo
		G1 |- EClass o : EClass o2
	'''
	
	def testDuplicateCheckRuleNames() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	checkrule Foo for
		EObject o1
	from {}

	checkrule Foo for
		EClass o
	from {}
	'''

	def testDuplicateRuleAndCheckRuleNames() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	axiom Foo
		G |- EClass eClass : EObject object

	checkrule Foo for
		EClass o
	from {}
	'''

	def testDuplicateParamsInRule() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject eClass
	from {
	}
	'''
	
	def testDuplicateParamsInJudgmentDescription() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass eClass : EClass eClass
	}
	'''

	def testRuleWithExpressionInConclusion() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EClass eClass : org::eclipse::emf::ecore::EcoreFactory::eINSTANCE.createEObject()
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = org::eclipse::emf::ecore::EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
	}
	'''
	
	def testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EClass _createEObject : org::eclipse::emf::ecore::EcoreFactory::eINSTANCE.createEObject()
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
	}
	'''

	def testRuleWithBlockExpressionInConclusion() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EClass eClass : { 
			val result = org::eclipse::emf::ecore::EcoreFactory::eINSTANCE.createEClass();
			result.name = 'MyEClass'
			result
		}
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = org::eclipse::emf::ecore::EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
	}
	'''

	def testRuleWithExpressionInConclusion2() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EcoreFactory::eINSTANCE.createEClass() : EObject eObject
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
	}
	'''

	def testRulesWithSameEnvironmentNames() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	axiom Foo
		G |- EClass eClass : EObject object

	axiom Foo2
		G |- EClass o : EClass o2
	'''

	def testRuleInvokingAnotherRule() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() + "bar".toFirstUpper
		G |- object.eClass : eClass
		G |- eClass : object.eClass
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		!(eC.name == 'MyEClass2')
		eC.name.length < 10
		eClass == eC
	}
	'''
	
	def testRuleWithFeatureCalls() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() || 'bar' == new String()
		'foo' == new String() && 'bar' == new String()
		'foo' == new String() + 'bar'.toFirstUpper
		'foo' != new String() + 'bar'.toFirstUpper
		val temp = new String() + 'bar'.toFirstUpper
		'foo'.contains('f')
		'foo'.concat('f')
		!('foo'.contains('f'))
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
	}
	'''
	
	def testRuleWithFeatureCallsForBinaryOps() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() || 'bar' == new String()
		'foo' == new String() && 'bar' == new String()
		'foo' == new String() + 'bar'.toFirstUpper
		'foo' != new String() + 'bar'.toFirstUpper
		new String() + 'bar'.toFirstUpper
		'foo'.contains('f')
		'foo'.concat('f')
		!('foo'.contains('f'))
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
	}
	'''
	
	def testRuleOnlyInvokingRules() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G |- object.eClass : eClass
		G |- eClass : object.eClass
	}
	'''
	
	def testWithEnvironmentAccess() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G |- object.eClass : eClass
		env(G, 'this', EClass)
		G |- object.eClass : eClass
		env(G, eClass.name, EClass)
		// env as an expression
		'foo' == env(G, eClass.name, EClass).getInstanceClassName()
	}
	'''
	
	def testRuleInvokingAnotherRule3() '''
	«testJudgmentDescriptionsReferringToEcore3»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object : EStructuralFeature feat
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		G |- object.eClass : eClass : feat
		G |- eClass : object.eClass : feat
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		!(feat.name == 'MyEClass')
		eC.name.length < 10
		eClass == eC
	}
	'''
	
	def testRuleInvokingAnotherRuleWith3Params() '''
	«testRuleInvokingAnotherRule3»
	
	rule ESub derives
		G ||- EObject object <: EClass eClass :> EStructuralFeature feat
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		G ||- object <: eClass :> feat
		G |- eClass : object.eClass : feat
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		!(feat.name == 'MyEClass')
		eC.name.length < 10
		eClass == eC
	}
	'''
	
	// this would not pass validation due to the boolean right
	// expression in the second rule invocation
	def testRuleInvokingAnotherRuleNotValid() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		G |- object.eClass : eClass
		G |- eClass : object.eClass.name == [ s | s.toFirstLower ].apply('foo')
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		!(eC.name == 'MyEClass')
		eC.name.length < 10
		eClass == eC
	}
	'''

	def testRuleInvocationsWithOperatorsConflictingXbase() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type1 |- EClass c : EObject o
		type2 |- EClass c <: EObject o
		type3 |- EClass c :> EObject o
		type4 |- EClass c << EObject o
		type5 |- EClass c >> EObject o
		type6 |- EClass c <| EObject o
		type7 |- EClass c ~~ EObject o
		type8 |- EClass c |> EObject o
		type9 |- EClass c --> EObject o
		type10 |- EClass c <- EObject o
		type11 |- EClass c <~ EObject o
		type12 |- EClass c ~> EObject o
		type13 |- EClass c <! EObject o
		type14 |- EClass c !> EObject o
		type15 |- EClass c <<! EObject o
		type16 |- EClass c !>> EObject o
		type17 |- EClass c <~! EObject o
		type18 |- EClass c !~> EObject o
		type19 ||- EClass c >> EObject o
	}
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		// :: as relation symbol disabled due to ambiguities with xbase static access
		//G |- object.eClass :: eClass
		//G |- (eClass) :: eClass // we need () otherwise interpreted as static access
		//G |- (eClass) :: object.eClass.name == [ s | s.toFirstLower ].apply('foo')
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass <: eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass :> eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass << eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass >> eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass <| eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass ~~ eClass
		eC.name = 'MyEClass'
		eClass == eC
		G |- object.eClass |> eClass
		G |- (object.eClass) --> (eClass)
		G |- (object.eClass) <- (eClass)
		G |- (object.eClass) <~ (eClass)
		G |- (object.eClass) ~> (eClass)
		G |- (object.eClass) <! (eClass)
		G |- (object.eClass) !> (eClass)
		G |- (object.eClass) <<! (eClass)
		G |- (object.eClass) !>> (eClass)
		G |- (object.eClass) <~! (eClass)
		G |- (object.eClass) !~> (eClass)
		eC.name = 'MyEClass'
		eClass == eC
		G ||- object.eClass >> eClass
	}
	'''

	def testRuleWithoutJudgmentDescription() '''
	«testSimpleRule»
	
	rule NoJudgmentDescription derives
		G  ||- EClass eClass : EObject object
	from {
		
	}
	'''
	
	def testRuleInvocationWithoutJudgmentDescription() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule NoJudgmentDescription derives
		G  |- EClass eClass : EObject object
	from {
		G ||- eClass : object
		eClass.name = 'MyEClass'
	}
	'''
	
	def testRuleWithConclusionNotSubtype() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	// note that only the left parameter raises an error (EObject not <: EClass)
	// while the right is acceptable since EClass <: EObject
	rule EClassEObject derives
		G |- EObject object : EClass eClass 
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		eClass == object.eClass
	}
	'''
	
	def testRuleWithConclusionNotSubtypeBoth() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EObject object : object.eClass.name
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
	}
	'''
	
	def testRuleInvocationWithWrongOutputArg() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EClassEObject derives
		G |- EObject object : EClass eClass 
	from {
		// this is OK
		G |- object : eClass
		// this is NOT: not valid output argument
		G |- object : object.eClass
	}
	'''
	
	def testRuleInvocationWithInputParamPassedAsOutput() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule PassInputParamAsOutput derives
		G |- EClass eClass : EObject object
	from {
		// can't pass eClass input param as output
		G |- eClass : eClass
	}
	'''
	
	def testRulesOfTheSameKind() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- Object o1 : Object o2
		subtype |- Object o1 <: Object o2
	}
	
	axiom Type1
		G |- String s1 : Integer i2
	
	axiom Type2
		G |- Boolean b1 : Integer i2
	
	axiom SubType1
		G |- String s1 <: Integer i2
	
	axiom SubType2
		G |- Boolean b1 <: Integer i2
	'''
	
	def testRulesOfTheSameKindWithSameArgumentTypes() '''
	«typeSystemQualifiedName»
	
	judgments {
		type |- Object o1 : Object o2
		subtype |- Object o1 <: Object o2
	}
	
	axiom Type1
		G |- String s1 : Integer i2
	
	axiom Type2
		G |- String b1 : int i2
	
	axiom SubType1
		G |- Object s1 <: Integer i2
	
	axiom SubType2
		G |- Object b1 <: Integer i2
	'''
	
	def testRulesOfTheSameKindWithSameInputArgumentTypes() '''
	«typeSystemQualifiedName»
	
	judgments {
		type |- Object o1 : output Object
	}
	
	axiom Type1
		G |- String s1 : Integer i2
	
	// output params do not make two rules different
	axiom Type2
		G |- String b1 : String i2
	
	'''
	
	def testRuleWithErrorSpecifications() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
			error "this " + stringRep(object) + " made an error!"
			source object.eClass
			feature object.eClass.eContainingFeature
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
	}
	'''
	
	def testErrorSpecificationSourceNotEObject() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
			error "Conclusion error"
			source object.eClass.name
	from {
	}
	'''
	
	def testErrorSpecificationFeatureNotEStructuralFeature() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
			error "Conclusion error"
			feature object.eClass
	from {
	}
	'''
	
	def testOrExpression() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		eClass.name == 'foo'
		or
		object.eClass.name == 'bar'
	}
	'''
	
	def testOrExpression2() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		eClass.name == 'foo'
		eClass.name == 'foo'
		or
		object.eClass.name == 'bar'
		object.eClass.name == 'bar'
	}
	'''
	
	def testOrExpressionWithBlocks() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		{eClass.name == 'foo'
		eClass.name == 'foo'}
		or
		{object.eClass.name == 'bar'
		object.eClass.name == 'bar'}
	}
	'''
	
	def testOrExpressionWithRuleInvocations() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		{eClass.name == 'foo'
		G |- object.eClass : eClass}
		or
		{G |- object.eClass : eClass
		object.eClass.name == 'bar'}
	}
	'''
	
	def testOrExpressionWithRuleInvocations2() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G |- object.eClass : eClass
		or
		G |- object.eClass : eClass
	}
	'''
	
	def testOrExpressionWithManyBranches() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G |- object.eClass : eClass
		or
		G |- object.eClass : eClass
		or
		{G |- object.eClass : eClass
		object.eClass.name == 'bar'}
		or
		object.eClass.name == 'bar'
	}
	'''
	
	def testEmptyEnvironment() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		empty |- object.eClass : eClass
	}
	'''
	
	def testEnvironmentComposition() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		empty, G |- object.eClass : eClass
	}
	'''
	
	def testEnvironmentComposition2() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		empty, G, empty, G |- object.eClass : eClass
	}
	'''
	
	def testSingleEnvironmentMapping() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		'this' <- object |- object.eClass : eClass
	}
	'''
	
	def testEnvironmentCompositionWithMapping() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G, 'this' <- object |- object.eClass : eClass
	}
	'''
	
	def testEnvironmentMapping2() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		G, 'this' <- object, object <- EcoreFactory::eINSTANCE.createEClass()
		|- object.eClass : eClass
	}
	'''
	
	def testRulesWithNonEObjectParams() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass e : String s
	}
	
	axiom EClassString
		G |- EClass e : String s
	'''
	
	def testRulesWithOnlyNonEObjectParams() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- List<String> l : String s
	}
	
	axiom OnlyNonEObject
		G |- List<String> l : String s
	'''
	
	def testCheckRule() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	axiom EObjectEClass
		G |- EObject object : object.eClass
	
	checkrule CheckEObject for
		EObject obj
	from {
		var EClass result
		empty |- obj : result
	}
	'''
	
	def testStringRep() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
			error "this " + stringRep(c) + " made an error!"
			source c
			feature c.eClass.eContainingFeature
	}
	'''
	
	def testForFail() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		empty |- obj : eClass
		fail
	}
	'''
	
	def testForFailWithErrorSpecification() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		empty |- obj : eClass
		fail
			error "this is the error"
			source obj
	}
	'''
	
	def testForClosures()
	'''«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c
		useless ||- EStructuralFeature f
	}
	
	rule TestForClosures
		G |- EClass eClass
	from {
		// boolean expressions inside closures will not
		// throw exception if they fail
		eClass.EStructuralFeatures.forall [
			it.name != 'foo'
		]
		
		// boolean expressions inside blocks inside closures will still
		// throw exception if they fail
		eClass.EStructuralFeatures.forall [
			{ it.name != 'foo' }
		]
		
		// rule invocations inside closures will still
		// throw exception if they fail
		eClass.EStructuralFeatures.forall [
			G ||- it
		]
		
		eClass.EStructuralFeatures.get(0).name != 'foo'
	}
	
	rule Useless
		G ||- EStructuralFeature feat
	from {
		fail
	}
	'''
	
	def testForScopeOfThisInRule() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		// clone is in the base runtime system
		// it should be visible through this
		eClass = clone(obj.eClass)
	}
	'''
	
	def testForScopeOfThisInClosure() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		// clone is in the base runtime system
		// it should be visible through this
		eClass.EAllStructuralFeatures.forEach [
			val e = clone(obj.eClass)
			println(e)
		]
	}
	'''
	
	def testForScopeOfThisInCheckRule() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	checkrule EObjectEClass
		for EObject obj
	from {
		// clone is in the base runtime system
		// it should be visible through this
		val eClass = clone(obj.eClass)
	}
	'''
	
	def testForScopeOfThisInJudgmentDescription() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
			error "this " + clone(c.eClass) + " made an error!"
			source clone(c)
			feature clone(c.eClass).eContainingFeature
	}
	'''
	
	def testOutputParamFromInputParam() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	axiom EObjectEClass
		G |- EClass eClass : eClass
	'''
	
	def testVariableDeclarationAsOutputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		G |- o : var EClass e
	}
	'''

	def testDuplicateVariableDeclarationAsOutputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		var temp = c
		or
		{
			G |- o : var EClass temp
		}
	}
	'''
	
	def testScopingForVariableDeclarationAsOutputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		G |- o : var EClass e
		e.name == 'foo'
	}
	'''

	def testScopingForParameters() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		c.name != null
		o.eContainer != null
	}
	'''
	
	def testForBooleanVariableDeclaration() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		var Boolean b
	}
	'''
	
	def testForNonBooleanPremises() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		var Boolean b
		b = false
		if (b) { true } else { false }
		for (oo : o.eContents) {
			c.name == 'bar'
		}
	}
	'''
	
	def testWrongVariableDeclarationAsOutputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		G |- o : var EClass e = o.eClass
	}
	'''
	
	def testWrongVariableDeclarationAsInputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		G |- var EObject o2 : c
	}
	'''
	
	def testRuleInvocationWithOutputArgInsideClosure() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eC
	from {
		obj.eClass.EAllStructuralFeatures.forEach [
			G |- obj : eC // cannot access output arg in closure
		]
	}
	'''

	def testAccessToVarInsideClosure() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		var s = 'foo'
		eClass.EStructuralFeatures.forEach [
			println(s)
		]
	}
	'''

	def testAccessToOutputParamInsideClosure() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eC
	from {
		eC.EStructuralFeatures.forEach [
			println(eC)
		]
	}
	'''

	def testVarDeclInRuleInvokationShadowsPreviousVariable() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		var s = 'foo'
		println(s)
		G |- obj : var EClass s // s should shadow previous declaration
		s.EStructuralFeatures.forEach [
			println(it)
		]
	}
	'''	

	def testWrongReturnInPremises() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		obj == obj
		return obj
	}
	'''
	
	def testWrongThrowInPremises() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject obj : EClass eClass
	from {
		obj == obj
		throw new Exception('foo')
	}
	'''
	
	// Xtext 2.3
	
	def testRuleWithBooleanExpressionsWithNoSideEffect() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		'a' == new String() || 'bar' == new String()
		'a' == new String() + 'bar'.toFirstUpper
	}
	'''
	
	def testRuleWithBooleanExpressionsWithNoSideEffectInFor() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		for (s : eClass.EAllStructuralFeatures) {
			s.name != 'foo'
		}
	}
	'''
	
	def testForClosureWithExpressionWithNoSideEffect()
	'''«typeSystemQualifiedName»
	import org.eclipse.emf.ecore.EClass
	
	judgments {
		type |- EClass c
	}
	
	rule TestForClosures
		G |- EClass eClass
	from {
		// boolean expressions inside closures without side effect
		eClass.EStructuralFeatures.forEach [
			it.name != "foo"
		]
	}
	'''

	def testFailSideEffect()
	'''«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c
	}
	
	rule TestForClosures
		G |- EClass eClass
	from {
		fail
			error stringRep(eClass)
	}
	'''

	def testFailInsideClosureSideEffect()
	'''«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c
	}
	
	rule TestForClosures
		G |- EClass eClass
	from {
		eClass.EStructuralFeatures.forEach [
			fail
		]
	}
	'''

	def testFailWithErrorSpecificationInsideClosureSideEffect()
	'''«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c
	}
	
	rule TestForClosures
		G |- EClass eClass
	from {
		eClass.EStructuralFeatures.forEach [
			fail
				error "" + stringRep(eClass)
		]
	}
	'''
	
	def testBooleanExpressionsInIf() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		if (eClass.name != 'foo') { true } else { false }
		val s = 'foo'
	}
	'''
	
	def testNoSideEffectButNoError() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		eClass.name + 'foo'
	}
	'''
	
	def testErrorNoSideEffect() '''
	«testJudgmentDescriptionsReferringToEClassEObject»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
	from {
		eClass.name + 'foo'
		print(eClass.name)
	}
	'''

	def testSystemWithInjections() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	/* a utility field */
	inject List<String> strings
	inject String myString
	/* another utility field */
	inject List<EClass> eClasses
	inject List<EClass> classes
	
	judgments {
		type |- EObject o : output EClass
	}
	'''

	def testAccessToInjectedFields() '''
	«testSystemWithInjections»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		println(o)
		println(myString)
		strings.add(myString)
		eClasses.add(o.eClass)
	}
	'''

	def testAccessToInjectedFieldsInExpressionInConclusion() '''
	«testSystemWithInjections»
	
	axiom EObjectEClass
		G |- EObject o : classes.get(0)
	'''

	def testAccessToThisInExpressionInConclusion() '''
	«testSystemWithInjections»
	
	axiom EObjectEClass
		G |- EObject o : 
		{ 
			println(this);
			clone(o).eClass
		}
	'''

	def testTwoExpressionsInConclusion() '''
	«testJudgmentDescriptionsWith2OutputParams»
	
	axiom TwoExpressionsInConclusion
		G |- EClass cl : cl : cl.EAllStructuralFeatures.head
	'''

	def testSystemWithValidatorExtends() '''
	system it.xsemantics.test.TypeSystem
	
	validatorExtends org.eclipse.xtext.validation.AbstractDeclarativeValidator
	'''

	def testCheckRuleWithValidatorExtends() '''
	«testSystemWithValidatorExtends»
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
	}
	
	axiom EObjectEClass
		G |- EObject object : object.eClass
	
	checkrule CheckEObject for
		EObject obj
	from {
		var EClass result
		empty |- obj : result
	}
	'''

	def testSystemWithValidatorExtendsNotAbstractDeclarativeValidator() '''
	system it.xsemantics.test.TypeSystem
	
	validatorExtends org.eclipse.emf.ecore.EClass
	'''

	def testSystemExtends() '''
	system it.xsemantics.test.TypeSystem extends it.xsemantics.runtime.XsemanticsRuntimeSystem
	'''

	def testSystemExtendsTestBaseSystem() '''
	system it.xsemantics.test.TypeSystem extends it.xsemantics.dsl.tests.input.TestBaseSystem
	'''

	def testSystemExtendsInvalidBaseSystem() '''
	system it.xsemantics.test.TypeSystem extends it.xsemantics.dsl.tests.input.TestInvalidBaseSystem
	'''

	def testSystemExtendsSystemWithJudgments() '''
	system it.xsemantics.test.ExtendedTypeSystem 
		extends it.xsemantics.test.TypeSystem
	'''

	def testSystemExtendsSystem2() '''
	system it.xsemantics.test.ExtendedTypeSystem2 
		extends it.xsemantics.test.ExtendedTypeSystem
	'''

	def testSystemExtendsSystemWithJudgmentsReferringToEcore() '''
	system it.xsemantics.test.ExtendedTypeSystem 
		extends it.xsemantics.test.TypeSystem
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		subtype |- EClass c1 <: EClass c2
	}
	'''

	def testSystemExtendsExtendedTypeSystem() '''
	system it.xsemantics.test.ExtendedTypeSystem2 
		extends it.xsemantics.test.ExtendedTypeSystem
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		type2 ||- EClass c1 : EClass c2
	}
	
	// the judgment is defined in TypeSystem
	rule FromTypeSystem
		G |- EObject c : c.eClass
	from {
		G |- c.eClass <: c.eClass
	}
	
	// the judgment is defined in ExtendedTypeSystem
	rule FromExtendedTypeSystem
		G |- EClass c1 <: EClass c2
	from {
		G ||- c1 : c2
	}
	
	// the judgment is defined here
	rule FromThisTypeSystem
		G ||- EClass c1 : EClass c2
	from {
		G |- c1 : var EClass o
	}
	
	checkrule CheckEObject for
		EObject o
	from {
		empty |- o : var EClass c
		empty |- o.eClass <: c
	}
	'''

	def testRuleOverride() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// the judgment is defined in TypeSystem
	override axiom FromTypeSystem
		G |- EObject c : c.eClass
	
	// the judgment is defined in ExtendedTypeSystem
	override rule FromExtendedTypeSystem
		G |- EClass c1 <: EClass c2
	from {
		G ||- c1 : c2
	}
	
	// the judgment is defined here
	override rule FromThisTypeSystem
		G ||- EClass c1 : EClass c2
	from {
		G |- c1 : var EClass o
	}
	
	override checkrule CheckEObject for
		EObject o
	from {
		empty |- o : var EClass c
		empty |- o.eClass <: c
	}
	'''

	def testInvalidRuleOverrideWithoutSystemExtends() '''
	system it.xsemantics.test.TypeSystem
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
	}
	
	// the judgment is defined in TypeSystem
	override axiom FromTypeSystem
		G |- EObject c : c.eClass
	
	override checkrule CheckEObject for
		EObject o
	from {
		empty |- o : var EClass c
		empty |- o.eClass <: c
	}
	'''

	/* TypeSystem -> ExtendedTypeSystem2 -> ExtendedTypeSystem -> TypeSystem */
	def testSystemBaseWithCycle() '''
	system it.xsemantics.test.TypeSystem
		extends it.xsemantics.test.ExtendedTypeSystem2
	'''

	def testSystemBaseWithCycle2() '''
	system it.xsemantics.test.ExtendedTypeSystem2 
		extends it.xsemantics.test.ExtendedTypeSystem
	'''

	def testSystemExtendsWithValidatorExtends() '''
	system it.xsemantics.test.ExtendedTypeSystem 
		extends it.xsemantics.test.TypeSystem
	
	validatorExtends org.eclipse.xtext.validation.AbstractDeclarativeValidator
	'''

	def testDuplicateRuleOfTheSameKindFromSuperSystem() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// the rule is already defined in TypeSystem
	// so an 'override' is mandatory
	axiom FromTypeSystem
		G |- EObject c : c.eClass
	'''

	def testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// a rule of the same kind is already defined in TypeSystem
	// but with a different name!
	axiom MyRuleWithDifferentName
		G |- EObject c : c.eClass
	'''

	def testDuplicateCheckRuleOfTheSameKindFromSuperSystem() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// the checkrule is already defined in TypeSystem
	// so an 'override' is mandatory
	checkrule CheckEObject for
		EObject o
	from {
		
	}
	'''

	def testNoRuleOfTheSameKindToOverride() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// no rule to override in the base system with EClass, EClass
	override axiom FromTypeSystem
		G |- EClass o : EClass c
	'''	

	def testOverrideRuleWithDifferentName() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// override rule must have the same name
	// of the one in the base system
	override axiom DifferentName
		G |- EObject o : EClass c
	'''

	def testNoCheckRuleToOverride() '''
	system it.xsemantics.test.ExtendedTypeSystemWithRuleOverride 
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*
	
	// wrong name of override rule
	override checkrule WrongCheckEObject for
		EObject o
	from {
		
	}
	
	// wrong element type
	override checkrule CheckEObject for
		EClass o
	from {
		
	}
	'''

	def testInvalidJudgmentWithTheSameNameOfBaseSystem() '''
	system it.xsemantics.test.ExtendedTypeSystem2 
		extends it.xsemantics.test.ExtendedTypeSystem
	
	import org.eclipse.emf.ecore.*

	// type judgment already defined in inherited system
	judgments {
		type ||- EClass c1 : EClass c2
	}
	'''

	def testOverrideJudgment() '''
	system it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject

	// type judgment already defined in inherited system
	// and we override it, so that's OK
	judgments {
		override type |- EObject obj : output EClass
		
		override subtype |- EClass c1 <: EClass c2
			error stringRep(c1) + " not <: " + stringRep(c2)
				source c1
				feature c1.eClass.eContainingFeature
	}
	'''

	def testOverrideJudgmentWithDifferentParamNames() '''
	system it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride
		extends it.xsemantics.test.ExtendedTypeSystem2
	
	import org.eclipse.emf.ecore.*

	// type judgment already defined in inherited system
	// and we override it, with different param names
	judgments {
		override subtype |- EClass left <: EClass right
	}
	'''

	def testForJudgmentParameters() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type0 |- EClass c : output EObject
		type1 ||- EClass c : output EObject
		type2 |~ EClass c : EObject o
		type3 |~ EClass c 
	}
	'''

	def testInvalidJudgmentOverrideWithoutSystemExtends() '''
	system it.xsemantics.test.TypeSystem
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		override type |- EObject c : output EClass
	}
	'''

	def testInvalidOverrideJudgment() '''
	system it.xsemantics.test.ExtendedTypeSystem2 
		extends it.xsemantics.test.ExtendedTypeSystem
	
	import org.eclipse.emf.ecore.*

	judgments {
		// EClass was output in the base system
		override type |- EObject obj : EClass c
		// different name of the judgment to override
		override subtype2 |- EClass c1 <: EClass c2
	}
	'''

	def testErrorSpecifications() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		// the judgment has an error specification
		type |- EObject c : output EClass
			error "this " + c + " made an error!"
			source c
			feature c.eClass.eContainingFeature
		
		subtype |- EObject left <: EObject right
	}
	
	axiom TypeEObject
		G |- EObject o : o.eClass
	
	// this rule has its own error specification
	axiom TypeEClass
		G |- EClass c : c
			error "unexpected error!"
			source c
			feature c.eClass.eContainingFeature
	
	// this rule has its own error specification
	rule SubtypeEObject
		G |- EObject left <: EObject right
			error "Unhandled case"
			source left
	from { fail }
	
	rule SubtypeEClass
		G |- EClass left <: EClass right
	from { right.isSuperTypeOf(left) }
	'''

	def testBaseSystemWithValidatorExtends() '''
	system it.xsemantics.test.TypeSystem
	
	validatorExtends org.eclipse.xtext.validation.AbstractDeclarativeValidator
	
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EObject c : output EClass
	}
	
	checkrule CheckEObject for
		EObject o
	from {
		
	}
	'''

	def testSystemExtendsSystemWithValidatorExtends() '''
	system it.xsemantics.test.ExtendedTypeSystem
		extends it.xsemantics.test.TypeSystem
	
	import org.eclipse.emf.ecore.*
	
	override checkrule CheckEObject for
		EObject o
	from {
		
	}
	
	checkrule CheckEClass for
		EClass o
	from {
		
	}
	'''

	def testAuxiliaryDescriptions() '''
	«typeSystemQualifiedName»
	import org.eclipse.emf.ecore.EClass
	import org.eclipse.emf.ecore.EObject
	
	auxiliary {
		isValue(EObject o, EClass c) : Boolean
		voidFun(EObject o)
		objectClass(EObject o) : EClass
			error "error in objectClass"
			source o
	}
	'''

	def testDuplicateAuxiliaryDescriptions() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	auxiliary {
		foo(EObject o)
		foo(EClass o) : EClass
	}
	'''

	def testAuxiliaryFunctions() '''
	«testAuxiliaryDescriptions»
	
	auxiliary isValue(EObject eO, EClass eC) {
		eO.eClass == eC
	}
	
	auxiliary objectClass(EObject o) {
		o.eClass
	}
	
	auxiliary voidFun(EObject o) {
		println(o)
		true
	}
	'''

	def testAuxiliaryFunctionWithWrongReturnExpression() '''
	«testAuxiliaryDescriptions»
	
	auxiliary isValue(EObject eO, EClass eC) {
		eO.eClass
	}
	'''

	def testAuxiliaryFunctionsInvocation() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	auxiliary {
		objectClass(EObject o) : EClass
			error "error in objectClass()"
			source o
	}
	
	judgments {
		type |- EObject o : output EClass
	}
	
	auxiliary objectClass(EObject o) {
		o.eClass
	}
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		objectClass(o)
		c = objectClass(o)
	}
	
	checkrule CheckEObject
		for EObject o
	from {
		objectClass(o) != null
	}
	'''

	def testAuxiliaryDescriptionWithTheSameNameOfJudgment() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	auxiliary {
		foo(EObject o)
	}
	
	judgments {
		foo |- EClass c
	}
	'''

	def testAuxiliaryFunctionWithoutAuxiliaryDescription() '''
	«testAuxiliaryDescriptions»
	
	auxiliary foobar(EObject eO, EClass eC) {
		eO.eClass == eC
	}
	'''

	def testNonConformantAuxiliaryFunction() '''
	«testAuxiliaryDescriptions»
	
	// the second param EObject is not subtype of
	// EClass as specified in the description
	auxiliary isValue(EClass eO, EObject eC) {
		eO == eC
	}
	
	// wrong number of parameters w.r.t. auxiliary description
	auxiliary voidFun(EObject o, String s) {
		
	}
	'''
}