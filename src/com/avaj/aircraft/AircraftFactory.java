package com.avaj.aircraft;

/**
 * Factory class to create new aircraft.
 */
public class AircarftFactory {
	private static AircarftFactory factory = new AircarftFactory();

	priate static long idCounter = 0;

	private AircarftFactory() {}

	public static AircarftFactory getFactory() {
		return this.factory;
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
				return new JetPlane(idCounter++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(idCounter++, p_name, p_coordinates);
			default:
				return null;
		}
		return null;
	}
}