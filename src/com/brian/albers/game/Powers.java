package com.brian.albers.game;

import java.io.Serializable;

public class Powers implements Serializable {

	private static final long serialVersionUID = 1L;
	private String powerName;
	private int addHitPoints, loseHitPoints;

	public String getShieldName() {
		return powerName;
	}

	public void setShieldName(String name) {
		this.powerName = name;
	}

	public int getAddHitPoints() {
		return addHitPoints;
	}

	public void setAddHitPoints(int addHPs) {
		this.addHitPoints = addHPs;
	}

	public int getLoseHitPoints() {
		return loseHitPoints;
	}

	public void setLoseHitPoints(int loseHPs) {
		this.loseHitPoints = loseHPs;
	}

	public Powers(String powerName, int addHitPoints, int loseHitPoints) {
		this.powerName = powerName;
		this.addHitPoints = addHitPoints;
		this.loseHitPoints = loseHitPoints;
	}

	@Override
	public String toString() {
		return "Power: " + powerName + " Adds: " + addHitPoints + " hit points " + " Takes Away: " + loseHitPoints
				+ " hit points";
	}
}