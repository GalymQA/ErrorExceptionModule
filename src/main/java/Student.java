package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {
    static private int counterStudentID = 0;

    private int studentID;
    private String studentFirstName;
    private String studentSecondName;
    private HashSet<AcademicSubject> academicSubjectsOfStudent;

    public Student(String studentFirstName, String studentSecondName) {
        this.studentID = counterStudentID++;
        this.studentFirstName = studentFirstName;
        this.studentSecondName = studentSecondName;
    }

    public static int getCounterStudentID() {
        return counterStudentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentSecondName() {
        return studentSecondName;
    }

    public HashSet<AcademicSubject> getAcademicSubjectsOfStudent() {
        return academicSubjectsOfStudent;
    }

    public static void setCounterStudentID(int counterStudentID) {
        Student.counterStudentID = counterStudentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentSecondName(String studentSecondName) {
        this.studentSecondName = studentSecondName;
    }

    public void setAcademicSubjectsOfStudent(HashSet<AcademicSubject> academicSubjectsOfStudent) {
        this.academicSubjectsOfStudent = academicSubjectsOfStudent;
    }

    public void addAcademicSubjectsToStudent(AcademicSubject academicSubject) {
        academicSubjectsOfStudent.add(academicSubject);
    }

    public void addListOfAcademicSubjectsToStudent(List<AcademicSubject> listOfAcademicSubjects) {
        academicSubjectsOfStudent.addAll(listOfAcademicSubjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentSecondName='" + studentSecondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return studentID == student.studentID && Objects.equals(studentFirstName, student.studentFirstName) &&
                Objects.equals(studentSecondName, student.studentSecondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentFirstName, studentSecondName);
    }
}
