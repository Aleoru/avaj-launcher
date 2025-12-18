package com.avaj.aircraft;

/**
 * Helicopter class extends from Aircraft abstract class.
 */
public class Helicopter extends Aircraft {

	/**
	 * Constructs a Helicopter with the following attributes.
	 * @param p_id Unique ID of the Aircraft.
	 * @param p_name Name of the Aircraft.
	 * @param p_coordinate actual Coordinates of the Aircraft.
	 */
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		
		int lonChange = 0;
		int latChange = 0;
		int heightChange = 0;
		String message = "";

		switch (weather) {
			case "SUN":
				lonChange = 10;
				heightChange = -2;
				message = "Sunny sunny, can't see nothing.";
				break;
			case "RAIN":
				lonChange = 5;
				message = "Stop raining pls.";
				break;
			case "FOG":
				lonChange = 1;
				message = "Can't see nothing but at least I won't be blind.";
				break;
			case "SNOW":
				heightChange = -12;
				message = "Do you wanna build a snowmaaaaan?";
				break;
		}

		this.coordinates = this.coordinates.update(lonChange, latChange, heightChange);
		System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + message);

		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
		}
	}
}
