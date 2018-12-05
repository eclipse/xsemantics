<!--
Copyright (c) 2013-2017 Lorenzo Bettini.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
  Lorenzo Bettini - Initial contribution and API
-->

Xsemantics
============================

Xsemantics is a DSL (implemented in Xtext itself) for writing type systems, reduction rules, interpreters (and in general relation rules) for languages implemented in Xtext. It then generates Java code that can be used in your language implemented in Xtext for scoping and validation (it can also generate a validator in Java).

https://projects.eclipse.org/projects/modeling.xsemantics

## Milestones update site:

http://download.eclipse.org/xsemantics/milestones/

- version 1.13 requires Xtext 2.13.0
- version 1.14 requires Xtext 2.14.0
- version 1.15 requires Xtext 2.15.0

## Maven snapshots

- version 1.13.0-SNAPSHOT requires Xtext 2.13.0
- version 1.14.0-SNAPSHOT requires Xtext 2.14.0
- version 1.15.0-SNAPSHOT requires Xtext 2.15.0

Make sure you enable Maven snapshots repositories, see, e.g., https://github.com/eclipse/xsemantics/blob/master/tests/org.eclipse.xsemantics.example.maven.test/pom.xml

[![Build Status](https://travis-ci.org/eclipse/xsemantics.svg?branch=master)](https://travis-ci.org/eclipse/xsemantics) [![Coverage Status](https://coveralls.io/repos/github/eclipse/xsemantics/badge.svg?branch=master)](https://coveralls.io/github/eclipse/xsemantics?branch=master)
