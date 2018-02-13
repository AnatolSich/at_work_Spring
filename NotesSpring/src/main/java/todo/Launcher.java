package todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public void launch(){
        String [] contextPaths = new String[]{"spring-context-application.xml"};

        ApplicationContext context = new ClassPathXmlApplicationContext(contextPaths);
        ((ConfigurableApplicationContext)context).close();
    }
}
