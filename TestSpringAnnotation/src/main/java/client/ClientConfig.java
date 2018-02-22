package client;


import director.Director;
import director.DirectorConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(DirectorConfig.class)
public class ClientConfig {
   @Bean
    public Client client(Director director){
       Client client = new Client(director);
       client.setCall("LCT");
       return client;
   }
}
