#!/bin/bash
# Original credit: NLSteveO
# Modified by: echoenzo
# Downloads sample files for given problem on open.kattis.com
# $1: name of problem
# $2 (if any): location of directory to download sample files

problem="$1"
url="https://open.kattis.com/problems/$problem/file/statement/samples.zip"

if wget -q --spider "$url"; then
    echo "Downloading samples."
    if [[ $2 ]]; then
        directory="$2"
    else
        directory="."
    fi
    wget -nv -P "$directory" "$url"
    echo "Download complete."
    echo "Unzipping samples."
    unzip "$directory/samples.zip" -d "$directory/samples"
    echo "Samples unzipped. Deleting 'samples.zip'."
    rm "$directory/samples.zip"
    echo "Done!"
else
    echo "Nothing to download. Check problem ID or maybe there are no samples."
fi
