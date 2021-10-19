package com.fbn.utils;

import com.fbn.service.Service;

import java.io.*;
import java.util.Properties;

public class LoadProp implements ConstantsI {
    public static String serverIp;
    public static String serverWrapperPort;
    public static String serverCabinetName;
    public static String serviceUserName;
    public static String serviceUserPassword;
    public static String serviceLogPath;

    static {
        try {
            Properties properties = new Properties();
            InputStream in = new FileInputStream(Service.getConfigPath());
            properties.load(in);
            serverIp = properties.getProperty(appServerIp);
            serverWrapperPort = properties.getProperty(wrapperPort);
            serverCabinetName = properties.getProperty(cabinetName);
            serviceUserName = properties.getProperty(userName);
            serviceUserPassword = properties.getProperty(password);
            serviceLogPath = properties.getProperty(logPathField);
        } catch  (IOException ex){
            ex.printStackTrace();
        }
    }
}
