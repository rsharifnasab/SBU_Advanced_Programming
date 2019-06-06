package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 19L;
    private String username;

    private transient ObjectInputStream inputStream;
    private transient ObjectOutputStream outputStream;

    public User(String username, ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.username = username;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setOutputStream(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}