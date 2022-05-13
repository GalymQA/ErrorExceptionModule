package main.java;

import main.java.exceptions.OutOfBoundAcademicGradeException;
import main.java.exceptions.StudentHasNoAcademicSubjectException;
import main.java.exceptions.StudentHasNoGradeException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {

    static private int counter = 0;

    private int id;
    private String firstName;
    private String secondName;
    private HashSet<AcademicSubject> academicSubjects = new HashSet<>();
    private HashMap<AcademicSubject, Integer> grades = new HashMap<>();

    public Student(String firstName, String secondName) {
        this.id = counter++;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public HashSet<AcademicSubject> getAcademicSubjects() {
        return academicSubjects;
    }

    public HashMap<AcademicSubject, Integer> getGrades() {
        return grades;
    }

    public int getGradeByAcademicSubject(AcademicSubject academicSubject) {
        return grades.get(academicSubject);
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAcademicSubjects(HashSet<AcademicSubject> academicSubjects) {
        this.academicSubjects = academicSubjects;
    }

    public void setGrades(HashMap<AcademicSubject, Integer> grades) {
        this.grades = grades;
    }

    public void addAcademicSubject(AcademicSubject academicSubject) {
        academicSubjects.add(academicSubject);
    }

    public void addListOfAcademicSubjects(List<AcademicSubject> listOfAcademicSubjects) {
        academicSubjects.addAll(listOfAcademicSubjects);
    }

    public void assignGrade(AcademicSubject academicSubject, Integer grade) throws OutOfBoundAcademicGradeException {
        if ((grade < 0) | (grade > 10)) {
            throw new OutOfBoundAcademicGradeException();
        }
        if (!academicSubjects.contains(academicSubject)) {
            throw new IllegalArgumentException("Student does not have the academic subject");
        }
        if (!grades.containsKey(academicSubject)) {
            grades.put(academicSubject, grade);
        } else {
            throw new IllegalArgumentException("Can't assign a new grade to the same academic subject");
        }
    }

    public double calculateAverageGradeByAllAcademicSubjects() throws
            StudentHasNoAcademicSubjectException,
            StudentHasNoGradeException,
            OutOfBoundAcademicGradeException {
        if (academicSubjects.isEmpty()) {
            throw new StudentHasNoAcademicSubjectException();
        }
        if (grades.isEmpty()) {
            throw new StudentHasNoGradeException();
        }
        int sumOfGrades = 0;
        for (Integer grade : grades.values()) {
            if ((grade < 0) | (grade > 10)) {
                throw new OutOfBoundAcademicGradeException();
            }
            sumOfGrades += grade;
        }
        return (sumOfGrades * 1.0) / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + id +
                ", studentFirstName='" + firstName + '\'' +
                ", studentSecondName='" + secondName + '\'' +
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
        return id == student.id && Objects.equals(firstName, student.firstName) &&
                Objects.equals(secondName, student.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName);
    }

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }

}
