# powermockito
Java + JUnit + Mockito + Power Mockito

# links
https://examples.javacodegeeks.com/core-java/powermockito/powermockito-tutorial-beginners/

# Dependencies
For this example we need the below mentioned jars:

cglib-nodep-3.2.2.jar
easymock-3.4.jar
hamcrest-all-1.3.jar
javassist-3.12.1.GA.jar
junit-4.12.jar
objenesis-2.2.jar
powermock-api-easymock-1.6.5.jar
powermock-mockito-release-full-1.6.4-full.jar

# ===========================================================================
## Defining test methods
JUnit uses annotations to mark methods as test methods and to configure them. The following table gives an overview of the most important annotations in JUnit for the 4.x and 5.x versions. All these annotations can be used on methods.
JUnit 4	Description
import org.junit.*

Import statement for using the following annotations.

@Test

Identifies a method as a test method.

@Before

Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).

@After

Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save memory by cleaning up expensive memory structures.

@BeforeClass

Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.

@AfterClass

Executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.

@Ignore or @Ignore("Why disabled")

Marks that the test should be disabled. This is useful when the underlying code has been changed and the test case has not yet been adapted. Or if the execution time of this test is too long to be included. It is best practice to provide the optional description, why the test is disabled.

@Test (expected = Exception.class)

Fails if the method does not throw the named exception.

@Test(timeout=100)

Fails if the method takes longer than 100 milliseconds.
# ===========================================================================
## Assert statements
JUnit provides static methods to test for certain conditions via the Assert class. These assert statements typically start with assert. They allow you to specify the error message, the expected and the actual result. An assertion method compares the actual value returned by a test to the expected value. It throws an AssertionException if the comparison fails.

The following table gives an overview of these methods. Parameters in [] brackets are optional and of type String.
fail([message])

Let the method fail. Might be used to check that a certain part of the code is not reached or to have a failing test before the test code is implemented. The message parameter is optional.

assertTrue([message,] boolean condition)

Checks that the boolean condition is true.

assertFalse([message,] boolean condition)

Checks that the boolean condition is false.

assertEquals([message,] expected, actual)

Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.

assertEquals([message,] expected, actual, tolerance)

Test that float or double values match. The tolerance is the number of decimals which must be the same.

assertNull([message,] object)

Checks that the object is null.

assertNotNull([message,] object)

Checks that the object is not null.

assertSame([message,] expected, actual)

Checks that both variables refer to the same object.

assertNotSame([message,] expected, actual)

Checks that both variables refer to different objects.
