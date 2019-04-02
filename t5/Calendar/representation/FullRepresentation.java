package representation;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;

public class FullRepresentation implements CalendarRepresentation {
    public String getRepresentation(CustomCalendar calendar){
      return calendar.getDay() + " " + calendar.getMonthName() + " " + calendar.getYear();
    }
}
