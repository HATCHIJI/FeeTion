package menus;

import java.util.*;

public class ConsoleMenu {
	public boolean isRunning = false;
	public String[] menuItems;
	public boolean error = false;
	protected String input;
	protected Scanner scan;
	
	public ConsoleMenu(Scanner scan) {
		this.scan = scan;
		isRunning = true;
		menuItems = new String[] {};
	}
	
	public void run() {
		while(isRunning) {
			menuShow();
			menuUserInput();
		}
	}
	
	public void menuShow() {
		int i = 1;
		System.out.println("=====================================");
		for (String items : menuItems) {
			System.out.println(i + ". " + items);
			i++;
		}
		System.out.println("=====================================");
	}
	
	public void menuUserInput() {
		System.out.print("\nChoice: ");
	    if (scan.hasNextLine()) {
	        input = scan.nextLine();
	    } else {
	        System.err.println("No input available.");
	        endProgram();
	    }
	}
	
	public void endProgram() {
		isRunning = false;
	}
}
