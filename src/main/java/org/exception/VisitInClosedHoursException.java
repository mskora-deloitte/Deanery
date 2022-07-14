package org.exception;

//TODO same here -> like in the WrongRoomNumberException
public class VisitInClosedHoursException extends Exception {
    public VisitInClosedHoursException(String errorMessage) {
        super(errorMessage);
    }
}
