import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }


    public void viewAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {
            student.displayStudent();
            System.out.println("---------------------------");
        }
    }


    public void searchStudent(int id) {

        boolean found = false;

        for (Student student : students) {

            if (student.getStudentId() == id) {

                System.out.println("\n===== STUDENT FOUND =====");
                student.displayStudent();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }
    public void updateStudent(int id, String name, int age, String course, int semester) {

        boolean found = false;

        for (Student student : students) {
            if (student.getStudentId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                student.setSemester(semester);
                saveToFile();
                System.out.println("Student Updated Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    public void deleteStudent(int id) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                saveToFile();
                System.out.println("Student Deleted Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    public void saveToFile() {

        try {
            FileWriter writer = new FileWriter("students.txt");
            for (Student student : students) {
                writer.write(
                        student.getStudentId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getCourse() + "," +
                                student.getSemester() + "\n"
                );
            }
            writer.close();
            System.out.println("Data saved successfully!");
        }
        catch (IOException e) {
            System.out.println("Error while saving data!");
        }
    }
    public void loadFromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                int semester = Integer.parseInt(data[4]);
                Student student = new Student(id, name, age, course, semester);
                students.add(student);
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        }
        catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }
}