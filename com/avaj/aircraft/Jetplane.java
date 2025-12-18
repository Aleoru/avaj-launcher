package com.avaj.aircraft;

/**
 * Jetplane class extends from Aircraft abstract class.
 */
public class Jetplane extends Aircraft {
	/**
	 * Constructs a Jetplane with the following attributes.
	 * @param p_id Unique ID for the Aircraft.
	 * @param p_name Name of the Baloon.
	 * @param p_coordinate Actual coordinates of the Baloon.
	 */
	public Jetplane(long p_id, String p_name, Coordinates p_coordinate){
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
				latChange = 10;
				heightChange = 2;
				message = "Sunny";
				break;
			case "RAIN":
				latChange = 5;
				message = "Rainy";
				break;
			case "FOG":
				latChange = 1;
				message = "Foggy";
				break;
			case "SNOW":
				heightChange = -7;
				message = "Snowy";
				break;
		}

		this.coordinates = this.coordinates.update(lonChange, latChange, heightChange);
		System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + message);

		if (this.coordinates.getHeight() <= 0) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
		}
	}
}
