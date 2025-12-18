package com.avaj.aircraft;

import com.avaj.simulator.AvajLauncherException;

/**
 * Factory class to create new aircraft.
 */
public class AircraftFactory {
	private static AircraftFactory factory = new AircraftFactory();

	private static long idCounter = 1;

	private AircraftFactory() {}

	public static AircraftFactory getFactory() {
		return AircraftFactory.factory;
	}

	public Coordinates createCoordinates(int longitude, int latitude, int height) {
		return new Coordinates(longitude, latitude, height);
	}

	/**
	 * Factory method to create new aircraft.
	 * @param p_type type of the aircraft.
	 * @param p_name name of the aircraft.
	 * @param p_coordinates coordinates of the aircraft.
	 * @return new aircraft.
	 * @throws AvajLauncherException 
	 */
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AvajLauncherException {
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(idCounter++, p_name, p_coordinates);
			case "JetPlane":
				return new Jetplane(idCounter++, p_name, p_coordinates);
			case "Balloon":
				return new Balloon(idCounter++, p_name, p_coordinates);
			default:
				throw new AvajLauncherException("Factory can't create aircraft of type " + p_type);
		}
	}
}