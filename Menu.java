import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    StudentManager manager = new StudentManager();
    {
        manager.loadFromFile();
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3.Search Student");
            System.out.println("4.Update Student");
            System.out.println("5.Delete Student");
            System.out.print("6.Exit");

            int choice = sc.nextInt();

            try {
                choice = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Please enter a number only!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public void addStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int studentid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Semester: ");
            int semester = sc.nextInt();

            Student student = new Student(studentid, name, age, course, semester);

            manager.addStudent(student);
            StudentDAO dao = new StudentDAO();
            dao.addStudent(student);

            System.out.println("\nStudent Added Successfully!");

        }
        catch (Exception e) {

            System.out.println("Invalid Input! Please enter correct details.");

            sc.nextLine();
        }
    }

    public void viewAllStudents() {
        manager.viewAllStudents();
    }
    public void searchStudent() {

        try {

            System.out.print("Enter Student ID to Search: ");
            int id = sc.nextInt();
            manager.searchStudent(id);
        }

        catch (Exception e) {
            System.out.println("Invalid Input! Please enter a valid ID");
            sc.nextLine();
        }
    }

    public void updateStudent() {

        try {

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Course: ");
            String course = sc.nextLine();
            System.out.print("Enter New Semester: ");
            int semester = sc.nextInt();

            manager.updateStudent(id, name, age, course, semester);
        }

        catch (Exception e) {
            System.out.println("Invalid Input! Please enter correct details");
            sc.nextLine();
        }
    }

    public void deleteStudent() {

        try {

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();
            manager.deleteStudent(id);
        }

        catch (Exception e) {
            System.out.println("Invalid Input! Please enter a valid ID");
            sc.nextLine();
        }
    }
}