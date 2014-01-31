package it.xsemantics.dsl.util

import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Injected
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.emf.ecore.EObject

class XsemanticsModelExtensions {
	
	def static computeName(EObject it) {
		switch (it) {
			JudgmentDescription: name
			AuxiliaryDescription: name
			Injected: name
			Rule: name
			CheckRule: name
		}
	}

}