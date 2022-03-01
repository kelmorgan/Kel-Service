package com.kelmorgan.ibpservices.initializer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IBPSServiceHandler {
    String completeWorkItem(String wiName);
    String completeWorkItem(String wiName, String tableName, String attribute, String value, String condition);
    String createWorkItem(String attributes, String processDefId, String queueId, String initiateFlag);
    void disconnectCabinet();
    Set<Map<String,String>> getRecords(String query);
    String updateRecord(String tableName, String columnName, String values, String condition);
    String insertRecords(String tableName, String column, String values);
    String getSessionId(String userName,String passWord);
    String getSessionId();
    void setSessionId(String sessionId);
    void addDocument(String folderIndex,String documentSize, String pageCount,String uploadType, String ISIndex,String appName,String docType);
    List<Map<String,String>> getDocumentList(String wiName, String numberOfRecords);

}
