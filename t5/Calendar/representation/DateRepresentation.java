package representation;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;

public class DateRepresentation implements CalendarRepresentation {
    String getRepresentation(CustomCalendar calendar){
      return "day!";
    }
}
