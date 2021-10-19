package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String register;
        if (capacity > students.size()) {
            if (!students.contains(student)) {
                students.add(student);
                register = "Added student " + student.getFirstName() + " " + student.getLastName();

            } else {
                register = "Student is already in the university";
            }

        } else {
            register = "No seats in the university";
        }


        return register;
    }

    public String dismissStudent(Student student) {
        String removeStudent;

        if (students.contains(student)) {
            students.removeIf(s -> s.equals(student));
            removeStudent = "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            removeStudent = "Student not found";
        }


        return removeStudent;
    }

    public String getStudent(String firstName, String lastName) {
       return getStudents().stream().filter(s -> s.firstName.equals(firstName)).findFirst().get().toString();

    }

    public String getStatistics() {

        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append("==Student: First Name = " + student.getFirstName()
                    + ", Last Name = " + student.getLastName()
                    + ", Best Subject = " + student.getBestSubject());
            builder.append(System.lineSeparator());
        }

            return builder.toString();

    }
}
