#!/usr/bin/env bash

echo popcorn project compile and deploy...

# mvnd
mvn clean -DskipTests source:jar deploy