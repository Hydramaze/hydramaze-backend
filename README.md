##* Installation guide *##

1 - Install JAVA 8 and create an environment variable JAVA_HOME


2 - Install IntelliJ Community Edition

https://www.jetbrains.com/idea/download/


3 - Install Maven

Download from http://ftp.unicamp.br/pub/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz and descompact the file into a root folder. Add the /my/local/maven/bin to an environment variable called PATH.


4 - Checkout project develop branch.


5 - Open IntelliJ and import the project as a Maven Project:
- Check Import Maven projects automatically and Automatically download (sources only).
- Select + to add the Java 8 SDK path.
- Finish


6 - Go to Run -> Edit Configurations... -> Press + -> Maven:
Name it as: HydraMaze Run
Insert on Command Line the following spring-boot:run
Apply -> OK.


7 - Run the application using Play / Debug button. Test it accessing http://localhost:8080/greeting

"Stay Hungry. Stay Foolish." (Steve Jobs)