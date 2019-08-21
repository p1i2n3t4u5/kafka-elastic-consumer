package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.service.TweetService;

@SpringBootApplication
public class KafkaElasticConsumerApplication implements CommandLineRunner {

	@Autowired
	private TweetService tweetService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaElasticConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Tweet tweet = new Tweet("11111", "Mytitle", "Niranjan", "11-03-1988");
//		Tweet tweet2 = new Tweet("11112", "Mytitle2", "Niranjan", "11-03-1988");
//		tweetService.save(tweet);
//		tweetService.save(tweet2);
	}

}
