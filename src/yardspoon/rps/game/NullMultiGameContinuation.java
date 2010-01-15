package yardspoon.rps.game;

public class NullMultiGameContinuation implements MultiGameContinuation {

	public void addPlayerOneResult(Result playerOneResult) {
	}

	public String report() {
		return null;
	}

	public Boolean shouldReportStatus() {
		return false;
	}

	public Boolean shouldStopPlaying() {
		return true;
	}

}
