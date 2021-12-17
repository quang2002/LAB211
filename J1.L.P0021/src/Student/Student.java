/*
 * Student
 *
 * Author: Quang Trieu - HE163060
 */
package Student;

/**
 * Class student have 4 fields: id, studentName, semester, courseName
 *
 * @version 1.0 17/12/2021
 * @author Quang Trieu
 */
public class Student {

    /**
     * id of the student
     */
    private String id;

    /**
     * name of the student
     */
    private String studentName;

    /**
     * the current student's semester
     */
    private int semester;

    /**
     * name of course that the student is learning
     */
    private String courseName;

    /**
     * default constructor of class Student
     */
    public Student() {
    }

    /**
     * constructor with 4 parameters:
     *
     * @param id - id of the student
     * @param studentName - name of the student
     * @param semester - current semester of this student
     * @param courseName - name of course that the student is learning
     */
    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * getter of student's id
     *
     * @return current student's id
     */
    public String getId() {
        return id;
    }

    /**
     * setter of student's id
     *
     * @param id - new id of this student
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter of student's name
     *
     * @return current student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * setter of student's name
     *
     * @param studentName - new name for this student
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * getter of semester
     *
     * @return current student's semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * setter of semester
     *
     * @param semester - update new semester of this student
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * getter of courseName
     *
     * @return the current name of course that the student learn
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * setter of courseName
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
