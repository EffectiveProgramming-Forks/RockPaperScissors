package yardspoon.rps.ui;

import yardspoon.rps.game.Result;

public class CommandLineUserInterfaceModifier {

	public String getPlayer1NamePrompt() {
		return "Player 1 Name: ";
	}

	public String getPlayer2NamePrompt() {
		return "Player 2 Name: ";
	}

	public String getThrowPrompt() {
		return "[R]ock, [P]aper, or [S]cissors? ";
	}

	public String getOutcome(String player1, String player2, Result outcome) {
		if(outcome == Result.Win) {
			return player1 + " Wins!";
		}
		else if(outcome == Result.Loss) {
			return player2 + " Wins!";
		}
		else {
			return "Players Tie!";
		}
	}

}
