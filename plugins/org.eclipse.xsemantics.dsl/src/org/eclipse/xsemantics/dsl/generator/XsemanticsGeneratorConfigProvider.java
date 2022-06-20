/*******************************************************************************
 * Copyright (c) 2022 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/
package org.eclipse.xsemantics.dsl.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;

/**
 * In order to make {@link XbaseCompiler} generate Java 8 lambdas also when
 * running from xtext-maven-plugin.
 * 
 * @see https://github.com/eclipse/xsemantics/issues/169
 * 
 * @author Lorenzo Bettini
 *
 */
public class XsemanticsGeneratorConfigProvider extends GeneratorConfigProvider {

	@Override
	public GeneratorConfig get(EObject context) {
		GeneratorConfig generatorConfig = super.get(context);
		generatorConfig.setJavaSourceVersion(JavaVersion.JAVA8);
		return generatorConfig;
	}
}