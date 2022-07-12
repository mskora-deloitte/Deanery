package org.deanery;

import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;
import org.student.FullTimeStudent;
import org.student.PartTimeStudent;
import org.student.Student;

public class Deanery {
    public static void checkVisitation(Student student, String roomNumber, Integer visitHour)
            throws WrongRoomNumberException, VisitInClosedHoursException {
        String wrongRoomMessage = "Student went to the incorrect room number.";
        String wrongHourMessage = "Student tried to visit deanery in closed hours.";
        if (student instanceof FullTimeStudent) {
            if (!roomNumber.equals("A123") && !roomNumber.equals("B123")) {
                throw new WrongRoomNumberException(wrongRoomMessage);
            } else if ((roomNumber.equals("A123") && !(visitHour >= 8 && visitHour <= 16)) ||
                    (roomNumber.equals("B123") && !(visitHour >= 9 && visitHour <= 17))) {
                throw new VisitInClosedHoursException(wrongHourMessage);
            }
        } else if (student instanceof PartTimeStudent) {
            if (!roomNumber.equals("C124") && !roomNumber.equals("D124")) {
                throw new WrongRoomNumberException(wrongRoomMessage);
            } else if ((roomNumber.equals("C124") && !(visitHour >= 9 && visitHour <= 13)) ||
                    (roomNumber.equals("D124") && !(visitHour >= 17 && visitHour <= 20))) {
                throw new VisitInClosedHoursException(wrongHourMessage);
            }
        }
    }
}
