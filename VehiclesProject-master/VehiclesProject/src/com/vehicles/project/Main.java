package com.vehicles.project;


import java.util.ArrayList;
import java.util.List;



public class Main {

	public static void main(String[] args) { 
		DataEntry.menu();
	}



	public static void addCar() {		


		Car c1;

		String[] carFeatures = new String[3];

		carFeatures = DataEntry.vehicleFeatures();

		c1 = new Car(carFeatures[0], carFeatures[1], carFeatures[2]);

		String[] backWheelsFeatures = new String[2];

		backWheelsFeatures = DataEntry.wheelFeatures(0, 0);

		String[] frontWheelsFeatures = new String[2];

		frontWheelsFeatures = DataEntry.wheelFeatures(1, 0);


		Wheel leftBackWheel;
		Wheel rightBackWheel;
		Wheel leftFrontWheel;
		Wheel rightFrontWheel;


		rightBackWheel = new Wheel(backWheelsFeatures[0], Double.parseDouble(backWheelsFeatures[1]));
		leftBackWheel = new Wheel(backWheelsFeatures[0], Double.parseDouble(backWheelsFeatures[1]));

		rightFrontWheel = new Wheel(frontWheelsFeatures[0], Double.parseDouble(frontWheelsFeatures[1]));
		leftFrontWheel = new Wheel(frontWheelsFeatures[0], Double.parseDouble(frontWheelsFeatures[1]));

		List<Wheel> frontWheels = new ArrayList<Wheel>(); 
		frontWheels.add(rightFrontWheel);
		frontWheels.add(leftFrontWheel);

		List<Wheel> backWheels = new ArrayList<Wheel>(); 
		backWheels.add(rightBackWheel);
		backWheels.add(leftBackWheel);

		try {
			c1.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DataEntry.correct();


		DataEntry.menu();

	}


	public static void addBike() {		


		Bike b1;

		String[] bikeFeatures = new String[3];

		bikeFeatures = DataEntry.vehicleFeatures();

		b1 = new Bike(bikeFeatures[0], bikeFeatures[1], bikeFeatures[2]);

		String[] backWheelFeatures = new String[2];

		backWheelFeatures = DataEntry.wheelFeatures(0, 1);

		String[] frontWheelFeatures = new String[2];

		frontWheelFeatures = DataEntry.wheelFeatures(1, 1);

		Wheel backWheel;
		Wheel frontWheel;


		backWheel = new Wheel(backWheelFeatures[0], Double.parseDouble(backWheelFeatures[1]));

		frontWheel = new Wheel(frontWheelFeatures[0], Double.parseDouble(frontWheelFeatures[1]));


		try {
			b1.addWheels(frontWheel, backWheel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		DataEntry.correct();

		DataEntry.menu();


	}

}