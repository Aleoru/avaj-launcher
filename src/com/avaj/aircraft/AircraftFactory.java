package com.avaj.aircraft;

/**
 * Factory class to create new aircraft.
 */
public class AircraftFactory {
	private static AircraftFactory factory = new AircraftFactory();

	private static long idCounter = 0;

	private AircraftFactory() {}

	public static AircraftFactory getFactory() {
		return AircraftFactory.factory;
	}

	public Coordinates Coordinates(int longitude, int latitude, int height) {
		return new Coordinates(longitude, latitude, height);
	}

	/**
	 * Factory method to create new aircraft.
	 * @param p_type type of the aircraft.
	 * @param p_name name of the aircraft.
	 * @param p_coordinates coordinates of the aircraft.
	 * @return new aircraft.
	 */
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(idCounter++, p_name, p_coordinates);
			case "JetPlane":
				return new Jetplane(idCounter++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(idCounter++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}