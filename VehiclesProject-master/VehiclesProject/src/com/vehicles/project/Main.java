package com.vehicles.project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) { 
		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		int option;

		System.out.println("Escull una opció:");
		System.out.println("1. Crear cotxe");
		System.out.println("2. Crear moto");
		System.out.println("3. Sortir");
		option = sc.nextInt();
		switch(option) {
		case 1:
			addCar();
			break;
		case 2:
			addBike();
			break;
		default:
			System.out.println("FI");
			sc.close();
		}	
	}

	public static void addCar() {		
		Scanner sc = new Scanner(System.in);

		String plate;
		String brand;
		String color;

		Car c1;

		boolean correct = false;


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
						throw new Exception();
					} 
				}

				//2 o 3 ultims caracters han de ser lletres (= no han de ser numeros)
				for (int k = 4; k < characters.length ; k++) {
					if (Character.getNumericValue(characters[k]) > -1 && Character.getNumericValue(characters[k]) < 10) {
						throw new Exception();
					} else {
						correct = true;
					}
				}		
			} catch (Exception e) {
				System.out.println(VehiclesException.WRONG_PLATE);
			}  
		} while (correct == false);

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
		correct = false;
		do {
			System.out.println("Diàmetre rodes traseres?");
			diameterBackWheels = sc.nextDouble();
			try {
				if (diameterBackWheels<=0.4 || diameterBackWheels >=4) {
					throw new Exception(); 
				} else {
					correct = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  
		} while (correct == false);

		rightBackWheel = new Wheel(brandBackWheels, diameterBackWheels);
		leftBackWheel = new Wheel(brandBackWheels, diameterBackWheels); 

		System.out.println("Marca rodes davanteres?");
		brandFrontWheels = sc.next();

		//pregunta diametre davanteres amb control errors
		correct = false;
		do {
			System.out.println("Diàmetre rodes davanteres?");
			diameterFrontWheels = sc.nextDouble();
			try {
				if (diameterFrontWheels<=0.4 || diameterFrontWheels >=4) {
					throw new Exception();
				} else {
					correct = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  
		} while (correct == false);

		rightFrontWheel = new Wheel(brandFrontWheels, diameterFrontWheels);
		leftFrontWheel = new Wheel(brandFrontWheels, diameterFrontWheels); 

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

		//sc.close();

		System.out.println("COTXE CREAT CORRECTAMENT");

		menu();

	}


	public static void addBike() {		
		Scanner sc = new Scanner(System.in);

		String plate;
		String brand;
		String color;

		Bike b1;

		boolean correct = false;

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
						throw new Exception();
					} 
				}

				//2 o 3 ultims caracters han de ser lletres (= no han de ser numeros)
				for (int k = 4; k < characters.length ; k++) {
					if (Character.getNumericValue(characters[k]) > -1 && Character.getNumericValue(characters[k]) < 10) {
						throw new Exception();
					} else {
						correct = true;
					}
				}		
			} catch (Exception e) {
				System.out.println(VehiclesException.WRONG_PLATE);
			}  
		} while (correct == false);

		System.out.println("Marca?");
		brand = sc.next();
		System.out.println("Color?");
		color = sc.next();

		b1 = new Bike(plate, brand, color);

		String brandBackWheel;
		double diameterBackWheel;
		String brandFrontWheel;
		double diameterFrontWheel;
		Wheel backWheel;
		Wheel frontWheel;

		System.out.println("Marca roda trasera?");
		brandBackWheel = sc.next();


		//pregunta diametre roda trasera amb control errors
		correct = false;
		do {
			System.out.println("Diàmetre roda trasera?");
			diameterBackWheel = sc.nextDouble();
			try {
				if (diameterBackWheel<=0.4 || diameterBackWheel >=4) {
					throw new Exception(); 
				} else {
					correct = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  
		} while (correct == false);

		backWheel = new Wheel(brandBackWheel, diameterBackWheel);

		System.out.println("Marca roda davantera?");
		brandFrontWheel = sc.next();

		//pregunta diametre roda davantera amb control errors
		correct = false;
		do {
			System.out.println("Diàmetre roda davantera?");
			diameterFrontWheel = sc.nextDouble();
			try {
				if (diameterFrontWheel<=0.4 || diameterFrontWheel >=4) {
					throw new Exception(); 
				} else {
					correct = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  
		} while (correct == false);

		frontWheel = new Wheel(brandFrontWheel, diameterFrontWheel);


		try {
			b1.addWheels(frontWheel, backWheel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//sc.close();

		System.out.println("MOTO CREADA CORRECTAMENT");

		menu();
		

	}

}