package director;

import build.BuilderConfig;
import build.ErrorMessageBuilder;
import build.LocationCauseTimeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectorConfig {
    @Bean
    public Director director(){
        return new Director(builder());
    }
    @Bean
    public ErrorMessageBuilder builder(){
        return new LocationCauseTimeBuilder();
    }
}
