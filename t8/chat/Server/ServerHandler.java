package Server;

import ViewModel.Message;
import ViewModel.MessageType;


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

    int OnlineCheck(String userName){
      for (int i =0; i < userList.size(); i++) {
        User u = userList.get(i);
        if(u.getUsername().equals(userName)) return i;
      }
      return -1;
    }
    void connect(Message message) throws IOException{
      System.err.println("it seems " + message + " connectd");
      User newUser = new User(message.getSender(),inputStream,outputStream);

      Message respond = new Message(MessageType.Connect,message.getSender(),message.getReceiver(),"");
      for( User u : userList){
        u.getOutputStream().writeObject(respond);
      }
      userList.add(newUser);
      System.out.println(newUser + " added to list");

    }

    void error(Message message) throws IOException{
      System.err.println(" error");
      Message respond = new Message(MessageType.Error,message.getReceiver(),message.getSender(),"error");
      User target = userList.get(OnlineCheck(message.getSender()));
      target.getOutputStream().writeObject(respond);
    }
    void text(Message message) throws IOException{
      System.err.println(" it seems teeexxtt " + message + " recived");
      if (OnlineCheck(message.getReceiver()) == -1){
        error(message);
        System.err.println("error found");
        System.err.flush();
        return;
      }
      Message respond = new Message(MessageType.Text,message.getSender(),message.getReceiver(),message.getMessageText());
      User target = userList.get(OnlineCheck(message.getReceiver()));
      target.getOutputStream().writeObject(respond);
    }

    void disconnect(Message message) throws IOException{
      int userIndex = OnlineCheck(message.getSender());
      if (userIndex == -1 ) return;
      User dc = userList.get(userIndex);
      userList.remove(userIndex);
      Message respond = new Message(MessageType.Disconnect,message.getSender(),message.getReceiver(),"");
      for (User u : userList) {
        u.getOutputStream().writeObject(respond);
      }
    }

    void handle(Message message) throws IOException {
        switch (message.getMessageType()) {
            case Connect:
              connect(message);
              break;
            case Disconnect:
                disconnect(message);
                // TODO
                break;
            case Text:
                text(message);
                break;
        }
    }
}
