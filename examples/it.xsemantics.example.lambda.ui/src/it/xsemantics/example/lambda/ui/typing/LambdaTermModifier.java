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

/**
 * 
 */
package it.xsemantics.example.lambda.ui.typing;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.xsemantics.LambdaTypeModifier;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 * 
 */
public class LambdaTermModifier {

	@Inject
	protected LambdaTypeModifier lambdaTypeModifier;

	public void modifyAbstractionWithInferredType(
			IXtextDocument xtextDocument) {
		xtextDocument.modify(new IUnitOfWork.Void<XtextResource>() {
			public void process(XtextResource resource) {
				Program program = (Program) resource.getContents().get(0);
				Abstraction abstraction = (Abstraction) (program.getTerm());
				lambdaTypeModifier.modifyAbstractionParamType(abstraction);
			}
		});
	}

	public void modifyTermWithInferredType(IXtextDocument xtextDocument) {
		xtextDocument.modify(new IUnitOfWork.Void<XtextResource>() {
			public void process(XtextResource resource) {
				Program program = (Program) resource.getContents().get(0);
				lambdaTypeModifier.setAllTypes(program.getTerm());
			}
		});
	}

}
