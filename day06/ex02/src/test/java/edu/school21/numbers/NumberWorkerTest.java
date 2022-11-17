package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker numberWorker;

    @BeforeEach
    void beforeEachMethod() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 449, 3571})
    public void isPrimeForPrimes(int arg) {
        Assertions.assertTrue(numberWorker.isPrime(arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 100, 3031})
    public void isPrimeForNotPrimes(int arg) {
        Assertions.assertFalse(numberWorker.isPrime(arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 1})
    public void isPrimeForIncorrectNumbers(int arg) {
        Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(arg));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    public void checkDigitsSum(int number, int sum) {
        Assertions.assertEquals(sum, numberWorker.digitsSum(number));
    }
}
