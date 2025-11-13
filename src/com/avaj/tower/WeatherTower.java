package com.avaj.tower;
import com.avaj.aircraft.Coordinates;
import com.avaj.weather.WeatherProvider;

/**
 * WeatherTower extends from Tower.
 */
public class WeatherTower extends Tower{
	/**
	 * Gets the current weather in a location with its coordinates.
	 * @param p_coordinates Coordinates.
	 * @return String current weather.
	 */
	public String getWeather(Coordinates p_coordinates){
		return(WeatherProvider.getProvider().getCurrentWeather(p_coordinates));
	}

	/**
	 * Calls the Tower method conditionChange() that iterates the observers List of the Tower
	 * informing the change on the Weather.
	 */
	public void changeWeather(){
		super.conditionChange();
	}
}
