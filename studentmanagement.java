import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollnumber;
    String subjects;
    int marks;

    Student(String name, int rollnumber, String subjects, int marks) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.subjects = subjects;
        this.marks = marks;
    }
}

class School {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int rollnumber, String subjects, int marks) {
        students.add(new Student(name, rollnumber, subjects, marks));
        System.out.println("Student added successfully!");
    }

    public void removeStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.name.equals(name)) {
                students.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available ");
            return;
        }
        System.out.println("Students available in the school:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("NAME: " + student.name + ", Roll Number: " + student.rollnumber);
        }
    }

    public void giveMarks(String name, int rollnumber, String subjects,int marks) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.name.equals(name) && student.rollnumber == rollnumber && student.subjects == subjects) {
                student.marks = marks; // Update marks
                System.out.println("Marks given successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }
}

public class studentmanagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display all students");
            System.out.println("4. Give marks to a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the student: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the roll number of the student: ");
                    int rollnumber = scanner.nextInt();
                    System.out.print("Enter the marks of the student: ");
                    int marks = scanner.nextInt();
                    school.addStudent(name, rollnumber, "", marks);
                    break;
                case 2:
                    System.out.print("Enter the name of the student to remove: ");
                    String studentToRemove = scanner.nextLine();
                    school.removeStudent(studentToRemove);
                    break;
                case 3:
                    school.displayAllStudents();
                    break;
                case 4:
                    System.out.print("Enter the name of the student: ");
                    name = scanner.nextLine();
                    System.out.print("Enter the roll number of the student: ");
                    rollnumber = scanner.nextInt();
                    System.out.print("Enter the subjects : ");
                    subjects = scanner.nextLine();
                    System.out.print("Enter the marks of the student: ");
                    marks = scanner.nextInt();
                    school.giveMarks(name, rollnumber, subjects,marks);
                    System.out.println("NAME: "+name+"  rollnumber: "+rollnumber+"  subjects:  "+subjects+"   marks:  "+marks);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}


















