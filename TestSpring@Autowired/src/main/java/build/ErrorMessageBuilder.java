package build;

public interface ErrorMessageBuilder {
    String reset();
    String addLocation(String loc,String message);
    String addErrorCause(Integer cause,String message);
    String addCurrentTime(String message);
}
