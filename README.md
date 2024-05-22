
# Selenium Java Automation for Reziapp with Mailosaur

This project automates the registration process on the Reziapp website, fetching OTP emails using Mailosaur and Selenium with Java.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)

## Introduction

This project uses Selenium WebDriver with Java to automate the process of registering a new account on [Reziapp](https://www.reziapp.com). It fetches OTP (One-Time Password) emails using Mailosaur, a service for testing email and SMS messages.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed
- Maven installed
- A Mailosaur account
- An IDE such as IntelliJ IDEA or Eclipse

## Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```

2. **Configure Mailosaur:**

    Replace the placeholder values in your code with your actual Mailosaur credentials:

    ```java
    String apiKey = "YOUR_API_KEY";
    String serverId = "YOUR_SERVER_ID";
    String serverDomain = "YOUR_SERVER_DOMAIN";
    ```

3. **Install dependencies:**

    Ensure you have all the necessary dependencies by running:

    ```sh
    mvn clean install
    ```

## Usage

1. **Run the tests:**

    You can execute the tests using your IDE or by running the following Maven command:

    ```sh
    mvn test
    ```

2. **Understanding the process:**

    - The Selenium WebDriver script will navigate to the Reziapp registration page.
    - It will fill out the registration form and submit it.
    - The script will then use Mailosaur to fetch the OTP sent to the email address used during registration.
    - The OTP will be entered on the website to complete the registration process.

Source :
- https://mailosaur.com/docs/languages/java
- https://www.youtube.com/watch?v=Il8efgsiJyw&ab_channel=NaveenAutomationLabs
- https://www.youtube.com/watch?v=s5ppYJJF0R0&ab_channel=NaveenAutomationLabs