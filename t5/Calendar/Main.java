import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;
import calendar.GregorianCustomCalendar;
import calendar.ShamsiCustomCalendar;
import representation.DateRepresentation;
import representation.FullRepresentation;

public class Main
{
    public static void main(String[] args) throws Exception{
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

        try {
            CustomCalendar gregorianCalendar = new GregorianCustomCalendar("salam");
            System.out.println("Unable to catch IllegalCalendarFormatException");
        } catch (IllegalCalendarFormatException e) {
            System.out.println("Catch IllegalCalendarFormatException");
        }
        CustomCalendar gregorianCalendar = new GregorianCustomCalendar("01/1/1980");
        try {
            System.out.println(gregorianCalendar); // representation must be set before print
            System.out.println("Unable to catch IllegalStateException");
        } catch (IllegalStateException e) {
            System.out.println("Catch IllegalStateException");
        }
        gregorianCalendar.setCalendarRepresentation(new DateRepresentation());
        System.out.println(gregorianCalendar); // 01/01/1980
        gregorianCalendar.setYear(2020);
        gregorianCalendar.setMonth(12);
        while (gregorianCalendar.getMonth() != 1)
            gregorianCalendar.increaseOneDay();
        System.out.println(gregorianCalendar); // 01/01/2021

        System.out.println(gregorianCalendar.compareTo(new GregorianCustomCalendar("02/01/2021")) < 0); // true
        System.out.println(gregorianCalendar.compareTo(new GregorianCustomCalendar("01/02/2021")) < 0); // true
        System.out.println(gregorianCalendar.compareTo(new GregorianCustomCalendar("15/12/2020")) > 0); // true
        System.out.println(gregorianCalendar.compareTo(gregorianCalendar)); // 0
    }
}
