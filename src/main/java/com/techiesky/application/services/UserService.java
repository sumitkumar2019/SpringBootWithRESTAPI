package com.techiesky.application.services;

import java.util.List;

import com.techiesky.application.model.Car;
import com.techiesky.application.model.User;

/**
 * User Services Provided by App like Search user, sort user, fetch all user,
 * fetch user/car by specific criteria
 * 
 * @author TechieSky
 *
 */
public interface UserService {

	/**
	 * Return List of Users
	 * 
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * Return List of Users by name
	 * 
	 * @return
	 */
	public List<User> getUsers(String name);

	/**
	 * Return List of Cars by make
	 * 
	 * @return
	 */

	public List<Car> getCarsByMake(String make);

	/**
	 * Return Sort of Users
	 * 
	 * @return
	 */
	public List<User> sortUsers(List<User> users, String order, String type);

	/**
	 * Return Sort of Cars
	 * 
	 * @return
	 */
	public List<Car> sortCars(List<Car> users, String order, String type);

	/**
	 * Return List of Cars
	 * 
	 * @return
	 */
	public List<Car> getCars();

	/**
	 * Return List of Cars by userId
	 * 
	 * @return
	 */
	public List<Car> getCars(Integer Id);

	/**
	 * Get Car by Id
	 * 
	 * @param Id
	 * @return
	 */
	public Car getCar(Integer carId);

	/**
	 * Get User by Id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Integer userId);

}
