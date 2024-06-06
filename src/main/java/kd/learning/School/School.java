package kd.learning.School;

import java.util.*;
import java.util.stream.Collectors;

public class School {
    String name;
    List<SchoolClass> schoolClasses = new ArrayList();

    public School(String name) {
        this.name = name;
        this.schoolClasses = schoolClasses;
    }

    public String getName() {
        return name;
    }

    public void addSchoolClasses(List<SchoolClass> schoolClassList) {
        this.schoolClasses = schoolClassList;
    }

    public List<SchoolClass> getSchoolClasses() {
        return this.schoolClasses;
    }

    public List<Student> getStudents() {
        List<List<Student>> students = Arrays.asList(schoolClasses.get(0).getStudents(), schoolClasses.get(1).getStudents());
        List<Student> allStudents = students.stream().flatMap(list -> list.stream()).toList();
        return allStudents;
    }

    public List<Student> getSortedStudentAverageGrade() {
        List<Student> sorted = getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .toList();
        return sorted;
    }

    public Set<Subject> getSubjects() {
        List<List<Subject>> subjects = Arrays.asList(schoolClasses.get(0).getSubjects(), schoolClasses.get(1).getSubjects());
        Set<Subject> allSubjects = subjects.stream().flatMap(set -> set.stream()).collect(Collectors.toSet());
        return allSubjects;
    }

    public List<Subject> getSortedSubjectsAverageGrade() {
        List<Subject> sorted = getSubjects()
                .stream()
                .sorted(Comparator.comparingDouble(Subject::getAverageSubjectGrade))
                .toList();
        return sorted;
    }

    public void printSortedSchoolClass(List<SchoolClass> schoolClasses) {
        System.out.println("-----------------");
        System.out.println("Report - sorted classes with the best students:");

        for (SchoolClass schoolClass : schoolClasses) {
            System.out.println("----");
            System.out.println("Name of school class: " + schoolClass.getName());
            System.out.println("----");
            List<Student> students = schoolClass.getSortedStudentAverageGrade();
            students.forEach(student -> System.out.println(student.getName() + " - average grade: " + student.getAverageGrade()));
        }
    }

    public void printSortedStudents(List<Student> students) {
        System.out.println("-----------------");
        System.out.println("Report - sorted students by their average grades:");
        System.out.println("----");
        students.forEach(student -> System.out.println("School: " + student.getName() + "   " + student.getAverageGrade()));
    }

    public void printSortedSubjects(List<Subject> subjects) {
        System.out.println("-----------------");
        System.out.println("Report - sorted subjects by average of grades given to students:");
        System.out.println("----");
        subjects.forEach(subject -> System.out.println(subject.getName() + "   " + subject.getAverageSubjectGrade()));
    }
}
