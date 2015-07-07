# java-R-example
This example shows how to execute R code embedded in Java

This example uses JRI to be able to execute R code.

References
 * JRI Java/R interface <https://www.rforge.net/JRI/>
 * Calling R from Java <http://www.cnblogs.com/mavlarn/archive/2012/12/24/2831688.html>


System Requirements
-------------------

 * Maven
 * Compile JRI from sources to get JRI.jar and the native library (libjri.so in Linux)
 * In this example, both the JRI.jar and the native library for Linux x64 are provided
 * Install and configure R
	sudo yum install R
	export R_HOME=/usr/lib64/R/
	sudo R
	> install.packages('rJava')
	> install.packages('HMisc')
	> q()


Running the example
-------------------

        mvn exec:exec

