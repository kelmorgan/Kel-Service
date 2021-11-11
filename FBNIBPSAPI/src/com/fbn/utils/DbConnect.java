package com.fbn.utils;


import com.fbn.api.Api;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class DbConnect implements ConstantsI{
    private final Logger logger = LogGen.getLoggerInstance(logName);
    private final String queryXml;
    private String outputXml;
    private final XmlParser xmlParser = new XmlParser();
    public DbConnect(String queryXml){
        this.queryXml = queryXml;
    }

    public Set<Map<String,String>> getData() {
        try {
            logger.info("Get Data Query: "+queryXml);
            outputXml = Api.executeCall(queryXml);
            logger.info("Get Data Result: "+outputXml);
            System.out.println(outputXml);
            xmlParser.setInputXML(outputXml);

            if (success(xmlParser.getValueOf("MainCode")))
                return xmlParser.getXMLData(outputXml,"Record");
        } catch (Exception e) {
            logger.error("Exception occurred in getData Method: "+e.getMessage());
        }
        return null;
    }
    public int saveData (){
        try {
            logger.info("Save Data Query: "+queryXml);
            outputXml = Api.executeCall(queryXml);
            logger.info("Save Data Result: "+outputXml);
            System.out.println(outputXml);
            xmlParser.setInputXML(outputXml);
            if (success(xmlParser.getValueOf("MainCode")))
                return 1;
        } catch (Exception e) {
            logger.error("Exception occurred in saveData Method: "+e.getMessage());
        }
        return -1;
    }

    private boolean success(String response){
        return response.equalsIgnoreCase("0");
    }
}

