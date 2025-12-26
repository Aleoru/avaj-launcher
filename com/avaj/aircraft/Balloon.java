package com.avaj.aircraft;

/**
 * Baloon class extends from Aircraft abstract class.
 */
public class Balloon extends Aircraft {
	/**
	 * Constructs a Baloon with the following attributes.
	 * @param p_id Unique ID for the Aircraft.
	 * @param p_name Name of the Baloon.
	 * @param p_coordinate Actual coordinates of the Baloon.
	 */
	public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);

		int lonChange = 0;
		int latChange = 0;
		int heightChange = 0;
		String message = "";

		switch (weather) {
			case "SUN":
				lonChange = 2;
				heightChange = 4;
				message = "So sunny that could burn my skin.";
				break;
			case "RAIN":
				heightChange = -5;
				message = "This rain is making me gain weight.";
				break;
			case "FOG":
				heightChange = -3;
				message = "Can barely see anything with this fog.";
				break;
			case "SNOW":
				heightChange = -15;
				message = "With this cold snow my flame is going to go out.";
				break;
		}
		
		this.coordinates = this.coordinates.update(lonChange, latChange, heightChange);
		System.out.println("Balloon#" + this.name + "(" + this.id + "): " + message);

		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Balloon#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
		}
	}
}
