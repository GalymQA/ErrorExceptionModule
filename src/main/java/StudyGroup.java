package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class StudyGroup {
    private String studyGroupName;
    private HashSet<Student> studentsOfStudyGroup;

    public StudyGroup(String studyGroupName) {
        this.studyGroupName = studyGroupName;
    }

    public String getStudyGroupName() {
        return studyGroupName;
    }

    public HashSet<Student> getStudentsOfStudyGroup() {
        return studentsOfStudyGroup;
    }

    public void setStudyGroupName(String studyGroupName) {
        this.studyGroupName = studyGroupName;
    }

    public void setStudentsOfStudyGroup(HashSet<Student> studentsOfStudyGroup) {
        this.studentsOfStudyGroup = studentsOfStudyGroup;
    }

    public void addStudentToStudyGroup(Student student) {
        studentsOfStudyGroup.add(student);
    }

    public void addListOfStudentsToStudyGroup(List<Student> listOfStudents) {
        studentsOfStudyGroup.addAll(listOfStudents);
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "studyGroupName='" + studyGroupName + '\'' +
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
        StudyGroup that = (StudyGroup) o;
        return Objects.equals(studyGroupName, that.studyGroupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyGroupName);
    }
}
