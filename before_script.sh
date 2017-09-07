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

set -ev
if [ "${TRAVIS_OS_NAME}" = "linux" ]; then
	sh -e /etc/init.d/xvfb start
	sleep 5
	metacity --sm-disable --replace 2> metacity.err &
fi 
