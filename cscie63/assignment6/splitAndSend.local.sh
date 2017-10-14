#!/bin/bash

if [ -z "$1" ]; then
        echo "Missing output folder name"
        exit 1
fi

split -l 10000 orders.txt chunk

for f in `ls chunk*`; do
                mv $f /home/rsha/staging
                sleep 3 
                mv /home/rsha/staging/$f /home/rsha/$1/
                rm -f $f
done
