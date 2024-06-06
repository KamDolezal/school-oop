package kd.learning.School;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SchoolClassInitialization {
    String[] TEACHER_NAMES = {"Anna", "John", "Lisa", "Richard"};
    String[] SUBJECT_NAMES = {"Chemistry", "Math", "English", "Geography"};
    String[] STUDENT_NAMES = {"Peter", "Andrew", "Michael", "Teresa", "Joe", "Rachel"};

    public List<Teacher> createTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teacherList.add(new Teacher(TEACHER_NAMES[i]));
        }
        return teacherList;
    }

    public List<Student> createStudentList() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < Array.getLength(STUDENT_NAMES); i++) {
            studentList.add(new Student((STUDENT_NAMES[i])));
        }
        return studentList;
    }

    public List<SchoolClass> createSchoolClass() {
        List<SchoolClass> schoolClassList = new ArrayList<>();
        List<Student> studListIni = createStudentList();
        List<Teacher> teachers = createTeacher();
        List<Subject> subjects1 = new ArrayList<>();
        List<Subject> subjects2 = new ArrayList<>();

        for (int i = 0; i < Array.getLength(SUBJECT_NAMES); i++) {
            Subject subject = new Subject((SUBJECT_NAMES[i]), teachers.get(i));
            if (i < Array.getLength(SUBJECT_NAMES) - 1) {
                subjects1.add(subject);
            }
            if (i > 0) {
                subjects2.add(subject);
            }
        }

        schoolClassList.add(new SchoolClass("6A", teachers.get(0)));
        schoolClassList.add(new SchoolClass("6B", teachers.get(2)));

        for (int i = 0; i < studListIni.size(); i++) {
            Student student = studListIni.get(i);
            if (i < (int) (studListIni.size()) / 2) {
                schoolClassList.get(0).addStudent(student);
                grade(student, subjects1);
            } else {
                schoolClassList.get(1).addStudent(student);
                grade(student, subjects2);
            }
        }
        return schoolClassList;
    }

    public void grade(Student student, List<Subject> subjectList) {
        Random random = new Random();
        for (Subject subject : subjectList) {
            int grade = random.nextInt(1, 5);
            subject.addStudentGrade(student, grade);
        }
    }

    public School createSchool(String name) {
        School school = new School(name);
        school.addSchoolClasses(createSchoolClass());
        return school;
    }
}
