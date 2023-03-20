#!/bin/bash

if [ "$1" == "L" ]
then
	read -p "What is the name of the directory to list? " dirname
	if [ -d "$dirname" ]
	then
		ls -l $dirname
	else
		echo "$dirname is not a directory"
	fi
elif [ "$1" == "D" ]
then
	read -p "What is the name of the file to delete? " filename
	if [ -f "$filename" ]
	then
		rm $filename
	else
		echo "$filename is not a file"
	fi
else
	echo "Invalid command line parameter"
fi
