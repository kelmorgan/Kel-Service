package com.fbn.service;

import com.fbn.controller.Controller;
import com.fbn.customService.CompleteWorkItem;
import com.fbn.customService.CreateWorkItem;
import com.fbn.utils.ConstantsI;

import java.util.Map;
import java.util.Set;

public class Service implements ConstantsI,ServiceHandler {
    private  String sessionId;
    private static String configPath;

    public Service(String sessionId) {
        this.sessionId = sessionId;
    }

    public Service() {
    }

    public static String getConfigPath() {
        return configPath;
    }
    public static void setConfigPath(String configPath) {
        Service.configPath = configPath;
    }
    @Override
    public void completeWorkItem (String wiName){
        new CompleteWorkItem(sessionId,wiName);
    }
    @Override
    public void completeWorkItem (String wiName, String tableName,String attribute, String value, String condition){
        new CompleteWorkItem(sessionId,wiName,tableName,attribute,value,condition);
    }
    @Override
    public String createWorkItem(String attributes,String processDefId,String queueId, String initiateFlag){
        return new CreateWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag).getCreatedWorkItem();
    }
    @Override
    public void disconnectCabinet(){
        new Controller().disconnectSession(sessionId);
    }
    @Override
    public Set<Map<String,String>> getRecords (String query){
        return new Controller().getRecords(query);
    }
    @Override
    public String updateRecord (String tableName, String columnName,String values, String condition){
        int update = new Controller().updateRecords(sessionId,tableName,columnName,values,condition);
        return (update == 1) ? apiSuccess : apiFailed;
    }
    @Override
    public String insertRecords (String tableName, String column,String values){
        int insertStatus = new Controller().insertRecords(sessionId,tableName,column,values);
        return (insertStatus == 1) ? apiSuccess : apiFailed;
    }

    @Override
    public  String getSessionId(String userName,String passWord){
        return new Controller().getSessionId(userName,passWord);
    }
    public static String getSessionId(){
        return new Controller().getSessionId();
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
