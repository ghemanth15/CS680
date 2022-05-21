package edu.umb.cs680.hw11;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.PriceComparator;

public class PriceComparatorTest {

	@Test
	public void priceAscendingSortTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car c1 = new Car("Maruti Suzuki", "WagonR", 70000, 2011, 7000.0f);
		Car c2 = new Car("Honda", "Civic", 80000, 2010, 8000.0f);
		Car c3 = new Car("Hyundai", "Elantra", 60000, 2012, 6000.0f);
		usedCars.add(c1);
		usedCars.add(c2);
		usedCars.add(c3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(c3);
		expected.add(c1);
		expected.add(c2);
		Collections.sort(usedCars, new PriceComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}
