package kd.learning.School;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    List<Subject> subjects = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public List<Integer> getGrades() {
        List<Integer> grades = new ArrayList<>();
        for (Subject subject : this.subjects) {
            grades.add(subject.grades.get(this));
        }
        return grades;
    }

    public double getAverageGrade() {
        List<Integer> studentGrades = getGrades();
        double averageGrade = studentGrades
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        return averageGrade;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }
}
