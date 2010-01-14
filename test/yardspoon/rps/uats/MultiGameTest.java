package yardspoon.rps.uats;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import yardspoon.rps.RockPaperScissors;

public class MultiGameTest {
	
	@Test
	public void firstToThreeWithPlayerTwoWinningTwoGames() throws Exception {
		String input = "Amos\nKenny\nS\nR\nS\nR\nS\nR\n";
		String expectedOutput = "Player 1 Name: " +
								"Player 2 Name: " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Kenny Wins!" + System.getProperty("line.separator") +
								"Record So Far: Amos-Kenny 0-1" + System.getProperty("line.separator") +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Kenny Wins!" + System.getProperty("line.separator") +
								"Record So Far: Amos-Kenny 0-2" + System.getProperty("line.separator") +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Kenny Wins!" + System.getProperty("line.separator") +
								"Record So Far: Amos-Kenny 0-3" + System.getProperty("line.separator");
		
		String actualOutput = executeGame(input, "-to", "3");
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void firstToTwoWithPlayerOneWinningOneGamesAndPlayerTwoWinningOneGame() throws Exception {
		String input = "Amos\nKenny\nS\nP\nR\nP\nS\nP\n";
		String expectedOutput = "Player 1 Name: " +
								"Player 2 Name: " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Amos Wins!" + System.getProperty("line.separator") +
								"Record So Far: Amos-Kenny 1-0" + System.getProperty("line.separator") +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Kenny Wins! (1-1)" + System.getProperty("line.separator") +
								"Record So Far: Amos-Kenny 1-1" + System.getProperty("line.separator") +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Amos Wins! (2-1)" + System.getProperty("line.separator") + 
								"Amos Wins Overall! Amos-Kenny 2-1" + System.getProperty("line.separator");
		
		String actualOutput = executeGame(input, "-to", "2");
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	// TODO Add test for ties
	
	private String executeGame(String input, String... arguments) throws IOException {
		PrintStream originalOutputStream = System.out;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		RockPaperScissors.main(arguments);
		
		System.setOut(originalOutputStream);
		return outputStream.toString();
	}
}
