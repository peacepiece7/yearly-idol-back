package com.yearly.idol.api.yearly_idol.SchedulerContent.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SchedulerContentDto {
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
