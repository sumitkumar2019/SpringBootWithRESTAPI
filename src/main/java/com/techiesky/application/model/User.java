package com.techiesky.application.model;

import java.util.Comparator;
import java.util.List;

/**
 * User Model Object
 * @author TechieSky
 *
 */

public class User {

	private Integer id;
	private String name;
	private List<Car> cars;

	public User() {

	}

	public User(Integer id, String name, List<Car> cars) {
		this.id = id;
		this.name = name;
		this.cars = cars;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public static Comparator<User> USERID_COMPARATOR = new Comparator<User>() {
		@Override
		public int compare(User u1, User u2) {
			return (u2.getId() < u1.getId() ? -1 : (u2.getId() == u1.getId() ? 0 : 1));
		}
	};

	public static Comparator<User> NAMECOMPARATOR = new Comparator<User>() {
		@Override
		public int compare(User u1, User u2) {
			return (int) (u1.getName()).compareTo(u2.getName());
		}
	};

}
