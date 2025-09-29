package com.cms.application_service.controller;

import com.cms.application_service.service.ApplicationService;
import com.cms.dto.ApplicationDTO;
import com.cms.dto.ResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @GetMapping("/")
    public ResponseEntity<ResponseEvent<List<ApplicationDTO>>> getAll() {
        return ResponseEntity.ok(ResponseEvent.<List<ApplicationDTO>>builder().statusCode(200).success(true).data(service.getAllApplications()).build());
    }

    @GetMapping("/{appId}")
    public ResponseEntity<ResponseEvent<ApplicationDTO>> getById(@PathVariable Long appId) {
        return ResponseEntity.ok(ResponseEvent.<ApplicationDTO>builder().success(true).statusCode(200).data(service.getApplicationById(appId)).build());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseEvent<ApplicationDTO>> create(@RequestBody ApplicationDTO app) {
        return ResponseEntity.ok(ResponseEvent.<ApplicationDTO>builder().statusCode(201).success(true).data(service.createApplication(app)).build());
    }

    @PutMapping("/{appId}")
    public ResponseEntity<ResponseEvent<ApplicationDTO>> update(@PathVariable Long appId, @RequestBody ApplicationDTO app) {
        return ResponseEntity.ok(ResponseEvent.<ApplicationDTO>builder().statusCode(200).success(true).data(service.updateApplication(appId, app)).build());
    }

    @DeleteMapping("/{appId}")
    public ResponseEntity<ResponseEvent> delete(@PathVariable Long appId) {
        service.deleteApplication(appId);
        return ResponseEntity.ok(ResponseEvent.builder().success(true).statusCode(200).build());
    }
}
