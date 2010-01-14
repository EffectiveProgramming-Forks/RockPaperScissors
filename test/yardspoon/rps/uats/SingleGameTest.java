package yardspoon.rps.uats;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import yardspoon.rps.RockPaperScissors;


public class SingleGameTest {

	@Test
	public void PlayersTie() throws Exception {
		String input = "Nate\nBen\nR\nR\n";
		String expectedOutput = "Player 1 Name: " +
								"Player 2 Name: " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Players Tie!" + System.getProperty("line.separator");
		
		String actualOutput = executeGame(input);

		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void FirstPlayerWins() throws Exception {
		String input = "Nate\nBen\nR\nS\n";
		String expectedOutput = "Player 1 Name: " +
								"Player 2 Name: " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Nate Wins!" + System.getProperty("line.separator");
		
		String actualOutput = executeGame(input);
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void SecondPlayerWins() throws Exception {
		String input = "Amos\nKenny\nP\nS\n";
		String expectedOutput = "Player 1 Name: " +
								"Player 2 Name: " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"[R]ock, [P]aper, or [S]cissors? " +
								"Kenny Wins!" + System.getProperty("line.separator");
		
		String actualOutput = executeGame(input);
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	private String executeGame(String input) throws IOException {
		PrintStream originalOutputStream = System.out;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		RockPaperScissors.main(new String[] {});
		
		System.setOut(originalOutputStream);
		return outputStream.toString();
	}
}
