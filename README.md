# testNGAppium

This is a sample project to use appium for - mobile browser & app automation

1. DriverProvider Class to get respective driver object - browser/mobile driver
2. PropertyUtils Class to read the test data from properties file 
3. Integrated with allure-report

Steps to run thr project:
===========================
1. mvn clean test

2. Allure results will appear in target/allure-results folder. To generate html report and automatically open it in a web browser, run the following command:

allure serve target/allure-results
or
allure serve allure-results


