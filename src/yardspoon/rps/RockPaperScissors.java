package yardspoon.rps;

import java.io.IOException;

import yardspoon.rps.game.GameLoop;
import yardspoon.rps.ui.CommandLineInterface;
import yardspoon.rps.ui.CommandLineUserInterfaceModifier;
import yardspoon.rps.ui.InterfaceModifier;
import yardspoon.rps.ui.SingleCharacterThrowTransator;
import yardspoon.rps.ui.ThrowTranslator;
import yardspoon.rps.ui.UserInterface;


public class RockPaperScissors {

	public static void main(String[] args) throws IOException {
		InterfaceModifier interfaceModifier = new CommandLineUserInterfaceModifier();
		UserInterface userInterface = new CommandLineInterface(System.in, System.out);
		ThrowTranslator throwTranslator = new SingleCharacterThrowTransator();
		
		new GameLoop().play(userInterface, interfaceModifier, throwTranslator);
	}

}
