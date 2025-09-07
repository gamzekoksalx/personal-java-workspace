import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Collects student records, stores them in a LinkedList,
 * sorts by name, and writes results to a text file.
 */
public class StudentDataManager {

    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter student name (or 'exit' to stop): ");
                String name = input.nextLine().trim();
                if (name.equalsIgnoreCase("exit")) break;

                System.out.print("Enter address: ");
                String addr = input.nextLine().trim();

                double gpa = StudentUtils.promptValidGpa(input);

                studentList.add(new Student(name, addr, gpa));
            }
        }

        // Sort before writing to file
        Collections.sort(studentList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output/student_records.txt"))) {
            for (Student s : studentList) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("All records saved in student_records.txt");
        } catch (IOException e) {
            System.err.println("Unable to write file: " + e.getMessage());
        }
    }
}