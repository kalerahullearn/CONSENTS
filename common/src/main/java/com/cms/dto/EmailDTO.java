package com.cms.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EmailDTO {

    private String templateId;
    private List<String> toEmails;
    private List<String> ccEmails;
    private Map<String, String> dynamicContent;
}
