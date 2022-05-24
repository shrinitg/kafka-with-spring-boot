package com.example.kafkaTest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(doNotUseGetters = true)
public class PublishMessageRequest {

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "time_stamp")
    private Timestamp timestamp;

}
