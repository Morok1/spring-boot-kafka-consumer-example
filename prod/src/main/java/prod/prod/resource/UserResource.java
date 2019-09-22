package prod.prod.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prod.prod.model.Statement;

import java.util.Date;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Statement> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";
    private static final String TOPIC_JSON = "Kafka_Example_json";

    @GetMapping("/publish/{name}")
    public Statement post(@PathVariable("name") final String name) {
        Statement statement = new Statement();

        statement.setDate(new Date());
        statement.setId(1L);
        statement.setValue(1);
        kafkaTemplate.send(TOPIC, statement);

        return statement;
    }
    @GetMapping("/publish_json/{name}")
    public Statement postJson(@PathVariable("name") final String name) {

        Statement statement = new Statement();

        statement.setDate(new Date());
        statement.setId(1L);
        statement.setValue(1);


        kafkaTemplate.send(TOPIC_JSON, statement);

        return statement;
    }
}
