package com.chris;

import com.chris.exceptioons.PasswordNotCorrectException;
import com.chris.exceptioons.UserNotFoundException;

import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        System.out.println("Welcome to Schooling International");
        System.out.println();
        System.out.println("Enter 1 for sign up");
        System.out.println("Enter 2 for enquiry");
        System.out.println("Enter -1 to exit");

        System.out.print("Enter any option: ");
        int option = scanner.nextInt();

        do {
            switch (option) {
                // Sign up
                case 1 : {
                    school.createAccount();
                    System.out.println("Account creating...");
                    Thread.sleep(1000);
                    System.out.println("Account created!");
                    // login
                    System.out.println();
                    System.out.println("Please provide your email and password to login!");
                    try {
                        school.login();

                        do {
                            System.out.println("Enter 1 to enrol a child");
                            System.out.println("Enter 2 view your information");
                            System.out.println("Enter 3 to view your children information");
                            System.out.println("Enter 4 to logout");
                            System.out.print("Select your option: ");
                            option = scanner.nextInt();

                            switch (option) {
                                case 1 : {
                                    school.enrollAChild();
                                    break;
                                }
                                case 2 : {
                                    school.showParentData();
                                    break;
                                }
                                case 3 : {
                                    school.showChildrenData();
                                    break;
                                }
                            }

                        } while(option != 4);
                    }
                    catch (PasswordNotCorrectException ex) {
                        System.out.print(ex.getMessage());
                    }
                    catch (UserNotFoundException ex) {
                        System.out.print(ex.getMessage());
                    }

                    break;
                }
                case 4 : {
                    school.logout();
                    System.out.println("Welcome to Schooling International");
                    System.out.println();
                    System.out.println("Enter 1 for sign up");
                    System.out.println("Enter 5 for login");
                    System.out.println("Enter 2 for enquiry");
                    System.out.println("Enter -1 to exit");
                    System.out.print("Enter any option: ");
                    option = scanner.nextInt();

                    break;
                }
                case 5 : {
                    school.login();
                }

                default : {
                    System.out.print("Please provide correct option!");
                }
            }
        } while (option != -1);
        System.out.println("We really appreciate you for visiting our website!");
        System.exit(3);
    }
}
