package yardspoon.rps.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import yardspoon.rps.game.Result;


public class FirstToXGameContinuationTest {

	@Test
	public void firstToOneFinishesWithASingleResult() throws Exception {
		FirstToXGameContinuation firstToOne = new FirstToXGameContinuation(1);
		firstToOne.addPlayerOneResult(Result.Win);
		
		assertTrue(firstToOne.stopPlaying());
	}
	
	@Test
	public void firstToTwoDoesNotStopAfterTheFirstResult() throws Exception {
		FirstToXGameContinuation firstToOne = new FirstToXGameContinuation(2);
		firstToOne.addPlayerOneResult(Result.Win);
		
		assertFalse(firstToOne.stopPlaying());
	}
}
