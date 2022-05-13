package main.java;

import main.java.exceptions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Department {

    private String name;
    private HashSet<StudyGroup> studyGroups = new HashSet<>();
    private HashSet<AcademicSubject> academicSubjects = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashSet<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public HashSet<AcademicSubject> getAcademicSubjects() {
        return academicSubjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyGroups(HashSet<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void setAcademicSubjects(HashSet<AcademicSubject> academicSubjects) {
        this.academicSubjects = academicSubjects;
    }

    public void addStudyGroup(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
    }

    public void addListOfStudyGroups(List<StudyGroup> listSOfStudyGroup) {
        studyGroups.addAll(listSOfStudyGroup);
    }

    public void addAcademicSubject(AcademicSubject academicSubject) {
        academicSubjects.add(academicSubject);
    }

    public void addListOfAcademicSubjects(List<AcademicSubject> listOfAcademicSubjects) {
        academicSubjects.addAll(listOfAcademicSubjects);
    }

    public double calculateAverageGradeByAcademicSubjectAndStudyGroup(
            AcademicSubject academicSubject,
            StudyGroup studyGroup) throws
            DepartmentHasNoStudyGroupException,
            DepartmentDoesNotContainStudyGroupException,
            StudyGroupHasNoStudentException,
            DepartmentDoesNotContainAcademicSubject, StudentHasNoAcademicSubjectException, StudentHasNoGradeException {
        if (studyGroups.isEmpty()) {
            throw new DepartmentHasNoStudyGroupException();
        }
        if (!studyGroups.contains(studyGroup)) {
            throw new DepartmentDoesNotContainStudyGroupException();
        }
        if (studyGroup.getStudents().isEmpty()) {
            throw new StudyGroupHasNoStudentException();
        }
        if (!academicSubjects.contains(academicSubject)) {
            throw new DepartmentDoesNotContainAcademicSubject();
        }

        HashSet<Student> studentsOfStudyGroup = studyGroup.getStudents();
        int sumOfGradesByAcademicSubjectAndStudent = 0;
        int counter = 0;
        for (Student student : studentsOfStudyGroup) {
            if (student.getAcademicSubjects().isEmpty()) {
                throw new StudentHasNoAcademicSubjectException();
            }
            if (student.getGrades().isEmpty()) {
                throw new StudentHasNoGradeException();
            }
            if (student.getGrades().containsKey(academicSubject)) {
                sumOfGradesByAcademicSubjectAndStudent += student.getGradeByAcademicSubject(academicSubject);
                counter++;
            }
        }
        return sumOfGradesByAcademicSubjectAndStudent * 1.0 / counter;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + name + '\'' +
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
