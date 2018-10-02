package com.brian.albers.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveWizards {
	private final String SERIALIZE_FILE_NAME = "wizards.ser";
	ObjectOutputStream oos = null;

	public void serializeWizard(List<Wizards> wizards) throws ClassNotFoundException {
		try {
			FileOutputStream fop = new FileOutputStream(SERIALIZE_FILE_NAME, true);
			oos = new ObjectOutputStream(fop);
			oos.writeObject(wizards);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Wizards> deserializeWizard() {
		ObjectInputStream ois = null;
		List<Wizards> wizards = null;
		try {
			wizards = new ArrayList<>();
			FileInputStream fis = new FileInputStream(SERIALIZE_FILE_NAME);
			ois = new ObjectInputStream(fis);
			wizards = (List<Wizards>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return wizards;
	}
}