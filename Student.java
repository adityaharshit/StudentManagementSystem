import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    String name;
    static int usn = 1000;
    String department;
    int semester;
    long phoneNumber;
    String email;
    String address;
    Scanner sc = new Scanner(System.in);

    public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = EMAIL_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    public void validatePhone(){
        while (true) {
            try {
                String ph = sc.next();
                if (ph.matches("\\d{10}")) { // Matches exactly 10 digits
                    phoneNumber = Long.parseLong(ph);
                    break;
                } else {
                    System.out.println("Phone number should be exactly 10 digits.\nPlease Enter again.");
                }
            } catch (Exception e) {
                System.out.println("Enter a valid phone number.");
            }
        }
    }

    void validateEmail(){
        while (true) {
            email = sc.next();
            if (validate(email)) {
                break;
            } else {
                System.out.println("Invalid email id. Please enter again");
            }
        }
    }
    public int init() {
        try {
            System.out.println("Enter the below mentioned details");
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Department: ");
            department = sc.nextLine();
            System.out.println("Semester: ");
            semester = sc.nextInt();
            System.out.println("Phone Number: ");
            validatePhone();
            System.out.println("Email Id: ");
            validateEmail();
            System.out.println("Address: ");
            sc.nextLine();
            address = sc.nextLine();
            return Student.usn++;
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        return -1;
    }


    void display() {
        System.out.println("Student details are: ");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Semester: " + semester);
        System.out.println("Mobile number: " + phoneNumber);
        System.out.println("Email id: " + email);
        System.out.println("Address: " + address);
    }

    void updateDetails(){
        char choice=0;
        while(choice!='7'){
            System.out.println();
            System.out.println("Select the detail you want to update : ");
            System.out.println("1.Name\n2.Department\n3.Address\n4.Semester\n5.Phone Number\n6.Email Id\n7.Exit");
            System.out.println("Enter your choice: ");
            choice=sc.next().charAt(0);
            switch(choice){
                case '1': updateName();
                        break;
                case '2': updateDepartment();
                        break;
                case '3': updateAddress();
                        break;
                case '4': updateSemester();
                        break;
                case '5': updatePhoneNumber();
                        break;
                case '6': updateEmail();
                        break;
                case '7': System.out.println("Thank you.");
                        break;
                default: System.out.println("Incorrect choice.\n");
            }
        }
    }

    void updateName() {
        System.out.println("Enter new name: ");
        name = sc.nextLine();
        sc.nextLine();
        System.out.println("Detail updated successfully.");
    }
    
    void updateAddress() {
        System.out.println("Enter new Address: ");
        address = sc.nextLine();
        sc.nextLine();
        System.out.println("Detail updated successfully.");
    }
    
    void updateDepartment() {
        System.out.println("Enter new Department: ");
        department = sc.nextLine();
        sc.nextLine();
        System.out.println("Detail updated successfully.");
    }
    
    void updateSemester() {
        System.out.println("Enter new semester: ");
        semester = sc.nextInt();
        System.out.println("Detail updated successfully.");
    }
    
    void updatePhoneNumber() {
        System.out.println("Enter new Phone number: ");
        validatePhone();
        System.out.println("Detail updated successfully.");
    }
    
    void updateEmail() {
        System.out.println("Enter new Email Id: ");
        validateEmail();
        System.out.println("Detail updated successfully.");
    }
}
