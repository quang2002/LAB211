/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chall
 */
public class StudentList extends ArrayList<Student> {

    private HashMap<Student, Integer> totalOfCourses;

    public StudentList() {
        totalOfCourses = new HashMap<>();
    }

    public boolean create(Student student) {
        boolean result = add(student);
        if (result) {
            increaseTotalCourse(student);
        }
        return result;
    }

    public boolean delete(Student student) {
        boolean result = remove(student);
        if (result) {
            totalOfCourses.remove(student);
        }
        return result;
    }

    public boolean increaseTotalCourse(Student student) {
        Integer total = totalOfCourses.get(student);
        totalOfCourses.put(new Student(student), total == null ? 1 : total + 1);

        return total != null;
    }

    public boolean decreaseTotalCourse(Student student) {
        Integer total = totalOfCourses.get(student);
        if (total == null || total <= 1) {
            totalOfCourses.remove(student);
        } else {
            totalOfCourses.put(new Student(student), total - 1);
        }

        return total != null && total > 1;
    }

    public Student find(String id) {
        for (Student student : this) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public void sort() {
        sort((Student o1, Student o2) -> o1.getAge() - o2.getAge());
    }

    public String report() {
        return totalOfCourses.entrySet().stream()
                .map((entry) -> String.format("%20s | %10s | %d\n", entry.getKey().getName(), entry.getKey().getCourseName(), entry.getValue()))
                .reduce("", String::concat);
    }

}
