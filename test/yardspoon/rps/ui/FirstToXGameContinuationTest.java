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
		FirstToXGameContinuation firstToX = new FirstToXGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		
		assertFalse(firstToX.stopPlaying());
	}
	
	@Test
	public void firstToThreeStopsOnlyAfterThree() throws Exception {
		FirstToXGameContinuation firstToThree = new FirstToXGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());

		firstToThree.addPlayerOneResult(Result.Win);
		assertTrue(firstToThree.stopPlaying());
	}
	
	@Test
	public void firstToThreeStopsOnlyAfterThreeWithPlayerTwoWinning() throws Exception {
		FirstToXGameContinuation firstToThree = new FirstToXGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertTrue(firstToThree.stopPlaying());
	}
	
	@Test
	public void tiesDoNotEffectOutcome() throws Exception {
		FirstToXGameContinuation firstToThree = new FirstToXGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.stopPlaying());

		firstToThree.addPlayerOneResult(Result.Tie);
		assertFalse(firstToThree.stopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.stopPlaying());

		firstToThree.addPlayerOneResult(Result.Tie);
		assertFalse(firstToThree.stopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertTrue(firstToThree.stopPlaying());
	}
	
	@Test
	public void winsAreRecordedAndDisplayedAfterSingleWin() throws Exception {
		FirstToXGameContinuation firstToX = new FirstToXGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		
		assertEquals("Record: 1-0", firstToX.report());
	}
	
	@Test
	public void winsAreRecordedAndDisplayedForBothPlayers() throws Exception {
		FirstToXGameContinuation firstToX = new FirstToXGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		firstToX.addPlayerOneResult(Result.Loss);
		
		assertEquals("Record: 1-1", firstToX.report());
	}
	
	@Test
	public void winsAreRecordedAndDisplayedForBothPlayersWhenTheGameIsOver() throws Exception {
		FirstToXGameContinuation firstToX = new FirstToXGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		firstToX.addPlayerOneResult(Result.Loss);
		firstToX.addPlayerOneResult(Result.Loss);
		
		assertEquals("Final Record: 1-2", firstToX.report());
	}
	
}
