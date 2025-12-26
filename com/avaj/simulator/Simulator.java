package com.avaj.simulator;

import com.avaj.aircraft.AircraftFactory;
import com.avaj.aircraft.Flyable;
import com.avaj.tower.WeatherTower;
import com.avaj.aircraft.Coordinates;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"));
			System.setOut(out);
		} catch (Exception e) {
			System.err.println("Could not redirect output to simulation.txt: " + e.getMessage());
			return;
		}
		int lineNumber = 1;
		try {
			validateArgs(args);
			try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
				String line = reader.readLine();

				if (line == null || line.trim().isEmpty()) {
					throw new AvajLauncherException("Scenario file is empty");
				}

				int simulations = 0;
				try {
					simulations = Integer.parseInt(line.trim().split("\\s+")[0]);
					if (simulations < 0) {
						throw new AvajLauncherException("Number of simulations must be a non-negative integer");
					}
				} catch (NumberFormatException e) {
					throw new AvajLauncherException("First line of scenario file must be a valid integer", e);
				}
				weatherTower = new WeatherTower();
				
				while ((line = reader.readLine()) != null) {
					lineNumber++;

					if (line.trim().isEmpty()) {
						continue;
					}

					Flyable flyable = parser(line, lineNumber);

					if (flyable != null) {
						flyables.add(flyable);
						flyable.registerTower(weatherTower);
						weatherTower.register(flyable);
					}
				}

				for (int i = 0; i < simulations; i++) {
					weatherTower.changeWeather();
				}
			} catch (AvajLauncherException e) {
				System.err.println("Error: " + e.getMessage());
			}		
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
	}

	private static Flyable parser(String line, int lineNumber) throws AvajLauncherException {
		String[] parts = line.split("\\s+");
		validateScenario(parts, lineNumber);

		String type = parts[0];
		String name = parts[1];
		int longitude = Integer.parseInt(parts[2]);
		int latitude = Integer.parseInt(parts[3]);
		int height = Integer.parseInt(parts[4]);

		Coordinates coords = AircraftFactory.getFactory().createCoordinates(longitude, latitude, height);
		return AircraftFactory.getFactory().newAircraft(type, name, coords);
	}

	private static void validateArgs(String[] args) throws AvajLauncherException {
		if (args.length != 1) {
			throw new AvajLauncherException("Usage: java -jar avaj-launcher.jar <scenario file>");
		}
	}

	private static void validateScenario(String[] parts, int lineNumber) throws AvajLauncherException {
		if (parts.length != 5) {
			throw new AvajLauncherException("Invalid scenario format at line " + lineNumber);
		}
		try {
			int lon = Integer.parseInt(parts[2]);
			int lat = Integer.parseInt(parts[3]);
			int height = Integer.parseInt(parts[4]);

			if (lon < 0 || lat < 0 || height < 0) {
				throw new AvajLauncherException("Negative coordinates at line " + lineNumber);
			}
		} catch (NumberFormatException e) {
			throw new AvajLauncherException("Invalid coordinates at line " + lineNumber);
		}

		String type = parts[0];
		if (!type.equals("Helicopter") && !type.equals("JetPlane") && !type.equals("Balloon")) {
			throw new AvajLauncherException("Unknown aircraft type " + type + " at line " + lineNumber);
		}
	}
}
