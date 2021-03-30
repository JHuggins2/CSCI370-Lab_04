package com.example.asynctask_demo_huggins;

import java.util.ArrayList;

public class StudentDAO {
    private ArrayList<Student> studentArrayList;

    public StudentDAO() {
        studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Smith", "John", "Computer Science"));
        studentArrayList.add(new Student("Brown", "Maggie", "History"));
        studentArrayList.add(new Student("Johnson", "Jim", "Business"));
        studentArrayList.add(new Student("Matthews", "Tim", "Computer Science"));
        studentArrayList.add(new Student("Micheal", "Jordan", "Computer Science"));
    }

    public ArrayList<Student> getAllStudents(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }
}
