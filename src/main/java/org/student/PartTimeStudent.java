package org.student;

public class PartTimeStudent extends Student {
    public PartTimeStudent(String id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public String serve(String roomNumber, Integer visitHour) {
        return super.serve(roomNumber, visitHour);
    }
}
