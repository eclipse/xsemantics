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

package org.eclipse.xsemantics.dsl.ui.outline

import org.eclipse.xsemantics.dsl.xsemantics.AuxiliaryDescription
import org.eclipse.xsemantics.dsl.xsemantics.AuxiliaryFunction
import org.eclipse.xsemantics.dsl.xsemantics.CheckRule
import org.eclipse.xsemantics.dsl.xsemantics.Description
import org.eclipse.xsemantics.dsl.xsemantics.AbstractFieldDefinition
import org.eclipse.xsemantics.dsl.xsemantics.JudgmentDescription
import org.eclipse.xsemantics.dsl.xsemantics.Named
import org.eclipse.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsFile
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.eclipse.xtext.util.ITextRegion

/**
 * customization of the default outline structure
 * 
 */
public class XsemanticsOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	def protected void _createChildren(DocumentRootNode parentNode, XsemanticsFile it) {
		// skip useless toplevel node and imports - start tree with node for "system" 
		createChildren(parentNode, it.getXsemanticsSystem())
	}
	
	def protected void _createChildren(IOutlineNode parentNode, XsemanticsSystem it) {
		// skip imports
		// fields
		createNodesFor(parentNode, fields)
		// auxiliary descriptions
		createGroupedNodesForAuxliary(parentNode, it)
		// judgment descriptions
		createGroupedNodesForJudgements(parentNode, it)
		// skip auxiliary functions and rules belonging to a description
		// checkrules
		createNodesFor(parentNode, checkrules)
		// nodes for auxiliary functions and rules that do not have a description
		// (of course this will represent errors in the input program)
		createNodesFor(parentNode, auxiliaryFunctions.filter[get_auxiliaryDescription === null])
		createNodesFor(parentNode, rules.filter[get_judgment === null])
	}
	
	def private <T extends EObject> void createNodesFor(IOutlineNode parentNode, Iterable<T> items){
		for(T item: items){
			createNode(parentNode, item)
		}
	}
	
	def private void createGroupedNodesForAuxliary(IOutlineNode parentNode, XsemanticsSystem it){
		val rootNodes = newLinkedHashSet
		rootNodes.addAll(auxiliaryDescriptions)		// all "local" descriptions
		rootNodes.addAll(auxiliaryFunctions.map[get_auxiliaryDescription].filterNull)	// all descriptions of superSystems which have functions in this file
		createNodesFor(parentNode, rootNodes)
	}
	
	def private void createGroupedNodesForJudgements(IOutlineNode parentNode, XsemanticsSystem it){
		val rootNodes = newLinkedHashSet
		rootNodes.addAll(judgmentDescriptions)		// all "local" descriptions
		rootNodes.addAll(rules.map[get_judgment].filterNull)	// all descriptions of superSystems which have rules in this file
		createNodesFor(parentNode, rootNodes)
	}
	
	
	def protected void _createNode(IOutlineNode parentNode, AuxiliaryDescription it) {
		val node = createEObjectNode(parentNode, it)
		
		// Merge all text regions from the description and all relevant functions to support editor to outline jumps.
		val childrenProvider = [XsemanticsSystem system | system.auxiliaryFunctions.filter[ function | function.get_auxiliaryDescription == it ] ]
		node.textRegion = calculateGroupedTextRegion(node, it, childrenProvider)
	}
	
	def protected void _createNode(IOutlineNode parentNode, JudgmentDescription it) {
		val node = createEObjectNode(parentNode, it)
		
		// Merge all text regions from the judgement and all relevant rules to support editor to outline jumps.
		val childrenProvider = [XsemanticsSystem system | system.rules.filter[ rule | rule.get_judgment == it ] ]
		node.textRegion = calculateGroupedTextRegion(node, it, childrenProvider)
	}
	
	def private ITextRegion calculateGroupedTextRegion(IOutlineNode node, Description it, (XsemanticsSystem) => Iterable<? extends Named> childrenProvider){
		val parentRegion = if (isLocalElement(node, it) ) node.fullTextRegion else ITextRegion.EMPTY_REGION
		var xsemanticsSystem = getXsemanticsSystem(node.parent, it)
		mergeRegions(parentRegion, childrenProvider.apply(xsemanticsSystem))
	}
	
	def private mergeRegions(ITextRegion startRegion, Iterable<? extends EObject> items){
		var region = startRegion
		for(EObject eo: items){
			val parserNode = NodeModelUtils.getNode(eo);
			if( parserNode !== null )
				region = region.merge(parserNode.textRegion)
		}
		region
	}
	
	def protected void _createChildren(IOutlineNode parentNode, AuxiliaryDescription it) {
		val xsemanticsSystem = getXsemanticsSystem(parentNode.parent, it)
		createNodesFor(parentNode, xsemanticsSystem.auxiliaryFunctions.filter[ function | function.get_auxiliaryDescription == it ])
	}
	
	def protected void _createChildren(IOutlineNode parentNode, JudgmentDescription it) {
		val xsemanticsSystem = getXsemanticsSystem(parentNode.parent, it)
		createNodesFor(parentNode, xsemanticsSystem.rules.filter[rule | rule.get_judgment == it ])
	}
	
	
	def protected boolean _isLeaf(Rule rule) {
		return true
	}

	def protected boolean _isLeaf(CheckRule rule) {
		return true
	}

	def protected boolean _isLeaf(JudgmentDescription desc) {
		return false
	}

	def protected boolean _isLeaf(AuxiliaryDescription desc) {
		return false
	}

	def protected boolean _isLeaf(AuxiliaryFunction aux) {
		return true
	}

	def protected boolean _isLeaf(AbstractFieldDefinition f) {
		return true
	}
	
	def private XsemanticsSystem  getXsemanticsSystem(IOutlineNode parentNode, Description description){
		if( isLocalElement(parentNode, description) ){
			EcoreUtil2.getContainerOfType(description, XsemanticsSystem)
		}
		else {
			// Do not use the actual description to get the system, because the description is in a different resource.
			parentNode.xsemanticsSystem
		}
	}
	
	def private XsemanticsSystem getXsemanticsSystem(IOutlineNode it){
		readOnly[ eo | 
			EcoreUtil2.getContainerOfType(eo, XsemanticsSystem)
		]
	}
}
