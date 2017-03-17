package loggers;

import java.io.IOException;

/**
 * Created by Maria_Akulova on 5/12/2016.
 */
public interface EventLogger {

    public void logEvent(Event event) throws IOException;
}
