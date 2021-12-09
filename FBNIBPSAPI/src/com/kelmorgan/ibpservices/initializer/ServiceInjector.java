package com.kelmorgan.ibpservices.initializer;

public interface ServiceInjector {

    ServiceHandler getService(String configPath);
    ServiceHandler getService(String configPath,String username, String password);
}
