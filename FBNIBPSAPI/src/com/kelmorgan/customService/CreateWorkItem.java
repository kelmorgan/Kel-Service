package com.kelmorgan.customService;

import com.kelmorgan.controller.Controller;


public class CreateWorkItem {
    private final String sessionId;
    private final String initiateFlag;
    private final String attributes;
    private final String processDefId;
    private final String queueId;
    private final Controller controller;

    public CreateWorkItem(String sessionId, String attributes, String processDefId, String queueId, String initiateFlag, Controller controller) {
        this.sessionId = sessionId;
        this.attributes = attributes;
        this.initiateFlag = initiateFlag;
        this.processDefId = processDefId;
        this.queueId = queueId;
        this.controller = controller;
    }

    public  String getCreatedWorkItem(){
        return controller.getCreatedWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag);
    }
}
