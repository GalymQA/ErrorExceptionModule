package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {
    static private int counterStudentID = 0;

    private int studentID;
    private String studentFirstName;
    private String studentSecondName;
    private HashSet<AcademicSubject> academicSubjectsOfStudent = new HashSet<AcademicSubject>();
    private HashMap<AcademicSubject, Integer> gradesOfStudent;

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

    public HashMap<AcademicSubject, Integer> getGradesOfStudent() {
        return gradesOfStudent;
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

    public void setGradesOfStudent(HashMap<AcademicSubject, Integer> gradesOfStudent) {
        this.gradesOfStudent = gradesOfStudent;
    }

    public void addAcademicSubjectsToStudent(AcademicSubject academicSubject) {
        if (!academicSubjectsOfStudent.contains(academicSubject)) {
            academicSubjectsOfStudent.add(academicSubject);
        } else {
            throw new IllegalArgumentException("Can't add the same academic subject twice.");
        }
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
