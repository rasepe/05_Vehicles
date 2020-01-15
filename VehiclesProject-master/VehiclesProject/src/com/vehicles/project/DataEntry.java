package com.vehicles.project;

import java.util.Scanner;

public class DataEntry {
	static Scanner sc = new Scanner(System.in);
	public static void menu() {

		int option;

		System.out.println("Escull una opció:");
		System.out.println("1. Crear cotxe");
		System.out.println("2. Crear moto");
		System.out.println("3. Sortir");
		option = sc.nextInt();
		switch(option) {
		case 1:
			Main.addCar();
			break;
		case 2:
			Main.addBike();
			break;
		default:
			System.out.println("FI");
			sc.close();
			System.exit(0);
		}	
	}

	public static String[] vehicleFeatures() {

		String plate;
		String brand;
		String color;

		String[] features;

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

		//pregunta marca i color
		System.out.println("Marca?");
		brand = sc.next();
		System.out.println("Color?");
		color = sc.next();

		features = new String[]{plate,brand,color};

		return features;

	}

	public static String[] wheelFeatures(int typeWheel, int typeVehicle) {

		String brand;
		double diameter; 
		String[] features;

		String wildcard = "";

		if (typeWheel == 0 && typeVehicle == 0) {
			wildcard = "rodes traseres";
		}  
		if (typeWheel == 1 && typeVehicle == 0) {
			wildcard = "rodes davanteres";
		} 
		if (typeWheel == 0 && typeVehicle == 1) {
			wildcard = "roda trasera";
		} 
		if (typeWheel == 1 && typeVehicle == 1) {
			wildcard = "roda davantera";
		}

		//pregunta marca
		System.out.println("Marca " + wildcard  + "?");
		brand = sc.next();

		//pregunta diametre amb control errors
		boolean correct = false;
		do {
			System.out.println("Diàmetre " + wildcard  + "?");
			diameter = sc.nextDouble();
			try {
				if (diameter<=0.4 || diameter >=4) {
					throw new Exception(); 
				} else {
					correct = true;
				}
			}catch (Exception e) {
				System.out.println(VehiclesException.WRONG_DIAMETER);
			}  
		} while (correct == false);


		features = new String[]{brand,String.valueOf(diameter)};

		return features;

	}

	public static void correct() {
		System.out.println("VEHICLE CREAT CORRECTAMENT");
		
	}




}
