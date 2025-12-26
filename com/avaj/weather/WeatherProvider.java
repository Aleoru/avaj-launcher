package com.avaj.weather;
import com.avaj.aircraft.Coordinates;

/**
 * Singleton WeatherProvider. Provides the weather based on the coordinates.
 */
public class WeatherProvider {
	private static WeatherProvider provider = new WeatherProvider();

	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider(){
		return WeatherProvider.provider;
	}

	/**
	 * Determines the weather based on the coordinates.
	 * @param p_coordinates Aircraft coordinates.
	 * @return A string with the weather ("SUN", "RAIN", "FOG", "SNOW")
	 */
	public String getCurrentWeather(Coordinates p_coordinates){
		int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();

		int random = (int)(Math.random() * 4);
		int index = (seed + random) % 4;

		return weather[index];
	}
}
