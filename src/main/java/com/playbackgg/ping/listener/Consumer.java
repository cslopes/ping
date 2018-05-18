package com.playbackgg.ping.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    //@MessageMapping
    @SqsListener(value = "${aws.queue.consumer}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message) {
        LOG.info("mesagem recebida");

        System.out.println("Conteúdo da mensagem recebida: " + message);
    }
}
