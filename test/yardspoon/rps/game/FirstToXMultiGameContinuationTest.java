package yardspoon.rps.game;

import static org.junit.Assert.*;

import org.junit.Test;

import yardspoon.rps.game.FirstToXMultiGameContinuation;
import yardspoon.rps.game.MultiGameContinuation;
import yardspoon.rps.game.Result;


public class FirstToXMultiGameContinuationTest {
	
	@Test
	public void shouldReportStatus() throws Exception {
		assertTrue(new FirstToXMultiGameContinuation(74).shouldReportStatus());
	}

	@Test
	public void firstToOneFinishesWithASingleResult() throws Exception {
		MultiGameContinuation firstToOne = new FirstToXMultiGameContinuation(1);
		firstToOne.addPlayerOneResult(Result.Win);
		
		assertTrue(firstToOne.shouldStopPlaying());
	}
	
	@Test
	public void firstToTwoDoesNotStopAfterTheFirstResult() throws Exception {
		MultiGameContinuation firstToX = new FirstToXMultiGameContinuation(2);
		firstToX.addPlayerOneResult(Result.Win);
		
		assertFalse(firstToX.shouldStopPlaying());
	}
	
	@Test
	public void firstToThreeStopsOnlyAfterThree() throws Exception {
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());

		firstToThree.addPlayerOneResult(Result.Win);
		assertTrue(firstToThree.shouldStopPlaying());
	}
	
	@Test
	public void firstToThreeStopsOnlyAfterThreeWithPlayerTwoWinning() throws Exception {
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertTrue(firstToThree.shouldStopPlaying());
	}
	
	@Test
	public void tiesDoNotEffectOutcome() throws Exception {
		MultiGameContinuation firstToThree = new FirstToXMultiGameContinuation(3);
		
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Win);
		assertFalse(firstToThree.shouldStopPlaying());

		firstToThree.addPlayerOneResult(Result.Tie);
		assertFalse(firstToThree.shouldStopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());
		firstToThree.addPlayerOneResult(Result.Loss);
		assertFalse(firstToThree.shouldStopPlaying());

		firstToThree.addPlayerOneResult(Result.Tie);
		assertFalse(firstToThree.shouldStopPlaying());
		
		firstToThree.addPlayerOneResult(Result.Loss);
		assertTrue(firstToThree.shouldStopPlaying());
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
