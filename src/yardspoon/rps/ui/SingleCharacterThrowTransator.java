package yardspoon.rps.ui;

import yardspoon.rps.game.Throw;

public class SingleCharacterThrowTransator implements ThrowTranslator {

	public Throw translate(String throwAsSingleCharacter) {
		if("R".equals(throwAsSingleCharacter)) {
			return Throw.Rock;
		}
		else if("S".equals(throwAsSingleCharacter)) {
			return Throw.Scissors;
		}
		
		return Throw.Paper;
	}

}
