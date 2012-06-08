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
	«testFileWithImports»
	
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
	«testFileWithImports»
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set
		type ||- List<String> list2 : java.util.Set<Integer> set2
	}
	'''
	
	def testJudgmentDescriptionsWithDuplicateSymbols() '''
	«testFileWithImports»
	
	judgments {
		type |- List<String> list : java.util.Set<Integer> set
		type2 |- List<String> list : Object o
		type3 ||- List<String> list : Object o
	}
	'''

	def testJudgmentDescriptionsRelatedToXsemantics() '''
	«testFileWithImports»
	
	import it.xsemantics.dsl.xsemantics.Import
	
	judgments {
		type |- List<Import> list : 
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
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : EObject o
	}
	'''
	
	def testJudgmentDescriptionsReferringToEcoreWithOutput() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
	judgments {
		type |- EClass c : output EObject
	}
	'''
	
	def testJudgmentDescriptionsEObjectEClass() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
		type |- EClass c : output EObject : output EStructuralFeature : output String
	}
	'''
	
	def testJudgmentDescriptionsWithNoInputParam() '''
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
	«testJudgmentDescriptionsReferringToEcore»
	
	axiom Foo
		G |- EClass eClass : EObject object

	axiom Foo
		G1 |- EClass o : EClass o2
	'''
	
	def testDuplicateCheckRuleNames() '''
	«testJudgmentDescriptionsReferringToEcore»
	
	checkrule Foo for
		EObject o1
	from {}

	checkrule Foo for
		EClass o
	from {}
	'''

	def testDuplicateRuleAndCheckRuleNames() '''
	«testJudgmentDescriptionsReferringToEcore»
	
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
		G |- EClass eClass : EcoreFactory::eINSTANCE.createEObject()
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
	}
	'''
	
	def testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EClass _createEObject : EcoreFactory::eINSTANCE.createEObject()
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
	}
	'''

	def testRuleWithBlockExpressionInConclusion() '''
	«testJudgmentDescriptionsReferringToEcoreWithOutput»
	
	rule EClassEObject derives
		G |- EClass eClass : { 
			val result = EcoreFactory::eINSTANCE.createEClass();
			result.name = 'MyEClass'
			result
		}
	from {
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
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
	«testJudgmentDescriptionsReferringToEcore»
	
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
		// some expressions from Xbase
		'foo' == new String() + 'bar'.toFirstUpper
		val EClass eC = EcoreFactory::eINSTANCE.createEClass()
		eC.name = 'MyEClass'
		eClass == eC
	}
	'''
	
	def testRuleInvocationWithoutJudgmentDescription() '''
	«testJudgmentDescriptionsReferringToEcore»
	
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
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
	«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
	«testJudgmentDescriptionsReferringToEcore»
	
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
	«testJudgmentDescriptionsReferringToEcore»
	
	rule EClassEObject derives
		G |- EClass eClass : EObject object
			error "Conclusion error"
			source object.eClass.name
	from {
	}
	'''
	
	def testErrorSpecificationFeatureNotEStructuralFeature() '''
	«testJudgmentDescriptionsReferringToEcore»
	
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
			eClass = clone(obj.eClass)
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
	
	def testScopingForVariableDeclarationAsOutputArgument() '''
	«testJudgmentDescriptionsEObjectEClass»
	
	rule EObjectEClass
		G |- EObject o : EClass c
	from {
		G |- o : var EClass e
		e.name == 'foo'
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
		G |- EObject obj : EClass eClass
	from {
		obj.eClass.EAllStructuralFeatures.forEach [
			G |- obj : eClass // cannot access output arg in closure
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
	'''«testFileWithImports»
	import org.eclipse.emf.ecore.*
	
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
}