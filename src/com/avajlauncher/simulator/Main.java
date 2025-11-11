package com.avajlauncher.simulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(args[0]);
		File scenario = new File(args[0]);

		try (Scanner myReader = new Scanner(scenario)) {
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error ocurred");
			e.printStackTrace();
		}
	}
}