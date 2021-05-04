package com.fbn.utils;

import java.io.*;
import java.util.Properties;

public class LoadProp implements ConstantsI {
    public static String serverIp;
    public static String serverWrapperPort;
    public static String serverCabinetName;
    public static String serviceUserName;
    public static String serviceUserPassword;

    static {
        try {
            Properties properties = new Properties();
            InputStream in = new FileInputStream(configPath);
            properties.load(in);
            serverIp = properties.getProperty(appServerIp);
            serverWrapperPort = properties.getProperty(wrapperPort);
            serverCabinetName = properties.getProperty(cabinetName);
            serviceUserName = properties.getProperty(userName);
            serviceUserPassword = properties.getProperty(password);
        } catch  (IOException ex){
            ex.printStackTrace();
        }
    }
}
