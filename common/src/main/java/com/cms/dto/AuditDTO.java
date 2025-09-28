package com.cms.dto;

import lombok.Data;

@Data
public class AuditDTO {

    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
}
