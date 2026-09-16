import java.util.ArrayList;

public class GradeBookTest {
	
	public static void main(String[] args) {
		/*
		 * Create students
		 */
	    Student maya = new Student("Maya", 101);
	    maya.addGrade(95); maya.addGrade(90);

	    Student leo = new Student("Leo", 102);
	    leo.addGrade(88); leo.addGrade(80);

	    Student sara = new Student("Sara", 103);
	    sara.addGrade(79); sara.addGrade(74);

	    /*
	     * Add to GradeBook
	     */
	    GradeBook gb = new GradeBook();
	    gb.addStudent(maya); gb.addStudent(leo); gb.addStudent(sara);
	    gb.printSummary();
	    
	    /*
	     * Tests
	     */
	    int numErrors = 0;
	    
	    try {
		    double avg = gb.getClassAverage();
		    if (Math.abs(avg - 84.33333) > 0.00001) {
		    	System.out.println("ERROR! getClassAverage should return 84.33 but returns " + avg);
		    	numErrors++;
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getClassAverage throws exception: " + e);
	    	numErrors++;
	    }
	    
	    try {
		    Student topStudent = gb.getTopStudent();
		    if (topStudent == null) {
		    	System.out.println("ERROR! getTopStudent returns null");
		    	numErrors++;
		    }
		    else {
		    	String topStudentName = topStudent.getName();
		    	if ("Maya".equals(topStudentName) == false) {
		    		System.out.println("ERROR! getTopStudent().getName() should return 'Maya' but returns '" + topStudentName + "'");
		    		numErrors++;
		    	}
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getTopStudent throws exception: " + e);
	    	numErrors++;
	    }


	    try {
		    Student student102 = gb.findStudentById(102);
		    if (student102 == null) {
		    	System.out.println("ERROR! findStudentById(102) returns null");
		    	numErrors++;
		    }
		    else {
		    	String student102Name = student102.getName();
			    if ("Leo".equals(student102Name) == false) {
			    	System.out.println("ERROR! getTopStudent(102).getName() should return 'Leo' but returns '" + student102Name + "'");
			    	numErrors++;
			    }
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! findStudentById throws exception: " + e);
	    	numErrors++;
	    }

	    try {
		    ArrayList<Student> bStudents = gb.getStudentsByLetterGrade("B");
		    if (bStudents == null) {
		    	System.out.println("ERROR! getStudentsByLetterGrade(\"B\") returns null");
		    	numErrors++;
		    }
		    else {
		    	if (bStudents.size() != 1) {
		    		System.out.println("ERROR! getStudentsByLetterGrade(\"B\") returns ArrayList with " + bStudents.size() + " elements; should only be 1");
		    		numErrors++;
		    	}
		    	else if (bStudents.size() > 0 && bStudents.get(0) == null) {
		    		System.out.println("ERROR! first element of ArrayList returned by getStudentsByLetterGrade(\"B\") is null");
		    		numErrors++;
		    	}
		    	else if (bStudents.size() > 0 && "Leo".equals(bStudents.get(0).getName()) == false) {
		    		System.out.println("ERROR! getStudentsByLetterGrade(\"B\") should have 'Leo' as name of first Student in ArrayList but has " + bStudents.get(0).getName());
		    		numErrors++;
		    	}
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getStudentsByLetterGrade throws exception: " + e);
	    	numErrors++;
	    }


	    /*
	     * Edge-case tests
	     */
	    GradeBook empty = new GradeBook();
	    try {
	    	double average = empty.getClassAverage();
		    if (average != 0.0) {
		    	System.out.println("ERROR! getClassAverage should return 0.0 for empty GradeBook but returns " + empty.getClassAverage());
		    	numErrors++;
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getClassAverage throws exception with empty GradeBook: " + e);
	    	numErrors++;
	    }
	    
	    try {
	    	Student top = empty.getTopStudent();
		    if (top != null) {
		    	System.out.println("ERROR! getTopStudent should return null for empty GradeBook but returns non-null Student");
		    	numErrors++;
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getTopStudent throws exception with empty GradeBook: " + e);
	    	numErrors++;
	    }
	    
	    try {
	    	Student student999 = gb.findStudentById(999);
		    if (student999 != null) {
		    	System.out.println("ERROR! findStudentById with invalid ID should return null but returns non-null Student");
		    	numErrors++;
		    }
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! findStudentById throws exception with empty GradeBook: " + e);
	    	numErrors++;
	    }

	    Student noGrades = new Student("Test", 999);
	    try {
	    	double average = noGrades.getAverage();
	    	if (average != 0.0) {
	    		System.out.println("ERROR! getAverage should return 0 for Student with no grades but returns " + noGrades.getAverage());
	    		numErrors++;
	    	}
	    }
	    catch (Exception e) {
	    	System.out.println("ERROR! getAverage throws exception with for Student with no grades: " + e);
	    	numErrors++;
	    }
	    
	    System.out.println("\nDone running tests");
	    System.out.println("Number of errors: " + numErrors);
	}


}
