package kz.singularity.testingpractice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CalculatorClass {
    @BeforeEach
    @Disabled
    void setUp() {

    }
    @AfterEach
    @Disabled
    void tearDown() {

    }
    @Test
    @DisplayName(value = "this test return equals when add two numbers")
    void should_returnEquals_when_addTwoNumbers() {
        Calculator calculator = new Calculator();
        // given
        int firstNumber = 10;
        int secondNumber = 20;
        int expected = 30;

        // when
        int actual = calculator.add(firstNumber, secondNumber);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void should_returnNotEquals_when_addTwoNumbers() {
        Calculator calculator = new Calculator();
        // given
        int firstNumber = 10;
        int secondNumber = 20;
        int expected = 40;

        // when
        int actual = calculator.add(firstNumber, secondNumber);

        // then
        assertNotEquals(expected, actual);
    }

    @Test
    void should_returnNotEqualsByBoolean_when_addTwoNumbers() {
        Calculator calculator = new Calculator();
        // given
        int firstNumber = 10;
        int secondNumber = 20;
        int expected = 40;

        // when
        int actual = calculator.add(firstNumber, secondNumber);

        // then
        assertTrue(actual != expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 1, 0, 20})
    public void should_returnZero_when_multiplyWithZero(int number) {
        Calculator calculator = new Calculator();
        // given
        int firstNumber = number;
        int secondNumber = 0;

        // when
        int actual = calculator.multiply(firstNumber, secondNumber);

        // then
        assertTrue(actual == 0);
    }

    @ParameterizedTest(name = "1st = {0}, 2nd ={1}, 3rd = {2}")
    @CsvSource(value = {"-10, -1, 5", "-10, -20, 4", "-4, -5, 1"})
    public void should_returnTrue_whenMultplyTwoNegativeAndPositiveNumbers(int givenFirstNumber, int givenSecondNumber, int givenThirdNumber) {
        Calculator calculator = new Calculator();
         // given
        int firstNumber = givenFirstNumber;
        int secondNumber = givenSecondNumber;
        int thirdNumber = givenThirdNumber;

        // when
        int actual = calculator.multiply(firstNumber, secondNumber);
        int newActual = calculator.multiply(actual, thirdNumber);

        // then
        assertTrue(newActual > 0);

    }

    @ParameterizedTest
    @CsvSource(value = {"10, 0", "14, 0", "0, 0"})
    public void should_throwException_when_divideNumberToZero(int firstNumber, int secondNumber) {
        Calculator calculator = new Calculator();
        // then
        assertThrows(ArithmeticException.class, ()-> calculator.divide(firstNumber, secondNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 2", "0, 4", "0, 1"})
    public void should_returnZero_when_divideNumberWithZero(int firstNumber, int secondNumber) {
        Calculator calculator = new Calculator();
        int actual = calculator.divide(firstNumber, secondNumber);
        // then
        assertTrue(actual == 0);
    }

    @Test
    public void should_returnEquals_when_substractTwoNumbers() {
        Calculator calculator = new Calculator();

        // given
        int firstNumber = 20;
        int secondNumber = 30;
        int expected = 10;

        // when
        int actual = calculator.subtract(secondNumber, firstNumber);

        // then
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 2", "5, 5", "10, 10"})
    public void should_returnZero_when_subtractTwoNumbers(int firstNumber, int secondNumber) {
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(secondNumber, firstNumber);

        // then
        assertTrue(actual == 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 2", "10, 5", "20, 10"})
    public void should_returnNegativeNumber_when_subtractTwoNumbers(int firstNumber, int secondNumber) {
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(secondNumber, firstNumber);

        // then
        assertTrue(actual < 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 2", "1, 5", "4, 10"})
    public void should_returnPositiveNumber_when_subtractTwoNumbers(int firstNumber, int secondNumber) {
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(secondNumber, firstNumber);

        // then
        assertTrue(actual > 0);
    }



}
