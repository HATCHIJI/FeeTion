package main;

import java.util.ArrayList;
import java.util.List;

public class Courses {
  public static final int PRICE_PER_UNIT = 1449;
  
  public static class Subject {
    private String subjectName;
    
    private int units;
    
    public Subject(String subjectName, int units) {
      this.subjectName = subjectName;
      this.units = units;
    }
    
    public int getUnits() {
      return this.units;
    }
    
    public String toString() {
      return String.valueOf(this.subjectName) + ":" + this.units;
    }
  }
  
  public static class Miscellaneous {
    private String miscName;
    
    private int price;
    
    public Miscellaneous(String miscName, int price) {
      this.miscName = miscName;
      this.price = price;
    }
    
    public int getPrice() {
      return this.price;
    }
    
    public String toString() {
      return String.valueOf(this.miscName) + ":" + this.price;
    }
  }
  
  public static String getCourseDetails(String course) {
    List<Subject> subjectsList = new ArrayList<>();
    List<Miscellaneous> miscList = new ArrayList<>();
    String semester = "1st Semester";
    String str1;
    switch ((str1 = course).hashCode()) {
      case 2048129:
        if (str1.equals("BSCS")) {
          subjectsList.add(new Subject("Computer Programming 1", 3));
          subjectsList.add(new Subject("Introduction to Computing", 3));
          subjectsList.add(new Subject("Physical Education 1", 2));
          subjectsList.add(new Subject("National Service Training Program 1", 3));
          subjectsList.add(new Subject("Understanding the Self", 3));
          subjectsList.add(new Subject("Purposive Communication", 3));
          subjectsList.add(new Subject("Euthenics", 1));
          subjectsList.add(new Subject("College Calculus", 3));
          miscList.add(new Miscellaneous("Library", 750));
          miscList.add(new Miscellaneous("P.E Court", 500));
          miscList.add(new Miscellaneous("Computer Lab", 1250));
          break;
        } 
      case 2048316:
        if (str1.equals("BSIT")) {
          subjectsList.add(new Subject("Computer Programming 1", 3));
          subjectsList.add(new Subject("Introduction to Computing", 3));
          subjectsList.add(new Subject("Physical Education 1", 2));
          subjectsList.add(new Subject("National Service Training Program 1", 3));
          subjectsList.add(new Subject("Understanding the Self", 3));
          subjectsList.add(new Subject("Purposive Communication", 3));
          subjectsList.add(new Subject("Euthenics", 1));
          subjectsList.add(new Subject("Information System", 3));
          miscList.add(new Miscellaneous("Library", 750));
          miscList.add(new Miscellaneous("P.E Court", 500));
          miscList.add(new Miscellaneous("Computer Lab", 1250));
          break;
        } 
      case 63492967:
        if (str1.equals("BSCpE")) {
          subjectsList.add(new Subject("Computer Programming 1", 3));
          subjectsList.add(new Subject("Robotics", 3));
          subjectsList.add(new Subject("Purposive Communication", 3));
          subjectsList.add(new Subject("National Service Training Program 1", 3));
          subjectsList.add(new Subject("Understanding the Self", 3));
          subjectsList.add(new Subject("Euthenics", 1));
          subjectsList.add(new Subject("College Calculus", 3));
          subjectsList.add(new Subject("Data Structure", 3));
          miscList.add(new Miscellaneous("Library", 750));
          miscList.add(new Miscellaneous("P.E Court", 500));
          miscList.add(new Miscellaneous("Computer Lab", 1250));
          miscList.add(new Miscellaneous("Robotics Lab", 1500));
          break;
        } 
      default:
        System.err.println("Update course details.");
        return "";
    } 
    int totalUnits = 0;
    for (Subject subj : subjectsList)
      totalUnits += subj.getUnits(); 
    String subjects = "";
    for (int i = 0; i < subjectsList.size(); i++) {
      subjects = String.valueOf(subjects) + ((Subject)subjectsList.get(i)).toString();
      if (i != subjectsList.size() - 1)
        subjects = String.valueOf(subjects) + ";"; 
    } 
    int totalMiscPrice = 0;
    for (Miscellaneous misc : miscList)
      totalMiscPrice += misc.getPrice(); 
    String miscellaneous = "";
    for (int j = 0; j < miscList.size(); j++) {
      miscellaneous = String.valueOf(miscellaneous) + ((Miscellaneous)miscList.get(j)).toString();
      if (j != miscList.size() - 1)
        miscellaneous = String.valueOf(miscellaneous) + ";"; 
    } 
    int tuitionFee = totalUnits * 1449 + totalMiscPrice;
    String courseDetails = String.valueOf(semester) + "," + subjects + "," + totalUnits + "," + miscellaneous + "," + totalMiscPrice + "," + tuitionFee;
    return courseDetails;
  }
}
