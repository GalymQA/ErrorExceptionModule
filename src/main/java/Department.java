package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Department {
    private String departmentName;
    private HashSet<StudyGroup> studyGroupsOfDepartment = new HashSet<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public HashSet<StudyGroup> getStudyGroupsOfDepartment() {
        return studyGroupsOfDepartment;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setStudyGroupsOfDepartment(HashSet<StudyGroup> studyGroupsOfDepartment) {
        this.studyGroupsOfDepartment = studyGroupsOfDepartment;
    }

    public void addStudyGroupToDepartment(StudyGroup studyGroup) {
        studyGroupsOfDepartment.add(studyGroup);
    }

    public void addListOfStudyGroupsToDepartment(List<StudyGroup> listSOfStudyGroup) {
        studyGroupsOfDepartment.addAll(listSOfStudyGroup);
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
