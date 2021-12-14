package com.kelmorgan.ibpservices.initializer;

public interface ServiceInjector {

    IBPSServiceHandler getService(String configPath);
    IBPSServiceHandler getService(String configPath, String username, String password);
}
