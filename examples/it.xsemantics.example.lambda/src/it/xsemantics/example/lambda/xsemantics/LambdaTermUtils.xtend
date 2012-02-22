package it.xsemantics.example.lambda.xsemantics

import it.xsemantics.example.lambda.lambda.Term
import static extension org.eclipse.xtext.EcoreUtil2.*
import it.xsemantics.example.lambda.lambda.Abstraction

class LambdaTermUtils {
	
	def static cloneWithoutTypes(Term term) {
		val clone = term.copy
		clone.eAllOfType(typeof(Abstraction)).forEach [
			it.param.type = null
		]
		clone
	}
}