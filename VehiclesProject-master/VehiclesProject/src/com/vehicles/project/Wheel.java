package com.vehicles.project;



public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	/*
	 * public double getDiameter() { return diameter; }
	 * 
	 * public void setDiameter(double diameter) { this.diameter = diameter; }
	 */
	
	public boolean equals(Object o) {
		/*
		 * if (this == o) { return true; } if (o == null || getClass() != o.getClass())
		 * { return false; }
		 */
        Wheel wheel = (Wheel) o;
        return this.brand.equals(wheel.brand) &&
        		this.diameter == wheel.diameter;
                
    }
}
