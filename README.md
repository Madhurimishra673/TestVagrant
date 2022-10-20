# TestVagrant
This Contains Test Project

Features:

1.	This is a selenium test automation framework, built in Maven and testNG
2.	Programming language used : Java
3.	Reporting an Loging: Log4J & Extent report


Folder Structure
a.	src/test/java
 packages->
  com.base: it has driver initializationand configuration
                 com.page: it can contain page classes, which contains common methods related to a particular                                          
                 com.testCases: it has test scenario classes with @test tag
                 You can execute these test directly or using TestNGRunner.xml
                 com.utilities: contains utility classes which has common methods which can be utilized throughout
                  In utilities you will find a JSONReader.class wich has common method to convert JSON file content in JSONArray.
                  

b.	src/test/resources

executables: has drivers
properties: has property files which can contain configuration like urs, browes, user id password etc.

Runner: has testNG xml.

 
 




