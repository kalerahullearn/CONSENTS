package com.cms.policy_service.service;

import com.cms.dto.ApplicationDTO;
import com.cms.dto.ResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProxyHelper {

    @Autowired
    private ApplicationProxy applicationProxy;

    public ApplicationDTO getApplicationById(Long id){
        ResponseEvent<ApplicationDTO> appById = applicationProxy.getApplicationById(id);
        if(appById.isSuccess()) return appById.getData();
        return null;
    }
}
