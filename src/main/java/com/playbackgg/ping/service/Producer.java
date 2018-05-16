package com.playbackgg.ping.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.playbackgg.ping.data.DTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("sqs.queue.name")
    String queueName;

    @Autowired
    public Producer(AmazonSQSAsync amazonSQS) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQS);
    }

    public void send(String message) {
        queueMessagingTemplate.convertAndSend(queueName, new DTO(DateTime.now(), message));
    }

}
