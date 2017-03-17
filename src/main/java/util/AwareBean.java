package util;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by Maria_Akulova on 5/17/2016.
 */
public class AwareBean implements ResourceLoaderAware {

    public void init() {

    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(resourceLoader.getResource("client.properties"));
    }
}
