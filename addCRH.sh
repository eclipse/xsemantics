#!/bin/bash

# -e  == exit immediately
# -x  == enable debug. (+x for disable)
set -e +x


find -E . -iregex '.*\.(fj)' -type f -print0 | while IFS= read -r -d '' file; do
	echo "$file"
    printf '%s\n' "$file"
    cat "$file" | pbcopy && printf "/*******************************************************************************\n * Copyright (c) 2013-2017 Lorenzo Bettini.\n * All rights reserved. This program and the accompanying materials\n * are made available under the terms of the Eclipse Public License v1.0\n * which accompanies this distribution, and is available at\n * http://www.eclipse.org/legal/epl-v10.html\n *\n * Contributors:\n *   Lorenzo Bettini - Initial contribution and API\n *******************************************************************************/\n\n" > "$file" && pbpaste >> "$file"
    #cat "$file" | pbcopy && printf "<!--\nCopyright (c) 2013-2017 Lorenzo Bettini.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n  Lorenzo Bettini - Initial contribution and API\n -->\n\n" > "$file" && pbpaste >> "$file"
done

#find -E . -iregex '.*\.(java|xtend|xsemantics|oldxsem|xtext)' -type f -exec bash -c 'echo "$1" && cat "$1" | pbcopy && printf "/*******************************************************************************\n * Copyright (c) 2013-2017 Lorenzo Bettini.\n * All rights reserved. This program and the accompanying materials\n * are made available under the terms of the Eclipse Public License v1.0\n * which accompanies this distribution, and is available at\n * http://www.eclipse.org/legal/epl-v10.html\n *\n * Contributors:\n *   Lorenzo Bettini - Initial contribution and API\n *******************************************************************************/\n\n" > "$1" && pbpaste >> "$1"' -- {} \;

#find . -name 'README.txt' -type f -exec bash -c 'echo "$1" && cat "$1" | pbcopy && printf "*******************************************************************************\nCopyright (c) 2013-2017 Lorenzo Bettini.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n  Lorenzo Bettini - Initial contribution and API\n*******************************************************************************\n\n" > "$1" && pbpaste >> "$1"' -- {} \;

#find . -name 'README.md' -type f -exec bash -c 'echo "$1" && cat "$1" | pbcopy && printf "////\nCopyright (c) 2013-2017 Lorenzo Bettini.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n  Lorenzo Bettini - Initial contribution and API\n////\n\n" > "$1" && pbpaste >> "$1"' -- {} \;


