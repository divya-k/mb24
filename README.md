<H1>Demo Project for the Amazon android application</H1>

This project has been created to automate the Log In functionality of the Amazon app, followed by the search funcitonality, then adding a product to the cart and verifying it. This app is available on the app store.

<h3>How To Run The Tests</h3>

1. Make sure the TestNG plugin is installed for your IDE (I used Eclipse)
2. Make sure the whole Appium setup is also done on the machine i.e. Appium + Android Studio
2. Right click on the testng.xml file in Eclipse
3. Select Run As > TestNG Suite

This will run the desired test case test case and generate the test report

<h3>About The Project</h3>

<b>Page Object Model</b> design has been used to create tests. Every view has its own page class which can be found at /src/test/java/pages. The /src/test/java/tests directory contains a <b>BaseClass</b> which is inherited to all the test classes and is responsible for setting up the test session and ending the test session. <b>PurchaseTest</b> class contains the tests relevant for this task assigned by <b>Telstra</b>. All the method names and variable names are very readable and easy to undertand. For dependency management I have used Maven.
The Parameters for the tests are passed via the testng XML file. So any change in the test case. data. can be done in the XML file without touching the code.
All the assertion statements are part of the test case and no assertion is made in the view pages because that's one of the principles of the POM.


&#10003;Appium gestures Swipe and Click are used

&#10003;Desired test case has been automated

&#10003;Name of the product is verified on all the relevant pages and made sure it is consistent

&#10003;Test Case passes and fails based on assertions

&#10003;Test data is read from the external source and is not part of the test code
