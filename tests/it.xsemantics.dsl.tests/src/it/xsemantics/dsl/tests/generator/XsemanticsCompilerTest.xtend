package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustomForPluginTest
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.TraceUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.util.Wrapper
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import it.xsemantics.runtime.Result

@InjectWith(typeof(XsemanticsInjectorProviderCustomForPluginTest))
@RunWith(typeof(XtextRunner))
class XsemanticsCompilerTest extends XsemanticsBaseTest {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder 
	
	@Inject extension CompilationTestHelper
	
	@Inject extension ReflectExtensions
	
	@Inject extension TraceUtils
	
	@Test
	def testRuleInvocation() {
'''
import java.util.List

system my.test.ruleinvokations.System
			
judgments {
	type |- Object o : output Object
}

rule Type G |- List<String> list : Object res
from {
	res = list.head
}
'''.invokeTypeAndExpect(
'''Type: [] |- [first, second] : first'''
)
	}

	@Test
	def testRuleInvocationInsideLambda_Issue_36() {
		// https://github.com/LorenzoBettini/xsemantics/issues/36
		// the generated code used to fail to compile into Java
		// because RuleFailedException was not caught
		// now RuleFailedException extends RuntimeException
'''
import java.util.List

system my.test.ruleinvokations.System
			
judgments {
	type |- Object o : output Object
}

// the result is simply the input list
rule TypeList G |- List<String> list : list
from {
	list.forEach[
		element |
		// but first invoke type on every element
		G |- element : var Object r
	]
}

// the result is simply the input
axiom TypeString G |- String s : s
'''.invokeTypeAndExpect(
'''
TypeList: [] |- [first, second] : [first, second]
 TypeString: [] |- first : first
 TypeString: [] |- second : second
'''
)
	}

	@Test
	def testRuleInvocationInsideLambdaWithFailure_Issue_36() {
		// https://github.com/LorenzoBettini/xsemantics/issues/36
		// the generated code used to fail to compile into Java
		// because RuleFailedException was not caught
		// now RuleFailedException extends RuntimeException
'''
import java.util.List

system my.test.ruleinvokations.System
			
judgments {
	type |- Object o
}

rule TypeList G |- List<Object> list
from {
	list.forEach[
		element |
		// but first invoke type on every element
		G |- element 
	]
}

// the result is simply the input
axiom TypeString G |- String s 

// no rule defined for input Integer
'''.invokeTypeAndExpectFailure(
'''
failed: TypeList: [] |- [first, 0]
 cannot find a rule for |- 0
'''
)
	}

	def private invokeTypeAndExpect(CharSequence input, CharSequence expectedTrace) {
		val system = input.instantiateSystem
		val trace = new RuleApplicationTrace
		system.invoke("type", null, trace, newArrayList("first", "second"))
		expectedTrace.toString.trim.assertEqualsStrings(trace.traceAsString)
	}

	def private invokeTypeAndExpectFailure(CharSequence input, CharSequence expectedTrace) {
		val system = input.instantiateSystem
		val trace = new RuleApplicationTrace
		val result = system.invoke("type", null, trace, newArrayList("first", 0)) as Result<Object>
		expectedTrace.toString.trim.assertEqualsStrings(result.ruleFailedException.failureTraceAsString)
	}

	def private instantiateSystem(CharSequence input) {
		val instantiated = Wrapper.forType(XsemanticsRuntimeSystem)
		input.compile[
			val systemClass = compiledClass
			val obj = systemClass.newInstance
			getOrCreateInjectorProvider.injector.injectMembers(obj)
			obj.invoke("init")
			instantiated.set(obj as XsemanticsRuntimeSystem)
		]
		return instantiated.get
	}
}
