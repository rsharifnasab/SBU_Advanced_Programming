package Server;

import ViewModel.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerHandler {
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


    void handle(Message message) throws IOException {
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
        }
    }
}
