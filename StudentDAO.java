import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void addStudent(Student student) {

        String query = "INSERT INTO students (id, name, age, course,semester) VALUES (?, ?, ?, ?,?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, student.getStudentId());
            pst.setString(2, student.getName());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getCourse());
            pst.setInt(5, student.getSemester());

            pst.executeUpdate();

            System.out.println("Student added successfully to database!");

            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
