package yardspoon.rps.ui;

import yardspoon.rps.game.Result;

public class FirstToXGameContinuation {

	private final Integer goalNumberOfWins;
	private Integer numberOfPlayerOneWins = 0;

	public FirstToXGameContinuation(Integer goalNumberOfWins) {
		this.goalNumberOfWins = goalNumberOfWins;
	}

	public void addPlayerOneResult(Result playerOneResult) {
		if(playerOneResult == Result.Win) {
			numberOfPlayerOneWins++;
		}
	}

	public Boolean stopPlaying() {
		return numberOfPlayerOneWins == goalNumberOfWins;
	}

}
