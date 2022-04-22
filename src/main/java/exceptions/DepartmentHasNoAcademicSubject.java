package main.java.exceptions;

public class DepartmentHasNoAcademicSubject extends Exception {
    public DepartmentHasNoAcademicSubject() {
        super("Department has no academic subject");
    }
}
