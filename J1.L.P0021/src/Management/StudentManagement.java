/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package Management;

import student.Student;
import student.StudentList;
import utilities.Input;
import utilities.StringHelper;

/**
 *
 * @author chall
 */
public class StudentManagement {

    public final StudentList list;

    public StudentManagement() {
        this.list = new StudentList();
    }

    public int getMenuChoice() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("\n(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        return Input.getIntegerInclusive("Your choice: ", 1, 5);
    }

    public void create() {
        Student student = new Student();

        student.setId(Input.getString("Input student id (format: HAxxxxxx, HExxxxxx, HSxxxxxx): ", "H[ASE]\\d{6}"));

        Student existedStudent = list.find(student.getId());

        if (existedStudent == null) {
            student.setName(Input.getString("Enter student name: "));

            student.setAge(Input.getIntegerInclusive("Input student age: ", 0, Integer.MAX_VALUE));

            student.setSemester(Input.getIntegerInclusive("Input current semester of student (0-9): ", 0, 9));

            student.setCourseName(Input.getString("Input course name (C++, Java, .NET): ", "C\\+\\+|Java|\\.NET"));

            list.create(student);
        } else {
            existedStudent.setSemester(Input.getIntegerInclusive("Input current semester of student (0-9): ", 0, 9));

            existedStudent.setCourseName(Input.getString("Input course name (C++, Java, .NET): ", "C\\+\\+|Java|\\.NET"));

            list.increaseTotalCourse(existedStudent);
        }
    }

    public void findAndSort() {
        list.sort();

        String name = Input.getString("Input a part of name: ").trim().toLowerCase();

        System.out.printf("%8s-|-%20s-|-%10s-|-%10s-|-%10s\n", "---ID---", "---------Name---------", "---Age--", "-Semester-", "--Course--");
        for (Student student : list) {
            if (student.getName().toLowerCase().contains(name)) {
                System.out.printf(
                        "%8s | %20s | %10d | %10d | %10s\n",
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getSemester(),
                        student.getCourseName()
                );
            }
        }
    }

    public void updateAndDelete() {
        String id = Input.getString("Input student id (format: HAxxxxxx, HExxxxxx, HSxxxxxx): ", "H[ASE]\\d{6}");
        Student student = list.find(id);

        if (student != null) {
            if (Input.getBoolean("Do you want to update (U) or delete (D): ", "U", "D")) {
                Student oldStudent = new Student(student);
                
                String newName = Input.getString("Enter new student name: ").trim();

                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                String newAge = Input.getString("Enter new age: ", "\\d{1,3}|\\s*").trim();
                if (!newAge.isEmpty()) {
                    student.setAge(Integer.parseInt(newAge));
                }

                student.setSemester(Input.getIntegerInclusive("Input current semester of student (0-9): ", 0, 9));

                student.setCourseName(Input.getString("Input course name (C++, Java, .NET): ", "C\\+\\+|Java|\\.NET"));

                if (!oldStudent.getName().equals(student.getCourseName())) {
                    list.decreaseTotalCourse(oldStudent);
                    list.increaseTotalCourse(student);
                }
            } else {
                list.delete(student);
            }
        } else {
            System.out.println("This student id is not exist");
        }
    }

    public void report() {
        System.out.println(list.report());
    }
}
