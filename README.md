#Pre requisits to execute the project on any machine/server

1. Execution Machine/Server should have JRE 1.7 or greater
2. Execution Machine/Server should have maven

#To execute the Project:

1. Open file 'pathToProjectRootFolder/Assignment/src/test/resources/features' and tag the scenarios with tag '@Regression' which are required to be executed
2. Add chromedriver/gechodriver/IeDriver excutable under the folder 'pathToProjectRootFolder/Assignment/src/main/resources/drivers' which is compatible with the one in the machine/server.
3. Once the above is done, under the project root folder execute the commmand 'mvn install' for first time and then 'mvn clean test' for every subsequent test
4. The reports after every execution can be viewed at URL: 'pathToProjectRootFolder/Assignment/target/cucumber-reports/report.html'
