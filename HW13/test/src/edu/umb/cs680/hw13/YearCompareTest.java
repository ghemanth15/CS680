package edu.umb.cs680.hw13;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Car;

public class YearCompareTest {

	@Test
	public void yearDescendingSortTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car c1 = new Car("Maruti Suzuki", "WagonR", 50000, 2011, 7000.0f);
		Car c2 = new Car("Honda", "Civic", 30000, 2010, 8000.0f);
		Car c3 = new Car("Hyundai", "Elantra", 40000, 2012, 6000.0f);
		usedCars.add(c1);
		usedCars.add(c2);
		usedCars.add(c3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		Collections.sort(usedCars, Comparator.comparing(car -> car.getYear(), Comparator.reverseOrder()));
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}
