package BaiTapOOP_Student_Ver4;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    Student newStudent = new Student(null, null, null, 0, null);
                    newStudent.enterStudentInfo();
                    personList.addStudent(newStudent);
                }
                case 2 -> {
                    Teacher newTeacher = new Teacher(null, null, null);
                    newTeacher.enterTeacherInfo();
                    personList.addTeacher(newTeacher);
                }
                case 3 -> {
                    System.out.print("Enter person ID to update: ");
                    String updateId = scanner.nextLine();
                    personList.updatePersonByID(updateId);
                }
                case 4 -> {
                    System.out.print("Enter person ID to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                }
                case 5 -> personList.displayAllPersons();
                case 6 -> {
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        System.out.println(topStudent);
                    } else {
                        System.out.println("No students found.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter department to find teachers: ");
                    String department = scanner.nextLine();
                    personList.findTeachersByDepartment(department);
                }
                case 8 -> {
                    exit = true;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
