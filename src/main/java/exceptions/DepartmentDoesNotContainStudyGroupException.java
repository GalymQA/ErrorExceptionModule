package main.java.exceptions;

public class DepartmentDoesNotContainStudyGroupException extends Exception {
    public DepartmentDoesNotContainStudyGroupException() {
        super("Department does not contain the study group");
    }
}
