package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
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

	@KafkaListener(topicPartitions = @TopicPartition(topic = "topicName", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0"),
			@PartitionOffset(partition = "3", initialOffset = "0") }))
	public void listenToParition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		System.out.println("Received Messasge: " + message + "from partition: " + partition);
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "topicName", partitions = { "0", "1" }))
	public void listenToParition2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		System.out.println("Received Messasge: " + message + "from partition: " + partition);
	}

}
