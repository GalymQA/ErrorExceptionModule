package main.java.exceptions;

public class StudentHasNoGrade extends Exception {
    public StudentHasNoGrade() {
        super("Student has now assigned grade");
    }
}
