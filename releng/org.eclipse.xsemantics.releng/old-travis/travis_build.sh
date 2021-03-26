#!/bin/bash
#
# Copyright (c) 2013-2017 Lorenzo Bettini.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Lorenzo Bettini - Initial contribution and API
#

# -Dtycho.disableP2Mirrors=true if there are problems with Eclipse mirrors

set -ev
if [ "$TRAVIS_OS_NAME" == "osx" ]; then
	if [ "${TRAVIS_PULL_REQUEST}" != "false" ]; then
		echo "Build on MacOSX: Pull Request"
		mvn -f releng/org.eclipse.xsemantics.releng/pom.xml clean verify -Dfindbugs.skip=true
	else
		echo "Skipping build on MacOSX for standard commit"
	fi
else
	echo "Build on Linux"
	mvn -f releng/org.eclipse.xsemantics.releng/pom.xml clean verify -Dfindbugs.skip=true -Pjacoco-report coveralls:report
fi 
