package yardspoon.rps.ui;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import yardspoon.rps.game.FirstToXMultiGameContinuation;
import yardspoon.rps.game.NullMultiGameContinuation;

public class MultiGameCommandLineArgumentsParserTest {

	private MultiGameCommandLineArgumentsParser testObject;
	
	@Before
	public void setup() {
		testObject = new MultiGameCommandLineArgumentsParser();
	}

	@Test
	public void emptyArgumentsCausesSingleGameToBePlayed() throws Exception {
		assertTrue(testObject.parse(new String[] {}) instanceof NullMultiGameContinuation);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unknownArgumentsThrowException() throws Exception {
		testObject.parse(new String[] { "unknown" });
	}
	
	@Test
	public void dashToAndANumberReturnsInstanceOfFirstToXContinuation() throws Exception {
		assertTrue(testObject.parse(new String[] { "-to", "10" }) instanceof FirstToXMultiGameContinuation);
	}
}
