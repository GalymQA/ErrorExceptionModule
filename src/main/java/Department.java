package main.java;

import main.java.exceptions.DepartmentDoesNotContainAcademicSubject;
import main.java.exceptions.DepartmentDoesNotContainStudyGroupException;
import main.java.exceptions.DepartmentHasNoStudyGroupException;
import main.java.exceptions.StudyGroupHasNoStudentException;

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

    public double calculateAverageGradeByAcademicSubjectAndStudyGroup(
            AcademicSubject academicSubject,
            StudyGroup studyGroup) throws
            DepartmentHasNoStudyGroupException,
            DepartmentDoesNotContainStudyGroupException,
            StudyGroupHasNoStudentException,
            DepartmentDoesNotContainAcademicSubject {
        if (studyGroupsOfDepartment.isEmpty()) {
            throw new DepartmentHasNoStudyGroupException();
        }
        if (!studyGroupsOfDepartment.contains(studyGroup)) {
            throw new DepartmentDoesNotContainStudyGroupException();
        }
        if (studyGroup.getStudentsOfStudyGroup().isEmpty()) {
            throw new StudyGroupHasNoStudentException();
        }
        if (!academicSubjectsOfDepartment.contains(academicSubject)) {
            throw new DepartmentDoesNotContainAcademicSubject();
        }
        // Предмет - задан
        // Группа - задана
        // Департамент - задан
        // получи всех студентов группы
        // посчитай сумму всех оценок по предмету
        // раздели
        HashSet<Student> studentsOfStudyGroup = studyGroup.getStudentsOfStudyGroup();
        int sumOfGradesByAcademicSubjectAndStudent = 0;
        int counter = 0;
        for (Student student : studentsOfStudyGroup) {
            if (student.getGradesOfStudent().containsKey(academicSubject)) {
                sumOfGradesByAcademicSubjectAndStudent += student.getGradeOfStudentByAcademicSubject(academicSubject);
                counter++;
            }
        }
        return  sumOfGradesByAcademicSubjectAndStudent * 1.0 / counter;
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
