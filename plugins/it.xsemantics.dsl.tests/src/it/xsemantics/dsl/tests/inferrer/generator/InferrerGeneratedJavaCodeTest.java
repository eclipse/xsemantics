package it.xsemantics.dsl.tests.inferrer.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import it.xsemantics.dsl.generator.GeneratorUtils;
import it.xsemantics.dsl.generator.XsemanticsGenerator;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;

import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Functions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProviderForInferrer.class)
@RunWith(XtextRunner.class)
public class InferrerGeneratedJavaCodeTest extends XsemanticsBaseTest {

	protected static final String FJ_FIRST_TYPE_SYSTEM = "FjFirstTypeSystem";

	protected static final String FJ_ALT_TYPE_SYSTEM = "FjAltTypeSystem";

	protected static final String TYPE_SYSTEM = "TypeSystem";

	protected final static String OUTPUT_PREFIX = "DEFAULT_OUTPUT";

	protected static final String TEST_PACKAGE_PREFIX = "it.xsemantics.test.";

	protected static final String FJ_FIRST_PACKAGE = TEST_PACKAGE_PREFIX
			+ "fj.first.";

	protected static final String FJ_ALT_PACKAGE = TEST_PACKAGE_PREFIX
			+ "fj.alt.";

	protected static final String ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "ecore.";

	protected static final String PARTICULAR_ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "particular.ecore.";

	protected static final String RULEINVOCATION_ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "ruleinvocation.ecore.";

	protected static final String OR_ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "orexpressions.ecore.";

	protected static final String EXPRESSIONS_ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "expressions.ecore.";

	protected static final String VALIDATION_ECORE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ "validation.ecore.";

	protected static final String SIMPLE_TYPE_SYSTEM = TEST_PACKAGE_PREFIX
			+ TYPE_SYSTEM;

	protected static final String TESTS_INPUT_FILES = "./tests_input_files/";

	@Inject
	protected EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	protected XsemanticsGenerator generator;

	@Inject
	protected XsemanticsGeneratorExtensions genExtensions;

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private JvmModelGenerator jvmModelGenerator;

	@Before
	public void initializeClassPath() throws Exception {
		javaCompiler.addClassPathOfClass(getClass()); // this bundle
		javaCompiler.addClassPathOfClass(Functions.class); // xbase.lib
		javaCompiler.addClassPathOfClass(Provider.class); // google guice
		javaCompiler.addClassPathOfClass(Supplier.class); // google collect
		javaCompiler.addClassPathOfClass(XsemanticsRuntimeSystem.class);
		javaCompiler.addClassPathOfClass(EClass.class);
		javaCompiler.addClassPathOfClass(EObject.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(PolymorphicDispatcher.class);
		javaCompiler.addClassPathOfClass(BasicType.class);
		javaCompiler.addClassPathOfClass(EcoreUtil2.class);
	}

	@Test
	public void testGenSimpleRule() throws Exception {
		assertEquals(SIMPLE_TYPE_SYSTEM,
				compileToJava(testFiles.testSimpleRule(), SIMPLE_TYPE_SYSTEM)
						.getName());
	}

	@Test
	public void testGenRuleWithTwoOutputParams() throws Exception {
		assertEquals(
				SIMPLE_TYPE_SYSTEM,
				compileToJava(testFiles.testRuleWithTwoOutputParams(),
						SIMPLE_TYPE_SYSTEM).getName());
	}

	protected Class<?> compileToJava(CharSequence program, String className)
			throws Exception {
		XsemanticsSystem parse = parseAndAssertNoError(program);
		Resource eResource = parse.eResource();
		return compileToJava(eResource, className);
	}

	protected Class<?> compileToJava(Resource eResource, String className)
			throws InstantiationException, IllegalAccessException {
		InMemoryFileSystemAccess fsa = generateJava(eResource);
		return compileToJava(fsa, className);
	}

	protected Class<?> compileToJava(InMemoryFileSystemAccess fsa,
			String className) {
		CharSequence concatenation = fsa.getFiles().get(
				OUTPUT_PREFIX + className.replace(".", "/") + ".java");
		Class<?> class1 = javaCompiler.compileToClass(className,
				concatenation.toString());
		return class1;
	}

	protected InMemoryFileSystemAccess generateJava(Resource eResource) {
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		jvmModelGenerator.doGenerate(eResource, fsa);
		return fsa;
	}

}
