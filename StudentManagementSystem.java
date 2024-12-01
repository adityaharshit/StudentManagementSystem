import java.util.*;

class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = '0';
        LinkedHashMap<Integer, Student> map = new LinkedHashMap<>();
        while (choice != '6') {
            System.out.println("1. Add new student detail");
            System.out.println("2. Remove existing student detail");
            System.out.println("3. Update student detail");
            System.out.println("4. View student detail");
            System.out.println("5. List of all the students");
            System.out.println("6. Exit");
            System.out.println("Please enter your choice");
            choice = sc.next().charAt(0);
            int usn = -1;
            switch (choice) {
                case '1':
                    Student student = new Student();
                    usn = student.init();
                    if (usn == -1) {
                        System.out.println("Couldn't create new detail");
                    } else {
                        System.out.println("Student detail created successfully.");
                        System.out.println("USN of the new Student is: " + usn);
                        map.put(usn, student);
                    }
                    break;
                case '2':
                    System.out.println("Enter the USN of the student to be removed: ");
                    usn = sc.nextInt();
                    if (!map.containsKey(usn)) {
                        System.out.println("The given usn doesn't exist");
                    } else {
                        map.remove(usn);
                        System.out.println("Student details removed successfully.");
                    }
                    break;
                case '3':
                    System.out.println("Enter the USN of the student: ");
                    usn = sc.nextInt();
                    if (!map.containsKey(usn))
                        System.out.println("The given usn doesn't exist");
                    else {
                        map.get(usn).updateDetails();
                    }
                    break;
                case '4':
                    System.out.println("Enter the USN of the student: ");
                    usn = sc.nextInt();
                    if (!map.containsKey(usn))
                        System.out.println("The given usn doesn't exist");
                    else {
                        map.get(usn).display();
                    }
                    break;
                case '5':
                    if (map.isEmpty()) {
                        System.out.println("No student details found");
                    } else {
                        System.out.println("Displaying the list of all the students: ");
                        System.out.println("USN\t\tName");
                        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + "\t" + entry.getValue().name);
                        }
                    }
                    break;
                case '6':
                    System.out.println("Are you sure you want to exit? (yes/no)");
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Thank you.");
                        choice = 6;
                    } else {
                        choice = 0; 
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}