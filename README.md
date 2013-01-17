Introduction
============
Hello, this is an "almost modern WEB application" based on spring MVC. Today, the term "modern WEB application" is used to identify client-side JavaScript WEB applications. In my opinion those applications are, sure, fancy and "new" but not necessary modern. It's rather just a "new" kind of WEB application architecture having certain, interesting, characteristics. 

However, I believe, "almost modern WEB applications" also have interesting characteristics which fulfil quite well many use-cases.

An, at the end, the real power is the ability balance client-side and server-side programming according to you needs.

So, why "almost modern"? Well, because this application is not a pure client-side application but still modern in term of characteristics and technologies.

Goals
-----
* Fun
* Learn
* Provide guidance and scaffolding for real business applications

Main characteristics
--------------------
* Secure (https://www.owasp.org/ top 10)
* Device optimised (http://en.wikipedia.org/wiki/Responsive_web_design)
* Mobile optimised
* Good performance (whatever this mean to you)
* Accessible (WCAG 2.0, Level AA)
* Enforcing the use of good frameworks and good design (I hope so at least!)

Alibi use-case
--------------
* A multistep user registration

Robot
-----
Ensure search engines and crawles to index the app properly, see http://www.robotstxt.org/

Test using: http://tools.seobook.com/robots-txt/

Generating Key Pairs and Certificates for HTTPS
-----------------------------------------------
keytool -genkey -alias localhost -keyalg RSA -keysize 1024 -dname "CN=localhost, OU=IT, O=chiodoni, L=Agno, S=Ticino, C=CH" -keypass keyPassword -keystore etc/https.jks -storepass keystorePassword


Enjoy,
Andrea
