import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student grades: ");
        
        String n = sc.nextLine();

        if (Pattern.matches("[a-zA-Z]+", n)) {
            System.out.println("Please use only numbers");
        } else {
            if (!(n.contains(" "))) {
                System.out.println("Please separate grades by a space!");
            } else {
                String[] scores = n.split(" ");
                studentGrade(scores);
            }
        }


    }

    static void studentGrade(String[] scores) {
        int[] grades = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            String gradeInString = scores[i];
            Integer b = Integer.valueOf(gradeInString);
            grades[i] = b;
        }
        Arrays.sort(grades);
        printGradeValue(grades);
        printGradeGraph(grades);
    }

    static void printGradeValue(int[] grades) {
        int maxGrade = grades[grades.length - 1];
        int minGrade = grades[0];
        double totalSumGrade = 0;
        for (int grade : grades) {
            totalSumGrade += grade;
        }
        double averageGrade = totalSumGrade / grades.length;

        System.out.printf("Values:\nThe maximum grade is: %d\nThe minimum grade is: %d\nThe average grade is: %f\n", maxGrade, minGrade, averageGrade);
    }

    static void printGradeGraph(int[] grades) {
        int[] stats = new int[5];
        int rangeOneNumber = 0;
        int rangeTwoNumber = 0;
        int rangeThreeNumber = 0;
        int rangeFourNumber = 0;
        int rangeFiveNumber = 0;

        for (int grade : grades) {
            if (grade <= 20) {
                rangeOneNumber++;
            } else if (grade >= 21 && grade <= 40) {
                rangeTwoNumber++;
            } else if (grade >= 41 && grade <= 60) {
                rangeThreeNumber++;
            } else if (grade >= 61 && grade <= 80) {
                rangeFourNumber++;
            } else {
                rangeFiveNumber++;
            }

        }
        stats[0] = rangeOneNumber;
        stats[1] = rangeTwoNumber;
        stats[2] = rangeThreeNumber;
        stats[3] = rangeFourNumber;
        stats[4] = rangeFiveNumber;

        int highestRange = 0;
        for (int numberRange : stats) {
            if (numberRange > highestRange) {
                highestRange = numberRange;
            }
        }

        System.out.println("Graph: ");
        int i = highestRange;
        while (i > 0) {
            System.out.printf("%d >", i);
            for (int j = 0; j < 5; j++) {
                System.out.print("  ######### ");
            }
            System.out.println("");

            i--;
        }
        System.out.println("  +-----------+-----------+-----------+-----------+-----------+");
        System.out.println("  I----0-20---I----21-40--I----41-60--I----61-80--I---81-10---I");

    }
}