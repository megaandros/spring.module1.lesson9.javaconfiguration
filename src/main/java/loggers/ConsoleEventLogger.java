package loggers;

/**
 * Created by Maria_Akulova on 5/11/2016.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
