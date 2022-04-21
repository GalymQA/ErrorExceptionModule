package main.java;

import main.java.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws StudentHasNoAcademicSubjectException {

        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
        AcademicSubject academicSubjectOrganicChemistry = new AcademicSubject("Introduction to Organic Chemistry");

        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        AcademicSubject academicSubjectCalculus = new AcademicSubject("Calculus");
        AcademicSubject academicSubjectMacroeconomics = new AcademicSubject("Macroeconomics");
        AcademicSubject academicSubjectMicroeconomics = new AcademicSubject("Microeconomics");

        Student studentIvanPerov = new Student("Ivan", "Perov");
        Student studentNikolaiZakharov = new Student("Nikolai", "Zakharov");
        Student studentVitaliiVasiliev = new Student("Vitalii", "Vasiliev");
        Student studentAntonVoronov = new Student("Anton", "Voronov");

        studentIvanPerov.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);
        studentIvanPerov.addAcademicSubjectToStudent(academicSubjectIntroductionToBiology);
        studentIvanPerov.addAcademicSubjectToStudent(academicSubjectIntroductionToChemistry);

        studentNikolaiZakharov.addAcademicSubjectToStudent(academicSubjectCalculus);
        studentNikolaiZakharov.addAcademicSubjectToStudent(academicSubjectMacroeconomics);
        studentNikolaiZakharov.addAcademicSubjectToStudent(academicSubjectMicroeconomics);

        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);
        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectIntroductionToChemistry);
        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectMicroeconomics);

        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectMacroeconomics);
        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectMicroeconomics);
        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectIntroductionToBiology);

        try {
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToSociology, 4);
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToBiology, 5);
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToChemistry, 7);

            studentNikolaiZakharov.assignGradeToStudent(academicSubjectCalculus, 7);
            studentNikolaiZakharov.assignGradeToStudent(academicSubjectMacroeconomics, 9);
            studentNikolaiZakharov.assignGradeToStudent(academicSubjectMicroeconomics, 10);

            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectIntroductionToSociology, 3);
            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectIntroductionToChemistry, 9);
            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectMicroeconomics, 1);

            studentAntonVoronov.assignGradeToStudent(academicSubjectMacroeconomics, 7);
            studentAntonVoronov.assignGradeToStudent(academicSubjectMicroeconomics, 9);
            studentAntonVoronov.assignGradeToStudent(academicSubjectIntroductionToBiology, 10);

        } catch (OutOfBoundAcademicGradeException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        // First part
        List<Student> listOfAllStudents = new ArrayList<>(Arrays.asList(studentIvanPerov,
                studentNikolaiZakharov,
                studentVitaliiVasiliev,
                studentAntonVoronov));

        printToConsoleListOfAllStudents(listOfAllStudents);

        System.out.println("Average grade:");
        try {
            System.out.println(studentIvanPerov.calculateAverageGradeOfStudentByAllAcademicSubjects());
            System.out.println(studentNikolaiZakharov.calculateAverageGradeOfStudentByAllAcademicSubjects());
            System.out.println(studentVitaliiVasiliev.calculateAverageGradeOfStudentByAllAcademicSubjects());
        } catch (StudentHasNoAcademicSubjectException | StudentHasNoGradeException e) {
            e.printStackTrace();
        }

        University universityPrinceton = new University("Princeton University");
        System.out.println(universityPrinceton);
        Department departmentOfBiology = new Department("Department of Biology");
        Department departmentOfEconomics = new Department("Department of Economics");
        System.out.println(departmentOfBiology);
        System.out.println(departmentOfEconomics);
        universityPrinceton.addDepartmentToUniversity(departmentOfBiology);
        universityPrinceton.addDepartmentToUniversity(departmentOfEconomics);
        StudyGroup studyGroupBiol2001 = new StudyGroup("Group-Biology-2001");
        StudyGroup studyGroupBiol2002 = new StudyGroup("Group-Biology-2002");
        StudyGroup studyGroupEcon2001 = new StudyGroup("Group-Econ-2001");
        StudyGroup studyGroupEcon2002 = new StudyGroup("Group-Econ-2002");
        studyGroupBiol2001.addStudentToStudyGroup(studentIvanPerov);
        studyGroupBiol2001.addStudentToStudyGroup(studentNikolaiZakharov);
        studyGroupBiol2001.addStudentToStudyGroup(studentVitaliiVasiliev);
        studyGroupBiol2001.addStudentToStudyGroup(studentAntonVoronov);
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2001);
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2002);
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2001);
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2002);

        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectIntroductionToBiology);
        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectIntroductionToChemistry);
        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectOrganicChemistry);

        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectIntroductionToSociology);
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectCalculus);
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectMacroeconomics);
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectMicroeconomics);

        // input: academicSubject, StudyGroup, Department

        try {
            double averageGrade = departmentOfEconomics.calculateAverageGradeByAcademicSubjectAndStudyGroup(
                    academicSubjectIntroductionToBiology,
                    studyGroupBiol2001);
            System.out.println("Work with : " + departmentOfEconomics);
            System.out.println("Work with : " + academicSubjectIntroductionToBiology);
            System.out.println("Work with : " + studyGroupBiol2001);
            System.out.println("Average grade of students of " +
                    studyGroupBiol2001.getStudyGroupName() +
                    " of " + departmentOfBiology.getDepartmentName() +
                    " by subject " + academicSubjectIntroductionToBiology.getAcademicSubjectName() +
                    " is : " + averageGrade);
        } catch (DepartmentHasNoStudyGroupException e) {
            System.out.println("000000000000");
            e.printStackTrace();
        } catch (DepartmentDoesNotContainStudyGroupException e) {
            System.out.println("1111111111111");
            e.printStackTrace();
        } catch (StudyGroupHasNoStudentException e) {
            System.out.println("2222222222222");
            e.printStackTrace();
        } catch (DepartmentDoesNotContainAcademicSubject e) {
            System.out.println("3333333333333");
            e.printStackTrace();
        }



    }

    private static void printToConsoleListOfAllStudents(List<Student> listOfStudents) {
        for (Student student : listOfStudents) {
            System.out.println(student.getStudentFirstName() + " " + student.getStudentSecondName());
        }
    }



}
