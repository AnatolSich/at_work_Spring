package director;

import build.ErrorMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.Countries;

@Component
public class Director {
    ErrorMessageBuilder builder;
    @Autowired
    public Director(@Qualifier("LocationCauseTime") ErrorMessageBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder( ErrorMessageBuilder builder) {
        this.builder = builder;
    }

    public void makeMessage(String type) {
        String message = builder.reset();
        if (type.contains("L")) {
            String country = Countries.values()[(int) (Math.random() * 5)].name();
            System.out.println("Country: " + country);
            message = builder.addLocation(country, message);
        }
        if (type.contains("C")) {
            Integer cause = (int) (Math.random() * 4);
            System.out.println("Cause: " + cause);
            message = builder.addErrorCause(cause, message);
        }
        if (type.contains("T")) {
            message = builder.addCurrentTime(message);
        }
        System.out.println(message);

    }
}
