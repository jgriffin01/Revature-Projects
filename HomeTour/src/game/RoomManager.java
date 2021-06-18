package game;

import java.util.HashSet;
import java.util.Set;

import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Set<Room> allRooms = new HashSet<>();
	
	public void init() {
		//floor one
		Room porch = new Room("Front Porch", "A Run Down Front Porch", "At one point this was a grand entrance. But time has taken its toll on the porch", false);
		Room foyer = new Room("Foyer", "Old Foyer", "The floorboard are weathered... many guests who have come and gone through this old foyer", false);
		Room stairs = new Room("Stairs", "A Spiral Staircase", "The stairs wind upwards and downwards. The rickty old stairs sway with each step, but they seem to hold you... at least for now", false);
		Room livingroom = new Room("LivingRoom", "A Cozy Living Room", "This old room must have been a wonderful place. The magnificent fireplace is really ties the room together", false);
		Room library = new Room("Library", "An Old Library", "A massive bookcase dominates the room, there must have been hundreds of books here once", false);
		Room diningroom = new Room("DiningRoom", "A Lavish DiningRoom", "A grand dining table takes center stage in the room. It must be big enough to seat thrity people.", false);
		Room groundBath = new Room("Bathroom", "A Modest Half-BAth", "a normal looking bathroom... just a littlle bit old", false);
		Room kitchen = new Room("Kitchen", "A Full Kitchen", "Pots and Pans, knives anf forks, cabinets as far as the eye can see... this kitchen could probably feed a whole army", false);
		Room garden = new Room("Garden", "A Lush Garden", "The garden may be the only part of the old house flourishing. Plants sprout from everywhere, and a massive apple tree sprouts out of the once strictly maintained garden",false);
		Room toolShed = new Room("Shed", "A Crumbling Shed", "The shed is barely standing. The wood is rotting, and it looks like a gentle breeze might blow the whole thing over.", false);
		//basement
		Room lowerStairs = new Room("Lower Stairs", "The Bottom of a Spiral Staircase", "These old stairs don't seem very safe... but they haven't fallen down yet...", false);
		Room creepyHallway = new Room("Creepy Hallway", "A Dark Hallway", "The hallway is long and dark. Even with your candle the hallway is still very dark... who knows what could be scurying about up ahead", true);
		Room vault = new Room("Vault", "A Mysterious Metal Door", "The mysterious room must have been a vault! Gems and gold coins are pilled sky high!", true);
		//floor two
		Room upperStairs = new Room("Upper Stairs", "The Top of a Spiral Staircase", "The old staircase must have once been a magnificent centerpiece to the old house... now it is barely stading", false);
		Room northHall = new Room("North Hall", "A Narrow Hallway", "This narrow hallway connects the stairs to the north side of the house", false);
		Room guestBedroom = new Room("Guest Bedroom", "A Guest Bedroom", "The old double bed and attached bathroom wuite must have made this quite the room in its prime", false);
		Room guestBath = new Room("Guest Bathroom", "A Bathroom Suite", "a modest on suit bathroom, with all the standard amenities", false);
		Room southHall = new Room("South Hall", "A Long Hallway", "The long southern hallway provied access to the southern side of the second floor", false);
		Room study = new Room("Study", "A Well Kept Study", "This chaotic organization of the room is evident even now. Whoever it was who used to live here must have been very busy", false);
		Room masterBed = new Room("Master Bedroom", "A Large Master Bedroom", "the master bedroom was a large room with an elegant double bedd and a bueatiful view of the garden out back from the window", false);
		Room masterBath = new Room("Master Bathroom", "A Large Bathroom Suite", "This must have been a luxourious bathroom... shower, tub, and double vanities... this bathroom had everything", false);
		
		//add all rooms to the map
		allRooms.add(porch);
		allRooms.add(foyer);
		allRooms.add(stairs);
		allRooms.add(livingroom);
		allRooms.add(library);
		allRooms.add(diningroom);
		allRooms.add(groundBath);
		allRooms.add(kitchen);
		allRooms.add(garden);
		allRooms.add(toolShed);
		
		allRooms.add(lowerStairs);
		allRooms.add(creepyHallway);
		allRooms.add(vault);
		
		allRooms.add(upperStairs);
		allRooms.add(northHall);
		allRooms.add(guestBedroom);
		allRooms.add(guestBath);
		allRooms.add(southHall);
		allRooms.add(study);
		allRooms.add(masterBed);
		allRooms.add(masterBath);
		
		//set exits for rooms
		porch.setNorthExit(foyer);
		foyer.setWestExit(livingroom);
		foyer.setNorthExit(stairs);
		foyer.setEastExit(diningroom);
		foyer.setSouthExit(porch);
		livingroom.setEastExit(foyer);
		livingroom.setNorthExit(library);
		library.setSouthExit(livingroom);
		stairs.setDownExit(lowerStairs);
		stairs.setSouthExit(foyer);
		stairs.setUpExit(upperStairs);
		diningroom.setWestExit(foyer);
		diningroom.setEastExit(groundBath);
		diningroom.setNorthExit(kitchen);
		groundBath.setWestExit(diningroom);
		kitchen.setSouthExit(diningroom);
		kitchen.setNorthExit(garden);
		garden.setSouthExit(kitchen);
		garden.setNorthExit(toolShed);
		toolShed.setSouthExit(garden);
		
		lowerStairs.setUpExit(stairs);
		lowerStairs.setNorthExit(creepyHallway);
		creepyHallway.setSouthExit(lowerStairs);
		creepyHallway.setNorthExit(vault);
		vault.setSouthExit(creepyHallway);
		
		upperStairs.setDownExit(stairs);
		upperStairs.setNorthExit(northHall);
		upperStairs.setSouthExit(southHall);
		northHall.setSouthExit(upperStairs);
		northHall.setWestExit(guestBedroom);
		guestBedroom.setEastExit(northHall);
		guestBedroom.setNorthExit(guestBath);
		guestBath.setSouthExit(guestBedroom);
		southHall.setNorthExit(stairs);
		southHall.setWestExit(study);
		southHall.setEastExit(masterBed);
		study.setEastExit(southHall);
		masterBed.setWestExit(southHall);
		masterBed.setSouthExit(masterBath);
		masterBath.setNorthExit(masterBed);
		
		//set items
		library.addItem("Mysterious Book");
		toolShed.addItem("Old Axe");
		garden.addItem("Ripe Apples");
		groundBath.addItem("Crusty Toilet");
		kitchen.addItem("ChefHat");
		livingroom.addItem("Box of Matches");
		diningroom.addItem("Large Candle");
		
		vault.addItem("Large Diamond");
		vault.addItem("Pile of Gold");
		vault.addItem("Box of Gems");
		
		masterBed.addItem("Old Diary");
		masterBed.addItem("Elegant Double Bed");
		guestBath.addItem("Toilet");
		guestBath.addItem("Shower");
		masterBath.addItem("Toilet");
		masterBath.addItem("Shower");
		masterBath.addItem("Bathtub");
		guestBedroom.addItem("TopHat");
		guestBedroom.addItem("Large Bed");
		study.addItem("Sturdy Safe");
		
		//set starting room
		startingRoom = porch;
	}
	
	public Room getStartingRoom() {
		return startingRoom;
	}
}
