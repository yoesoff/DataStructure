package com.mhyusuf;

record Student(String name, int age) {
    public Student {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}

public class HaloRecord {
    public static void main(String[] args) {
        Student student = new Student("M. Yusuf", 25);
        System.out.println(student.name());
        System.out.println(student.age());
        System.out.println(student.toString());

    }
}