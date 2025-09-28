package com.cms.application_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "applications")
@Data
public class ApplicationEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String appId;
    @Column(name = "app_display_id")
    private String appDisplayId;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "owner_email")
    private String ownerEmail;
    @Column(name = "deployment_id")
    private String deploymentId;
}
