# How to contribute to Eclipse Xsemantics

First of all, thanks for considering to contribute to Eclipse Xsemantics. We greatly appreciate your help!

## Legal Requirements

Xsemantics is an [Eclipse](http://www.eclipse.org) project and as such is governed by the Eclipse Development process.
This process helps us in creating open source software within a safe legal framework.

### First Steps
For you as a contributor, the following preliminary steps are required in order for us to be able to accept your contribution:

* Sign the [Eclipse Foundation Contributor License Agreement](http://www.eclipse.org/legal/CLA.php).
In order to do so:

  * Obtain an Eclipse Foundation user ID. Anyone who currently uses Eclipse Bugzilla or Gerrit systems already has one of those.
If you don't already have an account simply [register on the Eclipse web site](https://dev.eclipse.org/site_login/createaccount.php).
  * Once you have your account, log in to the [projects portal](https://projects.eclipse.org/), select *My Account* and then the *Contributor License Agreement* tab.

* Add your GitHub username to your Eclipse Foundation account. Log in to Eclipse and go to [Edit my account](https://dev.eclipse.org/site_login/myaccount.php).

### File Headers
We use a common header across all source files. For a new contribution, please add the below header:

```
/*******************************************************************************
 * Copyright (c) <year> <legal entity>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   <legal entity> - <short description of contribution>
 *******************************************************************************/
```

Please ensure \<year\> is replaced with the current year or range (e.g. 2021 or 2018-2021).
Please ensure \<legal entity\> is replaced with the relevant information.

If you are editing an existing contribution, feel free to add your legal entity to the contributors section.

### Signing Off Your Commits
It is a legal requirement that every commit of an author who is not a member of the project must be "signed off" using
the same email address used for the user's Eclipse account.

You do this by adding the `-s` flag when you make the commit(s), e.g.

    $> git commit -s -m "Shave the yak some more"

You can find all the details in the [Contributing via Git](http://wiki.eclipse.org/Development_Resources/Contributing_via_Git) document on the Eclipse web site.

## How to Contribute

The easiest way to contribute code/patches/whatever is by creating a GitHub pull request (PR). Submit a PR via the normal GitHub UI.

## After Submitting

Do not use your branch for any other development, otherwise further changes that you make will be visible in the PR.
