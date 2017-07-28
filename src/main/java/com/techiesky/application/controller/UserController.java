package com.techiesky.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techiesky.application.model.Car;
import com.techiesky.application.model.User;
import com.techiesky.application.services.UserService;

/**
 * REST API Controller for serving various services of users
 * 
 * @author TechieSky
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * REST API to get all cars
	 * 
	 * @param find
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> listAllCars(@RequestParam(value = "find", defaultValue = "default") String find,
			@RequestParam(value = "sort", defaultValue = "default:default") String sort) {

		String criteria[] = sort.split(":");

		if (!find.equals("default") && !criteria[0].equals("default") && !criteria[1].equals("default")) {
			return new ResponseEntity<List<Car>>(
					userService.sortCars(userService.getCarsByMake(find), criteria[1], criteria[0]), HttpStatus.OK);
		} else if (!find.equals("default") && criteria[0].equals("default") && criteria[1].equals("default")) {
			return new ResponseEntity<List<Car>>(userService.getCarsByMake(find), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Car>>(userService.getCars(), HttpStatus.OK);
		}
	}

	/**
	 * REST API to get Car by carid
	 * 
	 * @param carId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCarById(@PathVariable("id") Integer carId) {
		Car car = userService.getCar(carId);
		if (car == null) {
			return new ResponseEntity("Car with id " + carId + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	/**
	 * REST API to get all users and filter by sort order
	 * 
	 * @param find
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(@RequestParam(value = "find", defaultValue = "default") String find,
			@RequestParam(value = "sort", defaultValue = "default") String sort) {

		String criteria[] = sort.split(":");

		if (!find.equals("default") && !criteria[0].equals("default") && !criteria[1].equals("default")) {
			return new ResponseEntity<List<User>>(
					userService.sortUsers(userService.getUsers(find), criteria[1], criteria[0]), HttpStatus.OK);
		} else if (!find.equals("default") && criteria[0].equals("default") && criteria[1].equals("default")) {
			return new ResponseEntity<List<User>>(userService.getUsers(find), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
		}

	}

	/**
	 * REST API to get user by id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId) {
		User user = userService.getUser(userId);
		if (user == null) {
			return new ResponseEntity("User with id " + userId + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * REST API to get Cars by userid
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/users/{id}/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> getUserCarById(@PathVariable("id") Integer userId) {

		List<Car> cars = userService.getCars(userId);

		if (cars == null) {
			return new ResponseEntity("User with id " + userId + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

}
