# simple-cms
The most simple thymeleaf based CMS possible.

Add your templates in
spring.thymeleaf.prefix [/var/www]

And your pages in
spring.thymeleaf.prefix /pages

You can provide static key/value pairs as a property file and add them with the parameter --static.
They will be injected in your thymeleaf templates.

Start up your cms with
java -jar simple-cms-<VERSION>.jar [--server.port=8282][--static=FullPathToPropertyFile]

Make sure, that everything is readable by the user running simple-cms.
