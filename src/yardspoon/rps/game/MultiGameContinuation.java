package yardspoon.rps.game;


public interface MultiGameContinuation {

	public abstract void addPlayerOneResult(Result playerOneResult);

	public abstract Boolean shouldStopPlaying();

	public abstract String report();

	public Boolean shouldReportStatus();

}