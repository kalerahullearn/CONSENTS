package com.cms.audit_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name="audit")
public class AuditEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="old_data")
    private String oldData;
    @Column(name="new_data")
    private String newData;
    private String event;
    private String action;
    private String user;
    private LocalDateTime timestamp;
}
