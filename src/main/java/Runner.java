package main.java;

import main.java.exceptions.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws StudentHasNoAcademicSubjectException {

        List<Student> listOfAllStudents = new ArrayList<>();
        List<Department> listOfAllDepartments = new ArrayList<>();
        List<StudyGroup> listOfAllStudyGroups = new ArrayList<>();

        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
        AcademicSubject academicSubjectOrganicChemistry = new AcademicSubject("Introduction to Organic Chemistry");

        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        AcademicSubject academicSubjectCalculus = new AcademicSubject("Calculus");
        AcademicSubject academicSubjectMacroeconomics = new AcademicSubject("Macroeconomics");
        AcademicSubject academicSubjectMicroeconomics = new AcademicSubject("Microeconomics");

        Student studentIvanPerov = new Student("Ivan", "Perov");
        listOfAllStudents.add(studentIvanPerov);
        Student studentNikolaiZakharov = new Student("Nikolai", "Zakharov");
        listOfAllStudents.add(studentNikolaiZakharov);
        Student studentVitaliiVasiliev = new Student("Vitalii", "Vasiliev");
        listOfAllStudents.add(studentVitaliiVasiliev);
        Student studentAntonVoronov = new Student("Anton", "Voronov");
        listOfAllStudents.add(studentAntonVoronov);

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

        University universityPrinceton = new University("Princeton University");
        System.out.println(universityPrinceton);

        Department departmentOfBiology = new Department("Department of Biology");
        listOfAllDepartments.add(departmentOfBiology);
        Department departmentOfEconomics = new Department("Department of Economics");
        listOfAllDepartments.add(departmentOfEconomics);
        System.out.println(departmentOfBiology);
        System.out.println(departmentOfEconomics);

        universityPrinceton.addDepartmentToUniversity(departmentOfBiology);
        universityPrinceton.addDepartmentToUniversity(departmentOfEconomics);

        StudyGroup studyGroupBiol2001 = new StudyGroup("Group-Biology-2001");
        listOfAllStudyGroups.add(studyGroupBiol2001);
        StudyGroup studyGroupBiol2002 = new StudyGroup("Group-Biology-2002");
        listOfAllStudyGroups.add(studyGroupBiol2002);
        StudyGroup studyGroupEcon2001 = new StudyGroup("Group-Econ-2001");
        listOfAllStudyGroups.add(studyGroupEcon2001);
        StudyGroup studyGroupEcon2002 = new StudyGroup("Group-Econ-2002");
        listOfAllStudyGroups.add(studyGroupEcon2002);

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
        printToConsoleListOfStudents(listOfAllStudents);
        int inputIDOfStudent = acceptAsInputStudent(listOfAllStudents);
        calculateAndPrintAverageGradeOfStudentByAllAcademicSubjects(listOfAllStudents, inputIDOfStudent);

        // Second part
        printToConsoleMessagePartTwo();
        printToConsoleListOfDepartments(listOfAllDepartments);
        Department inputDepartment = acceptInputDepartment(listOfAllDepartments);
        printToConsoleListOfStudyGroups(listOfAllStudyGroups);

        try {
            double averageGrade = inputDepartment.calculateAverageGradeByAcademicSubjectAndStudyGroup(
                    academicSubjectIntroductionToBiology,
                    studyGroupBiol2001);
            System.out.println("Work with : " + inputDepartment);
            System.out.println("Work with : " + academicSubjectIntroductionToBiology);
            System.out.println("Work with : " + studyGroupBiol2001);
            System.out.println("The average grade of students of " +
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

    private static void printToConsoleListOfStudents(List<Student> listOfStudents) {
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

    public static void calculateAndPrintAverageGradeOfStudentByAllAcademicSubjects(
            List<Student> listOfStudents,
            int idOfStudent
    ) {
        Student inputStudent = null;
        Double averageGrade = null;
        try {
            inputStudent = getStudentById(listOfStudents, idOfStudent);
            averageGrade = inputStudent.calculateAverageGradeOfStudentByAllAcademicSubjects();
        } catch (StudentHasNoAcademicSubjectException | StudentHasNoGradeException | StudentIsNotFoundByIdInListOfStudents e) {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if (inputStudent != null) {
            System.out.println("Result: The average grade of student " +
                    inputStudent.getStudentFirstName() + " " +
                    inputStudent.getStudentSecondName() + " : " +
                    df.format(averageGrade));
        } else {
            System.out.println("Result: Could not calculate the average grade");
        }
    }

    private static void printToConsoleMessagePartTwo() {
        System.out.println("*********************************");
        System.out.println("   Part #2   ");
        System.out.println("*********************************");
    }

    private static void printToConsoleListOfDepartments(List<Department> listOfDepartments) {
        System.out.println("There are the following departments:");
        for (Department department : listOfDepartments) {
            System.out.println(department.getDepartmentName());
        }
    }

    private static HashSet<String> getDepartmentNames(List<Department> listOfDepartments) {
        HashSet<String> departmentNames = new HashSet<>();
        for (Department department : listOfDepartments) {
            departmentNames.add(department.getDepartmentName());
        }
        return departmentNames;
    }

    private static Department acceptInputDepartment(List<Department> listOfDepartments) {
        Scanner scanner = new Scanner(System.in);
        String inputDepartmentName;
        Department inputDepartment = null;
        do {
            System.out.println("Please exactly enter a name of department:");
            inputDepartmentName = scanner.nextLine();
        } while (!getDepartmentNames(listOfDepartments).contains(inputDepartmentName));
        for (Department department : listOfDepartments) {
            if (department.getDepartmentName().equals(inputDepartmentName)) {
                inputDepartment = department;
            }
        }
        if (inputDepartment == null) {
            System.out.println("Could not find a department");
            System.exit(-1);
        }
        return inputDepartment;
    }

    private static void printToConsoleListOfStudyGroups(List<StudyGroup> listOfStudyGroups) {
        System.out.println("There are the following study groups:");
        for (StudyGroup studyGroup : listOfStudyGroups) {
            System.out.println(studyGroup.getStudyGroupName());
        }
    }


}
