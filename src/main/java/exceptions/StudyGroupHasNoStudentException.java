package main.java.exceptions;

public class StudyGroupHasNoStudentException extends Exception {
    public StudyGroupHasNoStudentException() {
        super("Study group has no student");
    }
}
