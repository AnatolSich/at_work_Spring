package client;

import build.CountryLocationAndTimeBuilder;
import build.CurrentTimeAndCauseBuilder;
import build.StandardCauseAndLocationBuilder;
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
