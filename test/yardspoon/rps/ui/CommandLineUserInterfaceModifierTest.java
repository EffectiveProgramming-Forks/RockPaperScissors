package yardspoon.rps.ui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import yardspoon.rps.game.Result;


public class CommandLineUserInterfaceModifierTest {

	@Test
	public void getPlayer1NamePrompt() throws Exception {
		assertEquals("Player 1 Name: ", new CommandLineUserInterfaceModifier().getPlayer1NamePrompt());
	}
	
	@Test
	public void getPlayer2NamePrompt() throws Exception {
		assertEquals("Player 2 Name: ", new CommandLineUserInterfaceModifier().getPlayer2NamePrompt());
	}
	
	@Test
	public void getThrowPrompt() throws Exception {
		assertEquals("[R]ock, [P]aper, or [S]cissors? ", new CommandLineUserInterfaceModifier().getThrowPrompt());
	}
	
	@Test
	public void getWinOutcome() throws Exception {
		assertEquals("Bob Wins!", new CommandLineUserInterfaceModifier().getOutcome("Bob", "John", Result.Win));
	}
	
	@Test
	public void getLossOutcome() throws Exception {
		assertEquals("Mike Wins!", new CommandLineUserInterfaceModifier().getOutcome("Steve", "Mike", Result.Loss));
	}
	
	@Test
	public void getTieOutcome() throws Exception {
		assertEquals("Players Tie!", new CommandLineUserInterfaceModifier().getOutcome("Ben", "Kenny", Result.Tie));
	}
	
}
