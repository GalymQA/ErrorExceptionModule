package main.java;

import main.java.exceptions.*;

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

    public HashSet<Department> getDepartmentsOfUniversity() throws UniversityHasNoDepartmentException {
        if (departmentsOfUniversity.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        return departmentsOfUniversity;
    }

    public HashSet<StudyGroup> getStudyGroupsOfUniversity() throws DepartmentHasNoStudyGroupException {
        HashSet<StudyGroup> studyGroups = new HashSet<>();
        HashSet<Department> departments = null;
        HashSet<StudyGroup> studyGroupsOfDepartment;
        try {
            departments = this.getDepartmentsOfUniversity();
        } catch (UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
        if (!(departments ==null)) {
            for (Department department: departments) {
                studyGroupsOfDepartment = department.getStudyGroupsOfDepartment();
                if (studyGroupsOfDepartment.isEmpty()) {
                    throw new DepartmentHasNoStudyGroupException();
                }
                studyGroups.addAll(studyGroupsOfDepartment);
            }
        }
        return studyGroups;
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

    public double calculateAverageGradeByAcademicSubject(AcademicSubject inputAcademicSubject) throws
            UniversityHasNoDepartmentException,
            DepartmentHasNoStudyGroupException,
            StudyGroupHasNoStudentException,
            StudentHasNoAcademicSubjectException, OutOfBoundAcademicGradeException {
        double sumOfGrades = 0;
        int counter = 0;
        double averageGrade = 0;
        if (departmentsOfUniversity.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        for (Department department : departmentsOfUniversity) {
            if (department.getStudyGroupsOfDepartment().isEmpty()) {
                throw new DepartmentHasNoStudyGroupException();
            }
            for (StudyGroup studyGroup : department.getStudyGroupsOfDepartment()) {
                if (studyGroup.getStudentsOfStudyGroup().isEmpty()) {
                    throw new StudyGroupHasNoStudentException();
                }
                for (Student student : studyGroup.getStudentsOfStudyGroup()) {
                    if (student.getAcademicSubjectsOfStudent().isEmpty()) {
                        throw new StudentHasNoAcademicSubjectException();
                    }
                    for (AcademicSubject academicSubject : student.getGradesOfStudent().keySet()) {
                        if (academicSubject.equals(inputAcademicSubject)) {
                            if (student.getGradeOfStudentByAcademicSubject(inputAcademicSubject) < 0 |
                                    student.getGradeOfStudentByAcademicSubject(inputAcademicSubject) > 10
                            ) throw new OutOfBoundAcademicGradeException();
                            sumOfGrades += student.getGradeOfStudentByAcademicSubject(inputAcademicSubject);
                            counter++;
                        }
                    }
                }
            }
        }
        try {
            averageGrade = sumOfGrades / counter;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return averageGrade;
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
