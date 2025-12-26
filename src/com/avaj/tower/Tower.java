package com.avaj.tower;
import com.avaj.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

/**
 * Observer Tower stores a List of Flyable objects.
 */
public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	/**
	 * Adds the object to the List.
	 * @param p_flyable the aircraft which is going to be stored.
	 */
	public void register(Flyable p_flyable){
		if (observers.contains(p_flyable)) {
			return;
		}
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable + " registered to weather tower.");
	}

	/**
	 * Removes the object from the list.
	 * @param p_flyable the aircraft which is going to be deleted.
	 */
	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
		System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
	}

	/**
	 * Iterates the list and calls updateConditions() method in all the observers.
	 */
	protected void conditionChange(){
		List<Flyable> observersCopy = new ArrayList<>(this.observers);

		for (Flyable flyable : observersCopy) {
			flyable.updateConditions();
		}
	}
}
