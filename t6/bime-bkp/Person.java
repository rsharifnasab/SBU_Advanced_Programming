public class Person {

    private String name;
    private short age;
    private long balance;

    public Person(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;
        return name.equals(other.name) && age == other.age;
    }

}