package calendar;

import representation.CalendarRepresentation;
import exception.IllegalCalendarFormatExceptoin;

class ShamsiCustomCalendar implements CustomCalendar {
    private int day;
    private int month;
    private int year;
    private static final String[] monthDB = {null,"Farvardin","Ordibehesht","Khordad","Tir","Mordad","Shahrivar","Mehr","Aban","Azar","Dey","Bahman","Esfand"};

    CalendarRepresentation representation;

    int getDay(){
      return year;
    }

    void setDay(int day){
      this.day = day;
    }

    int getMonth(){
      return month;
    }

    void setMonth(int month){
      this.month = month;
    }

    int getYear(){
      return year;
    }

    void setYear(int year){
      this.year = year;
    }

    String getMonthName(){
      return monthDB[month];
    }

    CustomCalendar increaseOneDay();

    CustomCalendar decreaseOneDay();

    void setCalendarRepresentation(CalendarRepresentation representation){
      this.representation = representation;
    }

    int compareTo(CustomCalendar object){
      //if(t)
    }

    String toString(){
      if(representation == null) throw new IllegalStateException("no representation");
      representation.getRepresentation(this);
    }

}
