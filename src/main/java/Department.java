package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Department {
    private String departmentName;
    private HashSet<StudyGroup> studyGroupsOfDepartment = new HashSet<>();
    private HashSet<AcademicSubject> academicSubjectsOfDepartment = new HashSet<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public HashSet<StudyGroup> getStudyGroupsOfDepartment() {
        return studyGroupsOfDepartment;
    }

    public HashSet<AcademicSubject> getAcademicSubjectsOfDepartment() {
        return academicSubjectsOfDepartment;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setStudyGroupsOfDepartment(HashSet<StudyGroup> studyGroupsOfDepartment) {
        this.studyGroupsOfDepartment = studyGroupsOfDepartment;
    }

    public void setAcademicSubjectsOfDepartment(HashSet<AcademicSubject> academicSubjectsOfDepartment) {
        this.academicSubjectsOfDepartment = academicSubjectsOfDepartment;
    }

    public void addStudyGroupToDepartment(StudyGroup studyGroup) {
        studyGroupsOfDepartment.add(studyGroup);
    }

    public void addListOfStudyGroupsToDepartment(List<StudyGroup> listSOfStudyGroup) {
        studyGroupsOfDepartment.addAll(listSOfStudyGroup);
    }

    public void addAcademicSubjectToDepartment(AcademicSubject academicSubject) {
        academicSubjectsOfDepartment.add(academicSubject);
    }

    public void addListOfAcademicSubjectsToDepartment(List<AcademicSubject> listOfAcademicSubjects) {
        academicSubjectsOfDepartment.addAll(listOfAcademicSubjects);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
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
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }
}
