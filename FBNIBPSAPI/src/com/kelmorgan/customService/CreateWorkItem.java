package com.kelmorgan.customService;

import com.kelmorgan.controller.Controller;
import com.kelmorgan.utils.LoadProp;
import org.apache.log4j.Logger;


public class CreateWorkItem {
    private final String sessionId;
    private final String initiateFlag;
    private final String attributes;
    private final String processDefId;
    private final String queueId;
    private final Logger logger;
    private final LoadProp loadProp;

    public CreateWorkItem(String sessionId, String attributes, String processDefId, String queueId, String initiateFlag, Logger logger, LoadProp loadProp) {
        this.sessionId = sessionId;
        this.attributes = attributes;
        this.initiateFlag = initiateFlag;
        this.processDefId = processDefId;
        this.queueId = queueId;
        this.logger = logger;
        this.loadProp = loadProp;
    }

    public  String getCreatedWorkItem(){
        return new Controller(logger, loadProp).getCreatedWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag);
    }
}
