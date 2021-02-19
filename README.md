# Goal
Improve mocking skills. Several mechanisms can be used for mocking integration between components examples are provided.

## Requirements
1. java 8
1. eclipse
1. maven is optional since mvnw (maven wrapper) can be used

## Importing project into eclipse
Import using File -> Import item from menu. When a dialog is opened then select Maven -> Existing Maven Projects option and follow steps in the wizard.

## Importing eclipse preferences
Import using File -> Import item from menu. When a dialog is opened then select General -> Preferences option and pick `./tdd-workshop-1-arrays/eclipse/preferences.epf` file using the wizard. 

## Build
Execute following command on linux:

    ./mvnw clean install
or on windows:

    mvn clean install

## Instructions

### Examples

1. fork repository to your own github account
1. checkout `feature/1-service-examples` branch
1. project is already set up using maven and junit 5, so start tests by executing `./mvnw clean test`
1. code contains interfaces and classes for simulating Repository and Service classes integration
1. each implementation of repository and service is different in order to try to simulate the approaches that can be choosen or to build tests on top of the legacy code that is hard to change
1. start by checking implementations of Service interface and test for it

### Car service
 
1. commit all changes and rebase your changes on `feature/2-car-service`
1. open CarServiceImpl class. Take a look at implementation of the repair method
1. classes ManufacturerInstructionsServiceImpl and SparePartsServiceImpl are added just for reference (may not be used at all)
1. check TODO comments in CarServiceImplTest
1. consider using answers or argument matchers for mocking `manufacturerInstructionsService.getSparePartsForReplacement` and `sparePartsService.getAvailabilities` methods instead of unconditional mocking (without `ArgumentMathcers.any()`)

## Important notes
1. push your changes to the fork repository at the end -no matter if it compiles or not :)
