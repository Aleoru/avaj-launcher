package com.avaj.simulator;

import com.avaj.aircraft.AircraftFactory;
import com.avaj.aircraft.Flyable;
import com.avaj.tower.WeatherTower;
import com.avaj.aircraft.Coordinates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			int simulations = 0;

			if (line != null) {
				weatherTower = new WeatherTower();
				simulations = Integer.parseInt(line.split(" ")[0]);

				if (simulations < 0) {
					System.out.println("Invalid simulations count: " + simulations);
					System.exit(1);
				}

				while ((line = reader.readLine()) != null) {
					Flyable flyable = parser(line);

					if (flyable != null) {
						flyables.add(flyable);
						flyable.registerTower(weatherTower);
						weatherTower.register(flyable);
					}
				}
			}

			for (int i = 0; i < simulations; i++) {
				weatherTower.changeWeather();
			}
			reader.close();
		
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static Flyable parser(String line) {
		try {
			String[] parts = line.split(" ");
			if (parts.length != 5) throw new Exception("Invalid line format");

			String type = parts[0];
			String name = parts[1];
			int longitude = Integer.parseInt(parts[2]);
			int latitude = Integer.parseInt(parts[3]);
			int height = Integer.parseInt(parts[4]);

			Coordinates coords = AircraftFactory.getFactory().Coordinates(longitude, latitude, height);
			return AircraftFactory.getFactory().newAircraft(type, name, coords);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}
