package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.FjFactory
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet

class EmfFactoryUtils {
	
	protected EcoreFactory factory = EcoreFactory::eINSTANCE
	
	protected FjFactory fjFactory = FjFactory::eINSTANCE
	
	@Inject
	private IResourceFactory resourceFactory;
	
	var counter = 0

	def createResource(ResourceSet resourceSet, (Resource) => void init) {
		val name = "__synthetic";
		val syntheticUri = URI.createURI(name + (counter++) + "." + "testresource");
		resourceFactory.createResource(syntheticUri) => [
			resourceSet.resources += it
			init.apply(it)
		]
	}

	def createEObject(Resource resource) {
		resource.contents += createEObject
	}
	
	def createEObject() {
		factory.createEObject
	}
	
	def createEClass(String name) {
		val e = factory.createEClass
		e.name = name
		e
	}
	
	def createEClass(String name, EClass superClass) {
		val e = createEClass(name)
		e.ESuperTypes += superClass
		e
	}
	
	def createFjClass(String name) {
		val c = fjFactory.createClass()
		c.name = name
		c
	}
	
	def createFjField(String name) {
		val f = fjFactory.createField
		f.name = name
		f
	}
	
	def createFjMethod(String name) {
		val m = fjFactory.createMethod
		m.name = name
		m
	}
}