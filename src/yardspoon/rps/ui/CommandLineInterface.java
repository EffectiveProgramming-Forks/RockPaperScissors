package yardspoon.rps.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CommandLineInterface {

	private final InputStream in;
	private final PrintStream out;

	public CommandLineInterface(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
	}

	public String prompt(String prompt) throws IOException {
		out.print(prompt);
		return new BufferedReader(new InputStreamReader(in)).readLine();
	}

	public void inform(String information) {
		out.println(information);
	}

}
