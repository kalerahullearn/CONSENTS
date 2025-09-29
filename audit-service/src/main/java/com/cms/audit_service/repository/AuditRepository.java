package com.cms.audit_service.repository;

import com.cms.audit_service.entity.AuditEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEventEntity, Long> {
}
