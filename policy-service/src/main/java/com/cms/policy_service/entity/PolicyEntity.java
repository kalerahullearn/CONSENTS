package com.cms.policy_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="policies")
public class PolicyEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String content;
    private String status;
    private int version;
    private String language;
    private String region;
    @Column(name="policy_type")
    private int policyType;
    private Long appId;
}
