import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private static final int MAX_SIZE = 100;

    private static SimpleArrayList arrayList;
    private static Random random = new Random();

    @Before
    public void init() {
        arrayList = new SimpleArrayList();
    }

    @After
    public void reset() {
        arrayList.clear();
        arrayList = null;
    }

    @Test
    public void sizeTest() {
        for (int i = 0; i < MAX_SIZE; i++) {
            assertSame(arrayList.size(), i);
            arrayList.add(i);
        }//end for
    }

    @Test
    public void isEmptyTest() {
        assertTrue(arrayList.isEmpty());
        for (int i = 0; i < MAX_SIZE; i++) {
            arrayList.add(i);
            assertFalse(arrayList.isEmpty());
        }//end for
        for (int i = 0; i < MAX_SIZE; i++) {
            assertFalse(arrayList.isEmpty());
            arrayList.remove(0);
        }//end for
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void clearTest() {
        int numberOfAdds = random.nextInt(MAX_SIZE);
        for (int i = 0; i < numberOfAdds; i++)
            arrayList.add(i);
        arrayList.clear();
        assertSame(arrayList.size(), 0);
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void getTest() {
        try {
            arrayList.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        for (int i = 0; i < MAX_SIZE; i++)
            arrayList.add(i);
        for (int i = 0; i < MAX_SIZE; i++)
            assertSame(arrayList.get(i), i);
        try {
            arrayList.get(100);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
    }

    @Test
    public void setTest() {
        Integer[] help = new Integer[MAX_SIZE];
        try {
            arrayList.set(0, random.nextInt());
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        for (int i = 0; i < MAX_SIZE; i++)
            arrayList.add(i);
        for (int i = 0; i < MAX_SIZE; i++) {
            int randomValue = random.nextInt();
            int previous = arrayList.set(i, randomValue);
            help[i] = randomValue;
            assertSame(previous, i);
        }//end for
        for (int i = 0; i < MAX_SIZE; i++)
            assertEquals(arrayList.get(i), help[i]);
        try {
            arrayList.set(100, random.nextInt());
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        try {
            int randomIndex = random.nextInt(MAX_SIZE);
            arrayList.set(randomIndex, null);
            fail();
        } catch (NullPointerException e) {
        }//end catch block
    }

    @Test
    public void addTest() {
        for (int i = 0; i < MAX_SIZE; i++) {
            boolean operation = arrayList.add(i);
            assertSame(arrayList.size(), i + 1);
            assertTrue(operation);
        }//end for
        for (int i = 0; i < MAX_SIZE; i++)
            assertSame(arrayList.get(i), i);
        try {
            arrayList.add(null);
            fail();
        } catch (NullPointerException e) {
        }//end catch block
    }

    @Test
    public void addWithIndexTest() {
        List<Integer> help = new ArrayList<>();
        try {
            arrayList.add(1, random.nextInt());
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        for (int i = 0; i < MAX_SIZE; i++) {
            int randomValue = random.nextInt();
            int randomIndex = random.nextInt(i + 1);
            arrayList.add(randomIndex, randomValue);
            help.add(randomIndex, randomValue);
            assertSame(arrayList.size(), i + 1);
        }//end for
        for (int i = 0; i < MAX_SIZE; i++)
            assertEquals(arrayList.get(i), help.get(i));
        try {
            int randomIndex = random.nextInt(MAX_SIZE);
            arrayList.add(randomIndex, null);
            fail();
        } catch (NullPointerException e) {
        }//end catch block
    }

    @Test
    public void addAllTest() {
        boolean operation = arrayList.addAll(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        assertTrue(operation);
        for (int i = 0; i < 10; i++)
            assertSame(arrayList.get(i), 10 - i);
        assertSame(arrayList.size(), 10);
        try {
            arrayList.addAll(1, 2, 3, null, 4, 5);
            fail();
        } catch (NullPointerException e) {
        }//end catch block
        Integer[] help = new Integer[100];
        for (int i = 0; i < MAX_SIZE; i++)
            help[i] = random.nextInt();
        operation = arrayList.addAll(help);
        assertTrue(operation);
        assertSame(arrayList.size(), MAX_SIZE + 10);
        for (int i = 0; i < MAX_SIZE; i++) {
            int index = i + 10;
            assertEquals(arrayList.get(index), help[i]);
        }//end for
        int randomIndex = random.nextInt(MAX_SIZE + 10);
        help[randomIndex] = null;
        try {
            arrayList.addAll(help);
            fail();
        } catch (NullPointerException e) {
        }//end catch block
    }

    @Test
    public void removeTest() {
        List<Integer> help = new ArrayList<>();
        try {
            arrayList.remove(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        for (int i = 0; i < MAX_SIZE; i++) {
            int randomValue = random.nextInt();
            arrayList.add(randomValue);
            help.add(randomValue);
        }//end for
        try {
            arrayList.remove(MAX_SIZE);
            fail();
        } catch (IndexOutOfBoundsException e) {
        }//end catch block
        for (int i = 0; i < MAX_SIZE; i++) {
            int randomIndex = random.nextInt(MAX_SIZE - i);
            int deleting = arrayList.remove(randomIndex);
            int actual = help.get(randomIndex);
            assertEquals(deleting, actual);
            assertSame(arrayList.size(), MAX_SIZE - 1 - i);
            help.remove(randomIndex);
        }//end for
        assertTrue(arrayList.isEmpty());
    }

}