package Connection;

import ViewModel.Message;
import java.util.*;

public class ClientMessageHandler {

    public static String handle(Message message) {
        String respond = "";
        switch (message.getMessageType()) {
            case Connect:
                // TODO
                break;
            case Disconnect:
                // TODO
                break;
            case Text:
                // TODO
                break;
            case Error:
                // TODO
                break;
        }
        return respond;
    }
}
