package calendar;

import representation.CalendarRepresentation;
import calendar.exception.IllegalCalendarFormatException;

public class ShamsiCustomCalendar implements CustomCalendar {
  private int day;
  private int month;
  private int year;
  private static final String[] monthDB = {null,"Farvardin","Ordibehesht","Khordad","Tir","Mordad","Shahrivar","Mehr","Aban","Azar","Dey","Bahman","Esfand"};

  CalendarRepresentation representation;

  public ShamsiCustomCalendar(String inp) throws Exception{

    try{
      String[] db = inp.split("/");
      int day = Integer.parseInt(db[0]);
      int month = Integer.parseInt(db[1]);
      int year = Integer.parseInt(db[2]);
    }
    catch(Exception e){
      throw new IllegalCalendarFormatException("error!");
    }
    if(isValidDate(day,month,year)){ this.day = day; this.month = month; this.year = year;}
    else throw new IllegalCalendarFormatException();
  }
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
    if(isValidDate(day,month,year)) this.day = day;
    else throw new IllegalArgumentException("invalud date");
  }

  public int getMonth(){
    return month;
  }

  public void setMonth(int month){
    if(isValidDate(day,month,year)) this.month = month;
    else throw new IllegalArgumentException("invalid month");
  }

  public int getYear(){
    return year;
  }

  public void setYear(int year){
    if(isValidDate(day,month,year)) this.year = year;
    else throw new IllegalArgumentException("year should be bigger mosavi than 1");
  }

  public String getMonthName(){
    return monthDB[month];
  }

  public CustomCalendar increaseOneDay(){
    fMonth = this.month;
    fDay = this.day;
    fYear = this.year;
    if(isValidDate(fDay+1,fMonth,fYear)) {this.day++;}
    else if(isValidDate(1,fMonth+1,fYear)) {this.day=1; this.month++;}
    else {this.day=1; this.month=1; this.year++;}
    return this;
  }

    public CustomCalendar decreaseOneDay(){
      fMonth = this.month;
      fDay = this.day;
      fYear = this.year;
      if(isValidDate(fDay-1,fMonth,fYear)) {this.day--;}
      else if(isValidDate(31,fMonth-1,fYear)) {this.day=31; this.month--;}
      else if(isValidDate(30,fMonth-1,fYear)) {this.day=30; this.month--;}
      else if(isValidDate(29,fMonth-1,fYear)) {this.day=29; this.month--;}
      else if(isValidDate(28,fMonth-1,fYear)) {this.day=28; this.month--;}
      else if(isValidDate(31,12,fYear-1)) {this.day=31; this.month=12; this.year--;}
      else if(isValidDate(30,12,fYear-1)) {this.day=30; this.month=12; this.year--;}
      else {this.day=29; this.month=12; this.year--;} // this should not happen!
      return this;
    }

    public void setCalendarRepresentation(CalendarRepresentation representation){
      this.representation = representation;
    }

    public int compareTo(CustomCalendar object){
      if(object instanceof ShamsiCustomCalendar == false) throw new IllegalArgumentException("not same input!");
      if(isValidDate(object.day,object.month,object.year) == false) throw new IllegalArgumentException("invalid date");

      if(object.year > this.year) return -1;
      if(object.year < this.year) return +1;

      if(object.month > this.month) return -1;
      if(object.month < this.month) return +1;

      if(object.day > this.day) return -1;
      if(object.day < this.day) return +1;

      return 0;
    }

    public String toString(){
      if(representation == null) throw new IllegalStateException("no representation");
      return representation.getRepresentation(this);
    }

  }
