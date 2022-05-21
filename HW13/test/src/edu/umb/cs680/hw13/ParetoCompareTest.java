package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Car;

public class ParetoCompareTest {
	private static Car c1;
	private static Car c2;
	private static Car c3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		usedCars = new LinkedList<>();
		c1 = new Car("Maruti Suzuki", "WagonR", 50000, 2011, 7000.0f);
		c2 = new Car("Honda", "Civic", 30000, 2010, 8000.0f);
		c3 = new Car("Hyundai", "Elantra", 40000, 2012, 6000.0f);
		usedCars.add(c1);
		usedCars.add(c2);
		usedCars.add(c3);
	}
	
	@Test
	public void dominationCountTestWithCar1() {
		int expected = 1;
		c1.setDominationCount(usedCars);
		int actual = c1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar2() {
		int expected = 2;
		c2.setDominationCount(usedCars);
		int actual = c2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar3() {
		int expected = 0;
		c3.setDominationCount(usedCars);
		int actual = c3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void dominationCountAscendingSortTest() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(c3);
		expected.add(c1);
		expected.add(c2);
		c1.setDominationCount(usedCars);
		c2.setDominationCount(usedCars);
		c3.setDominationCount(usedCars);
		Collections.sort(usedCars, Comparator.comparing(car -> car.getDominationCount()));
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}
