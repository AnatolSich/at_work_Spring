package client;

import director.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {

    String call;

    Director director;

    @Autowired
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
