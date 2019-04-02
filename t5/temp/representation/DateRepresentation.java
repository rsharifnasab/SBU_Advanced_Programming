package representation;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;

public class DateRepresentation implements CalendarRepresentation {
    public String getRepresentation(CustomCalendar calendar){
      String day = calendar.getDay()+"";
      if(day.length() ==1) day = "0" + day;

      String month = calendar.getMonth()+"";
      if(month.length() ==1) month = "0" + month;

      return day + "/" + month + "/" + calendar.getYear();
    }
}
