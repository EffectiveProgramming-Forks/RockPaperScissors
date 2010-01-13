package yardspoon.rps.ui;

import java.io.IOException;

public interface UserInterface {

	public abstract String prompt(String prompt) throws IOException;

	public abstract void inform(String information);

}