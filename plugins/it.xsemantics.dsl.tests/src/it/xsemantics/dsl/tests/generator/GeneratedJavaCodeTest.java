package it.xsemantics.dsl.tests.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.GeneratorUtils;
import it.xsemantics.dsl.generator.XsemanticsGenerator;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
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
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Functions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class GeneratedJavaCodeTest extends XsemanticsBaseTest {

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
	public void testSimpleRule() throws Exception {
		assertEquals(SIMPLE_TYPE_SYSTEM,
				compileWithJava(testFiles.testSimpleRule(), SIMPLE_TYPE_SYSTEM)
						.getName());
	}

	@Test
	public void testRuleInvocation() throws Exception {
		checkCompilationOfInputFile("ecore_ruleinvocation_test.xsemantics",
				RULEINVOCATION_ECORE_TYPE_SYSTEM, TYPE_SYSTEM);
	}

	@Test
	public void testFjFirst() throws Exception {
		checkCompilationOfInputFile("fj_first_test.xsemantics",
				FJ_FIRST_PACKAGE, FJ_FIRST_TYPE_SYSTEM);
	}

	@Test
	public void testFjAlt() throws Exception {
		checkCompilationOfInputFile("fj_alt_test.xsemantics", FJ_ALT_PACKAGE,
				FJ_ALT_TYPE_SYSTEM);
	}

	@Test
	public void testEcore() throws Exception {
		checkCompilationOfInputFile("ecore_test.xsemantics", ECORE_TYPE_SYSTEM,
				TYPE_SYSTEM);
	}

	@Test
	public void testParticularCases() throws Exception {
		checkCompilationOfInputFile("ecore_particular_test.xsemantics",
				PARTICULAR_ECORE_TYPE_SYSTEM, TYPE_SYSTEM);
	}

	@Test
	public void testOrExpressions() throws Exception {
		checkCompilationOfInputFile("ecore_or_test.xsemantics",
				OR_ECORE_TYPE_SYSTEM, TYPE_SYSTEM);
	}

	@Test
	public void testExpressions() throws Exception {
		checkCompilationOfInputFile("ecore_expressions_test.xsemantics",
				EXPRESSIONS_ECORE_TYPE_SYSTEM, TYPE_SYSTEM);
	}

	@Test
	public void testValidationEcore() throws Exception {
		checkCompilationOfInputFile("ecore_validation_test.xsemantics",
				VALIDATION_ECORE_TYPE_SYSTEM, TYPE_SYSTEM);
	}

	protected void checkCompilationOfInputFile(String inputFile, String pack,
			String className) throws Exception {
		final String fullPathInputFile = TESTS_INPUT_FILES + inputFile;

		final String fullyQualifiedClassName = pack + className;

		InMemoryFileSystemAccess fsa = generateJavaCode(loadResourceFromFile(fullPathInputFile));

		assertEquals(fullyQualifiedClassName,
				compileWithJava(fsa, fullyQualifiedClassName).getName());

		final String validatorClassName = pack + "validation." + className
				+ "Validator";

		assertEquals(validatorClassName,
				compileWithJava(fsa, validatorClassName).getName());
	}

	protected Class<?> compileWithJava(CharSequence program, String className)
			throws Exception {
		XsemanticsSystem parse = parseAndAssertNoError(program);
		Resource eResource = parse.eResource();
		return compileWithJava(eResource, className);
	}

	protected Class<?> compileWithJava(String fileName, String className)
			throws Exception {
		return compileWithJava(loadResourceFromFile(fileName), className);
	}

	protected Resource loadResourceFromFile(String fileName) {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(fileName), true);

		// validate the resource
		List<Issue> issues = validator.validate(resource, CheckMode.ALL,
				CancelIndicator.NullImpl);
		if (!issues.isEmpty() && GeneratorUtils.hasErrors(issues)) {
			for (Issue issue : issues) {
				System.err.println(issue);
			}
			fail("validation failed");
		}
		return resource;
	}

	protected Class<?> compileWithJava(Resource eResource, String className)
			throws InstantiationException, IllegalAccessException {
		InMemoryFileSystemAccess fsa = generateJavaCode(eResource);
		return compileWithJava(fsa, className);
	}

	protected Class<?> compileWithJava(InMemoryFileSystemAccess fsa,
			String className) {
		CharSequence concatenation = fsa.getFiles().get(
				OUTPUT_PREFIX + className.replace(".", "/") + ".java");
		Class<?> class1 = javaCompiler.compileToClass(className,
				concatenation.toString());
		return class1;
	}

	protected InMemoryFileSystemAccess generateJavaCode(Resource eResource) {
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		generator.doGenerate(eResource, fsa);
		return fsa;
	}

}
