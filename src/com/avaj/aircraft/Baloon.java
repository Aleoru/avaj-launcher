package com.avaj.aircraft;

/**
 * Baloon class extends from Aircraft abstract class.
 */
public class Baloon extends Aircraft {
	/**
	 * Constructs a Baloon with the following attributes.
	 * @param p_id Unique ID for the Aircraft.
	 * @param p_name Name of the Baloon.
	 * @param p_coordinate Actual coordinates of the Baloon.
	 */
	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
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
				message = "Sunny";
				break;
			case "RAIN":
				heightChange = -5;
				message = "Rainy";
				break;
			case "FOG":
				heightChange = -3;
				message = "Foggy";
				break;
			case "SNOW":
				heightChange = -15;
				message = "Snowy";
				break;
		}
		
		this.coordinates.update(lonChange, latChange, heightChange);
		System.out.println("Baloon#" + this.name + "(" + this.id + "): " + message);

		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Baloon#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
		}
	}
}
