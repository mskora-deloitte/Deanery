package org.example;

import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;
import org.student.FullTimeStudent;
import org.student.PartTimeStudent;
import org.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student fullTimeStudent = new FullTimeStudent("252733", "Milosz", "Skora");
        Student partTimeStudent = new PartTimeStudent("886677", "Aleksander", "Nowak");
        Student fullTimeStudent2 = new FullTimeStudent("253733", "Arek", "Borek");
        Student partTimeStudent2 = new PartTimeStudent("885677", "Monika", "Kowalska");
        Student fullTimeStudent3 = new FullTimeStudent("254733", "Krzysztof", "Nowicki");
        Student partTimeStudent3 = new PartTimeStudent("884677", "Andzelika", "Kaczmarczyk");
        Student fullTimeStudent4 = new FullTimeStudent("255733", "Marek", "Sosna");
        Student partTimeStudent4 = new PartTimeStudent("883677", "Witold", "Nowak");
        List<Student> students = new ArrayList<>(List.of(fullTimeStudent, fullTimeStudent2, fullTimeStudent3,
                fullTimeStudent4, partTimeStudent, partTimeStudent2, partTimeStudent3, partTimeStudent4));
        List<String> incorrectRoomNumbers = new ArrayList<>(List.of("A123", "C124", "B123", "D124", "A123", "C124", "B123", "D124"));
        List<Integer> incorrectHours = new ArrayList<>(List.of(6, 10, 8, 6, 5, 4, 16, 14));
        List<String> roomNumbers = new ArrayList<>(List.of("A123", "A123", "B123", "B123", "C124", "C124", "D124", "D124"));
        List<Integer> hours = new ArrayList<>(List.of(10, 11, 12, 13, 10, 12, 17, 19));

        for (int i = 0; i < students.size(); i++) {
            try {
                System.out.println(students.get(i).serve(incorrectRoomNumbers.get(i), incorrectHours.get(i)));
            } catch (WrongRoomNumberException | VisitInClosedHoursException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < students.size(); i++) {
            try {
                System.out.println(students.get(i).serve(roomNumbers.get(i), hours.get(i)));
            } catch (WrongRoomNumberException | VisitInClosedHoursException e) {
                System.out.println(e.getMessage());
            }
        }

        // PART II

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Generate report\n2. Exit");
            switch (sc.next()) {
                case "1":
                    System.out.print("Enter the room number:\n\t> ");
                    String roomNumber = sc.next();
                    System.out.print("Enter the visit hour:\n\t> ");
                    Integer visitHour = sc.nextInt();
                    System.out.print("Enter the student ID:\n\t> ");
                    String id = sc.next();
                    List<Student> temp = students.stream()
                            .filter(s -> id.equals(s.getId()))
                            .collect(Collectors.toList());
                    if (!temp.isEmpty()) {
                        temp.forEach(student -> {
                            try {
                                System.out.println(student.serve(roomNumber, visitHour));
                            } catch (WrongRoomNumberException | VisitInClosedHoursException e) {
                                System.out.println(e.getMessage());
                            }
                        });
                    } else {
                        System.out.println("There is no student with such ID.");
                    }
                    break;
                case "2":
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}