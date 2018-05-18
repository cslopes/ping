package com.playbackgg.ping.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public class DTO {
    DateTime hora;
    String mensagem;
}
