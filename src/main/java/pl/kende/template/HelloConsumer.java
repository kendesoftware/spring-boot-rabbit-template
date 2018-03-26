package pl.kende.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {
    private static final Logger logger = LoggerFactory.getLogger(HelloConsumer.class);

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "hello", durable = "false", autoDelete = "true"), exchange = @Exchange(name = "hello", autoDelete = "true")))
    public void consumeHello(String data) {
        logger.info("Received data: {}", data);
    }
}
