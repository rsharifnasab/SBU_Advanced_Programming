package calendar;

import representation.CalendarRepresentation;

public interface CustomCalendar {
    int getDay();

    void setDay(int day);

    int getMonth();

    void setMonth(int month);

    int getYear();

    void setYear(int year);

    String getMonthName();

    CustomCalendar increaseOneDay();

    CustomCalendar decreaseOneDay();

    void setCalendarRepresentation(CalendarRepresentation representation);

    int compareTo(CustomCalendar object);
}
