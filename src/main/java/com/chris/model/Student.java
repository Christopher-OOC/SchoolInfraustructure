package com.chris.model;

public class Student {
    public static int numberOfStudents = 0;
    private int studentId;
    private String stuentName;
    private Term currentTerm;
    private Parent parent;
    private double outstandingBalance;

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStuentName() {
        return stuentName;
    }

    public void setStuentName(String stuentName) {
        this.stuentName = stuentName;
    }

    public Term getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Term currentTerm) {
        this.currentTerm = currentTerm;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }
}
