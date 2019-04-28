import static org.junit.Assert.*;
import org.junit.*;

import javax.sound.sampled.Line;

public class InfoExtractorTest {

    @Before
    public void prepare(){
        InfoExtractor.setMax(17);
    }

    @Test
    public void overFlow(){
        InfoExtractor.setMax(2);
        Person[] biig = new Person[3];
        biig[0] = new Person("ali" , (short) 12);
        biig[1] = new Person("mammad" , (short) 19);
        biig[2] = new Person("sahand" , (short) 22);

    }

    @Test
    public void getPaymentsPerHour() {
    }

    @Test
    public void getLaziest() {
    }

    @Test
    public void sortOnSuccess() {
    }

    @Test
    public void getRichestSorted() {
    }
}