package fr.uge.corp.ifscars.web;

class AverageRating {

	private double score;
	private double condition;
	
	AverageRating(double score, double condition) {
		this.score = score;
		this.condition = condition;
	}
	
	double getScore() {
		return score;
	}
	
	double getCondition() {
		return condition;
	}
}
