package main.java;

import main.java.exceptions.*;

import java.text.DecimalFormat;
import java.util.*;

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


        List<Student> listOfAllStudents = new ArrayList<>(Arrays.asList(studentIvanPerov,
                studentNikolaiZakharov,
                studentVitaliiVasiliev,
                studentAntonVoronov));

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

        // First part
        printToConsoleMessagePartOne();
        printToConsoleListOfAllStudents(listOfAllStudents);
        int inputIDOfStudent = acceptAsInputStudent(listOfAllStudents);
        calculateAndPrintAverageGradeOfStudentByAllAcademicSubjects(listOfAllStudents, inputIDOfStudent);

        // Second part

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

    private static void printToConsoleMessagePartOne() {
        System.out.println("*********************************");
        System.out.println("   Part #1   ");
        System.out.println("*********************************");
    }

    private static void printToConsoleListOfAllStudents(List<Student> listOfStudents) {
        System.out.println("There are the following " + listOfStudents.size() + " students:");
        if (listOfStudents.isEmpty()) {
            System.out.println("No student was defined");
        } else {
            for (Student student : listOfStudents) {
                System.out.println(student.getStudentID() + " "
                        + student.getStudentFirstName() + " "
                        + student.getStudentSecondName());
            }
        }
    }

    private static HashSet<Integer> getAllIDsOfStudents(List<Student> listOfStudents) {
        HashSet<Integer> setOfID = new HashSet<>();
        for (Student student : listOfStudents) {
            setOfID.add(student.getStudentID());
        }
        return setOfID;
    }

    private static int acceptAsInputStudent(List<Student> listOfStudents) {
        Scanner scanner = new Scanner(System.in);
        int inputIDOfStudent = -1;
        do {
            try {
                System.out.println("Please exactly enter an ID of a student:");
                inputIDOfStudent = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Should be an integer");
            }
        } while (!getAllIDsOfStudents(listOfStudents).contains(inputIDOfStudent));
        return inputIDOfStudent;
    }

    private static Student getStudentById(List<Student> listOfStudents, int idOfStudent) throws
            StudentIsNotFoundByIdInListOfStudents {
        Student studentFoundByID = null;
        for (Student student : listOfStudents) {
            if (student.getStudentID() == idOfStudent) {
                studentFoundByID = student;
            }
        }
        if (studentFoundByID == null) {
            throw new StudentIsNotFoundByIdInListOfStudents();
        }
        return studentFoundByID;
    }

    public static void calculateAndPrintAverageGradeOfStudentByAllAcademicSubjects(List<Student> listOfStudents, int idOfStudent) {
        Student inputStudent = null;
        Double averageGrade = null;
        try {
            inputStudent = getStudentById(listOfStudents, idOfStudent);
            averageGrade = inputStudent.calculateAverageGradeOfStudentByAllAcademicSubjects();
        } catch (StudentHasNoAcademicSubjectException | StudentHasNoGradeException | StudentIsNotFoundByIdInListOfStudents e) {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Average grade of student " +
                inputStudent.getStudentFirstName() + " " +
                inputStudent.getStudentSecondName() + " : " +
                df.format(averageGrade));
    }


}
