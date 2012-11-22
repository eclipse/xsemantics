The target-platform.cquery is used to materialize the target platform

The target-platform-local.cquery is an example to materialize the target platform
using a local eclipse mirror; it relies on local-mirror.properties which defines
the base URL for eclipse repositories as eclipse.download=file:${user.home}/eclipsemirror
thus, it assumes that the local mirror is in your home in the directory eclipsemirror

build.ant can be used to run an headless build, together with all the test suites.
You must pass the location of your buckminster headless installation, e.g.,

-Dbuckminster.home=/path/to/buckminster 

You can also pass additional properties as -D<key>=<value>, for instance, if you
want to use a local eclipse mirror to materialize the target platform (see also target-platform-local.cquery
above), you can specify

-Declipse.download=file:/path/to/my/local/eclipse/mirror

Happy building with Bucky! :)
