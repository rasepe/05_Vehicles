package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	    public static void main(String[] args) {
	    	String plate;
	    	String brand;
	    	String color;
	    	Car c1;
	    	Scanner sc = new Scanner(System.in);
	    	
	    	System.out.println("Matrícula?");
	    	plate = sc.next();
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
	    	System.out.println("Diàmetre rodes traseres?");
	    	diameterBackWheels = sc.nextDouble();
	    	
	    	rightBackWheel = new Wheel(brandBackWheels, diameterBackWheels);
	    	leftBackWheel = new Wheel(brandBackWheels, diameterBackWheels); // rightBackWheel;
	    	
	    	
	    	System.out.println("Marca rodes davanteres?");
	    	brandFrontWheels = sc.next();
	    	System.out.println("Diàmetre rodes davanteres?");
	    	diameterFrontWheels = sc.nextDouble();
	    	
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
	    	
	    }
	    
	
}
