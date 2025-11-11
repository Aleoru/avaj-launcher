package com.avaj.tower;
import com.avaj.aircraft.Flyable;
import java.util.List;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_flyable){
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
	}

	protected void conditionChange(){
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}
