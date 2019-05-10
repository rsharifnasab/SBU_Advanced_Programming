import java.util.*;

class Person {
    int rank;

    public Person(int rank) {
        this.rank = rank;
    }
}

class Developer extends Person implements Comparable<Person> {
    public Developer(int rank) {
        super(rank);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(rank, o.rank);
    }
}

class Boss extends Person implements Comparable<Boss> {
    int salary;

    public Boss(int rank, int salary) {
        super(rank);
        this.salary = salary;
    }

    @Override
    public int compareTo(Boss o) {
        return Integer.compare(salary, o.salary);
    }
}

class Employee extends Person implements Comparable<Boss> {
    int timeToWork;

    public Employee(int rank, int timeToWork) {
        super(rank);
        this.timeToWork = timeToWork;
    }

    @Override
    public int compareTo(Boss o) {
        return Integer.compare(timeToWork, o.salary);
    }
}

public class Maximum {

    public static <T extends Comparable<? super T>> T findMax (T...inp){
      Arrays.sort(inp);
      return inp[inp.length-1];

    }
    public static void main(String[] args) {
        Integer a = Maximum.findMax(0, 1, 2, 3); // a = 3
        System.out.println(a);
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        // Compile Error : Person should implements Comparable
        //Maximum.findMax(person1, person2);

        Developer s1 = new Developer(20);
        Developer s2 = new Developer(0);
        Developer maxDeveloper = Maximum.findMax(s1, s2);
        System.out.println(Objects.requireNonNull(maxDeveloper).rank); // prints 20

        Boss boss1 = new Boss(3, 200);
        Boss boss2 = new Boss(2, 400);
        Boss boss3 = new Boss(1, 600);
        Boss maxBoss = Maximum.findMax(boss1, boss2, boss3);
        System.out.println(Objects.requireNonNull(maxBoss).salary); // prints 600

        Employee employee1 = new Employee(3, 10);
        Employee employee2 = new Employee(2, 20);
        Employee employee3 = new Employee(1, 5);
        // Compile Error : Employee should be compared to Boss only
        //Employee maxEmployee = Maximum.findMax(employee1, employee2, employee3);
    }
}
