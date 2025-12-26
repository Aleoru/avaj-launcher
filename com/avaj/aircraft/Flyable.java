package com.avaj.aircraft;
import com.avaj.tower.WeatherTower;

/**
 * Defines which objects can be observed by the Tower class.
 */
public abstract class Flyable {
	protected WeatherTower weatherTower;
	
	/**
	 * Defines the movement logic of the aircraftt in reaction to the actual weather conditions.
	 */
	public abstract void updateConditions();

	/**
	 * Stores the weather tower reference in the aircraft.
	 * @param p_tower Instance of the weather tower reference which is associated the aircraft.
	 */
	public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
	}
}
