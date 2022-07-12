package org.student;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Student {
    private String id;
    private String name;
    private String surname;

    public Student(String id,String name,String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String serve(String roomNumber, Integer visitHour) {
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return
                "------------------------------------------\n" +
                "\t\t" + id + "\n\n" +
                "First Name:\t" + name + "\n" +
                "Last Name:\t" + surname + "\n\n" +
                "Report generated on " + timeFormat.format(date.getTime()) + "\n" +
                "Room number: " + roomNumber +
                "\n------------------------------------------";
    }
}
