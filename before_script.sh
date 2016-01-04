#!/bin/bash

set -ev
if [ "${TRAVIS_OS_NAME}" = "linux" ]; then
	sh -e /etc/init.d/xvfb start
	sleep 5
	metacity --sm-disable --replace 2> metacity.err &
fi 
