package Server;

import ViewModel.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

public class ServerHandler {
    public static List<User> userList = new ArrayList<>();
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    ServerHandler(Socket socket, ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    void connect(Message message) throws IOException{
      System.err.println("it seems " + message + " connectd");
      User newUser = new User(message.getSender(),inputStream,outputStream);
      for( User u : userList){
        u.getOutputStream().writeUTF(newUser.getUsername() + " connected");
      }
      userList.add(newUser);
      System.out.println(newUser + " added to list");

    }

    void handle(Message message) throws IOException {
        switch (message.getMessageType()) {
            case Connect:
              connect(message);
              break;
            case Disconnect:
                // TODO
                break;
            case Text:
                System.out.println(" it seems " + message + " recived");
                break;
        }
    }
}
