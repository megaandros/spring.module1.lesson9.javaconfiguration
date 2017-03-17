package util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Maria_Akulova on 5/17/2016.
 */
public class Monitor implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent.getSource().toString());
    }
}
