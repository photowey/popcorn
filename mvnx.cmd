@echo off

echo popcorn framework compile and deploy...

@REM call mvnd
call mvn clean -DskipTests source:jar deploy

@REM exit