package yardspoon.rps.ui;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

		CommandLineInterface testObject = new CommandLineInterface(inputStream, outputPrintStream);
		String actualText = testObject.prompt(prompt);
		
		String actualPrompt = outputStream.toString();
		
		assertEquals(expectedText, actualText);
		assertEquals(prompt, actualPrompt);
	}
	
	@Test
	public void informPushesStringToOutput() throws Exception {
		String information = "Something happened!";
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream outputPrintStream = new PrintStream(outputStream);

		CommandLineInterface testObject = new CommandLineInterface(null, outputPrintStream);
		testObject.inform(information);
		
		String actualInformation = outputStream.toString();
		
		assertEquals(information + System.getProperty("line.separator"), actualInformation);
	}
	
}
