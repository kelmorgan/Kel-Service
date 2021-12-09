package com.kelmorgan.initializer;

public interface ServiceInjector {

    ServiceHandler getService(String configPath);
    ServiceHandler getService(String configPath,String username, String password);
}
