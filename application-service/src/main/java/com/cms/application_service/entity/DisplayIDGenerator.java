package com.cms.application_service.entity;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class DisplayIDGenerator {

    public static String generate() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
