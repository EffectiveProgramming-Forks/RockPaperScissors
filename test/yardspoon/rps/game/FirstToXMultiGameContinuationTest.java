package yardspoon.rps.game;

import static org.junit.Assert.*;

import org.junit.Test;

import yardspoon.rps.game.FirstToXMultiGameContinuation;
import yardspoon.rps.game.MultiGameContinuation;
import yardspoon.rps.game.Result;


public class FirstToXMultiGameContinuationTest {

	@Test
	public void firstToOneFinishesWithASingleResult() throws Exception {
		MultiGameContinuation firstToOne = new FirstToXMultiGameContinuation(1);
		firstToOne.addPlayerOneResult(Result.Win);
		
		assertTrue(firstToOne.stopPlaying());
	}
	
	@Test
	public void firstToTwoDoesNotStopAfterTheFirstResult() throws Exception {
		MultiGameContinuation firstToX = new FirstToXMultiGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		
		assertFalse(firstToX.stopPlaying());
	}
	
	@Test
	public void firstToThreeStopsOnlyAfterThree() throws Exception {
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
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
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
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
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
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
		MultiGameContinuation firstToX = new FirstToXMultiGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		
		assertEquals("Record: 1-0", firstToX.report());
	}
	
	@Test
	public void winsAreRecordedAndDisplayedForBothPlayers() throws Exception {
		MultiGameContinuation firstToX = new FirstToXMultiGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		firstToX.addPlayerOneResult(Result.Loss);
		
		assertEquals("Record: 1-1", firstToX.report());
	}
	
	@Test
	public void winsAreRecordedAndDisplayedForBothPlayersWhenTheGameIsOver() throws Exception {
		MultiGameContinuation firstToX = new FirstToXMultiGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		firstToX.addPlayerOneResult(Result.Loss);
		firstToX.addPlayerOneResult(Result.Loss);
		
		assertEquals("Final Record: 1-2", firstToX.report());
	}
	
}
