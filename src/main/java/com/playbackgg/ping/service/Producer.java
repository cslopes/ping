package com.playbackgg.ping.service;

import com.playbackgg.ping.data.DTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send() {
        jmsTemplate.convertAndSend(new DTO(DateTime.now(), "ping"));
    }

}
