package com.vehicles.project;

public class VehiclesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static final String WRONG_PLATE = "La matrícula ha de tenir 4 números i dues o tres lletres";
	
		public static final String WRONG_DIAMETER = "El diametre ha de ser superior a 0.4 i inferior a 4";
		
		public VehiclesException(String message) {
			super(message);
		}

}
