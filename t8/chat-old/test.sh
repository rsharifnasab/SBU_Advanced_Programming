#!/bin/sh
reset
echo "satarting"
javac -cp .:junit.jar ChatTest.java
echo " compile complete"
java -cp ./junit.jar:.:j2.jar   org.junit.runner.JUnitCore ChatTest
echo " run complete"

