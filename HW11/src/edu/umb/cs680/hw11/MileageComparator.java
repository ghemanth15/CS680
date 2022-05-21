package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
	
	public int compare(Car c1, Car c2) {
		return c1.getMileage() - c2.getMileage();
	}

}
