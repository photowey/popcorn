#!/usr/bin/env bash

echo popcorn framework compile and deploy...

# mvnd
mvn clean -DskipTests source:jar deploy