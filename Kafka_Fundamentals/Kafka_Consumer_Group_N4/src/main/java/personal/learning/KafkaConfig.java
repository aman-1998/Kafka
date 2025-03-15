package personal.learning;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic topic1() {
		return new NewTopic("TestTopic1", 3, (short)1);
	}

}
