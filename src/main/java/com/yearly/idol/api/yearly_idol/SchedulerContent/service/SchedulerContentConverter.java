package com.yearly.idol.api.yearly_idol.SchedulerContent.service;

import com.yearly.idol.api.yearly_idol.SchedulerContent.db.SchedulerContentEntity;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentDto;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentRequest;
import org.springframework.stereotype.Service;

@Service
public class SchedulerContentConverter {
    public SchedulerContentEntity toEntity(
            SchedulerContentRequest schedulerRequest
    ) {
        return SchedulerContentEntity.builder()
                .schedulerId(schedulerRequest.getSchedulerId())
                .content(schedulerRequest.getContent())
                .title(schedulerRequest.getTitle())
                .type(schedulerRequest.getType())
                .url(schedulerRequest.getUrl())
                .startDate(schedulerRequest.getStartDate())
                .endDate(schedulerRequest.getEndDate())
                .build();
    }

    public SchedulerContentDto toDto(
            SchedulerContentEntity schedulerContentEntity
    ) {
        return SchedulerContentDto.builder()
                .id(schedulerContentEntity.getId())
                .schedulerId(schedulerContentEntity.getSchedulerId())
                .title(schedulerContentEntity.getTitle())
                .content(schedulerContentEntity.getContent())
                .type(schedulerContentEntity.getType())
                .url(schedulerContentEntity.getUrl())
                .startDate(schedulerContentEntity.getStartDate())
                .endDate(schedulerContentEntity.getEndDate())
                .createdAt(schedulerContentEntity.getCreatedAt())
                .build();
    }
}
