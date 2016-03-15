#!/bin/bash
# Original credit: NLSteveO
# Modified by: echoenzo
# Creates a directory and empty template for solving a problem on open.kattis.com
# $1: language of solution
# $2: filename of problem

language="$1"
filename="$2"
problem="${filename,,}"

if [[ "${language,,}" == "java" ]]; then
    javaFilename="$filename.java"
    directory="$HOME/Projects/kattis/java/$problem"
    mkdir -p "$directory" || exit 1
    cp "$HOME/Projects/kattis/java/TEMPLATE.java" "$directory/$javaFilename"
    sed -i "s/\${filename}/$filename/g" "$directory/$javaFilename"
    "$HOME/Projects/kattis/downloadSamples.bash" "$problem" "$directory"
else
    echo "Language not supported."
    exit 1
fi
