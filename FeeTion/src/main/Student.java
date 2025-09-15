package main;

import java.io.*;
import java.util.*;

public class Student {
	String LAST_NAME;
    String FIRST_NAME;
    String MIDDLE_NAME;
    String BIRTHDAY;
    String SCHOOL_YEAR;
    String YEAR_LEVEL;
    String COURSE;
    String COURSE_DETAILS;
    String SCHOLARSHIP_DETAILS;
    
    public static File FILE = new File("students.txt");
    
    public Student(String lastName, String firstName, String middleName,
                   String birthday, String schoolYear, String yearLevel, String course, String courseDetails, String scholarshipDetails) {
    	this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.MIDDLE_NAME = middleName;
        this.BIRTHDAY = birthday;
        this.SCHOOL_YEAR = schoolYear;
        this.YEAR_LEVEL = yearLevel;
        this.COURSE = course;
        this.COURSE_DETAILS = courseDetails;
        this.SCHOLARSHIP_DETAILS = scholarshipDetails;
    }
    
    @Override
    public String toString() {
        String info = LAST_NAME + "," + FIRST_NAME + "," + MIDDLE_NAME + "," 
        			+ BIRTHDAY + "," + SCHOOL_YEAR + "," + YEAR_LEVEL + "," 
        			+ COURSE + "," + COURSE_DETAILS;
        if (SCHOLARSHIP_DETAILS != null && !SCHOLARSHIP_DETAILS.trim().isEmpty()) {
        	return info + "," + SCHOLARSHIP_DETAILS;
        } else {
        	return info;
        }
    }

    public void saveStudent() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(this.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to save student: " + e.getMessage());
        }
    }
    
    public static List<Student> loadAllStudent() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                String lastName = parts[0];
                String firstName = parts[1];
                String middleName = parts[2];
                String birthday = parts[3];
                String schoolYear = parts[4];
                String yearLevel = parts[5];
                String course = parts[6];

                String courseDetails = String.join(",", Arrays.copyOfRange(parts, 7, 13));
                
                String scholarshipDetails = null;
                if (parts.length > 13 && parts[13] != null && !parts[13].isEmpty()) {
                    scholarshipDetails = parts[13];
                    if (parts.length > 14 && parts[14] != null && !parts[14].isEmpty()) {
                        scholarshipDetails += "," + parts[14];
                    }
                }

                Student student = new Student(lastName, firstName, middleName, birthday, schoolYear, yearLevel, course, courseDetails, scholarshipDetails);
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("Failed to load students: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void displayStudent(Display display, Scanner scan) {
        List<Student> students = loadAllStudent();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        } 
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== Student Options");
            System.out.println("1. Select Student");
            System.out.println("2. Back");
            System.out.print("\nChoice: ");

            String input = scan.nextLine();
            switch (input) {
                case "1":
                    System.out.println("\n=== Enrolled Students ");
                    System.out.println("Total Students: " + students.size());
                    System.out.println("=====================================");
                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        System.out.println((i + 1) + ". " + student.LAST_NAME + ", " + student.FIRST_NAME + " " + student.MIDDLE_NAME);
                    }
                    System.out.println("=====================================");

                    System.out.print("\nSelect a student by number: ");
                    int choice;
                    try {
                        choice = Integer.parseInt(scan.nextLine());
                        if (choice < 1 || choice > students.size()) {
                            System.err.println("Invalid choice. Please try again.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input. Please enter a number.");
                        break;
                    }

                    Student selectedStudent = students.get(choice - 1);
                    System.out.println("== Registration Form");
                    display.displayForm(selectedStudent);
                    
                    break;
                case "2":
                    isRunning = false;
                    break;

                default:
                    System.err.println("Invalid input. Please try again.");
                    break;
            }
        }
        
    }
}
