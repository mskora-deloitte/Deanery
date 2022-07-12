package org.student;

import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;

public class FullTimeStudent extends Student {
    public FullTimeStudent(String id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public String serve(String roomNumber, Integer visitHour) throws WrongRoomNumberException, VisitInClosedHoursException {
        return super.serve(roomNumber, visitHour);
    }
}
