package com.cms.policy_service.service;

import com.cms.dto.PolicyDTO;
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

    public List<PolicyDTO> getAllPolicies() {
        return modelMapper.map(policyRepository.findAll(), new TypeToken<>(){}.getType());
    }

    public PolicyDTO getPolicyById(Long id) {
        PolicyEntity fetchedEntity = policyRepository.findById(id).orElse(null);
        if(fetchedEntity == null) throw new RuntimeException("Policy not found");
        return modelMapper.map(fetchedEntity, PolicyDTO.class);
    }

    public PolicyDTO createPolicy(PolicyDTO policyDto) {
        PolicyEntity saved = policyRepository.save(modelMapper.map(policyDto, PolicyEntity.class));
        return modelMapper.map(saved, PolicyDTO.class);
    }

    public PolicyDTO updatePolicy(Long id, PolicyDTO dto) {
        PolicyDTO existing = getPolicyById(id);
        existing.setName(dto.getName());
        existing.setContent(dto.getContent());
        existing.setStatus(dto.getStatus());
        existing.setVersion(dto.getVersion());
        existing.setLanguage(dto.getLanguage());
        existing.setRegion(dto.getRegion());
        existing.setPolicyType(dto.getPolicyType());
        PolicyEntity updated = policyRepository.save(modelMapper.map(existing, PolicyEntity.class));
        return modelMapper.map(updated, PolicyDTO.class);
    }

    public boolean deletePolicy(Long id) {
        policyRepository.deleteById(id);
        return true;
    }
}
