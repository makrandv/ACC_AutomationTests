Pre-Requisites

Software used to create the test suite
Java 1.8.0
Maven 3.6.3
Cucumber
Intellij IDE
Selenium 4.6.0
Chrome Browser 107.0.5304.122
Java JDK version 19

Set JAVA_HOME environment variable set to JDK
Test JDK installation by typing java -version at the Command Prompt - you should get the java version returned
Test Environment variable by typing echo %JAVA_HOME% at the command prompt, you should see your java installation directory returned - check it is the JDK, not the JRE

Maven Build
Set M2_HOME environment variable to the Maven installation directory e.g. M2_HOME = C:\apache-maven-3.8.5
Add to PATH system environment variable, ensure it includes M2_HOME\bin (to allow maven to run from the command prompt)

Test Development
- Followed BDD approach for creating UI and API tests
- Webelements identification was parameterized so that they can be used across multiple search categories (e.g. Cars , Motorbikes) and also across multiple search options (e.g. Make, Style ,Location)
- Created helper class for setting up the web driver for selenium

Test Execution
 From the Command Line
 - Run command - mvn test
 
 From IntelliJ
- Right click on testng.xml and select run option

Test Report
- Latest test execution report (HTML format) can be found under target >> cucumber-reports folder

What was not done
Extend reporting

Attached is the test result "Cucumber-All Test Passed.html" showing all executed tests and being passed.
