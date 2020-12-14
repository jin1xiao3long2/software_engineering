package csmen.group.project.entity;

public class AppointmentInfo {
	private int DID;
	private int maxpatients;
	private int currentpatients;
	private String timestart;
	private String timestop;
	private String name;
	
	public AppointmentInfo() {}

	public AppointmentInfo(int DID, int maxpatients,int currentpatients,String timestart, String timestop, String name)
	{
		this.DID = DID;
		this.maxpatients = maxpatients;
		this.currentpatients = currentpatients;
		this.timestart = timestart;
		this.timestop = timestop;
		this.name = name;
	}
	
	public int getDID() {
		return DID;
	}
	public void setDID(int dID) {
		DID = dID;
	}
	public int getMaxpatients() {
		return maxpatients;
	}
	public void setMaxpatients(int maxpatients) {
		this.maxpatients = maxpatients;
	}
	public int getCurrentpatients() {
		return currentpatients;
	}
	public void setCurrentpatients(int currentpatients) {
		this.currentpatients = currentpatients;
	}
	public String getTimestart() {
		return timestart;
	}
	public void setTimestart(String timestart) {
		this.timestart = timestart;
	}
	public String getTimestop() {
		return timestop;
	}
	public void setTimestop(String timestop) {
		this.timestop = timestop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
