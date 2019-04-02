import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;
import calendar.ShamsiCustomCalendar;
import representation.DateRepresentation;
import representation.FullRepresentation;

public class Main
{
    public static void main(String[] args) {
        CustomCalendar shamsiCalendar = new ShamsiCustomCalendar("1/1/1397");
        shamsiCalendar.setCalendarRepresentation(new DateRepresentation());
        System.out.println(shamsiCalendar); // 01/01/1397
        shamsiCalendar.setCalendarRepresentation(new FullRepresentation());
        System.out.println(shamsiCalendar); // 1 Farvardin 1397
        shamsiCalendar.increaseOneDay();
        System.out.println(shamsiCalendar); // 2 Farvardin 1397
        shamsiCalendar.decreaseOneDay().decreaseOneDay();
        System.out.println(shamsiCalendar); // 30 Esfand 1396
        shamsiCalendar.increaseOneDay();
        System.out.println(shamsiCalendar); // 1 Farvardin 1397
        try {
            shamsiCalendar.setMonth(13);
            System.out.println("Unable to catch IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch IllegalArgumentException");
        }
        shamsiCalendar.setDay(31);
        try {
            shamsiCalendar.setMonth(7);
            System.out.println("Unable to catch IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch IllegalArgumentException");
        }
        shamsiCalendar.setCalendarRepresentation(new DateRepresentation());
        System.out.println(shamsiCalendar); // 31/01/1397
        shamsiCalendar.setDay(30);
        shamsiCalendar.setMonth(12);
        shamsiCalendar.increaseOneDay().increaseOneDay().increaseOneDay().decreaseOneDay();
        System.out.println(shamsiCalendar); // 02/01/1398
    }
}
