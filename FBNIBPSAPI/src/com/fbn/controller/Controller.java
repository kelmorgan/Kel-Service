package com.fbn.controller;


import com.fbn.api.Api;
import com.fbn.generateXml.RequestXml;
import com.fbn.utils.*;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class Controller implements ConstantsI {
    private final Logger logger = LogGen.getLoggerInstance("Service Logger");
    private final XmlParser xmlParser = new XmlParser();
    private String inputXml;
    private String outputXml;

    public String getSessionId(String userName,String passWord){
        logger.info("Welcome to getSession method");
        String connectXml = RequestXml.getConnectCabinetXml(LoadProp.serverCabinetName,userName,passWord);
        logger.info("connectXml: "+connectXml);
        try {
            String connectOutputXml = Api.executeCall(connectXml);
            logger.info("connectOutputXml: "+connectOutputXml);
            System.out.println("output from connect api:"+connectOutputXml);
            xmlParser.setInputXML(connectOutputXml);

            if (success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("SessionId");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getSessionId(){
        logger.info("Welcome to getSession method");
        String connectXml = RequestXml.getConnectCabinetXml(LoadProp.serverCabinetName,LoadProp.serviceUserName,LoadProp.serviceUserPassword);
        logger.info("connectXml: "+connectXml);
        try {
            String connectOutputXml = Api.executeCall(connectXml);
            logger.info("connectOutputXml: "+connectOutputXml);
            System.out.println("output from connect api:"+connectOutputXml);
            xmlParser.setInputXML(connectOutputXml);

            if (success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("SessionId");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getCreatedWorkItem(String sessionId,String attributes,String processDefId, String queueId,String initiateFlag){
        logger.info("Welcome to Created WorkItem method");
        inputXml = RequestXml.getCreateWorkItemXml(LoadProp.serverCabinetName,sessionId,processDefId,queueId,attributes,initiateFlag);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from upload api:"+inputXml);
        try {
            outputXml = Api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("output from upload api:"+outputXml);
            xmlParser.setInputXML(outputXml);
            if(success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("ProcessInstanceId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void completeWorkItem (String sessionId, String wiName) {
        logger.info("Welcome to Complete WorkItem method");
        inputXml = RequestXml.getCompleteWorkItemXml(LoadProp.serverCabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from completeworkitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from completeworkitem-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lockWorkItem(String sessionId,String wiName){
        logger.info("Welcome to Lock WorkItem method");
        inputXml = RequestXml.getLockWorkItemInputXml(LoadProp.serverCabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);

        System.out.println("input from lock workitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from lock workitem-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void unlockWorkItem (String sessionId,String wiName){
        logger.info("Welcome to unlock WorkItem method");
        inputXml = RequestXml.getUnlockWorkItemXml(LoadProp.serverCabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from unlock workitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from unlock workitem-- "+outputXml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setAttribute(String sessionId,String wiName,String attributeName, String value){
        logger.info("Welcome to setAttribute method");
        inputXml = RequestXml.getAssignAttributeXml(LoadProp.serverCabinetName,sessionId,wiName,attributeName,value);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from setAttribute-- "+ inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from setAttribute-- "+ outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMail(String sessionId, String activityId, String processInstanceId,String processDefId, String mailFrom, String mailTo, String mailCC, String mailSubject, String mailMessage   ) {
        logger.info("Welcome to sendMail method");
        inputXml = RequestXml.getAddToMailQueue(LoadProp.serverCabinetName, sessionId, processDefId, activityId, processInstanceId, mailFrom, mailTo, mailCC, mailSubject, mailMessage);
        logger.info("inputXml: "+inputXml);
        try {
            outputXml = Api.executeCall(inputXml);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void disconnectSession (String sessionId){
        logger.info("Welcome to Disconnect Session method");
        inputXml = RequestXml.getDisconnectCabinetXml(LoadProp.serverCabinetName,sessionId);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from disconnect cabinet-- "+inputXml);
        try {
            outputXml = Api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from disconnect cabinet-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Set<Map<String,String>> getRecords(String query){
        logger.info("Welcome to getRecords method");
        return new DbConnect(RequestXml.getSelectQueryXml(query,LoadProp.serverCabinetName)).getData();
    }
    public int updateRecords(String sessionId, String tableName, String columnName, String values, String condition){
        logger.info("Welcome to Update Records method");
       return new DbConnect(RequestXml.getUpdateQueryXml(LoadProp.serverCabinetName, sessionId, tableName, columnName, values, condition)).saveData();
    }
    public int insertRecords(String sessionId,String tableName,String columnName, String values){
        logger.info("Welcome to Insert Records method");
        return new DbConnect(RequestXml.getInsertQueryXml(LoadProp.serverCabinetName,sessionId,tableName,columnName,values)).saveData();
    }
    public int deleteRecords(String sessionId,String tableName,String condition){
        return new DbConnect(RequestXml.getDeleteQueryXml(LoadProp.serverCabinetName,sessionId,tableName,condition)).saveData();
    }
    private boolean success(String response){
        return response.equalsIgnoreCase("0");
    }
}




