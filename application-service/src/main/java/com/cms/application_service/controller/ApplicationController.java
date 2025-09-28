package com.cms.application_service.controller;

import com.cms.application_service.service.ApplicationService;
import com.cms.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @GetMapping("/")
    public List<ApplicationDTO> getAll() {
        return service.getAllApplications();
    }

    @GetMapping("/{appId}")
    public ApplicationDTO getById(@PathVariable Long appId) {
        return service.getApplicationById(appId);
    }

    @PostMapping("/")
    public ApplicationDTO create(@RequestBody ApplicationDTO app) {
        return service.createApplication(app);
    }

    @PutMapping("/{appId}")
    public ApplicationDTO update(@PathVariable Long appId, @RequestBody ApplicationDTO app) {
        return service.updateApplication(appId, app);
    }

    @DeleteMapping("/{appId}")
    public void delete(@PathVariable Long appId) {
        service.deleteApplication(appId);
    }
}
