package ver4;

import java.util.ArrayList;

public class PersonList {

    private final ArrayList<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        personList.add(student);
        System.out.println("Student added successfully.");
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
        System.out.println("Teacher added successfully.");
    }

    public void deletePersonById(String id) {
        Person person = findPersonByID(id);
        if (person != null) {
            personList.remove(person);
            System.out.println("Person with ID " + id + " deleted.");
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    public void updatePersonByID(String id) {
        Person person = findPersonByID(id);
        if (person != null) {
            System.out.println("Updating information for person with ID " + id + ":");
            switch (person) {
                case Student student ->
                    student.enterStudentInfo();
                case Teacher teacher ->
                    teacher.enterTeacherInfo();
                default -> {
                }
            }
            System.out.println("Person information updated.");
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    private Person findPersonByID(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public Student findTopStudent() {
        if (personList.isEmpty()) {
            return null;
        }
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student student) {
                if (topStudent == null || student.getGPA() > topStudent.getGPA()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    public void displayAllPersons() {
        if (personList.isEmpty()) {
            System.out.println("No persons in the list.");
        } else {
            for (Person person : personList) {
                person.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    public void findTeachersByDepartment(String department) {
        boolean found = false;
        for (Person person : personList) {
            if (person instanceof Teacher teacher) {
                if (teacher.getDepartment().equalsIgnoreCase(department)) {
                    teacher.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No teachers found in the department: " + department);
        }
    }

}
