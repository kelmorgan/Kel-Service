package com.kelmorgan.ibpservices.initializer;

import com.kelmorgan.ibpservices.service.Service;

public class ServiceInitializer implements ServiceInjector {
    @Override
    public Service getService(String configPath) {
        return new Service(configPath);
    }

    @Override
    public Service getService(String configPath, String username, String password) {
        return new Service(configPath,username,password);
    }
}
