package com.chris;

import com.chris.exceptioons.PasswordNotCorrectException;
import com.chris.exceptioons.UserNotFoundException;
import com.chris.model.Parent;
import com.chris.model.Student;

import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        System.out.println("Welcome to Schooling International");
        System.out.println();
        System.out.println("Enter 1 for sign up");
        System.out.println("Enter 2 for login in");
        System.out.println("Enter 3 for enquiry");
        System.out.println("Enter 4 to exit");

        System.out.print("Enter any option: ");
        int option = scanner.nextInt();

        switch (option) {
            // Sign up
            case 1 : {
                System.out.print("Enter your full name: ");
                String fullName = scanner.next();
                System.out.print("Enter your email: ");
                String email = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                System.out.print("Enter your address: ");
                String address = scanner.next();
                System.out.println();

                Parent newParent = new Parent();
                newParent.setParentId(++Parent.numberOfParents);
                newParent.setParentName(fullName);
                newParent.setAddress(address);
                newParent.setEmail(email);
                newParent.setPassword(password);

                school.createAccount(newParent);

                System.out.println("Account creating...");
                Thread.sleep(5000);
                System.out.println("Account created!");
                school.showParentData();

                // login
                System.out.println();
                System.out.println("Please provide your email and password to login!");
                System.out.print("Email: ");
                String loginEmail = scanner.next();
                System.out.print("Password: ");
                String loginPassword = scanner.next();

                try {
                    school.login(loginEmail, loginPassword);

                    System.out.println("Enter 1 for enrol child");
                    System.out.println("Enter 2 view your information");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 : {
                            System.out.print("Enter your child full name: ");
                            String studentName = scanner.next();

                            Student newStudent = new Student();
                            newStudent.setStudentId(++Student.numberOfStudents);
                            newStudent.setParent(school.getCurrentParent());
                            newStudent.setStuentName(studentName);
                        }
                    }


                }
                catch (PasswordNotCorrectException ex) {
                    System.out.print(ex.getMessage());
                }
                catch (UserNotFoundException ex) {
                    System.out.print(ex.getMessage());
                }

            }
            case 4 : {
                System.exit(1);
            }

            default : {
                System.out.print("Please provide correct option!");
            }
        }
    }
}
