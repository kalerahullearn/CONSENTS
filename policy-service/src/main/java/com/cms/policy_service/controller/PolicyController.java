package com.cms.policy_service.controller;

import com.cms.dto.PolicyDTO;
import com.cms.dto.ResponseEvent;
import com.cms.policy_service.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/")
    public ResponseEntity<ResponseEvent<List<PolicyDTO>>> getAll() {
        List<PolicyDTO> list = policyService.getAllPolicies();
        return ResponseEntity.ok(ResponseEvent.<List<PolicyDTO>>builder()
                .statusCode(200)
                .success(true)
                .data(list)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEvent<PolicyDTO>> getById(@PathVariable Long id) {
        PolicyDTO dto = policyService.getPolicyById(id);
        return ResponseEntity.ok(ResponseEvent.<PolicyDTO>builder()
                .statusCode(200)
                .success(true)
                .data(dto)
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseEvent<PolicyDTO>> create(@RequestBody PolicyDTO dto) {
        PolicyDTO created = policyService.createPolicy(dto);
        return ResponseEntity.ok(ResponseEvent.<PolicyDTO>builder()
                .statusCode(201)
                .success(true)
                .data(created)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseEvent<PolicyDTO>> update(@PathVariable Long id, @RequestBody PolicyDTO dto) {
        PolicyDTO updated = policyService.updatePolicy(id, dto);
        return ResponseEntity.ok(ResponseEvent.<PolicyDTO>builder()
                .statusCode(200)
                .success(true)
                .data(updated)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEvent<Void>> delete(@PathVariable Long id) {
        boolean deleted = policyService.deletePolicy(id);
        return ResponseEntity.ok(ResponseEvent.<Void>builder()
                .statusCode(200)
                .success(true)
                .build());
    }
}
