package yardspoon.rps.ui;

import yardspoon.rps.game.FirstToXMultiGameContinuation;
import yardspoon.rps.game.MultiGameContinuation;
import yardspoon.rps.game.NullMultiGameContinuation;

public class MultiGameCommandLineArgumentsParser {

	public MultiGameContinuation parse(String[] arguments) {
		if(arguments.length == 0) {
			return new NullMultiGameContinuation();
		}
		else if(arguments.length == 2) {
			String firstArgument = arguments[0];

			if(isFirstToX(firstArgument)) {
				int secondArgumentNumber = Integer.parseInt(arguments[1]);
				
				if(secondArgumentNumber > 0) {
					return new FirstToXMultiGameContinuation(secondArgumentNumber);
				}
			}
		}
		
		throw new IllegalArgumentException("Invalid game mode");
	}

	private boolean isFirstToX(String firstArgument) {
		return "-to".equals(firstArgument);
	}

}
