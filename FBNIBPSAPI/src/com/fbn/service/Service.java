package com.fbn.service;

import com.fbn.controller.Controller;
import com.fbn.customService.CompleteWorkItem;
import com.fbn.customService.CreateWorkItem;

public class Service {
    private final String sessionId;
    public Service() {
        this.sessionId = new Controller().getSessionId();
    }
    public void completeWorkItem (String wiName){
        new CompleteWorkItem(sessionId,wiName);
    }
    public void completeWorkItem (String wiName, String tableName,String attribute, String value, String condition){
        new CompleteWorkItem(sessionId,wiName,tableName,attribute,value,condition);
    }
    public String createWorkItem(String attributes,String processDefId,String queueId, String initiateFlag){
        return new CreateWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag).getCreatedWorkItem();
    }
    public void disconnectCabinet(){
        new Controller().disconnectSession(sessionId);
    }
}
