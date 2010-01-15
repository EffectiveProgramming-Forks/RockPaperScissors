package yardspoon.rps.ui;

import yardspoon.rps.game.Result;

public class FirstToXGameContinuation {

	private final Integer goalNumberOfWins;
	private Integer numberOfPlayerOneWins = 0;
	private Integer numberOfPlayerTwoWins = 0;

	public FirstToXGameContinuation(Integer goalNumberOfWins) {
		this.goalNumberOfWins = goalNumberOfWins;
	}

	public void addPlayerOneResult(Result playerOneResult) {
		if(playerOneResult == Result.Win) {
			numberOfPlayerOneWins++;
		}
		else if(playerOneResult == Result.Loss) {
			numberOfPlayerTwoWins++;
		}
	}

	public Boolean stopPlaying() {
		return 	numberOfPlayerOneWins == goalNumberOfWins || 
			   	numberOfPlayerTwoWins == goalNumberOfWins;
	}

	public String report() {
		String report = "Record: " + numberOfPlayerOneWins + "-" + numberOfPlayerTwoWins;
		
		if(stopPlaying()) {
			report = "Final " + report;
		}
		
		return report;
	}

}
