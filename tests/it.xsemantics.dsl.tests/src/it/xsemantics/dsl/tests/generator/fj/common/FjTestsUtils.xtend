package it.xsemantics.dsl.tests.generator.fj.common

import it.xsemantics.example.fj.fj.Field
import it.xsemantics.example.fj.fj.Member
import it.xsemantics.example.fj.fj.Method
import it.xsemantics.example.fj.fj.ParamRef
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.TraceUtils
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics
import org.junit.Assert

import static extension org.eclipse.xtext.EcoreUtil2.*

class FjTestsUtils {
	
	val extension TraceUtils traceUtils = new TraceUtils
	
	def fjClassForName(Program program, String className) {
		program.classes.findFirst( [ it.name.equals(className) ] )
	}
	
	def fjFieldForName(Program program, String fieldName) {
		val field = program.getAllContentsOfType(typeof(Field)).
			findFirst( [ it.name.equals(fieldName) ] )
		Assert::assertTrue("field not found: " + fieldName, field !== null)
		field
	}
	
	def fjMethodForName(Program program, String methodName) {
		val method = program.getAllContentsOfType(typeof(Method)).
			findFirst( [ it.name.equals(methodName) ] )
		Assert::assertTrue("method not found: " + methodName, method !== null)
		method
	}
	
	def mainExpression(Program program) {
		program.main
	}
	
	def variableExpression(Program program) {
		program.getAllContentsOfType(typeof(ParamRef)).get(0)
	}
	
	def diagnosticsToString(AssertableDiagnostics validate) {
		validate.diagnostic.children.join("\n");
	}
	
	def removeObjectIdentifiers(String s) {
		s.replaceAll("@(\\w)+", "")
	}
	
	def field(Member member) {
		member as Field
	}
	
	def method(Member member) {
		member as Method
	}

	def void assertTrace(RuleApplicationTrace trace, CharSequence expectedTrace) {
		assertEqualsStrings(expectedTrace.toString.trim,
			trace.traceAsString
		)
	}

	def void assertFailureTrace(RuleFailedException e, CharSequence expectedTrace) {
		assertEqualsStrings(expectedTrace.toString.trim,
			e.failureTraceAsString
		)
	}

	def assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
			("" + expected).replaceAll("\r", ""), 
			("" + actual).replaceAll("\r", "")
		)
	}
}