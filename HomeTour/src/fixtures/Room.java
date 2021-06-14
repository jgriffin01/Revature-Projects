package fixtures;

public class Room extends Fixture{
	private String roomName;
	private String shortDescription;
	private String longDescription;
	Room[] exits;
	
	public Room(String name, String shortDescription, String longDescription) {
		this.roomName = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.exits = new Room[4]; //size is your choice


		
	}
	
	public Room[] getExits() {
		return exits;
	}
	
	public Room getExit(int direction) {
		return exits[direction];
	}
	
	public void setDownExit(Room room) {
		exits[0] = room;
	}
	public void setLeftExit(Room room) {
		exits[1] = room;
	}
	public void setUpExit(Room room) {
		exits[2] = room;
	}
	public void setRightExit(Room room) {
		exits[3] = room;
	}
	
	@Override
	public String toString() {
		return roomName;
	}
}
