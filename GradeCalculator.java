import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner userInp = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int courseCount = userInp.nextInt();
        int[] courseGrades = new int[courseCount];

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter grade for course " + (i + 1) + " (out of 100): ");
            courseGrades[i] = userInp.nextInt();
        }

        int totalGradePoints = calculateTotalGradePoints(courseGrades);
        double averageGradePercentage = calculateAverageGradePercentage(totalGradePoints, courseCount);
        String letterGrade = determineLetterGrade(averageGradePercentage);

        displayGradeResults(totalGradePoints, averageGradePercentage, letterGrade);
        userInp.close();
    }

    private static int calculateTotalGradePoints(int[] courseGrades) {
        int totalGradePoints = 0;
        for (int grade : courseGrades) {
            totalGradePoints += grade;
        }
        return totalGradePoints;
    }

    private static double calculateAverageGradePercentage(int totalGradePoints, int courseCount) {
        return (double) totalGradePoints / courseCount;
    }

    private static String determineLetterGrade(double averageGradePercentage) {
        if (averageGradePercentage >= 94) {
            return "A+";
        } else if (averageGradePercentage >= 90) {
            return "A";
        } else if (averageGradePercentage >= 87) {
            return "B+";
        } else if (averageGradePercentage >= 83) {
            return "B";
        } else if (averageGradePercentage >= 80) {
            return "B-";
        } else if (averageGradePercentage >= 77) {
            return "C+";
        } else if (averageGradePercentage >= 73) {
            return "C";
        } else if (averageGradePercentage >= 70) {
            return "C-";
        } else if (averageGradePercentage >= 67) {
            return "D+";
        } else if (averageGradePercentage >= 63) {
            return "D";
        } else if (averageGradePercentage >= 60) {
            return "D-";
        } else {
            return "F";
        }
    }

    private static void displayGradeResults(int totalGradePoints, double averageGradePercentage, String letterGrade) {
        System.out.println("Total Grade Points: " + totalGradePoints);
        System.out.println("Average Grade Percentage: " + String.format("%.2f", averageGradePercentage) + "%");
        System.out.println("Letter Grade: " + letterGrade);
    }
}