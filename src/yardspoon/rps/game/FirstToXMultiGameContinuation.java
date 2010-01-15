package yardspoon.rps.game;


public class FirstToXMultiGameContinuation implements MultiGameContinuation {

	private final Integer goalNumberOfWins;
	private Integer numberOfPlayerOneWins = 0;
	private Integer numberOfPlayerTwoWins = 0;

	public FirstToXMultiGameContinuation(Integer goalNumberOfWins) {
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

	public Boolean shouldStopPlaying() {
		return 	numberOfPlayerOneWins == goalNumberOfWins || 
			   	numberOfPlayerTwoWins == goalNumberOfWins;
	}

	public String report() {
		String report = "Record: " + numberOfPlayerOneWins + "-" + numberOfPlayerTwoWins;
		
		if(shouldStopPlaying()) {
			report = "Final " + report;
		}
		
		return report;
	}

	public Boolean shouldReportStatus() {
		return true;
	}

}
