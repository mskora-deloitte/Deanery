package org.student;
import org.deanery.Deanery;
import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Student {
    private final String id;

    private String name;

    private String surname;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Student(String id,String name,String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String serve(String roomNumber, Integer visitHour) throws WrongRoomNumberException, VisitInClosedHoursException {
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Deanery.checkVisitation(this, roomNumber, visitHour);
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
