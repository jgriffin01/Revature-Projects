package game;

import java.util.HashSet;
import java.util.Set;

import fixtures.Room;

public class Player {
	String name;
	Room currentRoom;
	Set<String> inventory = new HashSet<String>();
	
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
	public Set<String> getInventory() {
		return inventory;
	}
	public void addToInventory(String item) {
		inventory.add(item);
	}
}
