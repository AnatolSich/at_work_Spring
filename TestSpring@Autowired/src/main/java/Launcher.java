
import client.Client;

import director.Director;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Launcher {
    public void launch(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

      //  Director director = context.getBean(Director.class);

        Client client = context.getBean(Client.class);

        client.setCall("LCT");
        client.makeMessage();
        context.close();
    }
}