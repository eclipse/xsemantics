package de.itemis.xcore2java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.mwe.PathTraverser;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;

/**
 * A reader that allows to parse Xcore files and use the contained EPackages.
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=410736
 * 
 * @author Christan Dietrich <christian.dietrich@itemis.de> - Initial contribution and API
 */
public class XcoreReader extends AbstractWorkflowComponent2 {
	
	protected List<String> pathes = Lists.newArrayList();

	public void addPath(String path) {
		this.pathes.add(path);
	}

	public List<String> getPathes() {
		return pathes;
	}
	
	private String slot;

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		ResourceSet resourceSet = getResourceSet();
		Multimap<String, URI> uris = getPathTraverser().resolvePathes(pathes, new Predicate<URI>() {
			public boolean apply(URI input) {
				return input.fileExtension().equals("xcore");
			}
		});
		int counter = 0;
		List<Resource> resources = new ArrayList<Resource>();
		for (URI uri : uris.values()) {
				String path = uri.toFileString();
				Resource r;
				System.out.println(path);
				try {
					r = parse(new FileInputStream(path),URI.createURI(counter+".xcore"),null, resourceSet);
					resources.add(r);
					counter++;
				} catch (FileNotFoundException e) {
					issues.addError("problem while reading", e);
					e.printStackTrace();
				}
		}
		EcoreUtil.resolveAll(resourceSet);
		for (Resource r : resources) {
			for (Diagnostic x : r.getErrors()) {
				issues.addError(x.getMessage(), x);
			}

		}
		ctx.set(slot, resources);
		
		
	}
	private Resource parse(InputStream in, URI uriToUse, Map<?, ?> options, ResourceSet resourceSet) {
		
		Resource resource = resourceSet.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			resource.load(in, options);
			return resource;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	protected PathTraverser getPathTraverser() {
		return new PathTraverser();
	}

	protected ResourceSet getResourceSet() {
		if (!injectors.isEmpty()) {
			ResourceSet instance = injectors.get(0).getInstance(ResourceSet.class);
			return instance;
		}
		return new ResourceSetImpl();
	}
	
	private List<Injector> injectors = Lists.newArrayList();

	public void addRegister(ISetup setup) {
		injectors.add(setup.createInjectorAndDoEMFRegistration());
	}

	protected List<Injector> getInjectors() {
		return injectors;
	}

}