package com.cms.dto;

import lombok.Data;

@Data
public class PolicyDTO extends AuditDTO {

    private Long id;
    private String name;
    private String content;
    private String status;
    private int version;
    private String language;
    private String region;
    private int policyType;
    private Long appId;
}
