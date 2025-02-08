package personal.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import personal.learning.dto.Customer;
import personal.learning.publisher.MessagePublisher;

@RestController
public class KafkaController {
	
	@Autowired
	private MessagePublisher messagePublisher;
	
	@PostMapping("/send/{partition}")
	public ResponseEntity<?> send(@PathVariable("partition") String partition, 
								  @RequestBody Customer customer) {
		try {
			System.out.println("Customer -> " + customer);
			messagePublisher.sendMessage(partition, customer);
			return ResponseEntity.ok("Message sent successfully...");
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
								 .build();
		}
	}
}
