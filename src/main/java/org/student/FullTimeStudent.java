package org.student;

public class FullTimeStudent extends Student {
    public FullTimeStudent(String id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public String serve(String roomNumber, Integer visitHour) {
        return super.serve(roomNumber, visitHour);
    }
}
