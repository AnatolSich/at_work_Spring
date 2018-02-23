package build;


import org.springframework.stereotype.Component;
import service.Countries;

import java.util.Date;

@Component
public class CountryLocationAndTimeBuilder extends AbstractBuilder {

    public String addLocation(String loc, String message) {
        for (Enum anEnum : Countries.values()
                ) {
            if (anEnum.name().equalsIgnoreCase(loc)) {
                return message + ", " + anEnum.name();
            }
        }
        return message + " " + "World";
    }

    public String addErrorCause(Integer cause, String message) {
        return message + ", " + " unknown problem";
    }

    public String addCurrentTime(String message) {
        return message + ", " + new Date();
    }
}
