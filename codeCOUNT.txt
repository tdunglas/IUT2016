#!/bin/bash

total=0
for f in $(find -name \*.java)
do
count = $cat $f | grep -v '^( \t)*$' | wc -l)
total=$(($total + $count))
done

echo $total
