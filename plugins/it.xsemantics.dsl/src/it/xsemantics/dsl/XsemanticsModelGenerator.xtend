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
 package it.xsemantics.dsl

import java.util.List
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.xbase.compiler.FileHeaderAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import com.google.inject.Inject
import org.eclipse.xtext.documentation.IFileHeaderProvider

/**
 * Customized version of {@link JvmModelGenerator}
 */
class XsemanticsModelGenerator extends JvmModelGenerator {
	@Inject protected extension ReflectExtensions

	/**
	 * This method copies logic from {@link JvmModelGenerator#generateFileHeader}
	 * but it calls {@link #generateFileHeaderComment} to enable custom comment syntax
	 * in copyright headers.
	 */
	override void generateFileHeader(JvmDeclaredType declType, ITreeAppendable appendable, GeneratorConfig config) {
		val fileHeaderAdapter = declType.eAdapters.filter(FileHeaderAdapter).head
		if (!fileHeaderAdapter?.headerText.nullOrEmpty) {
			val fileHeaderProvider = get('fileHeaderProvider') as IFileHeaderProvider
			val fileHeaderNodes = fileHeaderProvider.getFileHeaderNodes(declType.eResource)
			generateFileHeaderComment(fileHeaderAdapter.headerText, fileHeaderNodes, appendable, config)
		}
	}

	/**
	 * This method prepends the given copyright header text assuming this text is a legal comment.
	 */
	def protected generateFileHeaderComment(String headerComment, List<INode> documentationNodes,
		ITreeAppendable appendable, GeneratorConfig config) {

		val doc = new StringConcatenation()
		doc.append(headerComment)
		if (!documentationNodes.empty) {
			var documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION
			for (node : documentationNodes) {
				documentationTrace = documentationTrace.merge(node.textRegionWithLineInformation)
			}
			appendable.trace(new LocationData(documentationTrace, null)).append(doc.toString)
			appendable.newLine

		} else {
			appendable.append(doc.toString).newLine
		}
	}

}
