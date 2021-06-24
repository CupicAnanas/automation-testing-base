# Introduction
* Base test automation framework
* Will be mostly used for UI E2E testing.
* Please always read the comments inserted in the files

# Prerequisites
* Gradle 6.8
* Java SE Development Kit 11
* IntelliJ IDEA - with Cucumber plugins (in Settings/Build, Execution, Deployment/Build Tools/Gradle set Run Tests using: IntelliJ IDEA JVM 11)
* Setup Allure on local machine if you want to generate reports

# Dependencies
* For running tests - JUnit Runner `jupiterVersion = '5.7.0'`
* For BDD, writing tests cases - Cucumber (core, java, jvm, junit) `cucumberVersion = '6.9.1'`
* For preparing the body and asserting response - Gson `gsonVersion = '2.8.6'`
* For UI testing - Selenium and WebDriverManager `seleniumVersion = '4.0.0-beta-4'` and `webdrivermanagerVersion = '4.2.2'`
* For writing feature files - Gherkin `gherkinVersion = '16.0.0'`
* For logging - SLF4J `slf4jVersion = '1.7.30'`
* For API testing - RestAssured `restAssuredVersion = '4.3.3'`
* Rich set of assertions `assertJVersion = '3.19.0'`

# Project structure
* `src/main/java/common` - will be used for storing general helpers in common packages
* `src/main/java/poms` - will be used for storing Page Object Models
* `src/main/java/steps` - it will contain test steps definition classes
* `src/main/java/utils/listeners` - holds test listeners for logging and screenshotting while testing, with reporting (Allure/Extent-Reports)
* `src/main/java/utils/logging` - SLF4J logging class
* `src/test/java/runners` - test runner class with JUnit
* `src/test/resources/features` - will be used for storing all feature files
* `src/test/resources/screenshots` - will be used for storing screenshots
* `src/test/resources/reports` - will be used for storing reports

# How to run tests
* Simply run JUnitRunner.java in test/java/runners package.

# .gitignore
* If you want to update .gitignore file run this command in terminal after you've made changes in the file: `git rm -r --cached .`
* After the cache is cleaned you can `git add .` and then `git commit -m "message"` and git should ignore files and folders that you've specified