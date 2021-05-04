package com.fbn.customService;

import com.fbn.controller.Controller;

public class CreateWorkItem {
    private final String sessionId;
    private final String initiateFlag;
    private final String attributes;
    private final String processDefId;
    private final String queueId;

    public CreateWorkItem(String sessionId,String attributes,String processDefId,String queueId, String initiateFlag) {
        this.sessionId = sessionId;
        this.attributes = attributes;
        this.initiateFlag = initiateFlag;
        this.processDefId = processDefId;
        this.queueId = queueId;
    }

    public  String getCreatedWorkItem(){
        return new Controller().getCreatedWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag);
    }
}
