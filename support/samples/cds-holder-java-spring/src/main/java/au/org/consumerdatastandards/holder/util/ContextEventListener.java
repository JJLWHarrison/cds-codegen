package au.org.consumerdatastandards.holder.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ContextEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    CdsDataLoader dataLoader;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            dataLoader.loadProducts("payloads");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
