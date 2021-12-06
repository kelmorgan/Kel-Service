package com.fbn.service;

public interface ServiceInjector {

    Service getService(String configPath);
    Service getService(String configPath,String username, String password);
}
