# Testing UI Web DEMO BLAZE
Web UI testing using Cucumber, Java, Gradle, Selenium and https://www.demoblaze.com/ as the website

## FEATURE
* LOGIN
* HOME
* CART
* TRANSACTION 
* SIGN UP
* CONTACT
* ABOUT US


# Testing API Automation DUMMY API
API testing using Cucumber, Java, Gradle and https://dummyapi-24a5c.firebaseapp.com/ as the api

## FEATURE
* COMMENT
* CREATE
* DELETE
* GET
* POSTING
* UPDATE



## Programming language
This project was written using Java version "21.0.1"

## FRAMEWORK
* Junit

## LIBRARY
* Cucumber
* Selenium
* AssertJ
* Rest-assured


## HOW TO RUN
#### RUN ALL TEST CASE
##### API TEST
src/test/java/runner/api/ApiTest.java
run ApiTest class and display the test results.

OR Execute the command ./gradlew apiTest in the terminal.
##### WEB TEST
src/test/java/runner/web/WebTest.java
run WebTest class and display the test results.

OR Execute the command ./gradlew webTest in the terminal.
#### RUN SINGLE TEST CASE
src/test/java/features/web/login.feature
run 1 Scenario/gherkin and display the test results

