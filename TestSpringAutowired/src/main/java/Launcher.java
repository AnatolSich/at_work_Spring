import client.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public void launch(){
        String [] contextPaths = new String[]{"app-configuration.xml"};

        ApplicationContext context = new ClassPathXmlApplicationContext(contextPaths);
        Client client =(Client) context.getBean("client");
        client.makeMessage();
        ((ConfigurableApplicationContext)context).close();

    }
}