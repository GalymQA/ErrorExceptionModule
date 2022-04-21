package main.java.exceptions;

public class DepartmentDoesNotContainAcademicSubject extends Exception {
    public DepartmentDoesNotContainAcademicSubject() {
        super("Department does not contain the academic subject");
    }
}
