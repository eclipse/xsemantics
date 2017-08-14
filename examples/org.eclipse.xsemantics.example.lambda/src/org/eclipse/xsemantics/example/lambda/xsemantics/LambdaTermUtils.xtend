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

package org.eclipse.xsemantics.example.lambda.xsemantics

import org.eclipse.xsemantics.example.lambda.lambda.Term
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xsemantics.example.lambda.lambda.Abstraction

class LambdaTermUtils {
	
	def static cloneWithoutTypes(Term term) {
		val clone = term.copy
		clone.eAllOfType(typeof(Abstraction)).forEach [
			it.param.type = null
		]
		clone
	}
}