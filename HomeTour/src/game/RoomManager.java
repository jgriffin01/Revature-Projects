package game;

import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[] allRooms;
	
	public void init() {
		Room kit = new Room("Kitchen", "Kit = Food", "Food is made here");
		Room live = new Room("Living Room", "live = relax", "Watch tv here");
		Room bed = new Room ("Bedroom", "bed = sleep", "U sleep here");
		Room bath = new Room ("Bathroom", "bath = clean", "Take a shower here");
		
		//add all rooms to the map
		allRooms = new Room[4];
		allRooms[0] = bed;
		allRooms[1] = live;
		allRooms[2] = kit;
		allRooms[3] = bath;
		
		//set exits for rooms
		bed.setUpExit(live);
		bed.setRightExit(bath);
		live.setDownExit(bed);
		live.setRightExit(kit);
		kit.setLeftExit(live);
		kit.setDownExit(bath);
		bath.setUpExit(kit);
		bath.setLeftExit(bed);
		
		//set starting room
		startingRoom = kit;
	}
	
	public Room getStartingRoom() {
		return startingRoom;
	}
}
