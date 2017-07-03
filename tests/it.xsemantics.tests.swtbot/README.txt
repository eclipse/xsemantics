*******************************************************************************
Copyright (c) 2013-2017 Lorenzo Bettini.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
  Lorenzo Bettini - Initial contribution and API
*******************************************************************************

In Linux you can run UI tests in a different display
(so that you can continue working without UI tests getting in your way)

sudo apt-get install metacity xserver-xephyr

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
Xephyr -screen 1024x768 :50 &
sleep 5
export DISPLAY=:50
metacity --sm-disable --replace 2> ~/tmp/metacity.err &


You can then run mvn from that terminal, or use an Eclipse
launch configuration where the environment variable DISPLAY is set
to the value :50