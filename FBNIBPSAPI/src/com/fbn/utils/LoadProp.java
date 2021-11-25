package com.fbn.utils;

import com.fbn.service.ServiceHandler;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProp implements ConstantsI {
    private static final Logger logger = LogGen.getLoggerInstance(logName);
    public static String serverIp;
    public static String serverWrapperPort;
    public static String serverCabinetName;
    public static String serviceUserName;
    public static String serviceUserPassword;
    public static String serviceLogPath;

    static {
        try {
            Properties properties = new Properties();
            InputStream in = new FileInputStream(ServiceHandler.getConfigPath());
            properties.load(in);
            serverIp = properties.getProperty(appServerIp);
            serverWrapperPort = properties.getProperty(wrapperPort);
            serverCabinetName = properties.getProperty(cabinetName);
            serviceUserName = properties.getProperty(userName);
            serviceUserPassword = properties.getProperty(password);
            serviceLogPath = properties.getProperty(logPathField);
        } catch  (Exception e){
            logger.error("Exception occurred in reading user Config file: "+e.getMessage());
        }
    }
}
