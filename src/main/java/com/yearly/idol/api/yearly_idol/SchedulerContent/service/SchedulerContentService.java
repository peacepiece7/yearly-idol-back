package com.yearly.idol.api.yearly_idol.SchedulerContent.service;

import com.yearly.idol.api.yearly_idol.SchedulerContent.db.SchedulerContentRepository;
import com.yearly.idol.api.yearly_idol.Scheduler.db.SchedulerEntity;
import com.yearly.idol.api.yearly_idol.Scheduler.db.SchedulerRepository;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentDto;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerContentService {

    private final SchedulerRepository schedulerRepository;
    private final SchedulerContentRepository schedulerContentRepository;
    private final SchedulerContentConverter schedulerConverter;

    public void createScheduler(
            Long userId
    ) {
        var schedulerEntity = SchedulerEntity.builder()
                .UserId(userId)
                .build();
        schedulerRepository.save(schedulerEntity);

    }

    public SchedulerContentDto add(
            SchedulerContentRequest schedulerRequest
    ) {
        var schedulerContentEntity = schedulerConverter.toEntity(schedulerRequest);

        schedulerContentRepository.save(schedulerContentEntity);

        return schedulerConverter.toDto(schedulerContentEntity);
    }
}