package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.Tweet;
import com.kafka.service.TweetService;

@Service
public class KafkaConsumerListener {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

	@Autowired
	private TweetService tweetService;

	@KafkaListener(topics = "twittertweets", groupId = "tweets_group", containerFactory = "kafkaListenerContainerFactory")
	public void consumeJson(Tweet tweet) {
		logger.info("message User :" + tweet);
		tweetService.save(tweet);
	}

}
