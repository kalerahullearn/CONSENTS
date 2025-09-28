package com.cms.dto;

import lombok.Data;

@Data
public class ApplicationDTO extends AuditDTO {

    private Long appId;
    private String appDisplayId;
    private String appName;
    private String ownerEmail;
    private String deploymentId;
}
