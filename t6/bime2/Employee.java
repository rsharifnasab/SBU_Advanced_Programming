public class Employee extends Person {

    private short workHoursPerDay;
    private int paymentPerMonth;

    public Employee(String name, short age) {
        super(name, age);
    }

    public short getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(short workHoursPerDay) {
        this.workHoursPerDay = workHoursPerDay;
    }

    public int getPaymentPerMonth() {
        return paymentPerMonth;
    }

    public void setPaymentPerMonth(int paymentPerMonth) {
        this.paymentPerMonth = paymentPerMonth;
    }

    public int paymentPerTime() {
        return paymentPerMonth / workHoursPerDay;
    }

}