package org.exception;

// TODO Good naming of the exception - but when the custom exception is so specific, it can already include the message here:
//
public class WrongRoomNumberException extends Exception {
    // TODO e.g. private static final String MESSAGE = "Wrong room number provided";
//    public WrongRoomNumberException() {
//        super(MESSAGE);
//    }
    public WrongRoomNumberException(String errorMessage) {
        super(errorMessage);
    }
}
