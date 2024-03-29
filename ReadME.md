# Spotify Appium Android Automation Project using TestNG in Java


![Logo](src/main/resources/spotify_logo.png)



This README file will guide you through the setup process and provide instructions on how to run the tests and generate a report using Allure.

## Prerequisites

Please ensure you have the following dependencies and configurations set up on your machine:

1. **Java**: Install Java Development Kit (JDK) and set the `JAVA_HOME` environment variable to the JDK installation directory.

2. **Maven**: Install Maven and set the `MAVEN_HOME` and `M2_HOME` environment variables to the Maven installation directory.

3. **Allure Reports CLI Tool**: Install Allure Reports CLI Tool version 2.23.0 as mentioned in the project's `pom.xml` file.

## Getting Started

Follow these steps to set up and run the project:

1. **Clone the repository or download**:  the project source code to your local machine.

``` sh
git clone https://github.com/taimoorpashanbs17/SpotifyAppiumAutomation.git
```

2. Open a terminal and navigate to the project directory.

```sh
cd SpotifyAppiumAutomation
```

3. **Install Spotify App** : Open any emulator and drag and drop to emulator, it will install it. 
*Note* : Latest apk file of `Spotify` is added within `src/main/resources/spotify.apk`.


4. **Run Tests**: Execute the following command to clean and run the tests using Maven:
This command will trigger the execution of the TestNG tests on the connected Android device/emulator using the Appium framework.

```sh
mvn clean test
```

5. **Generate and View Report**: After the tests have completed, generate an Allure report using the following command:
This will generate an HTML report with detailed information about the test results, including screenshots, logs, and more. The report will be automatically opened in your default web browser.

```sh
allure serve
```

## Project Structure

The project is structured as follows:

- `src/test/java`: Contains the test scripts written in Java using TestNG annotations.
- `src/main/resources`: Contains any required resources, such as configuration files.
- `allure-results`: This directory will be generated after running tests and will contain the raw data needed to generate the Allure report.

## Device Configuration

You can customize the test configuration by modifying the `src/main/resources/config.properties` file.
i.e. If You want to change device , you change value on `deviceUDID` value and work it accordingly.


