package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static boolean quit = false;
	private static boolean roomChange = true;
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
			if (roomChange) {
				printRoom(john);
				roomChange = false;
			}
			parse(collectInput(), john);
		}
		scan.close();
	}
	
	public static void printRoom(Player player) {
		System.out.println();
		System.out.println("The " + player.getCurrentRoom());
		System.out.println();
		System.out.println(player.getCurrentRoom().getLongDescription());
		System.out.println();
		if (player.getCurrentRoom().itemsAvailable()) {
			System.out.println("Items:");
			for (String item: player.getCurrentRoom().getItems()) {
				System.out.println(item);
			}
			System.out.println();
		}
		printExits(player);
	}
	
	public static void printExits(Player player) {
		System.out.println("Exits:");
		for (int i = 0; i < player.getCurrentRoom().getExits().length; i++) {
			if (player.getCurrentRoom().getExits()[i] == null) {
				continue;
			}
			else {
				switch(i) {
				case 0: {
					System.out.println("South: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				case 1: {
					System.out.println("West: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				case 2: {
					System.out.println("North: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				case 3: {
					System.out.println("East: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				case 4: {
					System.out.println("Up: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				case 5: {
					System.out.println("Down: " + player.getCurrentRoom().getExits()[i].getShortDescription());
					break;
				}
				}
			}
		}
	}
	
	public static String[] collectInput() {
		//use scanner to collect console input from user
		//divide input into a command 'Go' and a target 'east'
		String info = scan.nextLine().trim().toLowerCase();
		String[] s  = info.split(" ");
		String[] input = {"", "", "", "", "", "", "", "", "", ""};
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
			case "west": {
				if (!player.getCurrentRoom().getExit(1).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(1);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(1).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(1);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			case "east": {
				if (!player.getCurrentRoom().getExit(3).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(3);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(3).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(3);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			case "north": {
				if (!player.getCurrentRoom().getExit(2).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(2);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(2).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(2);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			case "south": {
				if (!player.getCurrentRoom().getExit(0).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(0);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(0).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(0);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			case "up": {
				if (!player.getCurrentRoom().getExit(4).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(4);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(4).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(4);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			case "down": {
				if (!player.getCurrentRoom().getExit(5).isLocked()) {
					nextRoom = player.getCurrentRoom().getExit(5);
					player.setCurrentRoom(nextRoom);
					roomChange = true;
					break;
				} else {
					if (player.getCurrentRoom().getExit(5).unlock(player)) {
						nextRoom = player.getCurrentRoom().getExit(5);
						player.setCurrentRoom(nextRoom);
						roomChange = true;
						break;
					}
				}
			}
			default: {
				System.out.println("Invalid Direction");
			}
			}
			break;
		}
		case "shout": {
			switch (command[1]) {
			case "warning": {
				System.out.println("Who Goes There!");
				break;
			}
			case "again": {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
				break;
			}
			default: {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHH");
				break;
			}
			}
			break;
		}
		case "use": {
			switch (command[1]) {
			case "shower": {
				if (player.getCurrentRoom().containsItem("Shower")) {
					System.out.println(player.getName() + " took a shower");
					System.out.println();
					break;
				}
				else {
					System.out.println("A shower is not present in this room");
					System.out.println();
					break;
				}
			}
			case "toilet": {
				if (player.getCurrentRoom().containsItem("Toilet")) {
					System.out.println(player.getName() + " used the toilet");
					System.out.println();
					break;
				}
				else if (player.getCurrentRoom().containsItem("Crusty Toilet")) {
					System.out.println("The toilet is too groos even for " + player.getName() + " to use");
					System.out.println();
					break;
				}
				else {
					System.out.println("A toilet is not present in this room");
					System.out.println();
					break;
				}
			}
			case "bathtub": {
				if (player.getCurrentRoom().containsItem("Bathtub")) {
					System.out.println(player.getName() + " got into the  tub, but the water would not turn on");
					System.out.println();
					break;
				}
				else {
					System.out.println("A bathtub is not present in this room");
					System.out.println();
					break;
				}
			}
			case "bed": {
				if (player.getCurrentRoom().containsItem("Elegant Double Bed")) {
					System.out.println(player.getName() + " took a luxuirous nap");
					System.out.println();
					break;
				}
				else if (player.getCurrentRoom().containsItem("Large Bed")) {
					System.out.println(player.getName() + " took a short nap");
					System.out.println();
					break;
				}
				else {
					System.out.println("A bed is not present in this room");
					System.out.println();
					break;
				}
			}
			case "axe": {
				if (player.getInventory().contains("Old Axe")) {
					if (player.getCurrentRoom().containsItem("Sturdy Safe")) {
						double random = Math.floor(Math.random()*100);
						if (random > 75) {
							System.out.println(player.getName() + " delivered a mighty blow to the safe... and the door fell off!");
							System.out.println();
							player.getCurrentRoom().addItem("Shatered Safe");
							player.getCurrentRoom().removeItem("Sturdy Safe");
							player.getCurrentRoom().addItem("Mysterious Key");
							break;
						}
						else {
							System.out.println(player.getName() + " delivered a mighty blow to the safe... but the safe remains in tact");
							System.out.println();
							break;
						}
					}
					else {
						System.out.println(player.getName() + " swung their axe through the air");
						System.out.println();
						break;
					}
				}
				else {
					System.out.println(player.getName() + " does not have an axe to use");
					System.out.println();
					break;
				}
			}
			case "matches": {
				if (player.getInventory().contains("Box of Matches")) {
					System.out.println(player.getName() + " struck a match. It provides some light but a candle would do better");
					System.out.println();
					break;
				}
				else {
					System.out.println(player.getName() + " does not have any matches to use");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println("unable to use " + command[1]);
			}
			}
			break;
		}
		case "take": {
			switch (command[1]) {
			case "key": {
				if (player.getCurrentRoom().containsItem("Mysterious Key")) {
					System.out.println(player.getName() + " took the Mysterious Key");
					System.out.println();
					player.addToInventory("Mysterious Key");
					player.getCurrentRoom().removeItem("Mysterious Key");
					break;
				} else {
					System.out.println("There is no key to take");
					System.out.println();
					break;
				}
			}
			case "axe": {
				if (player.getCurrentRoom().containsItem("Old Axe")) {
					System.out.println(player.getName() + " took the Old Axe");
					System.out.println();
					player.addToInventory("Old Axe");
					player.getCurrentRoom().removeItem("Old Axe");
					break;
				} else {
					System.out.println("There is no Axe to take");
					System.out.println();
					break;
				}
			}
			case "book": {
				if (player.getCurrentRoom().containsItem("Mysterious Book")) {
					System.out.println(player.getName() + " took the Mysterious Book... the runied bookshelf begins to shake... and collapses into a pile of ruins");
					System.out.println();
					player.addToInventory("Mysterious Book");
					player.getCurrentRoom().removeItem("Mysterious Book");
					player.getCurrentRoom().setLongDescription("The library is even more of a ruin now. The remains of the bookshelf scattered across the floor are all thats left of the old library.");
					break;
				} else {
					System.out.println("There is no book to take");
					System.out.println();
					break;
				}
			}
			case "matches": {
				if (player.getCurrentRoom().containsItem("Box of Matches")) {
					System.out.println(player.getName() + " took the Box of Matches");
					System.out.println();
					player.addToInventory("Box of Matches");
					player.getCurrentRoom().removeItem("Box of Matches");
					break;
				} else {
					System.out.println("There are no matches to take");
					System.out.println();
					break;
				}
			}
			case "diary": {
				if (player.getCurrentRoom().containsItem("Old Diary")) {
					System.out.println(player.getName() + " took the Old Diary");
					System.out.println();
					player.addToInventory("Old Diary");
					player.getCurrentRoom().removeItem("Old Diary");
					break;
				} else {
					System.out.println("There is no diary to take");
					System.out.println();
					break;
				}
			}
			case "candle": {
				if (player.getCurrentRoom().containsItem("Large Candle")) {
					System.out.println(player.getName() + " took the Large Candle");
					System.out.println();
					player.addToInventory("Large Candle");
					player.getCurrentRoom().removeItem("Large Candle");
					break;
				} else {
					System.out.println("There is no candle to take");
					System.out.println();
					break;
				}
			}
			case "gold": {
				if (player.getCurrentRoom().containsItem("Pile of Gold")) {
					double random = Math.floor(Math.random()*100);
					if (random > 25) {
						System.out.println(player.getName() + " gathered up as much gold as they could... there is still plenty more where that came from");
						System.out.println();
						player.addToInventory("Bag of Gold");
						break;
					}
					else {
						System.out.println(player.getName() + " gathered up as much gold as they could... thats about all of it");
						System.out.println();
						player.addToInventory("Bag of Gold");
						player.getCurrentRoom().removeItem("Pile of Gold");
						break;
					}
				} else {
					System.out.println("There is no gold to take");
					System.out.println();
					break;
				}
			}
			case "gems": {
				if (player.getCurrentRoom().containsItem("Box of Gems")) {
					double random = Math.floor(Math.random()*100);
					if (random > 50) {
						System.out.println(player.getName() + " filled a whole box with gems... there is still plenty more where that came from");
						System.out.println();
						player.addToInventory("Box of Gems");
						break;
					}
					else {
						System.out.println(player.getName() + " filled a whole box with gems... thats about all of it");
						System.out.println();
						player.addToInventory("Box of Gems");
						player.getCurrentRoom().removeItem("Box of Gems");
						break;
					}
				} else {
					System.out.println("There are no gems to take");
					System.out.println();
					break;
				}
			}
			case "diamond": {
				if (player.getCurrentRoom().containsItem("Large Diamond")) {
					double random = Math.floor(Math.random()*100);
					if (random > 66) {
						System.out.println(player.getName() + " took a Large Diamond... theres more where that came from");
						System.out.println();
						player.addToInventory("Large Diamond");
						break;
					}
					else {
						System.out.println(player.getName() + " took a large Diamond... thats the last one");
						System.out.println();
						player.addToInventory("Large Diamond");
						player.getCurrentRoom().removeItem("Large Diamond");
						break;
					}
				} else {
					System.out.println("There is not Diamond to take");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println("No " + command[1] + " to take");
			}
			}
			break;
		}
		case "read": {
			switch (command[1]) {
			case "book": {
				if (player.getInventory().contains("Mysterious Book")) {
					System.out.println(player.getName() + " read the mysterious book... its contains a nice recipe for homemade tomato sauce");
					System.out.println();
					break;
				}
				else {
					System.out.println(player.getName() + "does not have a book to read");
					System.out.println();
					break;
				}
			}
			case "diary": {
				if (player.getInventory().contains("Old Diary")) {
					System.out.println(player.getName() + " read the Old Diary... the owener of this diary was a very rich man... maybe their stuff is till around here somewhere");
					System.out.println();
					break;
				}
				else {
					System.out.println(player.getName() + "does not have a diary to read");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println(command[1] + " is not a valid readable object");
				System.out.println();
			}
			}
			break;
		}
		case "wear": {
			switch (command[1]) {
			case "chefhat": {
				if (player.getCurrentRoom().containsItem("ChefHat")) {
					if (!player.getInventory().contains("TopHat")) {
						System.out.println(player.getName() + " put on the ChefHat");
						System.out.println();
						player.addToInventory("ChefHat");
						player.getCurrentRoom().removeItem("ChefHat");
						break;
					}
					else {
						System.out.println(player.getName() + " took of their TopHat and put on the ChefHat");
						System.out.println();
						player.addToInventory("ChefHat");
						player.getCurrentRoom().removeItem("ChefHat");
						player.getInventory().remove("TopHat");
						player.getCurrentRoom().addItem("TopHat");
						break;
					}
				}
				else {
					System.out.println("There is no ChefHat to wear");
					System.out.println();
					break;
				}
			}
			case "tophat": {
				if (player.getCurrentRoom().containsItem("TopHat")) {
					if (!player.getInventory().contains("ChefHat")) {
						System.out.println(player.getName() + " put on the TopHat");
						System.out.println();
						player.addToInventory("TopHat");
						player.getCurrentRoom().removeItem("TopHat");
						break;
					}
					else {
						System.out.println(player.getName() + " took of their ChefHat and put on the TopHat");
						System.out.println();
						player.addToInventory("TopHat");
						player.getCurrentRoom().removeItem("TopHat");
						player.getInventory().remove("ChefHat");
						player.getCurrentRoom().addItem("ChefHat");
						break;
					}
				}
				else {
					System.out.println("There is no TopHat to wear");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println(command[1] + " is not a wearable object");
				System.out.println();
			}
			}
			break;
		}
		case "juggle": {
			switch(command[1]) {
			case "apples": {
				if (player.getCurrentRoom().containsItem("Ripe Apples")) {
					double random = Math.floor(Math.random()*100);
					if (random > 45 ) {
						System.out.println(player.getName() + " juggled the apples like a pro... if anyone was watching they would be impressed for sure");
						System.out.println();
						break;
					}
					else {
						System.out.println(player.getName() + " tried to juggle the apples but dropped them all.. thankfully no one was watching, otherwise that would have been embarassing");
						System.out.println();
						break;
					}
				}
				else {
					System.out.println("There are no apples to juggle");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println(command[1] + " is not a jugllable object");
				System.out.println();
			}
			}
			break;
		}
		case "light": {
			switch (command[1]) {
			case "candle": {
				if (player.getInventory().contains("Large Candle")) {
					if (player.getInventory().contains("Box of Matches")) {
						System.out.println(player.getName() + " light the Large Candle with a match... it gives off a lot of light");
						System.out.println();
						player.getInventory().remove("Large Candle");
						player.getInventory().add("Light Candle");
						break;
					}
					else {
						System.out.println("You need someway to light your candle... a Box of Matches would do the trick");
						System.out.println();
						break;
					}
				}
				else {
					System.out.println("You do not have a Large Candle to light");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println(command[1] + " is not a lightable object");
				System.out.println();
			}
			}
			break;
		}
		case "open": {
			switch (command[1]) {
			case "safe": {
				if (player.getCurrentRoom().containsItem("Sturdy Safe")) {
					double random = Math.floor(Math.random()*100);
					if (random > 95) {
						System.out.println(player.getName() + " guessed the combination to the safe... and it worked!");
						System.out.println();
						player.getCurrentRoom().removeItem("Strudy Safe");
						player.getCurrentRoom().addItem("Open Safe");
						player.getCurrentRoom().addItem("Mysterious Key");
						break;
					}
					else {
						System.out.println(player.getName() + " guessed the combination to the safe... but it didnt work");
						System.out.println();
						break;
					}
				}
				else {
					System.out.println("There is no safe to open");
					System.out.println();
					break;
				}
			}
			default: {
				System.out.println(command[1] + " is not an openable object");
				System.out.println();
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
