package com.brian.albers.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.brian.albers.game.Powers;
import com.brian.albers.game.SaveWizards;
import com.brian.albers.game.Shields;
import com.brian.albers.game.Wizards;
import com.fdmgroup.serialization.game.HealthPack;

public class WizardsTest {
	List<Wizards> wizards = new ArrayList<>();
	List<Wizards> loadedWizards = null;

	Wizards blue = new Wizards();
	Wizards red = new Wizards();
	Wizards loadedBlue = null;
	Wizards loadedRed = null;

	HealthPack healthPacks = null;
	Shields shield = null;
	Powers power = null;

	@Before
	public void setUp() throws Exception {
		SaveWizards saveWizards= new SaveWizards();
		
		healthPacks = new HealthPack(20);
		shield = new Shields("Iron Shield", 20);
		power = new Powers("Heal", 10, 0);

		blue.setName("Janus");
		blue.setHealthPoints(100);
		blue.getBackpack().addHealthPack(healthPacks);
		blue.addShield(shield);
		blue.addPower(power);

		red.setName("Judas");
		red.setHealthPoints(100);
		red.getBackpack().addHealthPack(healthPacks);
		red.addShield(shield);
		red.addPower(power);

		power = new Powers("Fire Ball", 0, 15);

		blue.addPower(power);
		red.addPower(power);

		wizards.add(blue);
		wizards.add(red);
		
		saveWizards.serializeWizard(wizards);
		loadedWizards = saveWizards.deserializeWizard();
		
		loadedBlue = loadedWizards.get(0);
		loadedRed = loadedWizards.get(1);
	}

	@Test
	public void testBlueInstanceOfWizard() {
		assertTrue(blue instanceof Wizards);
	}

	@Test
	public void testBlueGetname() {
		String expect = "Janus";
		String actual = blue.getName();

		assertEquals(expect, actual);
	}

	@Test
	public void testBlueGetHealthPoints() {
		int expected = 100;
		int actual = blue.getHealthPoints();

		assertEquals(expected, actual);
	}

	@Test
	public void testBluePowersList() {
		String expected = "[Power: Heal Adds: 10 hit points  Takes Away: 0 hit points, Power: Fire Ball Adds: 0 hit points  Takes Away: 15 hit points]";
		String actual = blue.getPowers().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testBlueShieldsList() {
		String expected = "[Shield: Iron Shield Adds:20 hit points.]";
		String actual = blue.getShields().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testRedInstanceOfWizard() {
		assertTrue(red instanceof Wizards);
	}

	@Test
	public void testRedGetname() {
		String expect = "Judas";
		String actual = red.getName();

		assertEquals(expect, actual);
	}

	@Test
	public void testRedGetHealthPoints() {
		int expected = 100;
		int actual = red.getHealthPoints();

		assertEquals(expected, actual);
	}

	@Test
	public void testRedPowersList() {
		String expected = "[Power: Heal Adds: 10 hit points  Takes Away: 0 hit points, Power: Fire Ball Adds: 0 hit points  Takes Away: 15 hit points]";
		String actual = red.getPowers().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testRedShieldsList() {
		String expected = "[Shield: Iron Shield Adds:20 hit points.]";
		String actual = red.getShields().toString();

		assertEquals(expected, actual);
	}
	
	@Test
	public void testLoadedBlueIsInstanceOfWizards() {
		assertTrue(loadedBlue instanceof Wizards);
	}
	
	@Test
	public void testBlueNameAndLoadedBlueNameIsSame() {
		String expected = blue.getName();
		String actual = loadedBlue.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBlueHealthAndLoadedBlueHealthIsSame() {
		int expected = blue.getHealthPoints();
		int actual = loadedBlue.getHealthPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBluePowersAndLoadedBluePowersIsSame() {
		String expected = blue.getPowers().toString();
		String actual = loadedBlue.getPowers().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testBlueSheildsAndLoadedBlueShieldsIsSame() {
		String expected = blue.getShields().toString();
		String actual = loadedBlue.getShields().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testLoadedRedIsInstanceOfWizards() {
		assertTrue(loadedRed instanceof Wizards);
	}
	
	@Test
	public void testRedGetNameAndLoadedRedGetNameIsSame() {
		String expect = red.getName();
		String actual = loadedRed.getName();

		assertEquals(expect, actual);
	}

	@Test
	public void testRedGetHealthPointsAndLoadedRedGetHealthPointsIsSame() {
		int expected = red.getHealthPoints();
		int actual = loadedRed.getHealthPoints();

		assertEquals(expected, actual);
	}

	@Test
	public void testRedPowersAndLoadedRedPowersIsSame() {
		String expected = red.getPowers().toString();
		String actual = loadedRed.getPowers().toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testRedShieldsAndLoadedRedShieldsIsSame() {
		String expected = red.getShields().toString();
		String actual = loadedRed.getShields().toString();

		assertEquals(expected, actual);
	}
	
	@Test
	public void testWizardListAndLoadedWizardListAreDifferentObject() {
		assertFalse( wizards == loadedWizards);
	}
}