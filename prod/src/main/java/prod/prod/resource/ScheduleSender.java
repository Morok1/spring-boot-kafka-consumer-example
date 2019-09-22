package prod.prod.resource;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import prod.prod.model.Statement;

import java.util.Date;

@Component
@Log
public class ScheduleSender {
    @Autowired
    private KafkaTemplate<String, Statement> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";
    private static final String TOPIC_JSON = "Kafka_Example_json";

    @Scheduled(fixedRate = 5000)
    public void send() {
        Statement statement = new Statement();

        statement.setDate(new Date());
        statement.setId(1L);
        statement.setValue(1);

        log.info("Scheudling kafkaTemplate topic_json");

        kafkaTemplate.send(TOPIC_JSON, statement);
    }


    @Scheduled(fixedRate = 4000)
    public void sendTopic(){
        log.info("Scheudling kafkaTemplate topic");
        Statement statement = new Statement();

        statement.setDate(new Date());
        statement.setId(2L);
        statement.setValue(2);

        kafkaTemplate.send(TOPIC, statement);


    }


}
