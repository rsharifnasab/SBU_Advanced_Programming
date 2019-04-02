package representation;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;

public class DateRepresentation implements CalendarRepresentation {
    public String getRepresentation(CustomCalendar calendar){
      return "day!";
    }
}
