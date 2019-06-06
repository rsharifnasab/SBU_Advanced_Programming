package Connection;

import ViewModel.Message;
import java.util.*;

public class ClientMessageHandler {

    public static String handle(Message message) {
        String respond = "";
        switch (message.getMessageType()) {
            case Connect:
                System.out.println("anser from server");
                respond = message.getSender() + " connected";
                break;
            case Disconnect:
                respond = message.getSender() + " disconnected";
                break;
            case Text:
                respond = message.getSender() + ":" + message.getMessageText();
                break;
            case Error:
                respond = message.getSender() + " doesn't exist";
                break;
        }

        return respond;
    }
}
