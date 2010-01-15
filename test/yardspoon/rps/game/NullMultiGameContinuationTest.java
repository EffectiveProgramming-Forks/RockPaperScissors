package yardspoon.rps.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class NullMultiGameContinuationTest {
	
	@Test
	public void shouldReportStatus() throws Exception {
		assertFalse(new NullMultiGameContinuation().shouldReportStatus());
	}

	@Test
	public void shouldStopPlaying() throws Exception {
		assertTrue(new NullMultiGameContinuation().shouldStopPlaying());
	}
	
	@Test
	public void addResultDoesNothing() throws Exception {
		MultiGameContinuation testObject = new NullMultiGameContinuation();
		testObject.addPlayerOneResult(Result.Win);
		testObject.addPlayerOneResult(Result.Loss);
		testObject.addPlayerOneResult(Result.Tie);
	}
	
	@Test
	public void reportReturnsNull() throws Exception {
		assertNull(new NullMultiGameContinuation().report());
	}
	
}
