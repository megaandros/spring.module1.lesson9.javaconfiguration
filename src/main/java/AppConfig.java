import java.text.DateFormat;
import java.util.*;

import common.Client;
import common.EventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import loggers.*;
import util.AwareBean;
import util.Monitor;

@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    // @Autowired
    // Environment env;

    // @Bean Client client(){
    // Client client = new Client(env.getProperty("id"),env.getProperty("name") );
    // client.setGreeting(env.getProperty("greeting"));
    // return client;
    // }

    @Value("${id}")
    private String id;
    @Value("${name}")
    private String name;
    @Value("${greeting}")
    private String greeting;
  
    private Client client;

    private static String fileName = "log.txt";
    private static int fileCache = 4;
    private static Collection<EventLogger> loggers = Arrays.asList(new ConsoleEventLogger(),
            new FileEventLogger(fileName));
    private static Map<EventType, EventLogger> eventTypeEventLoggerMap;

    static {
        eventTypeEventLoggerMap = new HashMap<EventType, EventLogger>();
        eventTypeEventLoggerMap.put(EventType.INFO, new ConsoleEventLogger());
        eventTypeEventLoggerMap.put(EventType.ERROR, new CombinedEventLogger(loggers));
        eventTypeEventLoggerMap.put(null, new CacheFileEventLogger(fileName, fileCache));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Client client() {
        client = new Client(id, name);
        client.setGreeting(greeting);
        return client;
    }

    @Bean()
    public App app() {
        return new App(client, eventTypeEventLoggerMap);
    }

    @Bean
    public ConsoleEventLogger consoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean(initMethod = "init")
    public FileEventLogger fileEventLogger() {
        return new FileEventLogger(fileName);
    }

    @Bean(destroyMethod = "destroy")
    public CacheFileEventLogger cacheFileEventLogger() {
        return new CacheFileEventLogger(fileName, fileCache);
    }

    @Bean
    public CombinedEventLogger combinedEventLogger() {
        return new CombinedEventLogger(loggers);
    }

    @Bean
    @Scope("prototype")
    public Event event() {
        return new Event(new Date(), DateFormat.getDateTimeInstance()).setDf1(DateFormat.getDateTimeInstance());
    }

    @Bean
    public Monitor monitor() {
        return new Monitor();
    }

    @Bean(initMethod = "init")
    public AwareBean awareBean() {
        return new AwareBean();
    }
}
