package loggers;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Maria_Akulova on 5/16/2016.
 */
public class CombinedEventLogger implements EventLogger {

    public Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
