import Connection.Connection;
import Server.Server;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatTest{
    @Test
    public void test() throws InterruptedException {
        Server.start();
		Thread.sleep(100);
		Connection Ali = new Connection("Ali");
		Thread.sleep(200);
		Connection Reza = new Connection("Reza");
		Thread.sleep(200);
		assertEquals("Reza connected", Ali.getRespond());
		Thread.sleep(100);
		Ali.sendText("Salam. Khobi?", "Reza");
		Thread.sleep(100);
		Reza.sendText("Keili kobam", "Ali");
		Thread.sleep(100);
		assertEquals("Reza:Keili kobam", Ali.getRespond());
		Thread.sleep(100);
		assertEquals("Ali:Salam. Khobi?", Reza.getRespond());
		Thread.sleep(100);
		Connection Amin = new Connection("Amin");
		Thread.sleep(200);
		assertEquals("Amin connected", Ali.getRespond());
		Thread.sleep(100);
		assertEquals("Amin connected", Reza.getRespond());
		Thread.sleep(100);
		Amin.sendText("Man ham omadam", "Ali");
		Thread.sleep(100);
		Amin.sendText("Man ham omadam", "Reza");
		Thread.sleep(100);
		assertEquals("Amin:Man ham omadam", Ali.getRespond());
		Thread.sleep(100);
		assertEquals("Amin:Man ham omadam", Reza.getRespond());
		Thread.sleep(100);
		Ali.disconnect();
		Thread.sleep(200);
		assertEquals("Ali disconnected", Reza.getRespond());
		Thread.sleep(100);
		assertEquals("Ali disconnected", Amin.getRespond());
		Thread.sleep(100);
		Amin.sendText("Ali:koja rafti?", "Ali");
		Thread.sleep(100);
		assertEquals("Ali doesn't exist", Amin.getRespond());
		Thread.sleep(100);
		Amin.disconnect();
		Thread.sleep(200);
		assertEquals("Amin disconnected", Reza.getRespond());
		Thread.sleep(100);
		Reza.disconnect();
		Thread.sleep(200);
    }
}