#!/bin/bash

# To disable Eclipse mirrors: -Dtycho.disableP2Mirrors=true

set -ev
if [ "$TRAVIS_OS_NAME" == "osx" ]; then
	if [ "${TRAVIS_PULL_REQUEST}" != "false" ]; then
		echo "Build on MacOSX: Pull Request"
		mvn -f releng/it.xsemantics.releng/pom.xml clean verify -Dfindbugs.skip=true
	else
		echo "Skipping build on MacOSX for standard commit"
	fi
else
	echo "Build on Linux"
	mvn -f releng/it.xsemantics.releng/pom.xml clean verify -Dfindbugs.skip=true -Pjacoco-report coveralls:report
fi 
