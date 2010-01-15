package yardspoon.rps.game;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import yardspoon.rps.ui.InterfaceModifier;
import yardspoon.rps.ui.MultiGameContinuation;
import yardspoon.rps.ui.ThrowTranslator;
import yardspoon.rps.ui.UserInterface;


public class GameLoopTest {
	
	@Test
	public void singleGameLoopCallsCorrectMethod() throws Exception {
		String player1Prompt = "Prompt 1";
		String player1Name = "P 1";
		String player2Prompt = "Prompt 2";
		String player2Name = "P 2";
		String throwPrompt = "Throw";
		String player1Throw = "A";
		String player2Throw = "B";
		String outcome = "Outcome";

		UserInterface mockUserInterface = mock(UserInterface.class);
		when(mockUserInterface.prompt(player1Prompt)).thenReturn(player1Name);
		when(mockUserInterface.prompt(player2Prompt)).thenReturn(player2Name);
		when(mockUserInterface.prompt(throwPrompt)).thenReturn(player1Throw, player2Throw);

		InterfaceModifier mockInterfaceModifier = mock(InterfaceModifier.class);
		when(mockInterfaceModifier.getPlayer1NamePrompt()).thenReturn(player1Prompt);
		when(mockInterfaceModifier.getPlayer2NamePrompt()).thenReturn(player2Prompt);
		when(mockInterfaceModifier.getThrowPrompt()).thenReturn(throwPrompt);
		when(mockInterfaceModifier.getOutcome(player1Name, player2Name, Result.Win)).thenReturn(outcome);
		
		ThrowTranslator mockThrowTranslator = mock(ThrowTranslator.class);
		when(mockThrowTranslator.translate(player1Throw)).thenReturn(Throw.Rock);
		when(mockThrowTranslator.translate(player2Throw)).thenReturn(Throw.Scissors);
		
		GameLoop loop = new GameLoop();
		loop.play(mockUserInterface, mockInterfaceModifier, mockThrowTranslator);
		
		verify(mockUserInterface).prompt(player1Prompt);
		verify(mockUserInterface).prompt(player2Prompt);
		verify(mockUserInterface, times(2)).prompt(throwPrompt);
		verify(mockUserInterface).inform(outcome);
	}
	
	@Test
	public void firstToXGameLoopCallsCorrectMethod() throws Exception {
		String player1Prompt = "Prompt 1";
		String player1Name = "P 1";
		String player2Prompt = "Prompt 2";
		String player2Name = "P 2";
		String throwPrompt = "Throw";
		String player1Throw = "A";
		String player2Throw = "B";
		String outcome = "Outcome";
		String firstRecord = "Record: 1-0";
		String finalRecord = "Final Record: 2-0";
		Result result = Result.Win;
		
		UserInterface mockUserInterface = mock(UserInterface.class);
		when(mockUserInterface.prompt(player1Prompt)).thenReturn(player1Name);
		when(mockUserInterface.prompt(player2Prompt)).thenReturn(player2Name);
		when(mockUserInterface.prompt(throwPrompt)).thenReturn(player1Throw, player2Throw);
		
		InterfaceModifier mockInterfaceModifier = mock(InterfaceModifier.class);
		when(mockInterfaceModifier.getPlayer1NamePrompt()).thenReturn(player1Prompt);
		when(mockInterfaceModifier.getPlayer2NamePrompt()).thenReturn(player2Prompt);
		when(mockInterfaceModifier.getThrowPrompt()).thenReturn(throwPrompt);
		when(mockInterfaceModifier.getOutcome(player1Name, player2Name, result)).thenReturn(outcome);
		
		ThrowTranslator mockThrowTranslator = mock(ThrowTranslator.class);
		when(mockThrowTranslator.translate(player1Throw)).thenReturn(Throw.Rock);
		when(mockThrowTranslator.translate(player2Throw)).thenReturn(Throw.Scissors);
		
		MultiGameContinuation mockMultiGameContinuation = mock(MultiGameContinuation.class);
		when(mockMultiGameContinuation.stopPlaying()).thenReturn(false, true);
		when(mockMultiGameContinuation.report()).thenReturn(firstRecord, finalRecord);
		
		GameLoop loop = new GameLoop();
		loop.play(mockUserInterface, mockInterfaceModifier, mockThrowTranslator, mockMultiGameContinuation);
		
		verify(mockUserInterface).prompt(player1Prompt);
		verify(mockUserInterface).prompt(player2Prompt);
		verify(mockUserInterface, times(4)).prompt(throwPrompt); // 2 for each game
		verify(mockUserInterface).inform(outcome);
		verify(mockMultiGameContinuation).addPlayerOneResult(result);
		verify(mockUserInterface).inform(firstRecord);
		verify(mockUserInterface).inform(outcome);
		verify(mockMultiGameContinuation).addPlayerOneResult(result);
		verify(mockUserInterface).inform(finalRecord);
		
	}
}
