package fr.uge.corp.ifscars.rating;

import java.io.Serializable;

import fr.uge.corp.ifscars.cars.ICar;

/**
 * <p>The Rating class will allow the employees to rate the {@link ICar}.</p>
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
@SuppressWarnings("serial")
public class Rating implements Serializable {
	static enum Score {
		Excellent, Good, Adequate, Bad, Terrible, None,
	}
	
	public String display() {
		return "Rating";
	}
	
	
}
