package yardspoon.rps.ui;

import yardspoon.rps.game.Throw;

public class SingleCharacterThrowTransator {

	public Throw translate(String throwAsSingleCharacter) {
		if("R".equals(throwAsSingleCharacter)) {
			return Throw.Rock;
		}
		
		return Throw.Scissors;
	}

}
