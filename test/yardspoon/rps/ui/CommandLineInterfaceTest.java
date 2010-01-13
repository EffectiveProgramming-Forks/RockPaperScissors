package yardspoon.rps.ui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class CommandLineInterfaceTest {
	
	@Test
	public void promptPushesStringToOutputAndReturnsNextLineFromInput() throws Exception {
		String expectedText = "dog";
		String input = expectedText + "\ncat";
		String prompt = "What are you?";
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream outputPrintStream = new PrintStream(outputStream);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

		UserInterface testObject = new CommandLineInterface(inputStream, outputPrintStream);
		String actualText = testObject.prompt(prompt);
		
		String actualPrompt = outputStream.toString();
		
		assertEquals(expectedText, actualText);
		assertEquals(prompt, actualPrompt);
	}
	
	@Test
	public void informPushesStringToOutput() throws Exception {
		String text = "Something happened!";
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream outputPrintStream = new PrintStream(outputStream);

		UserInterface testObject = new CommandLineInterface(mock(InputStream.class), outputPrintStream);
		testObject.inform(text);
		
		String actualInformation = outputStream.toString();
		
		assertEquals(text + System.getProperty("line.separator"), actualInformation);
	}
	
}
