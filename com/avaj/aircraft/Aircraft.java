package com.avaj.aircraft;

/**
 *	Abstract class extended from Flyable.
 */
public abstract class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	/**
	 * Aircraft Constructor.
	 * @param p_id unique ID of the Aircraft.
	 * @param p_name name of the Aircarft.
	 * @param p_coordinate acutal coordinates of the Aircraft.
	 */
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	@Override
	public String toString() {
		String type = this.getClass().getSimpleName();
		return String.format("%s#%s(%d)", type, this.name, this.id);
	}
}
