package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class PrimeGeneratorTest {
    @Test
    public void primesBetween1and10(){
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(2L);
        expectedPrimes.add(3L);
        expectedPrimes.add(5L);
        expectedPrimes.add(7L);
        int expectedNumberOfPrimes = 4;
        int actualNumberOfPrimes = primes.size();
        assertEquals(expectedNumberOfPrimes, actualNumberOfPrimes);
        assertArrayEquals(primes.toArray(), expectedPrimes.toArray());
    }

    @Test
    public void primesBetween4and47(){
        PrimeGenerator gen = new PrimeGenerator(4, 47);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(5L);
        expectedPrimes.add(7L);
        expectedPrimes.add(11L);
        expectedPrimes.add(13L);
        expectedPrimes.add(17L);
        expectedPrimes.add(19L);
        expectedPrimes.add(23L);
        expectedPrimes.add(29L);
        expectedPrimes.add(31L);
        expectedPrimes.add(37L);
        expectedPrimes.add(41L);
        expectedPrimes.add(43L);
        expectedPrimes.add(47L);
        int expectedNumberOfPrimes = expectedPrimes.size();
        int actualNumberOfPrimes = primes.size();
        assertEquals(expectedNumberOfPrimes, actualNumberOfPrimes);
        assertArrayEquals(primes.toArray(), expectedPrimes.toArray());
    }
}
