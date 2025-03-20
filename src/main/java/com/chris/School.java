package com.chris;

import com.chris.exceptioons.*;
import com.chris.model.DataInitializer;
import com.chris.model.Parent;
import com.chris.model.Student;
import com.chris.model.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private List<Parent> parents = new ArrayList<>();
    private Parent currentParent;
    private Scanner scanner = new Scanner(System.in);
    private int option;

    public School() {

    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public Parent getCurrentParent() {
        return currentParent;
    }

    public void setCurrentParent(Parent currentParent) {
        this.currentParent = currentParent;
    }

    public void createAccount() {
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

        parents.add(newParent);
    }

    public void login() {
        System.out.print("Email: ");
        String loginEmail = scanner.next();
        System.out.println(loginEmail);
        System.out.print("Password: ");
        String loginPassword = scanner.next();
        System.out.println(loginPassword);
        System.out.println("list parent: " + parents);
        System.out.println("Cuurent parent: " + currentParent);

        for (Parent parent : parents) {
            if (parent.getEmail().equals(loginEmail)) {
                if (parent.getPassword().equals(loginPassword)) {
                    currentParent = parent;
                    break;
                }
                else {
                    throw new PasswordNotCorrectException("Password not correct!");
                }
            }
            System.out.println("You have successfully logged in!");
        }

        if (currentParent == null)  {
            throw new UserNotFoundException("User not found!");
        }
    }

    public void enrollAChild() {
        List<Term> allTerms = DataInitializer.getAllTerms();

        System.out.print("Enter your child full name: ");
        String studentName = scanner.next();
        System.out.println("Select the term:");

        for (Term term : allTerms) {
            System.out.println(term.getTermId() + " for " + term.getTermType());
        }
        int option = scanner.nextInt();
        Term selectedTerm = null;
        for (Term term : allTerms) {
            if (option == term.getTermId()) {
                selectedTerm = term;
                break;
            }
        }

        Student newStudent = new Student();
        newStudent.setStudentId(++Student.numberOfStudents);
        newStudent.setParent(currentParent);
        newStudent.setStuentName(studentName);
        newStudent.setCurrentTerm(selectedTerm);
        newStudent.setOutstandingBalance(selectedTerm.getFee().getAmount());
        currentParent.getChildren().add(newStudent);
    }

    public void showParentData() {
        System.out.printf("%-4s|%-10s|%-20s|%-20s|%-2s", "S\\N", "ParentName", "Email",
                "Address", "NumberOfChildren");
        System.out.println();
        for (Parent parent : parents) {
            System.out.printf("%-4s|%-10s|%-20s|%-20s|%-2s", parent.getParentId(),
                    parent.getParentName(), parent.getEmail(), parent.getAddress(),
                    parent.getChildren().size());
            System.out.println();
        }
    }

    public void showChildrenData() {
        List<Student> children = currentParent.getChildren();
        System.out.println("You children Information");
        System.out.printf("%-4s|%-15s|%-10s|%-10s|%-10s|%-10s", "S/N", "Name", "Term",
                "Session", "Fee", "Outstanding Balance");
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        for (Student student : children) {
            System.out.printf("%-4s|%-15s|%-10s|%-10s|%-10s|%-10s", student.getStudentId(),
                    student.getStuentName(), student.getCurrentTerm().getTermType(),
                    student.getCurrentTerm().getSession().getSessionYear(), student.getCurrentTerm().getFee().getAmount(),
                    student.getCurrentTerm().getFee().getAmount());
            System.out.println();
        }
        System.out.println();
    }

    public void logout() {
        currentParent = null;
    }
}
