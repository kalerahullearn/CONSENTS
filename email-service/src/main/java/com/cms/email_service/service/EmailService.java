package com.cms.email_service.service;

import com.cms.dto.EmailDTO;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(EmailDTO emailRequest){
      System.out.println("Email Sent:-- "+emailRequest);
    }
}
