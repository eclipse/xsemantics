/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.xtext.xbase.compiler.ImportManager

class XsemanticsValidatorGenerator {
	
	@Inject extension XsemanticsGeneratorExtensions
	
	def compile(XsemanticsSystem ts) {
		val importManager = new ImportManager(true, ts.createValidatorJvmType)
		compile(ts, importManager)
	}
	
	def compile(XsemanticsSystem ts, ImportManager importManager) '''
		«val packageGen = ts.toValidatorPackage»
		«val injectClass = importManager.injectAnnotation»
		«val generatedTypeSystemClass = importManager.serialize(ts.createJvmType)»
		«val superClass = importManager.serialize(createJvmType(typeof(XsemanticsBasedDeclarativeValidator)))»
		«val checkMethods = ts.compileCheckRuleMethods(importManager)»
		«IF packageGen.length > 0»
		package «packageGen»;
		«ENDIF»
		«IF !importManager.imports.empty»

		«FOR i : importManager.imports»
		import «i»;
		«ENDFOR»
		«ENDIF»

		public class «ts.toValidatorJavaClassName» extends «superClass» {
			«injectClass»
			protected «generatedTypeSystemClass» xsemanticsSystem;
		
			«checkMethods»
		}
	'''

	def compileCheckRuleMethods(XsemanticsSystem ts, ImportManager importManager) {
		ts.getCheckrules.map([ it.compileCheckRuleMethod(importManager) ]).join("\n")
	}

	def compileCheckRuleMethod(CheckRule rule, ImportManager importManager) {
		'''
		«importManager.checkAnnotation»
		public void «rule.methodName»(«rule.inputParameter(importManager)») {
			generateErrors(
				xsemanticsSystem.«rule.methodName»(«rule.inputParameterName»),
				«rule.inputParameterName»);
		}
		'''
	}
}