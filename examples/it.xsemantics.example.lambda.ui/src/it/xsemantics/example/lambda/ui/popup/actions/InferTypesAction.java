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
package it.xsemantics.example.lambda.ui.popup.actions;

import it.xsemantics.example.lambda.ui.typing.LambdaTermModifier;
import it.xsemantics.example.lambda.ui.util.LambdaUiUtil;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * @author Lorenzo Bettini
 * 
 */
public class InferTypesAction implements IEditorActionDelegate {
	protected IEditorPart editor;

	protected LambdaTermModifier lambdaTermModifier;

	public InferTypesAction() {
		lambdaTermModifier = LambdaUiUtil.getInjector().getInstance(
				LambdaTermModifier.class);
	}

	public void run(IAction action) {
		IXtextDocument xtextDocument = ((XtextEditor) editor).getDocument();
		lambdaTermModifier.modifyTermWithInferredType(xtextDocument);
	}

	public void selectionChanged(IAction action, ISelection selection) {

	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = targetEditor;
	}

}
