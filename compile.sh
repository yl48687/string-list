#!/bin/bash -ex

javac -d bin -cp string-list.jar src/BaseStringList.java
javac -cp bin:string-list.jar -d bin src/ArrayStringList.java
javac -cp bin:string-list.jar -d bin src/LinkedStringList.java
