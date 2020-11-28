package fr.uge.corp.ifscars.web;

import java.util.function.LongUnaryOperator;

import fr.uge.corp.ifscars.common.Car;

public class AvailableCar {

	private long id;
	private String model;
	private long price;
	private double score;
	private double condition;
	
	static AvailableCar from(Car car, AverageRating averageRating, LongUnaryOperator currencyConverter) {
		AvailableCar avCar = new AvailableCar();
		avCar.setId(car.getId());
		avCar.setModel(car.getModel());
		avCar.setPrice(currencyConverter.applyAsLong(car.getPrice()));
		avCar.setScore(averageRating.getScore());
		avCar.setCondition(averageRating.getCondition());
		return avCar;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getCondition() {
		return condition;
	}
	public void setCondition(double condition) {
		this.condition = condition;
	}
}
