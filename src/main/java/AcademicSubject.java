package main.java;

import java.util.Objects;

public class AcademicSubject {

    private String academicSubjectName;

    public AcademicSubject(String academicSubjectName) {
        this.academicSubjectName = academicSubjectName;
    }

    public String getAcademicSubjectName() {
        return academicSubjectName;
    }

    public void setAcademicSubjectName(String academicSubjectName) {
        this.academicSubjectName = academicSubjectName;
    }

    @Override
    public String toString() {
        return "AcademicSubject{" +
                "academicSubjectName='" + academicSubjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AcademicSubject that = (AcademicSubject) o;
        return Objects.equals(academicSubjectName, that.academicSubjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academicSubjectName);
    }
}
