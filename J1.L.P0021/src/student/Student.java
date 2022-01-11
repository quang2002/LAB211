/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package student;

import utilities.StringHelper;

/**
 *
 * @author chall
 */
public class Student {

    private String id;
    private String name;
    private int age;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(Student other) {
        this(other.id, other.name, other.age, other.semester, other.courseName);
    }

    public Student(String id, String name, int age, int semester, String courseName) {
        this.id = id;
        this.name = StringHelper.toTitle(name);
        this.age = age;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringHelper.toTitle(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;

            return other.id.equals(id) && other.name.equals(name) && other.courseName.equals(courseName) && other.semester == semester;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode() * name.hashCode() * courseName.hashCode() * semester;
    }

}
