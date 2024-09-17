package com.yearly.idol.api.yearly_idol.Scheduler.controller;

import com.yearly.idol.api.yearly_idol.Scheduler.model.SchedulerDto;
import com.yearly.idol.api.yearly_idol.Scheduler.model.SchedulerRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scheduler")
@RequiredArgsConstructor
public class SchedulerController {

    public void add(
            SchedulerRequest schedulerRequest
    ) {

    }

    public void update(
            SchedulerRequest schedulerRequest
    ){

    }

    public void remove(
            Long schedulerId
    ) {
        // schedulerId -> scheduler-content id, status = "Registered" | "Removed"

    }
}
