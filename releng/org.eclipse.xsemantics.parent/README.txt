*******************************************************************************
Copyright (c) 2013-2017 Lorenzo Bettini.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
  Lorenzo Bettini - Initial contribution and API
*******************************************************************************

To test a composite release locally, from the root folder

mkdir -p ${HOME}/tmp/download-area

mvn -f releng/org.eclipse.xsemantics.releng/pom.xml package \
	-DskipTests=true \
	-Dxtext.maven.skip=true \
	-Dcbi.jarsigner.skip=true \
	-Dxsemantics.download.area=${HOME}/tmp/download-area \
	-Prelease-composite,release-milestone