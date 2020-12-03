# NewYork

## Introduction
`NewYork` is a simple app which displays list of articles fetched from nytimes.com and allows reading every article.

## Requirements
* Android studio latest version 4+
* Emulator / real device

## Installation
* Clone this repository and import into Android Studio<br>
  `git clone https://github.com/unifarid/NewYork.git`

## Generating signed APK
From Android Studio:
1. **Build** menu
2. **Generate Signed APK...**
3. Fill in the keystore information (you only need to do this once manually and then let Android Studio remember it)

## Questions And Answers
* I - I approached it using :-
  * MVVM
  * coroutines for execute code asynchronously
  * Koin as Service locator to provide my required dependencies
  * Repository design pattern (to group requests)
  * Data binding to bind UI elements with the required data

MVVM + Coroutines has been chosen over MVP due to the "reactivity" nature of the project<br>
Koin used to provide dependencies based on service locator pattern and avoid to using Dagger2 due to the time constrain<br>
<br>
