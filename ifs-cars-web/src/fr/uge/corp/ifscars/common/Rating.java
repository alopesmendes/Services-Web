package fr.uge.corp.ifscars.common;

import java.io.Serializable;


/**
 * Represents a rating given by an employee when they return a car.
 * 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 */
public class Rating implements Serializable {
	
	private final int score;
	private final int condition;
	
	/**
	 * Constructs a Rating with rating and condition
	 * @param score of the car.
	 * @param condition of the car.
	 */
	public Rating(int score, int condition) {
		if (score < 0 || score > 5) {
			throw new IllegalArgumentException("score is < 0 or > 5");
		}
		if (condition < 0 || condition > 5) {
			throw new IllegalArgumentException("condition is < 0 or > 5");
		}
		this.score = score;
		this.condition = condition;
	}
	
	public int getScore() {
		return score;
	}

	public int getCondition() {
		return condition;
	}

	@Override
	public String toString() {
		return "Rating{score=" + score + ", condition=" + condition + "}";
	}
}
