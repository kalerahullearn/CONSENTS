package com.cms.policy_service.service;

import com.cms.dto.ApplicationDTO;
import com.cms.dto.ResponseEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "APPLICATION-SERVICE")
public interface ApplicationProxy {

    final String APPLICATION_BASE_URL = "application/api/v1";

    @GetMapping(APPLICATION_BASE_URL+"/{id}")
    ResponseEvent<ApplicationDTO> getApplicationById(@PathVariable Long id);
}
