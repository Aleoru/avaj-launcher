package com.avaj.weather;
import com.avaj.aircraft.Coordinates;

/**
 * 
 */
public class WeatherProvider {
	private static WeatherProvider provider = new WeatherProvider();

	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	/**
	 * 
	 * @return
	 */
	public static WeatherProvider getProvider(){
		return WeatherProvider.provider;
	}

	/** */
	public String getCurrentWeather(Coordinates p_coordinates){
		int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();

		int index = (seed + p_coordinates.getHeight()) % 4;

		if (index < 0) {
			index += 4;
		}
		return weather[index];
	}
}
