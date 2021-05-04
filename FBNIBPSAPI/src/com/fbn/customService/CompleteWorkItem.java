package com.fbn.customService;

import com.fbn.controller.Controller;

public class CompleteWorkItem {

        private final String wiName;
        private String attribute;
        private String value;
        private final String sessionId;
        private String condition;
        private String tableName;



        public CompleteWorkItem(String sessionId, String  wiName) {
            this.sessionId = sessionId;
            this.wiName = wiName;
            completeWorkItem();
        }

        public CompleteWorkItem(String sessionId,String wiName,String tableName, String attribute,String value, String condition){
            this.wiName = wiName;
            this.attribute = attribute;
            this.value = value;
            this.sessionId = sessionId;
            this.tableName = tableName;
            this.condition = condition;
            completeWorkItemWithAttribute();
        }

        private  void completeWorkItem(){
            new Controller().unlockWorkItem(sessionId,wiName);
            new Controller().lockWorkItem(sessionId,wiName);
            new Controller().completeWorkItem(sessionId,wiName);
        }
        private  void completeWorkItemWithAttribute(){
            new Controller().unlockWorkItem(sessionId,wiName);
            new Controller().lockWorkItem(sessionId,wiName);
            new Controller().updateRecords(sessionId, tableName,attribute,value,condition);
            new Controller().completeWorkItem(sessionId,wiName);
        }

}
