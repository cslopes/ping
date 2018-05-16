package com.playbackgg.ping.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PongListener {
    private static final Logger LOG = LoggerFactory.getLogger(PongListener.class);

    @JmsListener(destination = "pong")
    public void receivePong(String message) {
        LOG.info("mesagem recebida");

        System.out.println("Conteúdo da mensagem: " + message);
    }
}
