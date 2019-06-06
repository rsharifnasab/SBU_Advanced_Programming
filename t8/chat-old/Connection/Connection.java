package Connection;

import Server.Server;
import ViewModel.Message;
import ViewModel.MessageType;

import java.io.*;
import java.net.Socket;

public class Connection
{
    private String currentUsername;
    private Socket client;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Connection(String currentUsername) {
        this.currentUsername = currentUsername;

        try
        {
            client = new Socket(Server.serverIP, Server.requestPort);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
            sendRequest(new Message(MessageType.Connect, currentUsername, "", ""));
        } catch (IOException e)
        {
            throw new ServerConnectionException();
        }
    }

    public void disconnect() {
        sendRequest(new Message(MessageType.Disconnect, currentUsername, "", ""));
    }

    public void initializeServices() {
        Thread listenerThread = new Thread(new ListenerService(this), "Listener Thread");
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    void sendRequest(Message request) {
        try
        {
            out.writeObject(request);
        } catch (IOException e)
        {
            throw new ServerConnectionException();
        }
    }

    public void sendText(String textMessage, String receiver) {
        sendRequest(new Message(MessageType.Text, currentUsername, receiver, textMessage));
    }

    public String getRespond() {
        try
        {
            return ClientMessageHandler.handle((Message) in.readObject());
        } catch (IOException | ClassNotFoundException e)
        {
            throw new ServerConnectionException();
        }
    }
}

