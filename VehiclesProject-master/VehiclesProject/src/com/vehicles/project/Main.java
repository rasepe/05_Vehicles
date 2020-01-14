package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) { // throws VehiclesException  {
		Scanner sc = new Scanner(System.in);

		String plate;
		String brand;
		String color;
		Car c1;

		boolean correcte = false;


		//Pregunta matricula amb control errors:
		do {
			//Una matrícula ha de tenir 4 números i dues o tres lletres.
			System.out.println("Matrícula?");
			plate = sc.next();
			try {
				//llargada minima 6, llargada maxima 7
				if (!(plate.length() > 5 && plate.length() < 8 )) {
					throw new Exception();
				}

				//4 primers caracters han de ser numerics
				char[]characters = new char[plate.length()];
				for (int i = 0; i < characters.length ; i++) {
					characters[i]=plate.charAt(i);
				}
				for (int j = 0; j < 4 ; j++) {
					if (Character.getNumericValue(characters[j]) < 0 || Character.getNumericValue(characters[j]) > 9) {
						//correcte = false;
						throw new Exception();
					} 
				}

				//2 o 3 ultims caracters han de ser lletres (= no han de ser numeros)
				for (int k = 4; k < characters.length ; k++) {
					if (Character.getNumericValue(characters[k]) > -1 && Character.getNumericValue(characters[k]) < 10) {
						//correcte = false;
						throw new Exception();
					} else {
						correcte = true;
					}
				}
			} catch (Exception e) {
				System.out.println(VehiclesException.WRONG_PLATE);
			}  
		} while (correcte == false);

		System.out.println("Marca?");
		brand = sc.next();
		System.out.println("Color?");
		color = sc.next();

		c1 = new Car(plate, brand, color);

		String brandBackWheels;
		double diameterBackWheels;
		String brandFrontWheels;
		double diameterFrontWheels;
		Wheel leftBackWheel;
		Wheel rightBackWheel;
		Wheel leftFrontWheel;
		Wheel rightFrontWheel;


		System.out.println("Marca rodes traseres?");
		brandBackWheels = sc.next();

		//pregunta diametre traseres amb control errors
		correcte = false;
		do {
			System.out.println("Diàmetre rodes traseres?");
			diameterBackWheels = sc.nextDouble();
			try {
				if (diameterBackWheels<=0.4 || diameterBackWheels >=4) {
					throw new Exception(); 
				} else {
					correcte = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  

		} while (correcte == false);


		rightBackWheel = new Wheel(brandBackWheels, diameterBackWheels);
		leftBackWheel = new Wheel(brandBackWheels, diameterBackWheels); 


		System.out.println("Marca rodes davanteres?");
		brandFrontWheels = sc.next();

		//pregunta diametre davanteres amb control errors
		correcte = false;
		do {
			System.out.println("Diàmetre rodes davanteres?");
			diameterFrontWheels = sc.nextDouble();
			try {
				if (diameterFrontWheels<=0.4 || diameterFrontWheels >=4) {
					throw new Exception(); // VehiclesException(VehiclesException.WRONG_DIAMETER);
				} else {
					correcte = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  

		} while (correcte == false);


		rightFrontWheel = new Wheel(brandFrontWheels, diameterFrontWheels);
		leftFrontWheel = new Wheel(brandFrontWheels, diameterFrontWheels); //= rightFrontWheel;


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

		System.out.println("FI");
		sc.close();
	}

}