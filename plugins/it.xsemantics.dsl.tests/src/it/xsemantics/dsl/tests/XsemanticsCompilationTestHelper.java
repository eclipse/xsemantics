/**
 * 
 */
package it.xsemantics.dsl.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * A custom helper since we generate two classes for each input file.
 * 
 * @author Lorenzo Bettini
 * 
 */
@SuppressWarnings("restriction")
public class XsemanticsCompilationTestHelper extends CompilationTestHelper {
	@Inject
	private XsemanticsOnTheFlyJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<EObject> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private IGenerator generator;
	
	/**
	 * A result contains information about various aspects of a compiled piece of code.
	 *   
	 */
	public static interface Result {
		/**
		 * @return the loaded, validated and fully linked source resource
		 */
		Resource getSource();
		
		/**
		 * Compile all Java sources generated for a resource
		 */
		void compileToJava();
		
		/**
		 * @return access to all generated artifacts. The key points to the pathesa dn the values are the generated code.
		 */
		Map<String,CharSequence> getAllGeneratedResources();
	}

	public void compileAll(CharSequence source, IAcceptor<Result> acceptor) {
		try {
			compileAll(parseHelper.parse(source), acceptor);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void compileAll(final EObject parsed, IAcceptor<Result> acceptor) {
			validationTestHelper.assertNoErrors(parsed);
			final InMemoryFileSystemAccess access = new InMemoryFileSystemAccess();
			
			ResourceSet resourceSet = parsed.eResource().getResourceSet();
			for (Resource resource : Lists.newArrayList(resourceSet.getResources())) {
				if (resource instanceof XtextResource) {
					generator.doGenerate(resource, access);
				}
			}
			
			acceptor.accept(new Result() {

				public Resource getSource() {
					return (Resource) parsed.eResource();
				}

				public void compileToJava() {
					Map<String, String> toCompile = new HashMap<String, String>();
					
					for (final Entry<String, CharSequence> e : access.getFiles().entrySet()) {
						String name = e.getKey().substring(
								"DEFAULT_OUTPUT".length(),
								e.getKey().length() - ".java".length());
						name = name.replace('/', '.');
						toCompile.put(name, e.getValue().toString());
					}
					
					javaCompiler.compileAll(toCompile);
				}

				public Map<String, CharSequence> getAllGeneratedResources() {
					return access.getFiles();
				}

			});
			
	}
}
