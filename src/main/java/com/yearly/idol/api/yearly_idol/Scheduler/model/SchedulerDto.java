package com.yearly.idol.api.yearly_idol.Scheduler.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SchedulerDto {
    Long id;
    Long schedulerId;
    String content;
    String title;
    String type;
    String url;
    LocalDateTime createdAt;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
