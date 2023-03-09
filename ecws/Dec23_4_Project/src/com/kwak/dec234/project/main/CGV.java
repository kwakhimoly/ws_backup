package com.kwak.dec234.project.main;

public class CGV {
	private String name;
	private String location;
	private int room;

	public CGV() {
		// TODO Auto-generated constructor stub
	}

	public CGV(String name, String location, int room) {
		super();
		this.name = name;
		this.location = location;
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

}
