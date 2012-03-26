/**
 * 
 */
package it.xsemantics.example.fj.tests.loader;

import it.xsemantics.example.fj.FJStandaloneSetup;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.util.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * @author bettini
 * 
 *         Loads (and parses) a local test fj file
 */
public class FJTestLoader {
	public static final String OBJECT_FJ = "Object.fj";

	public static final String PLATFORM_URI_FOR_FJ_LIB = "platform:/resource/it.xsemantics.example.fj.tests/src/it/xsemantics/example/fj/lib/";

	public static final String OBJECT_FJ_URI = PLATFORM_URI_FOR_FJ_LIB
			+ OBJECT_FJ;

	Injector injector = new FJStandaloneSetup()
			.createInjectorAndDoEMFRegistration();

	private XtextResourceSet resourceSet;

	public FJTestLoader() throws IOException {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");

		resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		//resourceSet.getResource(uriForFjLibFiles(OBJECT_FJ), true);
		Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/Object.fj"));
		String program = "class Object { } ";
		InputStream in = new ByteArrayInputStream(program.getBytes());
		resource.load(in, resourceSet.getLoadOptions());
	}

	public Resource createResource() {
		return resourceSet.createResource(URI.createURI("http:///My.fj"));
	}

	public Resource loadResource(String fileName) {
		return resourceSet.getResource(uriForFjTestFiles(fileName), true);
	}

	protected URI uriForFjTestFiles(String fileName) {
		return URI
				.createURI("platform:/resource/it.xsemantics.example.fj.tests/tests/"
						+ fileName);
	}
	
	protected URI uriForFjLibFiles(String fileName) {
		return URI
				.createURI(PLATFORM_URI_FOR_FJ_LIB
						+ fileName);
	}

	public Resource loadFromString(String program) throws IOException {
		Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/example.fj"));
		InputStream in = new ByteArrayInputStream(program.getBytes());
		resource.load(in, resourceSet.getLoadOptions());
		return resource;
	}
	
	public Injector getInjector() {
		return injector;
	}

	public Program loadProgramFromString(String program) throws IOException {
		return (Program)loadFromString(program).getContents().get(0);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FJTestLoader loader = new FJTestLoader();
		Resource resource = loader.loadResource("one_class.fj");
		EObject program = resource.getContents().get(0);
		System.out.println(new ModelPrinter().doSwitch(program));
		
		resource = loader.loadFromString("class A { A a; } class B extends A { B b; }");
		program = resource.getContents().get(0);
		System.out.println(new ModelPrinter().doSwitch(program));
	}

}
