package loggers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Created by Maria_Akulova on 5/12/2016.
 */
public class FileEventLogger implements EventLogger {

    public String filename;
    public File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), event + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        this.file = new File(filename);
        if (!this.file.canWrite()) {
            throw new IOException("Can't read file");
        }
        System.out.println("Init run");

    }
}
