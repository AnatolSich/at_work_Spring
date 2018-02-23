package build;



import org.springframework.stereotype.Component;
import service.Causes;

import java.util.Date;
@Component
public class CurrentTimeAndCauseBuilder extends AbstractBuilder {
    public String addLocation(String loc, String message) {
        return message + ", " + "World";
    }

    public String addErrorCause(Integer cause, String message) {
        if (cause == 1) return message + ", " + Causes.CAUSE1;
        else if (cause == 2) return message + ", " + Causes.CAUSE2;
        else if (cause == 3) return message + ", " + Causes.CAUSE3;
        else if (cause == 4) return message + ", " + Causes.CAUSE4;
        else return message + ", " + " unknown problem";
    }

    public String addCurrentTime(String message) {
        return message + ", " + new Date();
    }
}


