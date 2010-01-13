package yardspoon.rps.ui;

import yardspoon.rps.game.Result;

public interface InterfaceModifier {

	public abstract String getPlayer1NamePrompt();

	public abstract String getPlayer2NamePrompt();

	public abstract String getThrowPrompt();

	public abstract String getOutcome(String player1, String player2,
			Result outcome);

}