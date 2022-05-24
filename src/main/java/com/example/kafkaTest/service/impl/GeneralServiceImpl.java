package com.example.kafkaTest.service.impl;

import com.example.kafkaTest.constant.KafkaConstants;
import com.example.kafkaTest.request.PublishMessageRequest;
import com.example.kafkaTest.service.GeneralService;
import com.example.kafkaTest.util.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Slf4j
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publishToKafka(String message) {
        try {
            PublishMessageRequest publishMessageRequest = PublishMessageRequest.builder()
                    .message(message).timestamp(new Timestamp(System.currentTimeMillis())).build();
            log.info("Publishing message to kafka queue on topic {} with message {}",
                    KafkaConstants.TEST_MESSAGE_TOPIC, publishMessageRequest);
            kafkaTemplate.send(KafkaConstants.TEST_MESSAGE_TOPIC,
                    CommonUtils.MAPPER.writeValueAsString(publishMessageRequest));
        } catch (Exception e) {
            log.error("Error while publishing payload to kafka queue with message {}", message, e);
        }
    }

}
