Use the ant file to create a .target definition file, starting from another
.target file, but replacing all URLs to remote update sites with URLs 
pointing to a local file system path where a mirror of the original URLs
has previously been created (see the .b3aggr files).

The generated local.target file is automatically ignored by the
Git repository.

This file can be used by selecting the "local" profile in the
main pom.xml file.