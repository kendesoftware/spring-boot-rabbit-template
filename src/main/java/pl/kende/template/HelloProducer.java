package pl.kende.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelloProducer {
    private static final Logger logger = LoggerFactory.getLogger(HelloProducer.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 1000)
    public void produceHello() {
        String data = "Hello! " + UUID.randomUUID();
        logger.info("Sending data: {}", data);
        rabbitTemplate.convertAndSend("hello", data);
    }
}
