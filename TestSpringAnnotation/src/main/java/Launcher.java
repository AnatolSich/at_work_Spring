
import client.Client;
import client.ClientConfig;

import director.DirectorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Launcher {
    public void launch(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ClientConfig.class);
        context.register(DirectorConfig.class);
        context.refresh();

        Client client = context.getBean(Client.class);
        client.makeMessage();
        context.registerShutdownHook();
    }
}