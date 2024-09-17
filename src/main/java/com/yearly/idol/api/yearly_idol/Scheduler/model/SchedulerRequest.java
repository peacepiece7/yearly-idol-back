package com.yearly.idol.api.yearly_idol.Scheduler.model;

import java.time.LocalDateTime;

public class SchedulerRequest {
    Long schedulerId;
    String content;
    String title;
    String type;
    String url;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
