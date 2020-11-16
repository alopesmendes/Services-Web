package fr.uge.corp.ifscars.cars;

import java.io.Serializable;

/**
 * <p>The interface ICar will represent the different cars.</p>
 * Each ICar will have a model and a price. By default the price is in euro (EUR).
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface ICar extends Serializable {
	String getModel();
	
	double getPrice();
}
