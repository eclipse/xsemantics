package it.xsemantics.dsl.tests

import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EClass
import it.xsemantics.example.fj.fj.FjFactory

class EmfFactoryUtils {
	
	protected EcoreFactory factory = EcoreFactory::eINSTANCE
	
	protected FjFactory fjFactory = FjFactory::eINSTANCE
	
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