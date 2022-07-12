package org.exception;

public class WrongRoomNumberException extends Exception {
    public WrongRoomNumberException(String errorMessage) {
        super(errorMessage);
    }
}
