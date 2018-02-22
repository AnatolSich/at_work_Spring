package build;

public abstract class AbstractBuilder implements ErrorMessageBuilder {
    public String reset() {
        return "Error message";
    }

    public abstract String addLocation(String loc, String message);

    public abstract String addErrorCause(Integer cause, String message);

    public abstract String addCurrentTime(String message);
}
