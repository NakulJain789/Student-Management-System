public class Student {

    private int studentid;
    private String name;
    private int age;
    private String course;
    private int semester;

    public Student(int studentid, String name, int age, String course, int semester) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.course = course;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void displayStudent() {
        System.out.println("Student ID : " + studentid);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
        System.out.println("Semester   : " + semester);
    }
}
