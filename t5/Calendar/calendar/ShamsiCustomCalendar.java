package calendar;

import representation.CalendarRepresentation;
import exception.IllegalCalendarFormatExceptoin;

class ShamsiCustomCalendar implements CustomCalendar {
  private int day;
  private int month;
  private int year;
  private static final String[] monthDB = {null,"Farvardin","Ordibehesht","Khordad","Tir","Mordad","Shahrivar","Mehr","Aban","Azar","Dey","Bahman","Esfand"};

  CalendarRepresentation representation;

  public int getDay(){
    return this.day;
  }

  private static boolean isValidDate(int day,int month,int year){

    if(day < 1) return false;
    if(month < 1) return false;
    if(year < 1) return false;

    if(day > 31) return false;
    if(month > 12) return false;

    if(month > 6 && day==31) return false;

    return true;
  }

  public void setDay(int day) throws IllegalArgumentException{
    if(isValidDate(day,1,1)) this.day = day;
    else throw new IllegalArgumentException("invalud date");
  }

  public int getMonth(){
    return month;
  }

  public void setMonth(int month){
    if(isValidDate(1,month,1)) this.month = month;
    else throw new IllegalArgumentException("invalid month");
  }

  public int getYear(){
    return year;
  }

  public void setYear(int year){
    if(isValidDate(1,1,year)) this.year = year;
    else throw new IllegalArgumentException("year should be bigger mosavi than 1");
  }

  public String getMonthName(){
    return monthDB[month];
  }

  public CustomCalendar increaseOneDay(){
    fMonth = this.month;
    fDay = this.day;
    fYear = this.year;
    
  }

    public CustomCalendar decreaseOneDay(){

    }

    public void setCalendarRepresentation(CalendarRepresentation representation){
      this.representation = representation;
    }

    public int compareTo(CustomCalendar object){
      //if(t)
    }

    public String toString(){
      if(representation == null) throw new IllegalStateException("no representation");
      representation.getRepresentation(this);
    }

  }
