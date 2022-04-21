package main.java;

import main.java.exceptions.OutOfBoundAcademicGradeException;
import main.java.exceptions.StudentHasNoAcademicSubjectException;

public class Runner {

    public static void main(String[] args) throws StudentHasNoAcademicSubjectException {
        University university = new University("Princeton University");
        System.out.println(university);
        Student studentIvanPerov = new Student("Ivan","Perov");
        Student studentNikolaiZakharov = new Student("Nikolai","Zakharov");
        Student studentVitaliiVasiliev = new Student("Vitalii","Vasiliev");
        System.out.println(studentIvanPerov);
        System.out.println(studentNikolaiZakharov);
        System.out.println(studentVitaliiVasiliev);
        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
        AcademicSubject academicSubjectCalculus = new AcademicSubject("Calculus");
        AcademicSubject academicSubjectMacroeconomics = new AcademicSubject("Macroeconomics");
        AcademicSubject academicSubjectMicroeconomics = new AcademicSubject("Microeconomics");
        System.out.println(academicSubjectIntroductionToSociology);
        System.out.println(academicSubjectIntroductionToBiology);
        System.out.println(academicSubjectIntroductionToChemistry);
        System.out.println(academicSubjectCalculus);
        System.out.println(academicSubjectMacroeconomics);
        System.out.println(academicSubjectMicroeconomics);

//        studentIvanPerov.addAcademicSubjectsToStudent(academicSubjectIntroductionToSociology);
//        studentIvanPerov.addAcademicSubjectsToStudent(academicSubjectIntroductionToBiology);
//        studentIvanPerov.addAcademicSubjectsToStudent(academicSubjectIntroductionToChemistry);

//        try {
//            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToSociology, 4);
//            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToBiology, 5);
//            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToChemistry, 7);
//        } catch (OutOfBoundAcademicGradeException | IllegalArgumentException e) {
//            e.printStackTrace();
//        }
        System.out.println("Average grade:");
        try {
            studentIvanPerov.calculateAverageGradeOfStudentByAllAcademicSubjects();
        } catch (StudentHasNoAcademicSubjectException e) {
            e.printStackTrace();
        }




    }

}
