package com.fbn.controller;


import com.fbn.api.Api;
import com.fbn.generateXml.RequestXml;
import com.fbn.utils.ConstantsI;
import com.fbn.utils.DbConnect;
import com.fbn.utils.LoadProp;
import com.fbn.utils.XmlParser;

import java.util.Map;
import java.util.Set;

public class Controller implements ConstantsI {
    private final XmlParser xmlParser = new XmlParser();
    private String inputXml;
    private String outputXml;

    public String getSessionId(){
        String connectXml = RequestXml.getConnectCabinetXml(LoadProp.serverCabinetName,LoadProp.serviceUserName,LoadProp.serviceUserPassword);
        try {
            String connectOutputXml = Api.executeCall(connectXml);
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
        inputXml = RequestXml.getCreateWorkItemXml(LoadProp.serverCabinetName,sessionId,processDefId,queueId,attributes,initiateFlag);
        System.out.println("input from upload api:"+inputXml);
        try {
            outputXml = Api.executeCall(inputXml);
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
        inputXml = RequestXml.getCompleteWorkItemXml(LoadProp.serverCabinetName,sessionId,wiName);
        System.out.println("input from completeworkitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from completeworkitem-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lockWorkItem(String sessionId,String wiName){
        inputXml = RequestXml.getLockWorkItemInputXml(LoadProp.serverCabinetName,sessionId,wiName);

        System.out.println("input from lock workitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from lock workitem-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void unlockWorkItem (String sessionId,String wiName){
        inputXml = RequestXml.getUnlockWorkItemXml(LoadProp.serverCabinetName,sessionId,wiName);
        System.out.println("input from unlock workitem-- "+inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from unlock workitem-- "+outputXml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setAttribute(String sessionId,String wiName,String attributeName, String value){
        inputXml = RequestXml.getAssignAttributeXml(LoadProp.serverCabinetName,sessionId,wiName,attributeName,value);
        System.out.println("input from setAttribute-- "+ inputXml);

        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from setAttribute-- "+ outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMail(String sessionId, String activityId, String processInstanceId,String processDefId, String mailFrom, String mailTo, String mailCC, String mailSubject, String mailMessage   ) {
        inputXml = RequestXml.getAddToMailQueue(LoadProp.serverCabinetName, sessionId, processDefId, activityId, processInstanceId, mailFrom, mailTo, mailCC, mailSubject, mailMessage);

        try {
            outputXml = Api.executeCall(inputXml);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void disconnectSession (String sessionId){
        inputXml = RequestXml.getDisconnectCabinetXml(LoadProp.serverCabinetName,sessionId);
        System.out.println("input from disconnect cabinet-- "+inputXml);
        try {
            outputXml = Api.executeCall(inputXml);
            System.out.println("outputXml from disconnect cabinet-- "+outputXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Set<Map<String,String>> getRecords(String query){
        return new DbConnect(RequestXml.getSelectQueryXml(query,LoadProp.serverCabinetName)).getData();
    }
    public int updateRecords(String sessionId,String tableName,String columnName, String values,String condition){
        return new DbConnect(RequestXml.getUpdateQueryXml(LoadProp.serverCabinetName,sessionId,tableName,columnName,values,condition)).saveData();
    }
    public int insertRecords(String sessionId,String tableName,String columnName, String values){
        return new DbConnect(RequestXml.getInsertQueryXml(LoadProp.serverCabinetName,sessionId,tableName,columnName,values)).saveData();
    }
    public int deleteRecords(String sessionId,String tableName,String condition){
        return new DbConnect(RequestXml.getDeleteQueryXml(LoadProp.serverCabinetName,sessionId,tableName,condition)).saveData();
    }
    private boolean success(String response){
        return response.equalsIgnoreCase("0");
    }
}




