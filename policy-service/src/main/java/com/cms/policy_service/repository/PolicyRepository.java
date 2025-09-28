package com.cms.policy_service.repository;

import com.cms.policy_service.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {
}
