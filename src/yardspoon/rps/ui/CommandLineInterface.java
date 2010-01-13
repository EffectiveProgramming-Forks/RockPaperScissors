package yardspoon.rps.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CommandLineInterface implements UserInterface {

	private final PrintStream out;
	private final BufferedReader in;

	public CommandLineInterface(InputStream in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = out;
	}

	public String prompt(String prompt) throws IOException {
		out.print(prompt);
		return in.readLine();
	}

	public void inform(String information) {
		out.println(information);
	}

}
