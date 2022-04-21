package main.java.exceptions;

public class StudentHasNoGradeException extends Exception {
    public StudentHasNoGradeException() {
        super("Student has now assigned grade");
    }
}
