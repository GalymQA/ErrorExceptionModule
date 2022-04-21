package main.java;

import main.java.exceptions.*;

public class Runner {

    public static void main(String[] args) throws StudentHasNoAcademicSubjectException {
        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
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
        studyGroupBiol2002.addStudentToStudyGroup(studentVitaliiVasiliev);
        studyGroupBiol2002.addStudentToStudyGroup(studentAntonVoronov);
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2001);
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2002);
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2001);
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2002);


        // input: academicSubject, StudyGroup, Department


    }

    public double calculateAverageGradeByAcademicSubjectStudyGroupDepartment(
            AcademicSubject academicSubject,
            StudyGroup studyGroup,
            Department department) throws
            DepartmentHasNoStudyGroupException,
            DepartmentDoesNotContainStudyGroupException,
            StudyGroupHasNoStudentException {
        if (department.getStudyGroupsOfDepartment().isEmpty()) {
            throw new DepartmentHasNoStudyGroupException();
        }
        if (!department.getStudyGroupsOfDepartment().contains(studyGroup)) {
            throw new DepartmentDoesNotContainStudyGroupException();
        }
        if (studyGroup.getStudentsOfStudyGroup().isEmpty()) {
            throw new StudyGroupHasNoStudentException();
        }


    }

}
