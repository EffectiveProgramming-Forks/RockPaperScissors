package yardspoon.rps.game;


public interface MultiGameContinuation {

	public abstract void addPlayerOneResult(Result playerOneResult);

	public abstract Boolean stopPlaying();

	public abstract String report();

}