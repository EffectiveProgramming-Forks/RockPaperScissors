package yardspoon.rps.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import yardspoon.rps.game.Result;
import yardspoon.rps.game.Throw;

public class ThrowTest {

	@Test
	public void throwTwoOfTheSameKindResultsInATie() throws Exception {
		assertEquals(Result.Tie, Throw.Rock.play(Throw.Rock));
		assertEquals(Result.Tie, Throw.Paper.play(Throw.Paper));
		assertEquals(Result.Tie, Throw.Scissors.play(Throw.Scissors));
	}

	@Test
	public void rockBeatsScissors() throws Exception {
		assertEquals(Result.Win, Throw.Rock.play(Throw.Scissors));
	}

	@Test
	public void rockLossesToPaper() throws Exception {
		assertEquals(Result.Loss, Throw.Rock.play(Throw.Paper));
	}

	@Test
	public void scissorsBeatsPaper() throws Exception {
		assertEquals(Result.Win, Throw.Scissors.play(Throw.Paper));
	}

	@Test
	public void scissorsLosesToRock() throws Exception {
		assertEquals(Result.Loss, Throw.Scissors.play(Throw.Rock));
	}

	@Test
	public void paperBeatsRock() throws Exception {
		assertEquals(Result.Win, Throw.Paper.play(Throw.Rock));
	}

	@Test
	public void paperLosesToScissors() throws Exception {
		assertEquals(Result.Loss, Throw.Paper.play(Throw.Scissors));
	}

}
