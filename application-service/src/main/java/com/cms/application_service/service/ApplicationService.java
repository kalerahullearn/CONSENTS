package com.cms.application_service.service;

import com.cms.application_service.entity.ApplicationEntity;
import com.cms.application_service.repository.ApplicationRepository;
import com.cms.dto.ApplicationDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ApplicationDTO> getAllApplications() {
        return mapper.map(applicationRepository.findAll(), new TypeToken<List<ApplicationDTO>>(){}.getType());
    }

    public ApplicationDTO getApplicationById(Long appId) {
        ApplicationEntity entity = applicationRepository.findById(appId).orElse(new ApplicationEntity());
        return mapper.map(entity, ApplicationDTO.class);
    }

    public ApplicationDTO createApplication(ApplicationDTO app) {
        ApplicationEntity appToAdd = mapper.map(app, ApplicationEntity.class);
        return mapper.map(applicationRepository.save(appToAdd), ApplicationDTO.class);
    }

    public ApplicationDTO updateApplication(Long appId, ApplicationDTO app) {
        ApplicationDTO existing = getApplicationById(appId);
        existing.setAppDisplayId(app.getAppDisplayId());
        existing.setAppName(app.getAppName());
        existing.setOwnerEmail(app.getOwnerEmail());
        existing.setDeploymentId(app.getDeploymentId());
        ApplicationEntity entityToUpdate = mapper.map(existing, ApplicationEntity.class);
        return mapper.map(applicationRepository.save(entityToUpdate), ApplicationDTO.class);
    }

    public void deleteApplication(Long appId) {

        applicationRepository.deleteById(appId);
    }
}
