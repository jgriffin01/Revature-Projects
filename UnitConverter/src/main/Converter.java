package main;

import java.util.Scanner;

public class Converter {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String selection = "";
		Converter c = new Converter();
		
		while (!selection.equals("4")) {
			System.out.println("Please select an option:");
			System.out.println("1. Volume Conversions");
			System.out.println("2. Distance Conversions");
			System.out.println("3. Temperature Conversions");
			System.out.println("4. Quit");
			
			selection = myScanner.next();
			boolean secondary = false;
			
			switch (selection) {
			case "1": {
				while (!secondary) {
					System.out.println();
					System.out.println("Please Select a Volume Conversion");
					System.out.println("1. Liquid Ounces to Milliliters");
					System.out.println("2. US Gallon to Liters");
					String secondaryPick = myScanner.next();
					
					switch(secondaryPick) {
					case "1": {
						System.out.print("How many Liquid Ounces? ");
						double ounces = c.getInput();
						double milliliters = c.ouncesToMilliliters(ounces);
						System.out.println(ounces + " Liquid Ounces converts to " + milliliters + " Milliliters");
						System.out.println();
						secondary = true;
						break;
					}
					case "2": {
						System.out.print("How many US Gallons? ");
						double gallons = c.getInput();
						double liters = c.usGallonToLiter(gallons);
						System.out.println(gallons + " US Gallons converts to " + liters + " Liters");
						System.out.println();
						secondary = true;
						break;
					}
					default: {
						System.out.println("Please Enter a Valid Input");
					}
					}
				}
			}
			case "2": {
				while (!secondary) {
					System.out.println();
					System.out.println("Please Select a Distance Conversion");
					System.out.println("1. Miles to Kilometers");
					System.out.println("2. Inches to Centimeters");
					String secondaryPick = myScanner.next();
					
					switch(secondaryPick) {
					case "1": {
						System.out.print("How many Miles? ");
						double miles = c.getInput();
						double kilometers = c.milesToKilometers(miles);
						System.out.println(miles + " Miles converts to " + kilometers + " Kilometers");
						System.out.println();
						secondary = true;
						break;
					}
					case "2": {
						System.out.print("How many Inches? ");
						double inches = c.getInput();
						double centimeters = c.inchesToCentimeters(inches);
						System.out.println(inches + " Inches converts to " + centimeters + " Centimeters");
						System.out.println();
						secondary = true;
						break;
					}
					default: {
						System.out.println("Please Enter a Valid Input");
					}
					}
				}
			}
			case "3": {
				while (!secondary) {
					System.out.println();
					System.out.println("Please Select a Temperature Conversion");
					System.out.println("1. Fahrenheit to Celsius");
					System.out.println("2. Fahrenheit to Kelvin");
					String secondaryPick = myScanner.next();
					
					switch(secondaryPick) {
					case "1": {
						System.out.print("What degree Fahrenheit?");
						double fahrenheit = c.getInput();
						double celsius = c.fahrenheitToCelsius(fahrenheit);
						System.out.println(fahrenheit + " degrees Fahrenheit converts to " + celsius + " degrees Celsius");
						System.out.println();
						secondary = true;
						break;
					}
					case "2": {
						System.out.print("What degree Fahrenheit?");
						double fahrenheit = c.getInput();
						double kelvin = c.fahrenheitToKelvin(fahrenheit);
						System.out.println(fahrenheit + " degrees Fahrenheit converts to " + kelvin + " degrees Kelvin");
						System.out.println();
						secondary = true;
						break;
					}
					default: {
						System.out.println("Please Enter a Valid Input");
					}
					}
				}
				

				break;
			}
			case "4": {
				System.out.println();
				System.out.println("Thanks for using the Unit Converter, Have a nice day!");
				break;
			}
			default: {
				System.out.println();
				System.out.println("Please enter a Valid Input");
				System.out.println();
			}
			}
		}
	}
	
	public double ouncesToMilliliters(double cups) {
		return cups*29.5735;
	}
	
	public double usGallonToLiter(double gallon) {
		return gallon*3.78541;
	}
	
	public double milesToKilometers(double miles) {
		return miles*1.60934;
	}
	
	public double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}
	
	public double fahrenheitToCelsius(double fahrenheit) {
		return ((fahrenheit - 32) * (5.0/9.0));
	}
	
	public double fahrenheitToKelvin(double fahrenheit) {
		return ((fahrenheit - 32) * (5.0/9.0) + 273.15);
	}
	
	public double getInput() {
		while (!myScanner.hasNextDouble()) {
			String input = myScanner.next();
			System.out.println("Please enter a valid input");
		}
		return myScanner.nextDouble();
	}
}
