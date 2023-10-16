# Small World Challenge

Welcome to the Small World Challenge project! This project leverages Java, Selenium, Maven, and Cucumber to facilitate web application testing using the behavior-driven development (BDD) approach.

## Features

- **Java**: Uses Java to script and execute our tests.
- **Selenium Integration**: Seamlessly interact with web elements and perform actions on web pages using Selenium WebDriver.
- **Cucumber for BDD**: We utilize Cucumber to craft and execute test scenarios in a user-friendly, story-like format.
- **Maven Superpowers**: Maven takes care of managing dependencies, automating builds, and running our tests efficiently.

## Prerequisites

Before diving in, make sure you have the following prerequisites in place:

1. **Java Development Kit (JDK)**: Ensure you have the Java Development Kit installed.
2. **Maven Build Tool**: Verify that you have the Maven build tool installed.

## Setting Up and Configuration

To get started, follow these simple setup steps:

1. **Clone or Download**: Clone or download this repository to your local machine.
2. **Install Dependencies**: Install the necessary project dependencies using Maven. Open your terminal, navigate to the project directory, and run the following commands:

   ```shell
   $ cd SmallWorldAutomation
   $ mvn clean install

# Running the Tests
This project includes two scenarios:

Logging in using valid credentials.
Adding a product to the cart.
You can execute these scenarios in a web browser by using the feature files. If you prefer to run the tests using Maven, simply enter the following command:
  ```shell
$ mvn test
