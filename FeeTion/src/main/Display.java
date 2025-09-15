package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Display {
  public Student student;
  
  private Scanner scan;
  
  public Display(Scanner scan) {
    this.scan = scan;
  }
  
  public void enrollmentForm() {
    String[] info = new String[8];
    boolean formCompleted = false;
    while (!formCompleted) {
      boolean error;
      int i;
      System.out.println("\n=== Enrollment Fill Up Form");
      System.out.println("=========================================");
      System.out.println("\tLast Name\t: " + displayDash(info[0]));
      System.out.println("\tFirst Name\t: " + displayDash(info[1]));
      System.out.println("\tMiddle Name\t: " + displayDash(info[2]));
      System.out.println("\tBirth Day\t: " + displayDash(info[3]));
      System.out.println("\tSchool Year\t: " + displayDash(info[4]));
      System.out.println("\tYear Level\t: " + displayDash(info[5]));
      System.out.println("\tCourse\t\t: " + displayDash(info[6]));
      System.out.println("=========================================");
      System.out.println("\nType to edit: \n\t1 - Last Name \n\t2 - First Name \n\t3 - Middle Name \n\t4 - Birthday \n\t5 - School Year \n\t6 - Year Level \n\t7 - Course");
      System.out.println("\n'confirm' to finish \n'back' go back to enroll menu");
      System.out.print("\nChoice: ");
      String uEInput = this.scan.nextLine();
      String str1;
      switch ((str1 = uEInput.toLowerCase()).hashCode()) {
        case 49:
          if (!str1.equals("1"))
            break; 
          System.out.print("Enter Last Name: ");
          info[0] = this.scan.nextLine();
          continue;
        case 50:
          if (!str1.equals("2"))
            break; 
          System.out.print("Enter First Name: ");
          info[1] = this.scan.nextLine();
          continue;
        case 51:
          if (!str1.equals("3"))
            break; 
          System.out.print("Enter Middle Name: ");
          info[2] = this.scan.nextLine();
          continue;
        case 52:
          if (!str1.equals("4"))
            break; 
          while (true) {
            System.out.print("Enter Birthday (format: YYYY-MM-DD): ");
            info[3] = this.scan.nextLine();
            if (info[3].matches("\\d{4}-\\d{2}-\\d{2}"))
              break; 
            System.err.println("Invalid format. Please enter the date in YYYY-MM-DD format: ");
          } 
          continue;
        case 53:
          if (!str1.equals("5"))
            break; 
          System.out.println("Select School Year: ");
          System.out.println("\nType 1:  2025-2026");
          System.out.print("\nChoice: ");
          uEInput = this.scan.nextLine();
          if (uEInput.equalsIgnoreCase("1")) {
            info[4] = "2025-2026";
            continue;
          } 
          System.err.println("Invalid input for School Year.");
          continue;
        case 54:
          if (!str1.equals("6"))
            break; 
          System.out.println("Select Year Level: ");
          System.out.println("\nType 1: 1st Year");
          System.out.print("\nChoice: ");
          uEInput = this.scan.nextLine();
          if (uEInput.equalsIgnoreCase("1")) {
            info[5] = "1st Year";
            continue;
          } 
          System.err.println("Invalid input for Year Level.");
          continue;
        case 55:
          if (!str1.equals("7"))
            break; 
          System.out.println("Select Course: ");
          System.out.println("\nType 1: BSIT \nType 2: BSCS \nType 3: BSCpE");
          System.out.print("\nChoice: ");
          uEInput = this.scan.nextLine();
          if (uEInput.equalsIgnoreCase("1")) {
            info[6] = "BSIT";
            info[7] = Courses.getCourseDetails("BSIT");
            continue;
          } 
          if (uEInput.equalsIgnoreCase("2")) {
            info[6] = "BSCS";
            info[7] = Courses.getCourseDetails("BSCS");
            continue;
          } 
          if (uEInput.equalsIgnoreCase("3")) {
            info[6] = "BSCpE";
            info[7] = Courses.getCourseDetails("BSCpE");
            continue;
          } 
          System.err.println("Invalid input for Course.");
          continue;
        case 3015911:
          if (!str1.equals("back"))
            break; 
          formCompleted = true;
          continue;
        case 951117504:
          if (!str1.equals("confirm"))
            break; 
          error = false;
          for (i = 0; i < info.length; i++) {
            if (info[i] == null || info[i].trim().isEmpty()) {
              error = true;
              System.err.println("Field " + (i + 1) + " is incomplete.");
            } 
          } 
          if (!error) {
            returnStudent(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], null);
            formCompleted = true;
          } else {
            System.err.println("Please complete form.");
          } 
          System.out.println("Enrollment Form Completed Successfully.");
          continue;
      } 
      System.err.println("Invalid input.");
    } 
  }
  
  public void scholarshipForm() {
    boolean formCompleted = false;
    String condition = "";
    int discounted = 0;
    if (this.student == null) {
      System.err.println("Fill up enrollment form first.");
      return;
    } 
    while (!formCompleted) {
      boolean error;
      System.out.println("\n=== Scholarship Fill Up Form");
      displayForm(this.student);
      System.out.println("Scholarship: " + displayDash(condition));
      System.out.println("=========================================");
      System.out.println("\nType to Select Scholarship: \n\t1 - 15% \tWith Honors SH Graduate \n\t2 - 20% \tWith High Honors SH Graduate \n\t3 - 50% \tWith Highest Honors SH Graduate");
      System.out.println("\n'confirm' to finish \n'cancel' to cancel scholarship \n'back' go back to enroll menu");
      System.out.print("\nChoice: ");
      String uSInput = this.scan.nextLine();
      String[] details = this.student.COURSE_DETAILS.split(",");
      int tuitionFee = Integer.parseInt(details[5]);
      String str1;
      switch ((str1 = uSInput.toLowerCase()).hashCode()) {
        case -1367724422:
          if (!str1.equals("cancel"))
            break; 
          condition = null;
          this.student.SCHOLARSHIP_DETAILS = null;
          System.out.println("Scholarship Cancelled");
          continue;
        case 49:
          if (!str1.equals("1"))
            break; 
          condition = "With Honors";
          discounted = (int)(tuitionFee * 0.85D);
          continue;
        case 50:
          if (!str1.equals("2"))
            break; 
          condition = "With High Honors";
          discounted = (int)(tuitionFee * 0.8D);
          continue;
        case 51:
          if (!str1.equals("3"))
            break; 
          condition = "With Highest Honors";
          discounted = (int)(tuitionFee * 0.5D);
          continue;
        case 3015911:
          if (!str1.equals("back"))
            break; 
          formCompleted = true;
          continue;
        case 951117504:
          if (!str1.equals("confirm"))
            break; 
          error = false;
          if (condition == null || condition.isEmpty())
            error = true; 
          if (!error) {
            String scholarshipDetails = String.valueOf(condition) + "," + discounted;
            returnStudent(this.student.LAST_NAME, this.student.FIRST_NAME, this.student.MIDDLE_NAME, this.student.BIRTHDAY, this.student.SCHOOL_YEAR, this.student.YEAR_LEVEL, this.student.COURSE, this.student.COURSE_DETAILS, scholarshipDetails);
            System.out.println("Scholarship Added Successfully.");
            formCompleted = true;
            continue;
          } 
          System.err.println("Please complete form.");
          continue;
      } 
      System.err.println("Invalid input.");
    } 
  }
  
  public void confirmEnrollment() {
    if (this.student == null) {
      System.err.println("Student form not filled up.");
      return;
    } 
    System.out.println("== Registration Form");
    displayForm(this.student);
    System.out.println("\nType to select: \n\t'confirm' to confirm enrollment \n\t'cancel' to cancel enrollment (WARNING:It will erase all forms) \n\t'back' go back to enroll menu");
    System.out.print("\nChoice: ");
    String uCInput = this.scan.nextLine();
    String str1;
    switch ((str1 = uCInput.toLowerCase()).hashCode()) {
      case -1367724422:
        if (!str1.equals("cancel"))
          break; 
        this.student = null;
        System.out.println("Enrollment cancelled.");
        return;
      case 3015911:
        if (!str1.equals("back"))
          break; 
        return;
      case 951117504:
        if (!str1.equals("confirm"))
          break; 
        System.out.println("Student Enrolled Successfully.");
        this.student.saveStudent();
        this.student = null;
        return;
    } 
    System.err.println("Invalid input.");
  }
  
  public void displayForm(Student student) {
    if (student == null) {
      System.err.println("No student has been enrolled yet.");
      return;
    } 
    NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
    String[] courseDetails = student.COURSE_DETAILS.split(",");
    String semester = courseDetails[0];
    String[] subjects = courseDetails[1].split(";");
    int totalUnits = Integer.parseInt(courseDetails[2]);
    String[] miscellaneous = courseDetails[3].split(";");
    int totalMiscPrice = Integer.parseInt(courseDetails[4]);
    int tuitionFee = Integer.parseInt(courseDetails[5]);
    int w1 = 35, w2 = 27, w3 = 25;
    System.out.println("============================================================================\n");
    System.out.printf("%-" + w1 + "s%-" + w2 + "s%-" + w3 + "s\n", new Object[] { "Name:", "Birthday:", "School Year:" });
    System.out.printf("%-" + w1 + "s%-" + w2 + "s%-" + w3 + "s\n\n", new Object[] { String.valueOf(student.LAST_NAME) + ", " + student.FIRST_NAME + " " + student.MIDDLE_NAME, 
          student.BIRTHDAY, 
          student.SCHOOL_YEAR });
    System.out.printf("%-" + w1 + "s%-" + w2 + "s%-" + w3 + "s\n", new Object[] { "Course:", "Semester:", "Year Level:" });
    System.out.printf("%-" + w1 + "s%-" + w2 + "s%-" + w3 + "s\n\n", new Object[] { student.COURSE, 
          semester, 
          student.YEAR_LEVEL });
    System.out.println();
    System.out.printf("%-40s %s\n", new Object[] { "Subjects:", "Units:" });
    byte b;
    int i;
    String[] arrayOfString1;
    for (i = (arrayOfString1 = subjects).length, b = 0; b < i; ) {
      String subj = arrayOfString1[b];
      String[] parts = subj.split(":");
      if (parts.length == 2)
        System.out.printf("%-40s %-10s\n", new Object[] { parts[0], parts[1] }); 
      b++;
    } 
    System.out.println("----------------------------------------------------------------------------");
    System.out.printf("%-40s %d\n\n", new Object[] { "Total Units", Integer.valueOf(totalUnits) });
    System.out.printf("%-25s %s\n", new Object[] { "Miscellaneous:", "Price:" });
    for (i = (arrayOfString1 = miscellaneous).length, b = 0; b < i; ) {
      String misc = arrayOfString1[b];
      String[] parts = misc.split(":");
      if (parts.length == 2) {
        int price = Integer.parseInt(parts[1]);
        System.out.printf("%-25s %s\n", new Object[] { parts[0], pesoFormat.format(price) });
      } 
      b++;
    } 
    System.out.println("----------------------------------------------------------------------------");
    System.out.printf("%-25s %s", new Object[] { "Total", pesoFormat.format(totalMiscPrice) });
    System.out.printf("%29s %s\n", new Object[] { "Tuition Fee:", pesoFormat.format(tuitionFee) });
    if (student.SCHOLARSHIP_DETAILS != null && !student.SCHOLARSHIP_DETAILS.isEmpty()) {
      String[] scholarshipDetails = student.SCHOLARSHIP_DETAILS.split(",");
      if (scholarshipDetails.length == 2) {
        String scholarshipCondition = scholarshipDetails[0];
        int discountedTuitionFee = Integer.parseInt(scholarshipDetails[1]);
        double discountPercentage = 100.0D - discountedTuitionFee / tuitionFee * 100.0D;
        System.out.println("\nScholarships:");
        System.out.printf("%-25s %.0f%% %34s %s\n", new Object[] { scholarshipCondition, 
              Double.valueOf(discountPercentage), 
              "Discounted Tuition Fee:", 
              pesoFormat.format(discountedTuitionFee) });
      } 
    } 
    System.out.println("\n============================================================================");
  }
  
  public void returnStudent(String lastName, String firstName, String middleName, String birthday, String schoolYear, String yearLevel, String course, String courseDetails, String scholarshipDetails) {
    this.student = new Student(lastName, firstName, middleName, birthday, schoolYear, yearLevel, course, courseDetails, (
        scholarshipDetails != null && !scholarshipDetails.isEmpty()) ? scholarshipDetails : null);
  }
  
  private static String displayDash(String value) {
    return (value == null || value.trim().isEmpty()) ? " -" : value;
  }
}
