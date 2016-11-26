[![BuildStatus](https://travis-ci.org/roskenet/simple-cms.svg?branch=master)](https://travis-ci.org/roskenet/simple-cms)
[![Coverage Status](https://coveralls.io/repos/roskenet/simple-cms/badge.svg?branch=master&service=github)](https://coveralls.io/github/roskenet/simple-cms?branch=master)
# simple-cms

The most simple thymeleaf based Content Management System possible.

Needs a PostgreSQL database for meta data storage. (TODO: Support different db implementations).

Put your templates in a directory <TemplateDir>/page/ where the user running simple-cms can read them and set
--prefix=<TemplateDir> (defaults to /var/www/)
NEEDS A TRAILING SLASH!

Everything in /page/ will be accessible from the web. So you can put fragments etc. directly in <TemplateDir> (or any subdirectory).
Create <TemplateDir>/page/index.html.

Provide general key/value pairs in a property file (key=value) and inject them with --static=<FullPathToStaticValueFile> into your thymeleaf templates.

Supports Springs CRaSH.

Start up your cms with
java -jar simple-cms-<VERSION>.jar 

Options (with their defaults):

--port=8080
Port where simple-cms will listen.

--prefix=/var/www
Thymeleaf root directory. Store pages in subdir page/.

--static=
Set static property file, where you store key/value pairs.

--cache=false
Enable/disable thymeleaf caching. Will reread templates every time. (Useful when testing your layouts without restarting the app every time.)

--compression=on
Enables tomcats compression.

--rshell=true
Enable remote shell on
--rshellport=8081
with user
--rshelluser=scms
and password
--rshellpassword=scms
