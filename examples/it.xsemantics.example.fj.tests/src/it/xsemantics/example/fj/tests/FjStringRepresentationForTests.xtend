package it.xsemantics.example.fj.tests

import it.xsemantics.example.fj.typing.FjStringRepresentation
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import it.xsemantics.example.fj.fj.New
import it.xsemantics.example.fj.fj.Selection
import it.xsemantics.example.fj.fj.Field

class FjStringRepresentationForTests extends FjStringRepresentation {
	override stringRep(EObject eObject) {
		val node = NodeModelUtils::getNode(eObject)
		if (node != null)
			return super.stringRep(eObject)
		else
			return customRep(eObject).toString
	}
	
	def stringRep(Field f) {
		f.name
	}
	
	def dispatch customRep(EObject eObject) {
		super.stringRep(eObject)
	}
	
	def dispatch customRep(New exp) {
		'''new «exp.type.classref.name»(''' +
		exp.args.map [
			it.string
		].join(", ") +
		''')'''
	}
	
	def dispatch customRep(Selection exp) {
		'''«exp.receiver.string».«exp.message.string»'''
	}

}