package com.playbackgg.ping.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class PongListener {
    private static final Logger LOG = LoggerFactory.getLogger(PongListener.class);

    //@MessageMapping
    @SqsListener("pong")
    public void receivePong(String message) {
        LOG.info("mesagem recebida");

        System.out.println("Conteúdo da mensagem: " + message);
    }
}
