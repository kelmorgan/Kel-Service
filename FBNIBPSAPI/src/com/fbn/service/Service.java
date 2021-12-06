package com.fbn.service;

import com.fbn.controller.Controller;
import com.fbn.customService.CompleteWorkItem;
import com.fbn.customService.CreateWorkItem;
import com.fbn.utils.ConstantsI;
import com.fbn.utils.LoadProp;
import com.fbn.utils.LogGen;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class Service implements ConstantsI,ServiceHandler , ServiceInjector{
    private  String sessionId;
    private  String configPath;
    private  LoadProp  loadProp;
    private Logger logger;

//    public Service(String sessionId) throws IOException {
//        this.sessionId = sessionId;
//    }


    public Service(String configPath)  {
        this.configPath = configPath;
        this.loadProp = new LoadProp(configPath);
        this.sessionId = getSessionId();
        this.logger = new LogGen(loadProp).getLoggerInstance(logName);
    }

    public Service(String configPath,String username, String password) {
        this.configPath = configPath;
        this.loadProp = new LoadProp(configPath);
        this.sessionId = getSessionId(username,password);
        this.logger = new LogGen(loadProp).getLoggerInstance(logName);
    }

    @Override
    public void completeWorkItem (String wiName){
        new CompleteWorkItem(sessionId,wiName, logger, loadProp);
    }
    @Override
    public void completeWorkItem (String wiName, String tableName,String attribute, String value, String condition){
        new CompleteWorkItem(sessionId,wiName,tableName,attribute,value,condition, logger, loadProp);
    }
    @Override
    public String createWorkItem(String attributes,String processDefId,String queueId, String initiateFlag){
        return new CreateWorkItem(sessionId,attributes,processDefId,queueId,initiateFlag, logger, loadProp).getCreatedWorkItem();
    }
    @Override
    public void disconnectCabinet(){
        new Controller(logger, loadProp).disconnectSession(sessionId);
    }
    @Override
    public Set<Map<String,String>> getRecords (String query){
        return new Controller(logger, loadProp).getRecords(query);
    }
    @Override
    public String updateRecord (String tableName, String columnName,String values, String condition){
        int update = new Controller(logger, loadProp).updateRecords(sessionId,tableName,columnName,values,condition);
        return (update == 1) ? apiSuccess : apiFailed;
    }
    @Override
    public String insertRecords (String tableName, String column,String values){
        int insertStatus = new Controller(logger, loadProp).insertRecords(sessionId,tableName,column,values);
        return (insertStatus == 1) ? apiSuccess : apiFailed;
    }

    @Override
    public  String getSessionId(String userName,String passWord){
        return new Controller(logger, loadProp).getSessionId(userName,passWord);
    }
    @Override
    public String getSessionId(){
        return new Controller(logger, loadProp).getSessionId();
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public Service getService(String configPath) {
            return new Service(configPath);
    }

    @Override
    public Service getService(String configPath, String username, String password) {
        return new Service(configPath,username,password);
    }
}
