package game;

import fixtures.Room;

public class Player {
	String name;
	Room currentRoom;
	
	public Player() {}
	
	public Player(String name, Room currentRoom) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom (Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}
