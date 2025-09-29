package com.cms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuditEventDTO {

    private String oldData;
    private String newData;
    private String event;
    private String action;
    private String user;
    private LocalDateTime timestamp;
}
