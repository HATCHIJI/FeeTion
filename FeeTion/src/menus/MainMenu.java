package menus;

import main.*;
import java.util.*;

public class MainMenu extends ConsoleMenu {
	private Display display;

	public MainMenu(Display display, Scanner scan) {
		super(scan);
		this.display = display;
		isRunning = true;
		menuItems = new String[] {"Enroll Student", "Student List", "Exit"};
	}

	@Override
	public void menuShow() {
		System.out.println("\n=== Enrollment System");
		super.menuShow();
	}

	@Override
	public void menuUserInput() {
		EnrollMenu enrollMenu = new EnrollMenu(display, scan);
		
		super.menuUserInput();
		switch (input.toLowerCase()) {
		case "1":
			enrollMenu.run();
			break;
		case "2":
			Student.displayStudent(display, scan);
			break;
		case "3":
			endProgram();
			break;
		default:
			System.err.println("Invalid input.");
			error = true;
			break;
			}
	} 
}