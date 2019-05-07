#!/bin/sh
cd /d/wamp/www/projectName
git status
git add .
git commit -am "TestCommit"
git push
echo Press Enter...
read
