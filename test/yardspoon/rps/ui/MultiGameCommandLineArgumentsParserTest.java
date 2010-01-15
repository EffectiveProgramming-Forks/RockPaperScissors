package yardspoon.rps.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import yardspoon.rps.game.NullMultiGameContinuation;

public class MultiGameCommandLineArgumentsParserTest {

	@Test
	public void emptyArgumentsCausesSingleGameToBePlayed() throws Exception {
		assertTrue(new MultiGameCommandLineArgumentsParser().parseArguments(new String[] {}) instanceof NullMultiGameContinuation);
	}
}
