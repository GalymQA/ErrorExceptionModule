package main.java.exceptions;

public class StudentIsNotFoundByIdInListOfStudents extends Exception {
    public StudentIsNotFoundByIdInListOfStudents() {
        super("Student is not found by ID in the list");
    }
}
