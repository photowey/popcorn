@echo off

echo popcorn project compile and deploy...

@REM call mvnd
call mvn clean -DskipTests source:jar deploy

@REM exit