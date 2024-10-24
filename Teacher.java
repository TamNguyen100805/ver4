package BaiTapOOP_Student_Ver4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class Teacher extends Person {

    private String department;

    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void addPerson() {
        enterTeacherInfo();
    }

    @Override
    public void updatePerson(String id) {
    }

    public void enterTeacherInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID: ");
        setId(scanner.nextLine());

        System.out.println("Enter Full Name: ");
        setFullName(scanner.nextLine());

        System.out.println("Enter Date of Birth (dd/MM/yyyy): ");
        String dobString = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dob = sdf.parse(dobString);
            setDateOfBirth(dob);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dobStr = (dateOfBirth != null) ? sdf.format(dateOfBirth) : "N/A";
        return "ID: " + id + "\n"
                + "Full Name: " + fullName + "\n"
                + "Date of Birth: " + dobStr + "\n"
                + "Department: " + department + "\n"
                + "Teaching Subject: " + teachingSubject;
    }

}
