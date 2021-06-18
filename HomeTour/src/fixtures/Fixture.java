package fixtures;

public abstract class Fixture {
	protected String roomName;
	protected String shortDescription;
	protected String longDescription;
	public abstract String getShortDescription();
	public abstract void setShortDescription(String description);
	public abstract String getLongDescription();
	public abstract void setLongDescription(String description);
	public abstract String getRoomName();
}
