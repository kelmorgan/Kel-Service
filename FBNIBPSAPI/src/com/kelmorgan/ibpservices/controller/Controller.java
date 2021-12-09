package com.kelmorgan.ibpservices.controller;


import com.kelmorgan.ibpservices.api.Api;
import com.kelmorgan.ibpservices.generateXml.RequestXml;
import com.kelmorgan.ibpservices.utils.Constants;
import com.kelmorgan.ibpservices.utils.DbConnect;
import com.kelmorgan.ibpservices.utils.LoadProp;
import com.kelmorgan.ibpservices.utils.XmlParser;
import com.kelmorgan.utils.*;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class Controller implements Constants {
    private final Logger logger;
    private final XmlParser xmlParser = new XmlParser();
    private String inputXml;
    private String outputXml;
    private final String cabinetName;
    private final String username;
    private final String password;
    private final Api api;

    public Controller(Logger logger, LoadProp loadProp) {
        this.logger = logger;
        this.cabinetName = loadProp.getServerCabinetName();
        this.username = loadProp.getServiceUserName();
        this.password = loadProp.getServiceUserPassword();
        this.api = new Api(loadProp);
    }

    public String getSessionId(String userName,String passWord){
        logger.info("Welcome to getSession method");
        String connectXml = RequestXml.getConnectCabinetXml(cabinetName,userName,passWord);
        logger.info("connectXml: "+connectXml);
        try {
            String connectOutputXml = api.executeCall(connectXml);
            logger.info("connectOutputXml: "+connectOutputXml);
            System.out.println("output from connect api:"+connectOutputXml);
            xmlParser.setInputXML(connectOutputXml);

            if (success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("SessionId");

        } catch (Exception e) {
           logger.error("Exception occurred in getSessionId Method: "+e.getMessage());
        }
        return null;
    }
    public String getSessionId(){
        logger.info("Welcome to getSession method");
        String connectXml = RequestXml.getConnectCabinetXml(cabinetName,username,password);
        logger.info("connectXml: "+connectXml);
        try {
            String connectOutputXml = api.executeCall(connectXml);
            logger.info("connectOutputXml: "+connectOutputXml);
            System.out.println("output from connect api:"+connectOutputXml);
            xmlParser.setInputXML(connectOutputXml);

            if (success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("SessionId");

        } catch (Exception e) {
            logger.error("Exception occurred in getSessionId Method: "+e.getMessage());
        }
        return null;
    }
    public String getCreatedWorkItem(String sessionId,String attributes,String processDefId, String queueId,String initiateFlag){
        logger.info("Welcome to Created WorkItem method");
        inputXml = RequestXml.getCreateWorkItemXml(cabinetName,sessionId,processDefId,queueId,attributes,initiateFlag);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from upload api:"+inputXml);
        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("output from upload api:"+outputXml);
            xmlParser.setInputXML(outputXml);
            if(success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getValueOf("ProcessInstanceId");
        } catch (Exception e) {
            logger.error("Exception occurred in create workitem Method: "+e.getMessage());
        }
        return null;
    }
    public String completeWorkItem (String sessionId, String wiName) {
        logger.info("Welcome to Complete WorkItem method");
        inputXml = RequestXml.getCompleteWorkItemXml(cabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from completeworkitem-- "+inputXml);

        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from completeworkitem-- "+outputXml);
            xmlParser.setInputXML(outputXml);

            if (success(xmlParser.getValueOf("MainCode")))  return apiSuccess;
        } catch (Exception e) {
            logger.error("Exception occurred in complete Method: "+e.getMessage());
        }
        return apiFailed;
    }
    public void lockWorkItem(String sessionId,String wiName){
        logger.info("Welcome to Lock WorkItem method");
        inputXml = RequestXml.getLockWorkItemInputXml(cabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);

        System.out.println("input from lock workitem-- "+inputXml);

        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from lock workitem-- "+outputXml);
        } catch (Exception e) {
            logger.error("Exception occurred in lock workitem Method: "+e.getMessage());
        }
    }
    public void unlockWorkItem (String sessionId,String wiName){
        logger.info("Welcome to unlock WorkItem method");
        inputXml = RequestXml.getUnlockWorkItemXml(cabinetName,sessionId,wiName);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from unlock workitem-- "+inputXml);

        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from unlock workitem-- "+outputXml);

        } catch (Exception e) {
            logger.error("Exception occurred in unlock workitem Method: "+e.getMessage());
        }
    }
    public void setAttribute(String sessionId,String wiName,String attributeName, String value){
        logger.info("Welcome to setAttribute method");
        inputXml = RequestXml.getAssignAttributeXml(cabinetName,sessionId,wiName,attributeName,value);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from setAttribute-- "+ inputXml);

        try {
            outputXml = api.executeCall(inputXml);
            System.out.println("outputXml from setAttribute-- "+ outputXml);
        } catch (Exception e) {
            logger.error("Exception occurred in setAttribute Method: "+e.getMessage());
        }
    }
    public void sendMail(String sessionId, String activityId, String processInstanceId,String processDefId, String mailFrom, String mailTo, String mailCC, String mailSubject, String mailMessage   ) {
        logger.info("Welcome to sendMail method");
        inputXml = RequestXml.getAddToMailQueue(cabinetName, sessionId, processDefId, activityId, processInstanceId, mailFrom, mailTo, mailCC, mailSubject, mailMessage);
        logger.info("inputXml: "+inputXml);
        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);

        } catch (Exception e) {
            logger.error("Exception occurred in sendMail Method: "+e.getMessage());
        }

    }
    public void disconnectSession (String sessionId){
        logger.info("Welcome to Disconnect Session method");
        inputXml = RequestXml.getDisconnectCabinetXml(cabinetName,sessionId);
        logger.info("inputXml: "+inputXml);
        System.out.println("input from disconnect cabinet-- "+inputXml);
        try {
            outputXml = api.executeCall(inputXml);
            logger.info("outputXml: "+outputXml);
            System.out.println("outputXml from disconnect cabinet-- "+outputXml);
        } catch (Exception e) {
            logger.error("Exception occurred in disconnect cabinet Method: "+e.getMessage());
        }
    }
    public Set<Map<String,String>> getRecords(String query){
        logger.info("Welcome to getRecords method");
        return new DbConnect(logger,api, RequestXml.getSelectQueryXml(query,cabinetName)).getData();
    }
    public int updateRecords(String sessionId, String tableName, String columnName, String values, String condition){
        logger.info("Welcome to Update Records method");
       return new DbConnect(logger,api, RequestXml.getUpdateQueryXml(cabinetName, sessionId, tableName, columnName, values, condition)).saveData();
    }
    public int insertRecords(String sessionId,String tableName,String columnName, String values){
        logger.info("Welcome to Insert Records method");
        return new DbConnect(logger,api, RequestXml.getInsertQueryXml(cabinetName,sessionId,tableName,columnName,values)).saveData();
    }
    public int deleteRecords(String sessionId,String tableName,String condition){
        return new DbConnect(logger,api, RequestXml.getDeleteQueryXml(cabinetName,sessionId,tableName,condition)).saveData();
    }
    private boolean success(String response){
        return response.equalsIgnoreCase("0");
    }
}




