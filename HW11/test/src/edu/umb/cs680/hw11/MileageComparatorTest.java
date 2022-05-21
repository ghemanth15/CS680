package edu.umb.cs680.hw11;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.MileageComparator;

public class MileageComparatorTest {

	@Test
	public void mileageAscendingSortTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car c1 = new Car("Maruti Suzuki", "WagonR", 20000, 2007, 7000.0f);
		Car c2 = new Car("Honda", "Civic", 80000, 2011, 8000.0f);
		Car c3 = new Car("Hyundai", "Elantra", 20000, 2010, 6000.0f);
		usedCars.add(c1);
		usedCars.add(c2);
		usedCars.add(c3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(c3);
		expected.add(c1);
		expected.add(c2);
		Collections.sort(usedCars, new MileageComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}
