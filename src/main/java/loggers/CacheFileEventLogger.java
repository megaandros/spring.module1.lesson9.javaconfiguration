package loggers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria_Akulova on 5/13/2016.
 */
public class CacheFileEventLogger extends FileEventLogger {

    public int cacheSize;
    public List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
            System.out.println("Cache is clean");
        }
    }

    private void writeEventsFromCache() {
        for (Event cacheitem : cache) {
            super.logEvent(cacheitem);
        }
    }

    private void destroy() {
        System.out.println("Destroy is started, cache has " + cache.size() + " items");
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
        System.out.println("Destroy is finished");
    }
}
