# simple-cms
The most simple thymeleaf based CMS possible.

Put your templates in a directory <TemplateDir>/pages/ where the user running simple-cms can read them and set
--prefix=<TemplateDir> (defaults to /var/www)

Everything in /pages/ will be accessible from the web. So you can put fragments etc. directly in <TemplateDir> (or any subdirectory).
Create <TemplateDir>/pages/index.html.

You can provide static key/value pairs in a property file (key=value) and inject them with --static=<FullPathToStaticValueFile> into your thymeleaf templates.

Start up your cms with
java -jar simple-cms-<VERSION>.jar 

Options (with their defaults):

--port=8080
Port where simple-cms will listen.

--prefix=/var/www
Thymeleaf root directory. Store pages in subdir pages/.

--static=
Set static property file, where you store key/value pairs.

--cache=false
Enable/disable thymeleaf caching. Will reread templates every time. (Useful when testing your layouts without restarting the app every time.)

--compression=on
Enables tomcats compression.


