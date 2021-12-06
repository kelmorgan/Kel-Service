package com.fbn.customService;

import com.fbn.controller.Controller;
import com.fbn.utils.LoadProp;
import org.apache.log4j.Logger;

public class CompleteWorkItem {

        private final String wiName;
        private String attribute;
        private String value;
        private final String sessionId;
        private String condition;
        private String tableName;
        private final Logger logger;
        private final LoadProp loadProp;



        public CompleteWorkItem(String sessionId, String wiName, Logger logger, LoadProp loadProp) {
            this.sessionId = sessionId;
            this.wiName = wiName;
            this.logger = logger;
            this.loadProp = loadProp;
            completeWorkItem();
        }

        public CompleteWorkItem(String sessionId, String wiName, String tableName, String attribute, String value, String condition, Logger logger, LoadProp loadProp){
            this.wiName = wiName;
            this.attribute = attribute;
            this.value = value;
            this.sessionId = sessionId;
            this.tableName = tableName;
            this.condition = condition;
            this.logger = logger;
            this.loadProp = loadProp;
            completeWorkItemWithAttribute();
        }

        private  void completeWorkItem(){
            new Controller(logger, loadProp).unlockWorkItem(sessionId,wiName);
            new Controller(logger, loadProp).lockWorkItem(sessionId,wiName);
            new Controller(logger, loadProp).completeWorkItem(sessionId,wiName);
        }
        private  void completeWorkItemWithAttribute(){
            new Controller(logger, loadProp).unlockWorkItem(sessionId,wiName);
            new Controller(logger, loadProp).lockWorkItem(sessionId,wiName);
            new Controller(logger, loadProp).updateRecords(sessionId, tableName,attribute,value,condition);
            new Controller(logger, loadProp).completeWorkItem(sessionId,wiName);
        }

}
