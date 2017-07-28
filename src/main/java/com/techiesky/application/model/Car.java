package com.techiesky.application.model;

import java.util.Comparator;

/**
 * Car Model Object
 * @author TechieSky
 *
 */
public class Car {

	private Integer id;
	private String make;
	private String model;
	private String numberplate;

	public Car() {

	}

	public Car(Integer id, String make, String model, String numberplate) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.numberplate = numberplate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumberplate() {
		return numberplate;
	}

	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}

	public static Comparator<Car> CARID_COMPARATOR = new Comparator<Car>() {
		@Override
		public int compare(Car c1, Car c2) {
			return (c2.getId() < c1.getId() ? -1 : (c2.getId() == c1.getId() ? 0 : 1));
		}
	};

	public static Comparator<Car> MAKE_COMPARATOR = new Comparator<Car>() {
		@Override
		public int compare(Car c1, Car c2) {
			return (int) (c1.getMake().compareTo(c2.getMake()));
		}
	};
	
	public static Comparator<Car> MODEL_COMPARATOR = new Comparator<Car>() {
		@Override
		public int compare(Car c1, Car c2) {
			return (int) (c1.getModel()).compareTo(c2.getModel());
		}
	};
	
	public static Comparator<Car> PLATE_COMPARATOR = new Comparator<Car>() {
		@Override
		public int compare(Car c1, Car c2) {
			return (int) (c1.getNumberplate()).compareTo(c2.getNumberplate());
		}
	};
}
