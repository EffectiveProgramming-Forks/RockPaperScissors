package yardspoon.rps;

import static org.junit.Assert.*;

import org.junit.Test;


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
}
