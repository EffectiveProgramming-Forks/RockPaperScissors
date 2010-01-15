package yardspoon.rps.ui;

import yardspoon.rps.game.MultiGameContinuation;
import yardspoon.rps.game.NullMultiGameContinuation;

public class MultiGameCommandLineArgumentsParser {

	public MultiGameContinuation parseArguments(String[] arguments) {
		return new NullMultiGameContinuation();
	}

}
