package yardspoon.rps.ui;

import yardspoon.rps.game.Result;

public interface MultiGameContinuation {

	public abstract void addPlayerOneResult(Result playerOneResult);

	public abstract Boolean stopPlaying();

	public abstract String report();

}