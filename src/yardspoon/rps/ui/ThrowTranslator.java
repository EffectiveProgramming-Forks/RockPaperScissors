package yardspoon.rps.ui;

import yardspoon.rps.game.Throw;

public interface ThrowTranslator {

	public abstract Throw translate(String throwAsSingleCharacter);

}