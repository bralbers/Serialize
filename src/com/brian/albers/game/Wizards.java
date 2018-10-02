package com.brian.albers.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.serialization.game.*;

public class Wizards extends Player implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient Backpack backpack = new Backpack();
	private List<Shields> shields = new ArrayList<Shields>();
	private List<Powers> powers = new ArrayList<Powers>();

	public Backpack getBackpack() {
		return backpack;
	}

	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

	public List<Shields> getShields() {
		return shields;
	}

	public void setShields(List<Shields> shields) {
		this.shields = shields;
	}

	public List<Powers> getPowers() {
		return powers;
	}

	public void setPowers(List<Powers> powers) {
		this.powers = powers;
	}

	public void addPower(Powers power) {
		this.getPowers().add(power);
	}

	public void addShield(Shields shield) {
		this.getShields().add(shield);
	}

	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeUTF(this.getName());
			os.writeInt(this.getHealthPoints());

			int count = backpack.getNumPacks();
			os.writeInt(count);

			for (int i = 0; i < count; i++) {
				int num = this.getBackpack().useHealthPack().getHealthPoints();
				os.writeInt(num);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			setName(is.readUTF());
			setHealthPoints(is.readInt());

			int count = is.readInt();
			backpack = new Backpack();

			for (int i = 0; i < count; i++) {
				getBackpack().addHealthPack(new HealthPack(is.readInt()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}