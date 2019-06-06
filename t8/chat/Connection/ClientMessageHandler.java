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
                // TODO
                break;
            case Text:
                respond = message.getSender() + ":" + message.getMessageText();
                break;
            case Error:
                // TODO
                break;
        }

        return respond;
    }
}
