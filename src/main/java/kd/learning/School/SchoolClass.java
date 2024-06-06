package kd.learning.School;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SchoolClass {
    String name;
    Teacher primaryTeacher;
    List<Student> students = new ArrayList<>();

    public SchoolClass(String name, Teacher teacher) {
        this.name = name;
        this.primaryTeacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getPrimaryTeacher() {
        return primaryTeacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<Student> getSortedStudentAverageGrade() {
        List<Student> sorted = getStudents()
                .stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .toList();
        return sorted;
    }

    public List<Subject> getSubjects() {
        return this.students.get(0).getSubjects();
    }
}
