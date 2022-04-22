package main.java;

import main.java.exceptions.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        University universityOfPrinceton = new University("Princeton University");

        Department departmentOfBiology = new Department("Department of Biology");
        universityOfPrinceton.addDepartmentToUniversity(departmentOfBiology);
        Department departmentOfEconomics = new Department("Department of Economics");
        universityOfPrinceton.addDepartmentToUniversity(departmentOfEconomics);

        StudyGroup studyGroupBiol2001 = new StudyGroup("Group-Biology-2001");
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2001);
        StudyGroup studyGroupBiol2002 = new StudyGroup("Group-Biology-2002");
        departmentOfBiology.addStudyGroupToDepartment(studyGroupBiol2002);
        StudyGroup studyGroupEcon2001 = new StudyGroup("Group-Econ-2001");
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2001);
        StudyGroup studyGroupEcon2002 = new StudyGroup("Group-Econ-2002");
        departmentOfEconomics.addStudyGroupToDepartment(studyGroupEcon2002);

        Student studentIvanPerov = new Student("Ivan", "Perov");
        studyGroupBiol2001.addStudentToStudyGroup(studentIvanPerov);
        Student studentNikolaiZakharov = new Student("Nikolai", "Zakharov");
        studyGroupBiol2001.addStudentToStudyGroup(studentNikolaiZakharov);
        Student studentVitaliiVasiliev = new Student("Vitalii", "Vasiliev");
        studyGroupBiol2002.addStudentToStudyGroup(studentVitaliiVasiliev);
        Student studentAntonVoronov = new Student("Anton", "Voronov");
        studyGroupBiol2002.addStudentToStudyGroup(studentAntonVoronov);

        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectIntroductionToBiology);
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectIntroductionToChemistry);
        AcademicSubject academicSubjectOrganicChemistry = new AcademicSubject("Introduction to Organic Chemistry");
        departmentOfBiology.addAcademicSubjectToDepartment(academicSubjectOrganicChemistry);
        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectIntroductionToSociology);
        AcademicSubject academicSubjectCalculus = new AcademicSubject("Calculus");
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectCalculus);
        AcademicSubject academicSubjectMacroeconomics = new AcademicSubject("Macroeconomics");
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectMacroeconomics);
        AcademicSubject academicSubjectMicroeconomics = new AcademicSubject("Microeconomics");
        departmentOfEconomics.addAcademicSubjectToDepartment(academicSubjectMicroeconomics);

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

        HashSet<Department> allDepartments = new HashSet<>();
        try {
            allDepartments = universityOfPrinceton.getDepartmentsOfUniversity();
        } catch (UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
        HashSet<StudyGroup> allStudyGroups = new HashSet<>();
        try {
            allStudyGroups = universityOfPrinceton.getStudyGroupsOfUniversity();
        } catch (DepartmentHasNoStudyGroupException e) {
            e.printStackTrace();
        }
        HashSet<Student> allStudents = new HashSet<>();

        List<AcademicSubject> listOfAllAcademicSubjects = new ArrayList<>();

        // First part
        printToConsoleMessagePartOne();
        printToConsoleListOfStudents(allStudents);
        int inputIDOfStudent = acceptAsInputStudent(allStudents);
        printToConsoleAverageGradeOfStudentByAllAcademicSubjects(allStudents, inputIDOfStudent);

        // Second part
        printToConsoleMessagePartTwo();
        printToConsoleListOfDepartments(allDepartments);
        Department inputDepartment = acceptInputDepartment(allDepartments);
        printToConsoleListOfStudyGroups(allStudyGroups);
        StudyGroup inputStudyGroup = acceptInputStudyGroup(allStudyGroups);
        printToConsoleListOfAcademicSubjects(listOfAllAcademicSubjects);
        AcademicSubject inputAcademicSubject = acceptInputAcademicSubject(listOfAllAcademicSubjects);
        printToConsoleAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(inputDepartment,
                inputStudyGroup,
                inputAcademicSubject);

        // Third part
        printToConsoleMessagePartThree();
        printToConsoleListOfAcademicSubjects(listOfAllAcademicSubjects);
        inputAcademicSubject = acceptInputAcademicSubject(listOfAllAcademicSubjects);
        printToConsoleAverageGradeByAcademicSubject(universityOfPrinceton, inputAcademicSubject);
    }
    //    Department Biology
//    Group-Biology-2001
//    Introduction to biology
//    7.5

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

    public static void printToConsoleAverageGradeOfStudentByAllAcademicSubjects(
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

    private static void printToConsoleListOfDepartments(HashSet<Department> listOfDepartments) {
        System.out.println("There are the following departments:");
        for (Department department : listOfDepartments) {
            System.out.println(department.getDepartmentName());
        }
    }

    private static HashSet<String> getDepartmentNames(HashSet<Department> departments) {
        HashSet<String> departmentNames = new HashSet<>();
        for (Department department : departments) {
            departmentNames.add(department.getDepartmentName());
        }
        return departmentNames;
    }

    private static Department acceptInputDepartment(HashSet<Department> departments) {
        Scanner scanner = new Scanner(System.in);
        String inputDepartmentName;
        Department inputDepartment = null;
        do {
            System.out.println("Please exactly enter a name of a department:");
            inputDepartmentName = scanner.nextLine();
        } while (!getDepartmentNames(departments).contains(inputDepartmentName));
        for (Department department : departments) {
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

    private static void printToConsoleListOfStudyGroups(HashSet<StudyGroup> studyGroups) {
        System.out.println("There are the following study groups:");
        for (StudyGroup studyGroup : studyGroups) {
            System.out.println(studyGroup.getStudyGroupName());
        }
    }

    private static HashSet<String> getStudyGroupNames(HashSet<StudyGroup> studyGroups) {
        HashSet<String> studyGroupNames = new HashSet<>();
        for (StudyGroup studyGroup : studyGroups) {
            studyGroupNames.add(studyGroup.getStudyGroupName());
        }
        return studyGroupNames;
    }

    private static StudyGroup acceptInputStudyGroup(HashSet<StudyGroup> studyGroups) {
        Scanner scanner = new Scanner(System.in);
        String inputStudyGroupName;
        StudyGroup inputStudyGroup = null;
        do {
            System.out.println("Please exactly enter a name of a study group:");
            inputStudyGroupName = scanner.nextLine();
        } while (!getStudyGroupNames(studyGroups).contains(inputStudyGroupName));
        for (StudyGroup studyGroup : studyGroups) {
            if (studyGroup.getStudyGroupName().equals(inputStudyGroupName)) {
                inputStudyGroup = studyGroup;
            }
        }
        if (inputStudyGroup == null) {
            System.out.println("Could not find a study group");
            System.exit(-1);
        }
        return inputStudyGroup;
    }

    private static void printToConsoleListOfAcademicSubjects(List<AcademicSubject> listOfAcademicSubjects) {
        System.out.println("There are the following academic subjects:");
        for (AcademicSubject academicSubject : listOfAcademicSubjects) {
            System.out.println(academicSubject.getAcademicSubjectName());
        }
    }

    private static HashSet<String> getAcademicSubjectsNames(List<AcademicSubject> listOfAcademicSubjects) {
        HashSet<String> academicSubjectNames = new HashSet<>();
        for (AcademicSubject academicSubject : listOfAcademicSubjects) {
            academicSubjectNames.add(academicSubject.getAcademicSubjectName());
        }
        return academicSubjectNames;
    }

    private static AcademicSubject acceptInputAcademicSubject(List<AcademicSubject> listOfAcademicSubjects) {
        Scanner scanner = new Scanner(System.in);
        String inputAcademicSubjectName;
        AcademicSubject inputAcademicSubject = null;
        do {
            System.out.println("Please exactly enter a name of an academic subject:");
            inputAcademicSubjectName = scanner.nextLine();
        } while (!getAcademicSubjectsNames(listOfAcademicSubjects).contains(inputAcademicSubjectName));
        for (AcademicSubject academicSubject : listOfAcademicSubjects) {
            if (academicSubject.getAcademicSubjectName().equals(inputAcademicSubjectName)) {
                inputAcademicSubject = academicSubject;
            }
        }
        if (inputAcademicSubject == null) {
            System.out.println("Could not find an academic subject");
            System.exit(-1);
        }
        return inputAcademicSubject;
    }

    private static void printToConsoleAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(Department inputDepartment,
                                                                                             StudyGroup inputStudyGroup,
                                                                                             AcademicSubject inputAcademicSubject) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            double averageGrade = inputDepartment.calculateAverageGradeByAcademicSubjectAndStudyGroup(
                    inputAcademicSubject,
                    inputStudyGroup);

            System.out.println("The average grade of students of " +
                    inputStudyGroup.getStudyGroupName() +
                    " of " + inputDepartment.getDepartmentName() +
                    " by subject " + inputAcademicSubject.getAcademicSubjectName() +
                    " is : " + df.format(averageGrade));
        } catch (StudentHasNoAcademicSubjectException |
                StudentHasNoGradeException |
                DepartmentHasNoStudyGroupException |
                DepartmentDoesNotContainStudyGroupException |
                StudyGroupHasNoStudentException |
                DepartmentDoesNotContainAcademicSubject e) {
            e.printStackTrace();
        }
    }

    private static void printToConsoleMessagePartThree() {
        System.out.println("*********************************");
        System.out.println("   Part #3   ");
        System.out.println("*********************************");
    }

    private static void printToConsoleAverageGradeByAcademicSubject(University university,
                                                                    AcademicSubject academicSubject) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            double averageGrade = university.calculateAverageGradeByAcademicSubject(academicSubject);
            System.out.println("The average grade of students of " + academicSubject + " is :" + df.format(averageGrade));
        } catch (
                DepartmentHasNoStudyGroupException |
                OutOfBoundAcademicGradeException |
                StudentHasNoAcademicSubjectException |
                UniversityHasNoDepartmentException |
                StudyGroupHasNoStudentException e) {
            e.printStackTrace();
        }
    }

}
