package com.yearly.idol.api.yearly_idol.SchedulerContent.controller;

import com.yearly.idol.api.yearly_idol.Common.model.Api;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentDto;
import com.yearly.idol.api.yearly_idol.SchedulerContent.model.SchedulerContentRequest;
import com.yearly.idol.api.yearly_idol.SchedulerContent.service.SchedulerContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scheduler")
@RequiredArgsConstructor
public class SchedulerContentController {


    private final SchedulerContentService schedulerService;

    @PostMapping("/add")
    public ResponseEntity<Api<SchedulerContentDto>> add(
            @Valid
            @RequestBody
            SchedulerContentRequest schedulerRequest
    ) {
        var schedulerContentDto = schedulerService.add(schedulerRequest);
        var body = Api.<SchedulerContentDto>builder()
                .data(schedulerContentDto)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public void update(
            SchedulerContentRequest schedulerRequest
    ) {

    }

    public void remove(
            Long schedulerId
    ) {
        // schedulerId -> scheduler-content id, status = "Registered" | "Removed"
    }
}