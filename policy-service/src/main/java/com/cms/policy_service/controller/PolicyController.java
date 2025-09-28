package com.cms.policy_service.controller;

import com.cms.dto.PolicyDTO;
import com.cms.dto.ResponseEvent;
import com.cms.policy_service.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/")
    public ResponseEvent<List<PolicyDTO>> getAll() {
        List<PolicyDTO> list = policyService.getAllPolicies();
        return ResponseEvent.<List<PolicyDTO>>builder()
                .statusCode(200)
                .success(true)
                .data(list)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEvent<PolicyDTO> getById(@PathVariable Long id) {
        PolicyDTO dto = policyService.getPolicyById(id);
        return ResponseEvent.<PolicyDTO>builder()
                .statusCode(200)
                .success(true)
                .data(dto)
                .build();
    }

    @PostMapping("/")
    public ResponseEvent<PolicyDTO> create(@RequestBody PolicyDTO dto) {
        PolicyDTO created = policyService.createPolicy(dto);
        return ResponseEvent.<PolicyDTO>builder()
                .statusCode(201)
                .success(true)
                .data(created)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEvent<PolicyDTO> update(@PathVariable Long id, @RequestBody PolicyDTO dto) {
        PolicyDTO updated = policyService.updatePolicy(id, dto);
        return ResponseEvent.<PolicyDTO>builder()
                .statusCode(200)
                .success(true)
                .data(updated)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEvent<Void> delete(@PathVariable Long id) {
        boolean deleted = policyService.deletePolicy(id);
        return ResponseEvent.<Void>builder()
                .statusCode(200)
                .success(true)
                .build();
    }
}
