package com.asher.domain;

public class Position {
	private int id;
	private String position;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", position=" + position + "]";
	}
	
}
