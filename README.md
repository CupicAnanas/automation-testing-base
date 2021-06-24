# Introduction
Test automation framework will be used mostly for UI E2E tests.

# Prerequisites
* gradle 6.8 you can either install it locally or you can use it via dependency
* Open JDK 11
* Setup Allure on local machine if you want to generate report
* IntelliJ IDEA - with Cucumber plugins (in Settings/Build, Execution, Deployment/Build Tools/Gradle set Run Tests using: IntelliJ IDEA JVM 11)

# Dependencies
* For running tests - JUnit runner `jupiterVersion = '5.7.0'`
* For BDD - cucumber(core, java13, JVM, JUnit, gherkin) `cucumberVersion = '6.9.1'`
* For preparing the body and asserting response - Gson `gsonVersion = '2.8.6'`
* For UI - selenium and webdrivermanager `seleniumVersion = '4.0.0-beta-4'` and `webdrivermanagerVersion = '4.2.2'`
* Gherkin for feature files `gherkinVersion = '16.0.0'`
* Logging - slf4j `slf4jVersion = '1.7.30'`
* API cals using RestAssured `restAssuredVersion = '4.3.3'`
* Rich set of assertions `assertJVersion = '3.19.0'`

# Project structure
* `src/main/java/common` - will be used for storing general helpers in common packages
* `src/main/java/poms` - will be used for storing Page Object Models
* `src/main/java/steps` - it will contain step definition classes
* `src/main/java/utils/listeners` - holds test listeners for logging and screenshotting on failed tests with reporting (extent-reports , allure)
* `src/main/java/utils/logging` - slf4j Log class
* `src/test/java/runners` - cucumber runner class with JUnit
* `src/test/resources/features` - will be used for storing all feature files
* `src/test/resources/screenshots` - will be used for storing screenshots
* `src/test/resources/reports` - will be used for storing reports

# How to run tests
* By JUnit runner - just run class JUnitRunner.java in runners package.

# .gitignore
* If you want to update .gitignore file run this command in terminal after you've made changes in the file: `git rm -r --cached .`
* After the cache is cleaned you can `git add .` and then `git commit -m "message"` and git should ignore files and folders that you've specified
