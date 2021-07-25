package work.mq.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JMSProducer {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMessage(final String topic, final Map message) {
        jmsTemplate.convertAndSend(topic, message);
    }
}
