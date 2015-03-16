#!/bin/bash
if [ ! -e mixingmilk ]
then
  go build mixingmilk.go
fi
./mixingmilk 100 5 5 20 9 40 3 10 8 80 6 30
