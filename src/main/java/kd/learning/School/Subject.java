package kd.learning.School;

import java.util.HashMap;

public class Subject {
    String name;
    Teacher teacher;
    public HashMap<Student, Integer> grades = new HashMap<>();

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public double getAverageSubjectGrade() {
        return grades
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public void addStudentGrade(Student student, int grade) {
        grades.put(student, grade);
        student.addSubject(this);
    }

}
