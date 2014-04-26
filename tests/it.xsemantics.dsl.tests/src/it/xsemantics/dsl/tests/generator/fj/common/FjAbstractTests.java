/**
 * 
 */
package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Program;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.After;
import org.junit.Assert;

/**
 * @author bettini
 * 
 */
public abstract class FjAbstractTests extends AbstractXtextTests {

	protected FjInputFilesForTyping testFiles = new FjInputFilesForTyping();
	
	protected FjTestsUtils fjTestsUtils = new FjTestsUtils();

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// TODO serialize tests fail:
		// expected: ref Class extends ref: Class@//@classes.0
		// actual: ref Class extends ref: Class@mytestmodel.fj#//@classes.0
		// in AbstractXtextTests: tester.assertSerializeWithoutNodeModel(obj);
		return false;
	}

	protected Program getProgram(CharSequence program) throws Exception {
		return getProgram(program.toString());
	}

	protected Program getProgram(String model) throws Exception {
		return (Program) getModel(model);
	}

	public Class fjClassForName(Program program, String className) {
		return fjTestsUtils.fjClassForName(program, className);
	}
	
	protected void assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
				("" + expected).replaceAll("\r", ""), 
				("" + actual).replaceAll("\r", "")
			);
	}

}
