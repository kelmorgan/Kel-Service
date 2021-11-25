package com.fbn.service;

import java.util.Map;
import java.util.Set;

public interface ServiceHandler {
    static void setConfigPath(String configPath) {Service.setConfigPath(configPath);}
    static String getConfigPath() {return Service.getConfigPath();}
    static String getSessionId(){return Service.getSessionId();}
    void completeWorkItem(String wiName);
    void completeWorkItem(String wiName, String tableName, String attribute, String value, String condition);
    String createWorkItem(String attributes, String processDefId, String queueId, String initiateFlag);
    void disconnectCabinet();
    Set<Map<String,String>> getRecords(String query);
    String updateRecord(String tableName, String columnName, String values, String condition);
    String insertRecords(String tableName, String column, String values);
    String getSessionId(String userName,String passWord);
}
