package edu.umb.cs680.hw11;

import java.util.LinkedList;

public class Car {
	private String make, model;
	private int mileage, yr;
	private float price;
	private int domCount;
	
	public Car(String make, String model, int mileage, int yr, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.yr = yr;
		this.price = price;
	}
	
	public void setDominationCount(LinkedList<Car> cars) {
		this.domCount = 0;
		for (Car car : cars) {
			if(car.getMileage() <= this.getMileage() && car.getPrice() <= this.getPrice() && car.getYear() >= this.getYear()) {
				if(car.getMileage() < this.getMileage() || car.getPrice() < this.getPrice() || car.getYear() > this.getYear()) {
					domCount++;
				}
			}
		}
	}
	
	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return yr;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return domCount;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

}
