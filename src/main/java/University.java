package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class University {
    private String universityName;
    private HashSet<Department> departmentsOfUniversity = new HashSet<>();

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public HashSet<Department> getDepartmentsOfUniversity() {
        return departmentsOfUniversity;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setDepartmentsOfUniversity(HashSet<Department> departmentsOfUniversity) {
        this.departmentsOfUniversity = departmentsOfUniversity;
    }

    public void addDepartmentToUniversity(Department department) {
        departmentsOfUniversity.add(department);
    }

    public void addListOfDepartmentsToUniversity(List<Department> listOfDepartments) {
        departmentsOfUniversity.addAll(listOfDepartments);
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
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
        University that = (University) o;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityName);
    }
}
