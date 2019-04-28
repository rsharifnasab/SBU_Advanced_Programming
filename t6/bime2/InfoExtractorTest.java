import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import javax.sound.sampled.Line;
import java.util.Arrays;



public class InfoExtractorTest {
    Employee[] a;
    List<Person> list;
    @Before
    public void prepare(){
        //System.out.println("before ran");
        InfoExtractor.setMax(17);
        a  = new Employee[4];
        a[0] = new Employee("ali",(short)12);
        a[0].setPaymentPerMonth(11);
        a[0].setWorkHoursPerDay((short)2);
        a[0].setBalance(400);

        a[1] = new Employee("taghi",(short)50);
        a[1].setPaymentPerMonth(101);
        a[1].setWorkHoursPerDay((short)9);
        a[1].setBalance(830);

        a[2] = new Employee("Saeed",(short)35);
        a[2].setPaymentPerMonth(900);
        a[2].setWorkHoursPerDay((short)5);
        a[2].setBalance(8130);


        a[3] = new Employee("Saeed",(short)35);
        a[3].setPaymentPerMonth(900);
        a[3].setWorkHoursPerDay((short)5);
        a[3].setBalance(8130);

        list = new ArrayList<>();
        for (Person p : a
             ) {
            list.add(p);
        }


    }

    @Test
    public void NullTest(){
        Person[] biig = new Person[3];

        biig[0] = new Person("ali" , (short) 12);
        biig[2] = new Person("sahand" , (short) 22);
        biig[1] = null;
        List<Person> list = Arrays.asList(biig);

        try {
            InfoExtractor.getPaymentsPerHour(list);
            fail();
        }
        catch (NullPointerException e){
            //OK
        }


        try {
            InfoExtractor.getLaziest(list);
            fail();
        }
        catch (NullPointerException e){
            //OK
        }



        try {
            InfoExtractor.sortOnSuccess(list);
            fail();
        }
        catch (NullPointerException e){
            //OK
        }



        try {
            InfoExtractor.getRichestSorted(list);
            fail();
        }
        catch (NullPointerException e){
            //OK
        }


        try {
            InfoExtractor.getPaymentsPerHour(null);
            fail();
        }
        catch (EmptyInputException e){
            //OK
        }


        try {
            InfoExtractor.getLaziest(null);
            fail();
        }
        catch (EmptyInputException e){
            //OK
        }



        try {
            InfoExtractor.sortOnSuccess(null);
            fail();
        }
        catch (EmptyInputException e){
            //OK
        }



        try {
            InfoExtractor.getRichestSorted(null);
            fail();
        }
        catch (EmptyInputException e){
            //OK
        }

    }

    @Test
    public void overFlow(){
        InfoExtractor.setMax(2);
        Person[] biig = new Person[3];

        biig[0] = new Person("ali" , (short) 12);
        biig[1] = new Person("mammad" , (short) 19);
        biig[2] = new Person("sahand" , (short) 22);
        list = Arrays.asList(biig);

        try {
            InfoExtractor.getPaymentsPerHour(list);
            fail();
        }
        catch (DataInputOverflowException e){
            //OK
        }
        try {
            InfoExtractor.getLaziest(list);
            fail();
        }
        catch (DataInputOverflowException e){
            //OK
        }
        try {
            InfoExtractor.sortOnSuccess(list);
            fail();
        }
        catch (DataInputOverflowException e){
            //OK
        }
        try {
            InfoExtractor.getRichestSorted(list);
            fail();
        }
        catch (DataInputOverflowException e){
            //OK
        }


    }

    @Test
    public void getPaymentsPerHour() {
      //  if(list == null) System.out.println("nulleee");
        List<Integer> ans = InfoExtractor.getPaymentsPerHour(list);
        Integer[] should = new Integer[]{0,0,5,5};
        assertTrue(Arrays.equals(should, ans.toArray()));


    }

    @Test
    public void getLaziest() {
        List list2 = new ArrayList<>();
        list2.add(list.get(0));
        list2.add(list.get(1));
        Person p = InfoExtractor.getLaziest(list);
        assertNull(p);
        list2.add(new Person("bikar", (short) 1) );
        p = InfoExtractor.getLaziest(list2);
        assertEquals(p.getName(),"bikar");
    }

    @Test
    public void sortOnSuccess() {
        List<Employee> l = InfoExtractor.sortOnSuccess(list);

        assertEquals(l.get(0).getName(),"taghi");
        assertEquals(l.get(1).getName(),"ali");
        assertEquals(l.get(2).getName(),"Saeed");
    }

    @Test
    public void getRichestSorted() {
        List<Person> l = InfoExtractor.getRichestSorted(list);
        assertEquals(l.get(0).getName(),"Saeed");
    }
}