package client;

import director.Director;

public class Client {
    String call;
    Director director;

    public Client(Director director) {
        this.director = director;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public void makeMessage() {
        director.makeMessage(call);
    }
}
