package com.techiesky.application.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techiesky.application.helper.DataService;
import com.techiesky.application.model.Car;
import com.techiesky.application.model.User;

/**
 * User Services Provided by App like Search user, sort user, fetch all user,
 * fetch user/car by specific criteria
 * 
 * @author TechieSky
 *
 */
@Service("userService")
public class UserServiceImpl extends DataService implements UserService {

	@Override
	public List<User> getUsers() {
		return USERS;
	}

	@Override
	public List<User> getUsers(String name) {
		List<User> users = new ArrayList<User>();
		for (User user : USERS) {
			if (user.getName().contains(name)) {
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public List<Car> getCarsByMake(String make) {
		List<Car> cars = new ArrayList<Car>();
		for (Car car : CARS) {
			if (car.getMake().contains(make)) {
				cars.add(car);
			}
		}
		return cars;
	}

	@Override
	public List<Car> getCars(Integer userId) {
		for (User user : USERS) {
			if (user.getId().equals(userId)) {
				return user.getCars();
			}
		}
		return null;
	}

	@Override
	public Car getCar(Integer carId) {
		for (Car car : CARS) {
			if (car.getId().equals(carId)) {
				return car;
			}
		}
		return null;
	}

	@Override
	public List<User> sortUsers(List<User> users, String order, String type) {
		if (order.equals("asc")) {
			if (type.equals("name")) {
				Collections.sort(users, User.NAMECOMPARATOR);
			} else {
				Collections.sort(users, User.USERID_COMPARATOR);
			}
		} else {
			if (order.equals("dsc")) {
				if (type.equals("name")) {
					Collections.sort(users, Collections.reverseOrder(User.NAMECOMPARATOR));
				} else {
					Collections.sort(users, Collections.reverseOrder(User.USERID_COMPARATOR));
				}
			}
		}
		return users;
	}

	@Override
	public List<Car> sortCars(List<Car> cars, String order, String type) {
		if (order.equals("asc")) {
			if (type.equals("name")) {
				Collections.sort(cars, Car.MAKE_COMPARATOR);
			} else if (type.equals("model")) {
				Collections.sort(cars, Car.MODEL_COMPARATOR);
			} else if (type.equals("numberplate")) {
				Collections.sort(cars, Car.PLATE_COMPARATOR);
			} else {
				Collections.sort(cars, Car.CARID_COMPARATOR);
			}
		} else {
			if (type.equals("name")) {
				Collections.sort(cars, Collections.reverseOrder(Car.MAKE_COMPARATOR));
			} else if (type.equals("model")) {
				Collections.sort(cars, Collections.reverseOrder(Car.MODEL_COMPARATOR));
			} else if (type.equals("numberplate")) {
				Collections.sort(cars, Collections.reverseOrder(Car.PLATE_COMPARATOR));
			} else {
				Collections.sort(cars, Collections.reverseOrder(Car.CARID_COMPARATOR));
			}
		}
		return cars;
	}

	@Override
	public List<Car> getCars() {
		return CARS;
	}

	@Override
	public User getUser(Integer userId) {
		for (User user : USERS) {
			if (user.getId() == userId) {
				return user;
			}
		}
		return null;
	}
}
