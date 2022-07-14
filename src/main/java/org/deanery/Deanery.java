package org.deanery;

import org.exception.VisitInClosedHoursException;
import org.exception.WrongRoomNumberException;
import org.student.FullTimeStudent;
import org.student.PartTimeStudent;
import org.student.Student;

//TODO Fix the formatting here -> there should be new lines spaces between class, method, some if blocks etc
public class Deanery {
    public static void checkVisitation(Student student, String roomNumber, Integer visitHour)
            throws WrongRoomNumberException, VisitInClosedHoursException {
        String wrongRoomMessage = "Student went to the incorrect room number."; //TODO As I wrote in the WrongRoomNumberException - this message can be used as a constant in the custom exception
        String wrongHourMessage = "Student tried to visit deanery in closed hours.";
        if (student instanceof FullTimeStudent) {
            //TODO generally the usage of instanceof is not recommended
            // As you made the inheritance hierarchy in this task, it would be good to make use of it -> for now classes FullTime and PartTime have no logic inside
            // It can be changed and you could keep a collection of allowable rooms in each class: so FullTimeStudent and PartTimeStudent could have a variable with the allowable rooms
            if (!roomNumber.equals("A123") && !roomNumber.equals("B123")) {
                throw new WrongRoomNumberException(wrongRoomMessage);
            } else if ((roomNumber.equals("A123") && !(visitHour >= 8 && visitHour <= 16)) ||
                    //TODO it probably works and meets the conditions, but a better approach would be to move this logic somewhere else
                    // - e.g. introduce a class/enum representing a room that would have an opening and closing hour as variables
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
