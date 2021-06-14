package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		Room nextRoom;
		rm.init();
		System.out.println("Welcome to the HomeTour Simulator");
		System.out.println("Please Enter your Name to Begin");
		
		Player john = new Player();
		john.setName(scan.next());
		john.setCurrentRoom(rm.getStartingRoom());
		
		boolean quit = false;
		while (!quit) {
			printRoom(john);
			System.out.println("Where do you want to go");
			String input = scan .next();
			//how to take in array of strings separated by white spaces
			
			if (input.trim().toLowerCase().equals("quit")) {
				quit = true;
				continue;
			}
			nextRoom = null;
			if (input.equals("Left")) {
				nextRoom = john.getCurrentRoom().getExit(1);
				john.setCurrentRoom(nextRoom);
			}
			else if (input.equals("Right")) {
				nextRoom = john.getCurrentRoom().getExit(3);
				john.setCurrentRoom(nextRoom);
			}
			else if (input.equals("Up")) {
				nextRoom = john.getCurrentRoom().getExit(2);
				john.setCurrentRoom(nextRoom);
			}
			else if (input.equals("Down")) {
				nextRoom = john.getCurrentRoom().getExit(0);
				john.setCurrentRoom(nextRoom);
			}
			else {
				System.out.println("You must enter a valid exit direction");
			}
		}
	}
	
	public static void printRoom(Player player) {
		System.out.println("Current Room: " + player.getCurrentRoom());
	}
	
	public static String[] collectInput() {
		//use scanner to collect console input from user
		//divide input into a command 'Go' and a target 'east'
		String[] s  = {"Go", "East"};
		return s;
	}
	
	public static void parse(String[] command, Player player) {
		//take the output of collectInput() and resolve the command
	}
}
