package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class StudyGroup {

    private String name;
    private HashSet<Student> students = new HashSet<>();

    public StudyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addListOfStudents(List<Student> listOfStudents) {
        students.addAll(listOfStudents);
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "studyGroupName='" + name + '\'' +
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
