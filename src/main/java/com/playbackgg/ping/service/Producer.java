package com.playbackgg.ping.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.playbackgg.ping.data.DTO;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${aws.queue.name}")
    String queueName;


    @Autowired
    public Producer(AmazonSQSAsync amazonSQS) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQS);
    }

    public void send(String message) {
        log.info("{} - {}", queueName, message);
        queueMessagingTemplate.convertAndSend(queueName, new DTO(DateTime.now(), message));
    }

}
