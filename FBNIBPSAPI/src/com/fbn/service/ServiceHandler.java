package com.fbn.service;

import com.fbn.controller.Controller;

import java.util.Map;
import java.util.Set;

public interface ServiceHandler {

    void completeWorkItem(String wiName);
    void completeWorkItem(String wiName, String tableName, String attribute, String value, String condition);
    String createWorkItem(String attributes, String processDefId, String queueId, String initiateFlag);
    void disconnectCabinet();
    Set<Map<String,String>> getRecords(String query);
    String updateRecord(String tableName, String columnName, String values, String condition);
    String insertRecords(String tableName, String column, String values);
    String getSessionId(String userName,String passWord);
}
