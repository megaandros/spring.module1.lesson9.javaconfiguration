import java.io.IOException;
import java.util.Map;

import common.Client;
import common.EventType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import loggers.Event;
import loggers.EventLogger;

/**
 * Created by Maria_Akulova on 5/11/2016.
 */

public class App {

    public Client client;
    public Map<EventType, EventLogger> eventTypeEventLoggerMap;

    public App(Client client, Map<EventType, EventLogger> eventTypeEventLoggerMap) {
        this.client = client;
        this.eventTypeEventLoggerMap = eventTypeEventLoggerMap;
    }

    public static void main(String[] args) {


        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // ctx.register(AppConfig.class);
        // ctx.refresh();

         AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for user 1", null);
        app.logEvent("Some event for user 3", EventType.ERROR);
        app.logEvent("Some event for user 2", EventType.INFO);
        app.logEvent("Some event for user 4", null);
        app.logEvent("Some event for user 5", EventType.INFO);
        app.logEvent("Some event for user 6", EventType.ERROR);

        System.out.println("Call system exit");
        System.exit(1);

    }

    public void logEvent(String msg, EventType eventType) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Event event = (Event) ctx.getBean("event");
        event.setMsg(msg.replaceAll(client.getId(), client.getFullName()) + " - " + client.greeting);
        try {
            eventTypeEventLoggerMap.get(eventType).logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
