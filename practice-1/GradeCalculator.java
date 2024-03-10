import java.util.Scanner;
import java.util.HashMap;

public class GradeCalculator {
    private HashMap<String, Integer> grades = new HashMap<String, Integer>();

    public void inputGrades() {
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Enter a subject name or blank to finish: ");
            String subjectAndGrade = keyboard.nextLine();

            if (subjectAndGrade.equals("")) {
                break;
            }

            String subject = subjectAndGrade.split(" ")[0];
            int grade = Integer.parseInt(subjectAndGrade.split(" ")[1]);
            grades.put(subject, grade);
        } while (true);

        keyboard.close();
    }

    public double calculateAverage() {
        int total = 0;
        for (int grade : grades.values()) {
            total += grade;
        }
        double average = (double) total / grades.size();
        average = (double) Math.round(average * 100) / 100; // round to 2 decimal places
        return average;
    }

    public void printReportCard() {
        for (String subject : grades.keySet()) {
            System.out.println(subject + ": " + grades.get(subject));
        }
    }

    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator();

        System.out.println("Input format: <subject> <grade> (e.g. Math 90)");
        gradeCalculator.inputGrades();

        double average = gradeCalculator.calculateAverage();

        System.out.println("The average grade is: " + average);

        System.out.println("----- Report card -----");
        gradeCalculator.printReportCard();

        System.out.println("You " + (average >= 35 ? "passed" : "failed") + "!");

    }
}