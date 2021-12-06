package com.kelmorgan.initializer;

import com.kelmorgan.service.Service;

public interface ServiceInjector {

    Service getService(String configPath);
    Service getService(String configPath,String username, String password);
}
