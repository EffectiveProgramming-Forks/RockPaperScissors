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
		
		Result result = playSingleGame(userInterface, interfaceModifier, throwTranslator);
		
		userInterface.inform(interfaceModifier.getOutcome(player1Name, player2Name, result));
	}

	private Result playSingleGame(UserInterface userInterface,
			InterfaceModifier interfaceModifier, ThrowTranslator throwTranslator)
			throws IOException {
		String player1ThrowName = userInterface.prompt(interfaceModifier.getThrowPrompt());
		String player2ThrowName = userInterface.prompt(interfaceModifier.getThrowPrompt());
	
		Throw player1Throw = throwTranslator.translate(player1ThrowName);
		Throw player2Throw = throwTranslator.translate(player2ThrowName);
	
		Result result = player1Throw.play(player2Throw);
		return result;
	}

	public void play(UserInterface userInterface,
			InterfaceModifier interfaceModifier,
			ThrowTranslator throwTranslator,
			MultiGameContinuation multiGameContinuation) throws IOException {
		
		String player1Name = userInterface.prompt(interfaceModifier.getPlayer1NamePrompt());
		String player2Name = userInterface.prompt(interfaceModifier.getPlayer2NamePrompt());
		
		do {
			Result result = playSingleGame(userInterface, interfaceModifier, throwTranslator);
			
			userInterface.inform(interfaceModifier.getOutcome(player1Name, player2Name, result));
			
			multiGameContinuation.addPlayerOneResult(result);
			userInterface.inform(multiGameContinuation.report());
		} while (!multiGameContinuation.stopPlaying());
	}

}
