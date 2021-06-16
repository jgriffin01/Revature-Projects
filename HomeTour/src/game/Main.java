package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static boolean quit = false;
	private static Room nextRoom;
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		rm.init();
		System.out.println("Welcome to the HomeTour Simulator");
		System.out.println("Please Enter your Name to Begin");
		
		Player john = new Player();
		john.setName(scan.next());
		john.setCurrentRoom(rm.getStartingRoom());
		scan.nextLine();
		
		while (!quit) {
			printRoom(john);
			System.out.println("Where do you want to go");
			parse(collectInput(), john);
		}
	}
	
	public static void printRoom(Player player) {
		System.out.println("Current Room: " + player.getCurrentRoom());
	}
	
	public static String[] collectInput() {
		//use scanner to collect console input from user
		//divide input into a command 'Go' and a target 'east'
		String info = scan.nextLine().trim().toLowerCase();
		String[] s  = info.split(" ");
		String[] input = {"", ""};
		for (int i = 0; i < s.length; i++) {
			input[i] = s[i];
		}
		return input;
	}
	
	public static void parse(String[] command, Player player) {
		//take the output of collectInput() and resolve the command
		nextRoom = null;
		switch (command[0]) {
		case"quit": {
			quit = true;
			break;
		}
		case "go": {
			switch (command[1]) {
			case "left": {
				nextRoom = player.getCurrentRoom().getExit(1);
				player.setCurrentRoom(nextRoom);
				break;
			}
			case "right": {
				nextRoom = player.getCurrentRoom().getExit(3);
				player.setCurrentRoom(nextRoom);
				break;
			}
			case "forward": {
				nextRoom = player.getCurrentRoom().getExit(2);
				player.setCurrentRoom(nextRoom);
				break;
			}
			case "back": {
				nextRoom = player.getCurrentRoom().getExit(0);
				player.setCurrentRoom(nextRoom);
				break;
			}
			default: {
				System.out.println("Invalid Direction");
			}
			}
			break;
		}
		case "grab": {
			break;
		}
		case "shout": {
			switch (command[1]) {
			case "warning": {
				System.out.println("Who Goes There!");
				break;
			}
			case "freedom": {
				System.out.println("FFFRRRREEEEDDDOOOOOOOOOOOMMM");
				break;
			}
			default: {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHH");
				break;
			}
			}
			break;
		}
		default: {
			System.out.println("Invalid Command");
		}
		}
	}
}
