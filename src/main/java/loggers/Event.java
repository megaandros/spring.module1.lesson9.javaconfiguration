package loggers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Maria_Akulova on 5/12/2016.
 */
public class Event {

    public int id = new Random().nextInt();
    public String msg;
    public Date date;
    public DateFormat df;
    public DateFormat df1;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event setDf1(DateFormat df1) {
        this.df1 = df1;
        return this;
    }

    @Override
    public String toString() {
        return "loggers.Event{" + "id=" + id + ", msg='" + msg + '\'' + ", date=" + date + ", df=" + df + ", df1='"
                + df1 + '\'' + '}';
    }
}
