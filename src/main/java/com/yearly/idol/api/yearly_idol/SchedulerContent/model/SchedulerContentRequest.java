package com.yearly.idol.api.yearly_idol.SchedulerContent.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SchedulerContentRequest {
    Long schedulerId;

    String content;

    String title;
    
    // @StringValueConstraint(acceptedValues = {"REGISTERED", "REMOVED"})
    String type;

    String url;

    LocalDateTime startDate;

    LocalDateTime endDate;
}
