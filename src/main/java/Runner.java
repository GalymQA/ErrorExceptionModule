package main.java;

import main.java.exceptions.*;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

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
        Student studentElenaVoronova = new Student("Elena", "Voronova");
        studyGroupEcon2001.addStudentToStudyGroup(studentElenaVoronova);
        Student studentKaterinaPetrova = new Student("Katerian", "Petrova");
        studyGroupEcon2001.addStudentToStudyGroup(studentKaterinaPetrova);
        Student studentOlgaKashirina = new Student("Olga", "Kashirina");
        studyGroupEcon2002.addStudentToStudyGroup(studentOlgaKashirina);
        Student studentSvetlanaIgoreva = new Student("Svetlana", "Igoreva");
        studyGroupEcon2002.addStudentToStudyGroup(studentSvetlanaIgoreva);

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
        studentNikolaiZakharov.addAcademicSubjectToStudent(academicSubjectIntroductionToBiology);

        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);
        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectIntroductionToChemistry);
        studentVitaliiVasiliev.addAcademicSubjectToStudent(academicSubjectMicroeconomics);

        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectMacroeconomics);
        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectMicroeconomics);
        studentAntonVoronov.addAcademicSubjectToStudent(academicSubjectIntroductionToBiology);

        studentElenaVoronova.addAcademicSubjectToStudent(academicSubjectMacroeconomics);
        studentElenaVoronova.addAcademicSubjectToStudent(academicSubjectMicroeconomics);
        studentElenaVoronova.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);

        studentKaterinaPetrova.addAcademicSubjectToStudent(academicSubjectCalculus);
        studentKaterinaPetrova.addAcademicSubjectToStudent(academicSubjectIntroductionToBiology);
        studentKaterinaPetrova.addAcademicSubjectToStudent(academicSubjectIntroductionToChemistry);

        studentOlgaKashirina.addAcademicSubjectToStudent(academicSubjectCalculus);
        studentOlgaKashirina.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);
        studentOlgaKashirina.addAcademicSubjectToStudent(academicSubjectMacroeconomics);

        studentSvetlanaIgoreva.addAcademicSubjectToStudent(academicSubjectIntroductionToSociology);
        studentSvetlanaIgoreva.addAcademicSubjectToStudent(academicSubjectMacroeconomics);
        studentSvetlanaIgoreva.addAcademicSubjectToStudent(academicSubjectMicroeconomics);

        try {
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToSociology, 4);
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToBiology, 5);
            studentIvanPerov.assignGradeToStudent(academicSubjectIntroductionToChemistry, 7);

            studentNikolaiZakharov.assignGradeToStudent(academicSubjectCalculus, 7);
            studentNikolaiZakharov.assignGradeToStudent(academicSubjectMacroeconomics, 9);
            studentNikolaiZakharov.assignGradeToStudent(academicSubjectIntroductionToBiology, 10);

            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectIntroductionToSociology, 3);
            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectIntroductionToChemistry, 9);
            studentVitaliiVasiliev.assignGradeToStudent(academicSubjectMicroeconomics, 1);

            studentAntonVoronov.assignGradeToStudent(academicSubjectMacroeconomics, 7);
            studentAntonVoronov.assignGradeToStudent(academicSubjectMicroeconomics, 9);
            studentAntonVoronov.assignGradeToStudent(academicSubjectIntroductionToBiology, 10);

            studentElenaVoronova.assignGradeToStudent(academicSubjectMacroeconomics, 9);
            studentElenaVoronova.assignGradeToStudent(academicSubjectMicroeconomics, 10);
            studentElenaVoronova.assignGradeToStudent(academicSubjectIntroductionToSociology, 5);

            studentKaterinaPetrova.assignGradeToStudent(academicSubjectCalculus, 8);
            studentKaterinaPetrova.assignGradeToStudent(academicSubjectIntroductionToBiology, 10);
            studentKaterinaPetrova.assignGradeToStudent(academicSubjectIntroductionToChemistry, 3);

            studentOlgaKashirina.assignGradeToStudent(academicSubjectCalculus, 6);
            studentOlgaKashirina.assignGradeToStudent(academicSubjectIntroductionToSociology, 7);
            studentOlgaKashirina.assignGradeToStudent(academicSubjectMacroeconomics, 9);

            studentSvetlanaIgoreva.assignGradeToStudent(academicSubjectIntroductionToSociology, 9);
            studentSvetlanaIgoreva.assignGradeToStudent(academicSubjectMacroeconomics, 10);
            studentSvetlanaIgoreva.assignGradeToStudent(academicSubjectMicroeconomics, 4);

        } catch (OutOfBoundAcademicGradeException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        HashSet<Department> allDepartments = new HashSet<>();
        HashSet<StudyGroup> allStudyGroups = new HashSet<>();
        HashSet<Student> allStudents = new HashSet<>();
        HashSet<AcademicSubject> allAcademicSubjects = new HashSet<>();

        try {
            allDepartments = universityOfPrinceton.getDepartmentsOfUniversity();
            allStudyGroups = universityOfPrinceton.getStudyGroupsOfUniversity();
            allStudents = universityOfPrinceton.getStudentsOfUniversity();
            allAcademicSubjects = universityOfPrinceton.getAcademicSubjectsOfUniversity();
        } catch (UniversityHasNoDepartmentException |
                DepartmentHasNoStudyGroupException |
                StudyGroupHasNoStudentException |
                DepartmentHasNoAcademicSubject e) {
            e.printStackTrace();
        }

        printToConsoleMessagePartOne();
        printToConsoleListOfStudents(allStudents);
        int inputIDOfStudent = acceptAsInputStudent(allStudents);
        printToConsoleAverageGradeOfStudentByAllAcademicSubjects(universityOfPrinceton, inputIDOfStudent);

        printToConsoleMessagePartTwo();
        printToConsoleListOfDepartments(allDepartments);
        Department inputDepartment = acceptInputDepartment(allDepartments);
        printToConsoleListOfStudyGroups(allStudyGroups);
        StudyGroup inputStudyGroup = acceptInputStudyGroup(allStudyGroups);
        printToConsoleListOfAcademicSubjects(allAcademicSubjects);
        AcademicSubject inputAcademicSubject = acceptInputAcademicSubject(allAcademicSubjects);
        printToConsoleAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(
                universityOfPrinceton,
                inputDepartment,
                inputStudyGroup,
                inputAcademicSubject);

        printToConsoleMessagePartThree();
        printToConsoleListOfAcademicSubjects(allAcademicSubjects);
        inputAcademicSubject = acceptInputAcademicSubject(allAcademicSubjects);
        printToConsoleAverageGradeByAcademicSubject(universityOfPrinceton, inputAcademicSubject);
    }

    private static void printToConsoleMessagePartOne() {
        System.out.println("*********************************");
        System.out.println("   Part #1   ");
        System.out.println("*********************************");
    }

    private static void printToConsoleListOfStudents(HashSet<Student> students) {
        System.out.println("There are the following " + students.size() + " students:");
        if (students.isEmpty()) {
            System.out.println("No student was defined");
        } else {
            TreeSet<Student> studentsTreeSet = new TreeSet<>(students);
            for (Student student : studentsTreeSet) {
                System.out.println(" - " + student.getStudentID() + " "
                        + student.getStudentFirstName() + " "
                        + student.getStudentSecondName());
            }
        }
    }

    private static HashSet<Integer> getAllIDsOfStudents(HashSet<Student> students) {
        HashSet<Integer> setOfID = new HashSet<>();
        for (Student student : students) {
            setOfID.add(student.getStudentID());
        }
        return setOfID;
    }

    private static int acceptAsInputStudent(HashSet<Student> students) {
        Scanner scanner = new Scanner(System.in);
        int inputIDOfStudent = -1;
        do {
            try {
                System.out.println("Please exactly enter an ID of a student:");
                inputIDOfStudent = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Should be an integer");
            }
        } while (!getAllIDsOfStudents(students).contains(inputIDOfStudent));
        return inputIDOfStudent;
    }

    private static Student getStudentById(HashSet<Student> students, int idOfStudent) throws
            StudentIsNotFoundByIdInListOfStudents {
        Student studentFoundByID = null;
        for (Student student : students) {
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
            University university,
            int idOfStudent) {
        Student inputStudent = null;
        Double averageGrade = null;
        try {
            HashSet<Student> students = university.getStudentsOfUniversity();
            inputStudent = getStudentById(students, idOfStudent);
            averageGrade = university.getAverageGradeOfStudentByAllAcademicSubjects(inputStudent);
        } catch (StudentIsNotFoundByIdInListOfStudents |
                StudyGroupHasNoStudentException |
                UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if (inputStudent != null) {
            System.out.println("Result : The average grade of student " +
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
            System.out.println(" - " + department.getDepartmentName());
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
            System.out.println(" - " + studyGroup.getStudyGroupName());
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

    private static void printToConsoleListOfAcademicSubjects(HashSet<AcademicSubject> academicSubjects) {
        System.out.println("There are the following academic subjects:");
        for (AcademicSubject academicSubject : academicSubjects) {
            System.out.println(" - " + academicSubject.getAcademicSubjectName());
        }
    }

    private static HashSet<String> getAcademicSubjectsNames(HashSet<AcademicSubject> academicSubjects) {
        HashSet<String> academicSubjectNames = new HashSet<>();
        for (AcademicSubject academicSubject : academicSubjects) {
            academicSubjectNames.add(academicSubject.getAcademicSubjectName());
        }
        return academicSubjectNames;
    }

    private static AcademicSubject acceptInputAcademicSubject(HashSet<AcademicSubject> academicSubjects) {
        Scanner scanner = new Scanner(System.in);
        String inputAcademicSubjectName;
        AcademicSubject inputAcademicSubject = null;
        do {
            System.out.println("Please exactly enter a name of an academic subject:");
            inputAcademicSubjectName = scanner.nextLine();
        } while (!getAcademicSubjectsNames(academicSubjects).contains(inputAcademicSubjectName));
        for (AcademicSubject academicSubject : academicSubjects) {
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

    private static void printToConsoleAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(University university,
                                                                                             Department inputDepartment,
                                                                                             StudyGroup inputStudyGroup,
                                                                                             AcademicSubject inputAcademicSubject) {
        DecimalFormat df = new DecimalFormat("0.00");
        double averageGrade = 0;
        try {
            averageGrade = university.getAverageGradeByAcademicSubjectAndStudyGroupOfDepartment(inputDepartment,
                    inputStudyGroup,
                    inputAcademicSubject);
        } catch (UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }

        System.out.println("Result : The average grade of students of " +
                inputStudyGroup.getStudyGroupName() +
                " of " + inputDepartment.getDepartmentName() +
                " by subject " + inputAcademicSubject.getAcademicSubjectName() +
                " is : " + df.format(averageGrade));
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
            System.out.println("Result : The average grade of students of " +
                    academicSubject.getAcademicSubjectName() + " is : " +
                    df.format(averageGrade));
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