package com.techiesky.application.helper;

import java.util.ArrayList;
import java.util.List;

import com.techiesky.application.model.Car;
import com.techiesky.application.model.User;

/**
 * Data Service class for Serving Data
 * @author TechieSky
 *
 */
public class DataService {

	//static data
	public static List<Car> CARS = new ArrayList<Car>();
	public static List<User> USERS = new ArrayList<User>();

	{
		Car car1 = new Car(1, "LADA", "2101", "123ASD");
		Car car2 = new Car(2, "Kia", "Sorento", "534TTT");
		Car car3 = new Car(3, "Skoda", "Octavia", "999GLF");
		Car car4 = new Car(4, "Kia", "Sorento", "555TFF");
		Car car5 = new Car(5, "LADA", "2101", "445KKK");
		Car car6 = new Car(6, "Audi", "A6", "997HHH");
		Car car7 = new Car(7, "BMW", "760", "444RRR");
		Car car8 = new Car(8, "Audi", "A6", "876OUI");
		Car car9 = new Car(9, "BMW", "740", "112YUI");

		CARS.add(car1);
		CARS.add(car2);
		CARS.add(car3);
		CARS.add(car4);
		CARS.add(car5);
		CARS.add(car6);
		CARS.add(car7);
		CARS.add(car8);
		CARS.add(car9);

		List<Car> carsuser1 = new ArrayList<Car>();
		carsuser1.add(car1);
		carsuser1.add(car2);

		List<Car> carsuser2 = new ArrayList<Car>();
		carsuser2.add(car3);
		carsuser2.add(car4);

		List<Car> carsuser3 = new ArrayList<Car>();
		carsuser3.add(car5);
		carsuser3.add(car6);

		List<Car> carsuser4 = new ArrayList<Car>();
		carsuser4.add(car7);
		carsuser4.add(car8);

		List<Car> carsuser5 = new ArrayList<Car>();
		carsuser5.add(car9);

		User user1 = new User(1, "Arjun Kumar", carsuser1);
		User user2 = new User(2, "Arvind Sinha", carsuser2);
		User user3 = new User(3, "RadheShyam Tiwari", carsuser3);
		User user4 = new User(4, "Vinay Singh", carsuser4);
		User user5 = new User(5, "Jay Kumar", carsuser5);

		USERS.add(user1);
		USERS.add(user2);
		USERS.add(user3);
		USERS.add(user4);
		USERS.add(user5);

	}

}
