package fixtures;

import java.util.HashSet;
import java.util.Set;

import game.Player;

public class Room extends Fixture{
	private String roomName;
	private String shortDescription;
	private String longDescription;
	private Set<String> items = new HashSet<String>();
	private Room[] exits;
	private boolean locked;
	
	public Room(String name, String shortDescription, String longDescription, boolean locked) {
		this.roomName = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.locked = locked;
		this.exits = new Room[6]; //size is your choice
	}
	
	public Room(String name, String shortDescription, String longDescription, boolean locked, String item) {
		this.roomName = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.locked = locked;
		this.items.add(item);
		this.exits = new Room[6]; //size is your choice
	}
	
	public Room[] getExits() {
		return exits;
	}
	
	public Room getExit(int direction) {
		if (exits[direction] == null) {
			return this;
		}
		return exits[direction];
	}
	
	public void addItem(String item) {
		items.add(item);
	}
	public void removeItem(String item ) {
		items.remove(item);
	}
	public boolean itemsAvailable() {
		return !items.isEmpty();
	}
	
	public boolean containsItem(String item) {
		return items.contains(item);
	}
	
	public Set<String> getItems() {
		return items;
	}
	
	public void setSouthExit(Room room) {
		exits[0] = room;
	}
	public void setWestExit(Room room) {
		exits[1] = room;
	}
	public void setNorthExit(Room room) {
		exits[2] = room;
	}
	public void setEastExit(Room room) {
		exits[3] = room;
	}
	public void setUpExit(Room room) {
		exits[4] = room;
	}
	public void setDownExit(Room room) {
		exits[5] = room;
	}
	
	public boolean isLocked() {
		return locked;
	}
	public boolean unlock(Player player) {
		if (this.roomName.equals("Vault")) {
			if (player.getInventory().contains("Mysterious Key")) {
				System.out.println(player.getName() + " used the Mysterious Key to unlock the vault");
				System.out.println();
				this.locked = false;
				return true;
			}
			else {
				System.out.println("The Mysteriois Metal Door is locked...maybe theres a key for it somewhere");
				System.out.println();
				return false;
			}
		}
		else if (this.roomName.equals("Creepy Hallway")) {
			if (player.getInventory().contains("Light Candle")) {
				System.out.println(player.getName()+ "'s Light Candle illuminated the Creepy Hallway making it possible to traverse");
				System.out.println();
				this.locked = false;
				return true;
			}
			else {
				System.out.println("The Creepy Hallway is to dark to walk down... maybe there is a Candle to light the way");
				System.out.println();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return roomName;
	}
	
	@Override
	public String getRoomName() {
		return roomName;
	}
	
	@Override
	public String getShortDescription() {
		return shortDescription;
	}
	@Override
	public void setShortDescription(String description) {
		this.shortDescription = description;
	}
	
	@Override
	public String getLongDescription() {
		return longDescription;
	}
	@Override
	public void setLongDescription(String description) {
		this.longDescription = description;
	}
}
