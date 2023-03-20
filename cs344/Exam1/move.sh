#!/bin/bash
#David Greni

if [ ! -z "$1" ] && [ ! -z "$2" ] 
then
    if [ -f "$1" ] && [ -d "$2" ] 
    then
        mv "$1" "$2"
        ls -l "$2"
    else
        echo "File or directory not found please check the spelling of them or make sure they exist."
    fi 
else 
    echo "Incorrect usage. Use ./move filename dirname "
fi