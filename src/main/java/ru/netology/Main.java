 package ru.netology;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import jakarta.servlet.ServletRegistration;
import ru.netology.config.AppConfig;
import java.io.File;
public class Main {
    public static void main(String[] args) throws LifecycleException {
        // Create Tomcat instance
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Create context
        Context context = tomcat.addContext("", new File(".").getAbsolutePath());

        // Create Spring application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);


// Create and register DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/*", "dispatcher");

        // Start Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}
