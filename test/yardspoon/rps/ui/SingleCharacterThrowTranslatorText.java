package yardspoon.rps.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import yardspoon.rps.game.Throw;


public class SingleCharacterThrowTranslatorText {

	@Test
	public void rIsConvertedToRock() throws Exception {
		assertEquals(Throw.Rock, new SingleCharacterThrowTransator().translate("R"));
	}
	
	@Test
	public void sIsConvertedToScissors() throws Exception {
		assertEquals(Throw.Scissors, new SingleCharacterThrowTransator().translate("S"));
	}
}
