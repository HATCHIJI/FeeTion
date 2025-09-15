package menus;


import main.*;
import java.util.*;

public class EnrollMenu extends ConsoleMenu {
	private Display display;

	public EnrollMenu(Display display, Scanner scan) {
		super(scan);
		this.display = display;
		isRunning = true;
		menuItems = new String[] {"Enrollment Form", "Scholarship Form", "Confirm Enrollment", "Back"};
	}
	@Override
	public void menuShow() {
		System.out.println("\n=== Enroll Student");
		super.menuShow();
	}
	
	@Override
	public void menuUserInput() {
		
		super.menuUserInput();
		switch (input.toLowerCase()) {
		case "1":
			display.enrollmentForm();
			break;
		case "2":
			display.scholarshipForm();
			break;
		case "3":
			display.confirmEnrollment();
			break;
		case "4":
			endProgram();
			break;
		default:
			System.err.println("Invalid input.");
			error = true;
			break;
		}
	}
}