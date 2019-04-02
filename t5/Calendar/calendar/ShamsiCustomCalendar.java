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

  public void setDay(int day) throws IllegalArgumentException{
    if(day>31) throw new IllegalArgumentException("date is bigger than 31");
    if(day<1) throw new IllegalArgumentException("date should be bigger mosavi 1");
    if(month>6 && (day==31)) throw new IllegalArgumentException("invalid date");
    this.day = day;
  }

  public int getMonth(){
    return month;
  }

  public void setMonth(int month){
    if(month > 12) throw new IllegalArgumentException("month is bigger than 12");
    if(month < 1) throw new IllegalArgumentException("month is lower than 1");
    this.month = month;
  }

  public int getYear(){
    return year;
  }

  public void setYear(int year){
    if(year < 1) throw new IllegalArgumentException("year should be bigger mosavi than 1");
    this.year = year;
  }

  public String getMonthName(){
    return monthDB[month];
  }

  public CustomCalendar increaseOneDay(){
    fMonth = this.month;
    fDay = this.day;
    fYear = this.year;
    try{
      try{
        setDay(fDay+1);
      }
      catch(exception e){
        setDay(1);
        try{
          setMonth(fMonth+1);
        }
        catch(exception e){
          setMonth(1);
          setYear(fYear+1);
        }

      }
    }
    catch(exception e){
      System.err.println("error!");
    }
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
