package com.example.kafkaTest.listener;

import com.example.kafkaTest.constant.KafkaConstants;
import com.example.kafkaTest.request.PublishMessageRequest;
import com.example.kafkaTest.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GeneralListener {

    @KafkaListener(id = KafkaConstants.TEST_MESSAGE_ID,
            topics = {KafkaConstants.TEST_MESSAGE_TOPIC},
            containerFactory = KafkaConstants.CONTAINER_FACTORY)
    public void receiveMessage(String payload) {
        try {
            log.info("Message received from kafka queue: {}", payload);
            PublishMessageRequest publishMessageRequest =
                    CommonUtils.MAPPER.readValue(payload, PublishMessageRequest.class);
            log.info("Message decoded after mapping to publish message request object is {}",
                    publishMessageRequest.getMessage());
        } catch (Exception e) {
            log.error("Error while listening the kafka payload with payload {}", payload);
        }
    }

}
