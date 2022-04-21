package main.java.exceptions;

public class OutOfBoundAcademicGradeException extends Exception {
    public OutOfBoundAcademicGradeException() {
        super("Grade should be between 0 and 10");
    }
}
