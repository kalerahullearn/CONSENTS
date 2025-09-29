package com.cms.policy_service.service;

import com.cms.dto.ApplicationDTO;
import com.cms.dto.PolicyDTO;
import com.cms.exception.EntityNotFoundException;
import com.cms.policy_service.entity.PolicyEntity;
import com.cms.policy_service.repository.PolicyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ApplicationProxyHelper applicationProxyHelper;

    public List<PolicyDTO> getAllPolicies() {
        return modelMapper.map(policyRepository.findAll(), new TypeToken<>(){}.getType());
    }

    public PolicyDTO getPolicyById(Long id) {
        PolicyEntity fetchedEntity = policyRepository.findById(id).orElse(null);
        if(fetchedEntity == null) throw new EntityNotFoundException("Policy not found");
        return modelMapper.map(fetchedEntity, PolicyDTO.class);
    }

    public PolicyDTO createPolicy(PolicyDTO policyDto) {
        ApplicationDTO appById = applicationProxyHelper.getApplicationById(policyDto.getAppId());
        if(appById == null) throw new EntityNotFoundException("Application not found");
        PolicyEntity saved = policyRepository.save(modelMapper.map(policyDto, PolicyEntity.class));
        return modelMapper.map(saved, PolicyDTO.class);
    }

    public PolicyDTO updatePolicy(Long id, PolicyDTO policyDto) {
        ApplicationDTO appById = applicationProxyHelper.getApplicationById(policyDto.getAppId());
        if(appById == null) throw new EntityNotFoundException("Application not found");

        PolicyDTO existing = getPolicyById(id);
        existing.setName(policyDto.getName());
        existing.setContent(policyDto.getContent());
        existing.setStatus(policyDto.getStatus());
        existing.setVersion(policyDto.getVersion());
        existing.setLanguage(policyDto.getLanguage());
        existing.setRegion(policyDto.getRegion());
        existing.setPolicyType(policyDto.getPolicyType());
        PolicyEntity updated = policyRepository.save(modelMapper.map(existing, PolicyEntity.class));
        return modelMapper.map(updated, PolicyDTO.class);
    }

    public boolean deletePolicy(Long id) {
        policyRepository.deleteById(id);
        return true;
    }
}
