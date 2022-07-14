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

    public Student(String id,String name,String surname) { // TODO add spaces between parameters - CTRL + ALT + L does the job in IntelliJ ;)
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String serve(String roomNumber, Integer visitHour) throws WrongRoomNumberException, VisitInClosedHoursException { //TODO a small int can be used as well
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Deanery.checkVisitation(this, roomNumber, visitHour);
        return
                //TODO when you use \t for creating a table, the report will not keep the format when e.g. first name is super long and last name is short
                // so for the future -> use String format with specifying the fixed lenght - using %20s for example
                "------------------------------------------\n" +
                "\t\t" + id + "\n\n" +
                "First Name:\t" + name + "\n" +
                "Last Name:\t" + surname + "\n\n" +
                "Report generated on " + timeFormat.format(date.getTime()) + "\n" +
                "Room number: " + roomNumber +
                "\n------------------------------------------";
    }
}
