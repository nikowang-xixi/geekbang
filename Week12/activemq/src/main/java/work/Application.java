package work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import work.mq.activemq.jms.JMSProducer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private JMSProducer jmsProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String topic = "topic-test";
        Map<String, String> message = new HashMap<>();
        message.put("message", "test message");
        jmsProducer.sendMessage(topic, message);
    }
}
