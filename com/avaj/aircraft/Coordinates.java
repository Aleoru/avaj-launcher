package com.avaj.aircraft;

/**
 * Coordinates class to store a location point using longitude, latitude and height.
 */
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	/**
	 * Constructs a Coordinates Object which stores the following attributes.
	 * @param p_longitude Longitude.
	 * @param p_latitude Latitude.
	 * @param p_height Height.
	 */
	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;

		if(p_height > 100) {
			this.height = 100;
		}
		else if (p_height < 0) {
			this.height = 0;
		} else {
			this.height = p_height;
		}
	}

	/**
	 * Gets the longitude attribute.
	 * @return int Longitude.
	 */
	public int getLongitude(){
		return(this.longitude);
	}

	/**
	 * Gets the latitude attribute.
	 * @return int Latitude.
	 */
	public int getLatitude(){
		return(this.latitude);
	}

	/**
	 * Gets the height attribute.
	 * @return int Height.
	 */
	public int getHeight(){
		return(this.height);
	}

	/**
	 * Updates the Coordinates creating a new object.
	 * @param lonChange the difference within the new and old longitude.
	 * @param latChange the difference within the new and old latitude.
	 * @param heightChange the difference within the new and old height.
	 * @return new Coordinates
	 */
	public Coordinates update(int lonChange, int latChange, int heightChange) {
		int newLon = this.longitude + lonChange;
		int newLat = this.latitude + latChange;
		int newHeight = this.height + heightChange;

		if (newHeight > 100) {
			newHeight = 100;
		} else if (newHeight < 0) {
			newHeight = 0;
		}

		if (newLon < 0) newLon = 0;
		if (newLat < 0) newLat = 0;

		return new Coordinates(newLon, newLat, newHeight);
	}
}
