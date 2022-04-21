package main.java.exceptions;

public class DepartmentHasNoStudyGroupException extends Exception {
    public DepartmentHasNoStudyGroupException() {
        super("Department has no study group");
    }
}
