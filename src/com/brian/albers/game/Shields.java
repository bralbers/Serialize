package com.brian.albers.game;

import java.io.Serializable;

public class Shields implements Serializable{

	private static final long serialVersionUID = 1L;
	private String shieldName;
	private int addHitPoints;

	public String getShieldName() {
		return shieldName;
	}
	
	public void setShieldName(String name) {
		this.shieldName = name;
	}
	
	public int getAddHitPoints() {
		return addHitPoints;
	}
	
	public void setAddHitPoints(int addHPs) {
		this.addHitPoints = addHPs;
	}
	
	public Shields(String shieldName, int addHitPoints){
		this.shieldName = shieldName;
		this.addHitPoints = addHitPoints;
	}
	
	@Override
	public String toString() {
		return "Shield: " + shieldName + " Adds:" + addHitPoints + " hit points.";
	}
}
