import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ArrayLists to store student names and grades
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("=================================");

        // Ask for the number of students
        System.out.print("\nEnter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Clears the Enter key

        // Input student details
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            double grade;

while (true) {
    System.out.print("Enter student grade (0-100): ");
    grade = scanner.nextDouble();
    scanner.nextLine();

    if (grade >= 0 && grade <= 100) {
        break;
    } else {
        System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
    }
}

            studentNames.add(name);
            studentGrades.add(grade);
        }

        // Check if students were added
        if (studentGrades.size() > 0) {

            double total = 0;
            double highest = studentGrades.get(0);
            double lowest = studentGrades.get(0);

            // Calculate total, highest, and lowest grades
            for (double grade : studentGrades) {

                total += grade;

                if (grade > highest) {
                    highest = grade;
                }

                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / studentGrades.size();

            // Display report
            System.out.println("\n=================================");
            System.out.println("        STUDENT REPORT");
            System.out.println("=================================");

            for (int i = 0; i < studentNames.size(); i++) {

    double grade = studentGrades.get(i);
    String letterGrade = getLetterGrade(grade);

    System.out.println(
        "Name: " + studentNames.get(i)
        + " | Score: " + grade
        + " | Letter Grade: " + letterGrade
    );
}

            System.out.println("---------------------------------");
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
            System.out.println("=================================");
        } else {
            System.out.println("No student data available.");
        }

        scanner.close();
    }
    public static String getLetterGrade(double grade) {

    if (grade >= 90) {
        return "A";
    } else if (grade >= 80) {
        return "B";
    } else if (grade >= 70) {
        return "C";
    } else if (grade >= 60) {
        return "D";
    } else {
        return "F";
    }
}
}