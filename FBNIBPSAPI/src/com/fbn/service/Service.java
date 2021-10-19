package com.fbn.service;

import com.fbn.controller.Controller;
import com.fbn.customService.CompleteWorkItem;
import com.fbn.customService.CreateWorkItem;
import com.fbn.utils.ConstantsI;
import com.fbn.utils.LoadProp;

import java.util.Map;
import java.util.Set;

public class Service implements ConstantsI {
    private final String sessionId;
    private static String configPath;

    public Service(String sessionId) {
        this.sessionId = sessionId;
    }

    public static String getConfigPath() {
        return configPath;
    }
    public static void setConfigPath(String configPath) {
        Service.configPath = configPath;
    }
    public void completeWorkItem (String wiName){
        new CompleteWorkItem(sessionId,wiName);
    }
    public void completeWorkItem (String wiName, String tableName,String attribute, String value, String condition){
    	//test change
        new CompleteWorkItem(sessionId,wiName,tableName,attribute,value,condition);
    }
    public String createWorkItem(String attributes,String processDefId,String queueId, String initiateFlag){
        return new CreateWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag).getCreatedWorkItem();
    }
    public void disconnectCabinet(){
        new Controller().disconnectSession(sessionId);
    }
    public Set<Map<String,String>> getRecords (String query){
        return new Controller().getRecords(query);
    }
    public String updateRecord (String tableName, String columnName,String values, String condition){
        int update = new Controller().updateRecords(sessionId,tableName,columnName,values,condition);
        return (update == 1) ? apiSuccess : apiFailed;
    }
    public String insertRecords (String tableName, String column,String values){
        int insertStatus = new Controller().insertRecords(sessionId,tableName,column,values);
        return (insertStatus == 1) ? apiSuccess : apiFailed;
    }
    public static String getSessionId(String userName,String passWord){
        return new Controller().getSessionId(userName,passWord);
    }
    public static String getSessionId(){
        return new Controller().getSessionId();
    }

}
