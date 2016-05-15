# ProEp
Repository for the ProEp course

#Netbeans backend
Make sure you have installed:
- Netbeans with JavaEE
- JDK 8
- Apache Tomcat 8.5 - add a user that has the manager-script role

Inside of netbeans:
Clone the project  **errors will be given**

To resolve these errors:
First unzip the libraries.zip file in the lib folder

Then: Add library by right clicking on the libraries in the project

Create Library - Call it "Genson" - Add the .jar in the lib/Genson folder

Create another Library - Call it "Jersey" - Add the .jars in the lib/Jersey folder

Now go to Tools -> Servers

Add a new server - Call it "Apache Tomcat or TomEE"

Give the location of the server and the login for the server with the manager-script role

Now the project should be runnable (given the code is compilable)
