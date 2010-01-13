package yardspoon.rps.game;

import java.io.IOException;

import yardspoon.rps.ui.InterfaceModifier;
import yardspoon.rps.ui.ThrowTranslator;
import yardspoon.rps.ui.UserInterface;

public class GameLoop {

	public void play(UserInterface userInterface, InterfaceModifier interfaceModifier,
			ThrowTranslator throwTranslator) throws IOException {
		
		String player1Name = userInterface.prompt(interfaceModifier.getPlayer1NamePrompt());
		String player2Name = userInterface.prompt(interfaceModifier.getPlayer2NamePrompt());
		String player1ThrowName = userInterface.prompt(interfaceModifier.getThrowPrompt());
		String player2ThrowName = userInterface.prompt(interfaceModifier.getThrowPrompt());
		Throw player1Throw = throwTranslator.translate(player1ThrowName);
		Throw player2Throw = throwTranslator.translate(player2ThrowName);
		userInterface.inform(interfaceModifier.getOutcome(player1Name, player2Name, player1Throw.play(player2Throw)));
	}

}
