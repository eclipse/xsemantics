/**
 * 
 */
package it.xsemantics.example.fj.tests.loader;

import java.io.InputStream;

import it.xsemantics.example.fj.FJStandaloneSetup;
import it.xsemantics.example.fj.fj.Program;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author bettini
 */
public class FJAbstractTests extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(FJStandaloneSetup.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// TODO serialize tests fail:
		// expected: ref Class extends ref: Class@//@classes.0
		// actual: ref Class extends ref: Class@mytestmodel.fj#//@classes.0
		// in AbstractXtextTests: tester.assertSerializeWithoutNodeModel(obj);
		return false;
	}

	public Program getProgramFromString(String program) throws Exception {
		return (Program) getModel(program);
	}
	
	/**
	 * Also adds the Object.fj resource
	 * @see org.eclipse.xtext.junit.AbstractXtextTests#doGetResource(java.io.InputStream, org.eclipse.emf.common.util.URI)
	 */
	@Override
	protected XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		
		rs.getResource(URI.createURI(FJTestLoader.OBJECT_FJ_URI), true);

		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		if (resource instanceof LazyLinkingResource) {
			((LazyLinkingResource) resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		} else {
			EcoreUtil.resolveAll(resource);
		}
		return resource;
	}

}
