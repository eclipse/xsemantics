package it.xsemantics.dsl.tests.inferrer.generator;

import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
import it.xsemantics.dsl.tests.generator.GeneratedJavaCodeTest;

import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProviderForInferrer.class)
@RunWith(XtextRunner.class)
public class InferrerGeneratedJavaCodeTest extends GeneratedJavaCodeTest {

	@Override
	protected void checkCompilationOfGeneratedValidator(String pack,
			String className, InMemoryFileSystemAccess fsa) {
		// nothing for the moment: the validator is not generated
	}
}
