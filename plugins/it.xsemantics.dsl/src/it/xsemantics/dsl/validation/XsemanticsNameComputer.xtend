package it.xsemantics.dsl.validation

import org.eclipse.emf.ecore.EObject
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.Injected
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.CheckRule

class XsemanticsNameComputer {
	
	def static computeName(EObject it) {
		switch (it) {
			JudgmentDescription: name
			AuxiliaryDescription: name
			Injected: name
			AuxiliaryFunction: name
			Rule: name
			CheckRule: name
		}
	}
}