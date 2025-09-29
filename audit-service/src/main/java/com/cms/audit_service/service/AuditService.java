package com.cms.audit_service.service;

import com.cms.audit_service.entity.AuditEventEntity;
import com.cms.audit_service.repository.AuditRepository;
import com.cms.dto.AuditEventDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private ModelMapper mapper;

    public AuditEventDTO addAuditEvent(AuditEventDTO auditEvent){
        AuditEventEntity entity = mapper.map(auditEvent, AuditEventEntity.class);
        AuditEventEntity saved = auditRepository.save(entity);
        return mapper.map(saved, AuditEventDTO.class);
    }

}
