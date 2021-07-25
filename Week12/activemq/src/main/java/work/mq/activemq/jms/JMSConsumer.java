package work.mq.activemq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JMSConsumer {
    @JmsListener(destination = "topic-test")
    public void receive(final Map message) {
        System.out.println(message);
    }

    @JmsListener(destination = "rec-web")
    public void receive(final String message) {
        System.out.println(message);
    }

}
