package org.example;

import org.student.FullTimeStudent;
import org.student.PartTimeStudent;
import org.student.Student;

public class Main {
    public static void main(String[] args) {
        Student fullTimeStudent = new FullTimeStudent("252733", "Milosz", "Skora");
        Student partTimeStudent = new PartTimeStudent("886677", "Aleksander", "Nowak");

        System.out.println(fullTimeStudent.serve("A123", 8));
        System.out.println(partTimeStudent.serve("C124", 9));
    }
}