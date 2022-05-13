package main.java;

import main.java.exceptions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class University {

    private String name;
    private HashSet<Department> departments = new HashSet<>();

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashSet<Department> getDepartments() throws UniversityHasNoDepartmentException {
        if (departments.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        return departments;
    }

    public HashSet<StudyGroup> getStudyGroups() throws DepartmentHasNoStudyGroupException {
        HashSet<StudyGroup> studyGroups = new HashSet<>();
        HashSet<Department> departments = null;
        HashSet<StudyGroup> studyGroupsOfDepartment;
        try {
            departments = this.getDepartments();
        } catch (UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
        if (!(departments == null)) {
            for (Department department : departments) {
                studyGroupsOfDepartment = department.getStudyGroups();
                if (studyGroupsOfDepartment.isEmpty()) {
                    throw new DepartmentHasNoStudyGroupException();
                }
                studyGroups.addAll(studyGroupsOfDepartment);
            }
        }
        return studyGroups;
    }

    public HashSet<Student> getStudents() throws StudyGroupHasNoStudentException {
        HashSet<Student> students = new HashSet<>();
        HashSet<StudyGroup> studyGroups = null;
        HashSet<Student> studentsOfStudyGroup;
        try {
            studyGroups = this.getStudyGroups();
        } catch (DepartmentHasNoStudyGroupException e) {
            e.printStackTrace();
        }
        try {
            assert studyGroups != null;
            for (StudyGroup studyGroup : studyGroups) {
                studentsOfStudyGroup = studyGroup.getStudents();
                if (studentsOfStudyGroup.isEmpty()) {
                    throw new StudyGroupHasNoStudentException();
                }
                students.addAll(studentsOfStudyGroup);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return students;
    }

    public HashSet<AcademicSubject> getAcademicSubjects() throws
            DepartmentHasNoAcademicSubject,
            DepartmentHasNoStudyGroupException,
            UniversityHasNoDepartmentException {
        if (departments.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        HashSet<AcademicSubject> academicSubjects = new HashSet<>();
        HashSet<Department> departments = null;
        HashSet<AcademicSubject> academicSubjectsOfDepartment;
        try {
            departments = this.getDepartments();
        } catch (UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
        try {
            assert departments != null;
            for (Department department : departments) {
                academicSubjectsOfDepartment = department.getAcademicSubjects();
                if (academicSubjectsOfDepartment.isEmpty()) {
                    throw new DepartmentHasNoAcademicSubject();
                }
                if (department.getStudyGroups().isEmpty()) {
                    throw new DepartmentHasNoStudyGroupException();
                }
                academicSubjects.addAll(academicSubjectsOfDepartment);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return academicSubjects;
    }

    public double getAverageGradeOfStudentByAllAcademicSubjects(Student student) throws
            UniversityHasNoDepartmentException {
        if (departments.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        double averageGrade = 0;
        try {
            averageGrade = student.calculateAverageGradeByAllAcademicSubjects();
        } catch (StudentHasNoAcademicSubjectException |
                StudentHasNoGradeException | OutOfBoundAcademicGradeException e) {
            e.printStackTrace();
        }
        return averageGrade;
    }

    public double getAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(Department inputDepartment,
                                                                            StudyGroup inputStudyGroup,
                                                                            AcademicSubject inputAcademicSubject) throws
            UniversityHasNoDepartmentException {
        if (departments.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        double averageGrade = 0;
        try {
            averageGrade = inputDepartment.calculateAverageGradeByAcademicSubjectAndStudyGroup(inputAcademicSubject,
                    inputStudyGroup);
        } catch (DepartmentHasNoStudyGroupException |
                DepartmentDoesNotContainStudyGroupException |
                StudyGroupHasNoStudentException |
                DepartmentDoesNotContainAcademicSubject |
                StudentHasNoAcademicSubjectException |
                StudentHasNoGradeException e) {
            e.printStackTrace();
        }
        return averageGrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(HashSet<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addListOfDepartments(List<Department> listOfDepartments) {
        departments.addAll(listOfDepartments);
    }

    public double calculateAverageGradeByAcademicSubject(AcademicSubject inputAcademicSubject) throws
            UniversityHasNoDepartmentException,
            DepartmentHasNoStudyGroupException,
            StudyGroupHasNoStudentException,
            StudentHasNoAcademicSubjectException, OutOfBoundAcademicGradeException {
        double sumOfGrades = 0;
        int counter = 0;
        double averageGrade = 0;
        if (departments.isEmpty()) {
            throw new UniversityHasNoDepartmentException();
        }
        for (Department department : departments) {
            if (department.getStudyGroups().isEmpty()) {
                throw new DepartmentHasNoStudyGroupException();
            }
            for (StudyGroup studyGroup : department.getStudyGroups()) {
                if (studyGroup.getStudents().isEmpty()) {
                    throw new StudyGroupHasNoStudentException();
                }
                for (Student student : studyGroup.getStudents()) {
                    if (student.getAcademicSubjects().isEmpty()) {
                        throw new StudentHasNoAcademicSubjectException();
                    }
                    for (AcademicSubject academicSubject : student.getGrades().keySet()) {
                        if (academicSubject.equals(inputAcademicSubject)) {
                            if (student.getGradeByAcademicSubject(inputAcademicSubject) < 0 |
                                    student.getGradeByAcademicSubject(inputAcademicSubject) > 10
                            ) throw new OutOfBoundAcademicGradeException();
                            sumOfGrades += student.getGradeByAcademicSubject(inputAcademicSubject);
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
                "universityName='" + name + '\'' +
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
