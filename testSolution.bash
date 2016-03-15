#!/bin/bash
# Author: echoenzo
# Tests solution with name $filename against sample data downloaded from open.kattis.com
# $1: filename of the solution (without file extension)

filename="$1"
problem="${filename,,}"

if [[ -d "$HOME/Projects/kattis/java/$problem" ]]; then
    directory="$HOME/Projects/kattis/java/$problem"
    cd "$directory" || exit 1
    javac ./*.java
    exit_status="$?"
    if [[ "$exit_status" != 0 ]]; then
        exit 1
    elif [[ -d "samples/" ]]; then
        x=1
        for i in samples/*.in; do
            touch "output"
            touch "error"
            java "$filename" < "$i" > "output" 2> "error"
            exit_status="$?"
            if [[ "$exit_status" != 0 ]]; then
                cat "error"
                echo "TEST ${x}: RUNTIME ERROR"
            elif grep -Fqxvf "output" "${i:0:-3}.ans"; then
                echo "TEST ${x}: FAIL"
            else
                echo "TEST ${x}: PASS"
            fi
            rm "output"
            rm "error"
            x=$((x+1))
        done
    else
        echo "There are no sample files to test!"
    fi
else
    echo "No such file to test."
    exit 1
fi
