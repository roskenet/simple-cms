# simple-cms
The most simple thymeleaf based CMS possible.

Put your templates in a directory <TemplateDir>/pages/ where the user running simple-cms can read them and set
--prefix=<TemplateDir> (defaults to /var/www)

Everything in /pages/ will be accessible from the web. So you can put fragments etc. directly in <TemplateDir> (or any subdirectory).

You can provide static key/value pairs as a property file and add them with the parameter --static=<FullPathToStaticValueFile>
Everything in there will be injected in your thymeleaf templates.

Start up your cms with
java -jar simple-cms-<VERSION>.jar 

Options (with their defaults):

--port=8080
Port where simple-cms will listen.

--prefix=/var/www
Thymeleaf root directory. Store pages in subdir pages/.

--static=
Set static property file, where you store key/value pairs.

--chache=false
Enable/disable thymeleaf caching. Will reread templates every time. (Useful when testing your layouts without restarting the app every time.)

--compression=on
Enables tomcats compression.


