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
        universityOfPrinceton.addDepartment(departmentOfBiology);
        Department departmentOfEconomics = new Department("Department of Economics");
        universityOfPrinceton.addDepartment(departmentOfEconomics);

        StudyGroup studyGroupBiol2001 = new StudyGroup("Group-Biology-2001");
        departmentOfBiology.addStudyGroup(studyGroupBiol2001);
        StudyGroup studyGroupBiol2002 = new StudyGroup("Group-Biology-2002");
        departmentOfBiology.addStudyGroup(studyGroupBiol2002);
        StudyGroup studyGroupEcon2001 = new StudyGroup("Group-Econ-2001");
        departmentOfEconomics.addStudyGroup(studyGroupEcon2001);
        StudyGroup studyGroupEcon2002 = new StudyGroup("Group-Econ-2002");
        departmentOfEconomics.addStudyGroup(studyGroupEcon2002);

        Student studentIvanPerov = new Student("Ivan", "Perov");
        studyGroupBiol2001.addStudent(studentIvanPerov);
        Student studentNikolaiZakharov = new Student("Nikolai", "Zakharov");
        studyGroupBiol2001.addStudent(studentNikolaiZakharov);
        Student studentVitaliiVasiliev = new Student("Vitalii", "Vasiliev");
        studyGroupBiol2002.addStudent(studentVitaliiVasiliev);
        Student studentAntonVoronov = new Student("Anton", "Voronov");
        studyGroupBiol2002.addStudent(studentAntonVoronov);
        Student studentElenaVoronova = new Student("Elena", "Voronova");
        studyGroupEcon2001.addStudent(studentElenaVoronova);
        Student studentKaterinaPetrova = new Student("Katerian", "Petrova");
        studyGroupEcon2001.addStudent(studentKaterinaPetrova);
        Student studentOlgaKashirina = new Student("Olga", "Kashirina");
        studyGroupEcon2002.addStudent(studentOlgaKashirina);
        Student studentSvetlanaIgoreva = new Student("Svetlana", "Igoreva");
        studyGroupEcon2002.addStudent(studentSvetlanaIgoreva);

        AcademicSubject academicSubjectIntroductionToBiology = new AcademicSubject("Introduction to Biology");
        departmentOfBiology.addAcademicSubject(academicSubjectIntroductionToBiology);
        AcademicSubject academicSubjectIntroductionToChemistry = new AcademicSubject("Introduction to Chemistry");
        departmentOfBiology.addAcademicSubject(academicSubjectIntroductionToChemistry);
        AcademicSubject academicSubjectOrganicChemistry = new AcademicSubject("Introduction to Organic Chemistry");
        departmentOfBiology.addAcademicSubject(academicSubjectOrganicChemistry);
        AcademicSubject academicSubjectIntroductionToSociology = new AcademicSubject("Introduction to Sociology");
        departmentOfEconomics.addAcademicSubject(academicSubjectIntroductionToSociology);
        AcademicSubject academicSubjectCalculus = new AcademicSubject("Calculus");
        departmentOfEconomics.addAcademicSubject(academicSubjectCalculus);
        AcademicSubject academicSubjectMacroeconomics = new AcademicSubject("Macroeconomics");
        departmentOfEconomics.addAcademicSubject(academicSubjectMacroeconomics);
        AcademicSubject academicSubjectMicroeconomics = new AcademicSubject("Microeconomics");
        departmentOfEconomics.addAcademicSubject(academicSubjectMicroeconomics);

        studentIvanPerov.addAcademicSubject(academicSubjectIntroductionToSociology);
        studentIvanPerov.addAcademicSubject(academicSubjectIntroductionToBiology);
        studentIvanPerov.addAcademicSubject(academicSubjectIntroductionToChemistry);

        studentNikolaiZakharov.addAcademicSubject(academicSubjectCalculus);
        studentNikolaiZakharov.addAcademicSubject(academicSubjectMacroeconomics);
        studentNikolaiZakharov.addAcademicSubject(academicSubjectIntroductionToBiology);

        studentVitaliiVasiliev.addAcademicSubject(academicSubjectIntroductionToSociology);
        studentVitaliiVasiliev.addAcademicSubject(academicSubjectIntroductionToChemistry);
        studentVitaliiVasiliev.addAcademicSubject(academicSubjectMicroeconomics);

        studentAntonVoronov.addAcademicSubject(academicSubjectMacroeconomics);
        studentAntonVoronov.addAcademicSubject(academicSubjectMicroeconomics);
        studentAntonVoronov.addAcademicSubject(academicSubjectIntroductionToBiology);

        studentElenaVoronova.addAcademicSubject(academicSubjectMacroeconomics);
        studentElenaVoronova.addAcademicSubject(academicSubjectMicroeconomics);
        studentElenaVoronova.addAcademicSubject(academicSubjectIntroductionToSociology);

        studentKaterinaPetrova.addAcademicSubject(academicSubjectCalculus);
        studentKaterinaPetrova.addAcademicSubject(academicSubjectIntroductionToBiology);
        studentKaterinaPetrova.addAcademicSubject(academicSubjectIntroductionToChemistry);

        studentOlgaKashirina.addAcademicSubject(academicSubjectCalculus);
        studentOlgaKashirina.addAcademicSubject(academicSubjectIntroductionToSociology);
        studentOlgaKashirina.addAcademicSubject(academicSubjectMacroeconomics);

        studentSvetlanaIgoreva.addAcademicSubject(academicSubjectIntroductionToSociology);
        studentSvetlanaIgoreva.addAcademicSubject(academicSubjectMacroeconomics);
        studentSvetlanaIgoreva.addAcademicSubject(academicSubjectMicroeconomics);

        try {
            studentIvanPerov.assignGrade(academicSubjectIntroductionToSociology, 4);
            studentIvanPerov.assignGrade(academicSubjectIntroductionToBiology, 5);
            studentIvanPerov.assignGrade(academicSubjectIntroductionToChemistry, 7);

            studentNikolaiZakharov.assignGrade(academicSubjectCalculus, 7);
            studentNikolaiZakharov.assignGrade(academicSubjectMacroeconomics, 9);
            studentNikolaiZakharov.assignGrade(academicSubjectIntroductionToBiology, 10);

            studentVitaliiVasiliev.assignGrade(academicSubjectIntroductionToSociology, 3);
            studentVitaliiVasiliev.assignGrade(academicSubjectIntroductionToChemistry, 9);
            studentVitaliiVasiliev.assignGrade(academicSubjectMicroeconomics, 1);

            studentAntonVoronov.assignGrade(academicSubjectMacroeconomics, 7);
            studentAntonVoronov.assignGrade(academicSubjectMicroeconomics, 9);
            studentAntonVoronov.assignGrade(academicSubjectIntroductionToBiology, 10);

            studentElenaVoronova.assignGrade(academicSubjectMacroeconomics, 9);
            studentElenaVoronova.assignGrade(academicSubjectMicroeconomics, 10);
            studentElenaVoronova.assignGrade(academicSubjectIntroductionToSociology, 5);

            studentKaterinaPetrova.assignGrade(academicSubjectCalculus, 8);
            studentKaterinaPetrova.assignGrade(academicSubjectIntroductionToBiology, 10);
            studentKaterinaPetrova.assignGrade(academicSubjectIntroductionToChemistry, 3);

            studentOlgaKashirina.assignGrade(academicSubjectCalculus, 6);
            studentOlgaKashirina.assignGrade(academicSubjectIntroductionToSociology, 7);
            studentOlgaKashirina.assignGrade(academicSubjectMacroeconomics, 9);

            studentSvetlanaIgoreva.assignGrade(academicSubjectIntroductionToSociology, 9);
            studentSvetlanaIgoreva.assignGrade(academicSubjectMacroeconomics, 10);
            studentSvetlanaIgoreva.assignGrade(academicSubjectMicroeconomics, 4);

        } catch (OutOfBoundAcademicGradeException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        HashSet<Department> allDepartments = new HashSet<>();
        HashSet<StudyGroup> allStudyGroups = new HashSet<>();
        HashSet<Student> allStudents = new HashSet<>();
        HashSet<AcademicSubject> allAcademicSubjects = new HashSet<>();

        try {
            allDepartments = universityOfPrinceton.getDepartments();
            allStudyGroups = universityOfPrinceton.getStudyGroups();
            allStudents = universityOfPrinceton.getStudents();
            allAcademicSubjects = universityOfPrinceton.getAcademicSubjects();
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
                System.out.println(" - " + student.getId() + " "
                        + student.getFirstName() + " "
                        + student.getSecondName());
            }
        }
    }

    private static HashSet<Integer> getAllIDsOfStudents(HashSet<Student> students) {
        HashSet<Integer> setOfID = new HashSet<>();
        for (Student student : students) {
            setOfID.add(student.getId());
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
            if (student.getId() == idOfStudent) {
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
            HashSet<Student> students = university.getStudents();
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
                    inputStudent.getFirstName() + " " +
                    inputStudent.getSecondName() + " : " +
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
            System.out.println(" - " + department.getName());
        }
    }

    private static HashSet<String> getDepartmentNames(HashSet<Department> departments) {
        HashSet<String> departmentNames = new HashSet<>();
        for (Department department : departments) {
            departmentNames.add(department.getName());
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
            if (department.getName().equals(inputDepartmentName)) {
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
            System.out.println(" - " + studyGroup.getName());
        }
    }

    private static HashSet<String> getStudyGroupNames(HashSet<StudyGroup> studyGroups) {
        HashSet<String> studyGroupNames = new HashSet<>();
        for (StudyGroup studyGroup : studyGroups) {
            studyGroupNames.add(studyGroup.getName());
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
            if (studyGroup.getName().equals(inputStudyGroupName)) {
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
            System.out.println(" - " + academicSubject.getName());
        }
    }

    private static HashSet<String> getAcademicSubjectsNames(HashSet<AcademicSubject> academicSubjects) {
        HashSet<String> academicSubjectNames = new HashSet<>();
        for (AcademicSubject academicSubject : academicSubjects) {
            academicSubjectNames.add(academicSubject.getName());
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
            if (academicSubject.getName().equals(inputAcademicSubjectName)) {
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
                inputStudyGroup.getName() +
                " of " + inputDepartment.getName() +
                " by subject " + inputAcademicSubject.getName() +
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
                    academicSubject.getName() + " is : " +
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