package kd.learning;

import kd.learning.School.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SchoolClassInitialization schoolClassInitialization = new SchoolClassInitialization();
        School school = schoolClassInitialization.createSchool("Elementary school");
        System.out.println();
        System.out.println("School: " + school.getName());

        // Students sorted acc. to school class and their average grade
        List<SchoolClass> schoolClasses = school.getSchoolClasses();
        school.printSortedSchoolClass(schoolClasses);

        // Students sorted acc. to their average grade
        List<Student> students = school.getSortedStudentAverageGrade();
        school.printSortedStudents(students);

        // Subjects sorted acc. to average grades
        List<Subject> subjects = school.getSortedSubjectsAverageGrade();
        school.printSortedSubjects(subjects);

    }
}
