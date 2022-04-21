package main.java.exceptions;

public class StudentHasNoAcademicSubjectException extends Exception {
    public StudentHasNoAcademicSubjectException() {
        super("Student has no academic subject");
    }
}
