package com.chris;

import com.chris.exceptioons.*;
import com.chris.model.Parent;
import com.chris.model.Student;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Parent> parents = new ArrayList<>();
    private Parent currentParent;

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

    public void createAccount(Parent parent) {
        parents.add(parent);
    }

    public void login(String email, String password) {
        for (Parent parent : parents) {
            if (parent.getEmail().equals(email)) {
                if (parent.getPassword().equals(password)) {
                    currentParent = parent;
                    break;
                }
                else {
                    throw new PasswordNotCorrectException("Password not correct!");
                }
            }
            else {
                throw new UserNotFoundException("User not found!");
            }
        }
    }

    public void enrollAChild(Student student) {
        currentParent.getChildren().add(student);
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
}
