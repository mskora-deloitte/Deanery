package org.example;

import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;
import org.student.FullTimeStudent;
import org.student.PartTimeStudent;
import org.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student fullTimeStudent = new FullTimeStudent("252733", "Milosz", "Skora");
        Student partTimeStudent = new PartTimeStudent("886677", "Aleksander", "Nowak");
        List<Student> students = new ArrayList<>();
        students.add(fullTimeStudent);
        students.add(partTimeStudent);
        List<String> roomNumbers = new ArrayList<>(List.of("A123", "C124"));
        List<Integer> hours = new ArrayList<>(List.of(9, 10));

        for (int i = 0; i < students.size(); i++) {
            try {
                System.out.println(students.get(i).serve(roomNumbers.get(i), hours.get(i)));
            } catch (WrongRoomNumberException | VisitInClosedHoursException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}