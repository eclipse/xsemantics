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

	def private invokeTypeAndExpect(CharSequence input, CharSequence expectedTrace) {
		val system = input.instantiateSystem
		val trace = new RuleApplicationTrace
		system.invoke("type", null, trace, newArrayList("first", "second"))
		expectedTrace.assertEqualsStrings(trace.traceAsString)
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
