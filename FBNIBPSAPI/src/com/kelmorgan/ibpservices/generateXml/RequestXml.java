package com.kelmorgan.ibpservices.generateXml;

public class RequestXml {

    private static final StringBuilder builder = new StringBuilder();

    public static String getDocumentListXml(String cabinetName,
                                            String sessionId, String folderIndex, String noOfRecordsToFetch) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<NGOGetDocumentListExt_Input>\n"
                + "<Option>NGOGetDocumentListExt</Option>\n"
                + "<CabinetName>" + cabinetName + "</CabinetName>\n"
                + "<UserDBId>" + sessionId + "</UserDBId>\n"
                + "<FolderIndex>" + folderIndex + "</FolderIndex>\n"
                + "<NoOfRecordsToFetch>" + noOfRecordsToFetch + "</NoOfRecordsToFetch>\n"
                + "<OrderBy>2</OrderBy>\n"
                + "<DataAlsoFlag>N</DataAlsoFlag>\n"
                + "</NGOGetDocumentListExt_Input>";
    }

    public static String getAddDocumentXml(String cabinetName,
                                           String sessionId, String folderIndex, String docSize, String noOfPages,
                                           String uploadType, String strISIndex, String appName, String docType) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<NGOAddDocument_Input>\n"
                + "<Option>NGOAddDocument</Option>\n"
                + "<CabinetName>" + cabinetName + "</CabinetName>\n"
                + "<UserDBId>" + sessionId + "</UserDBId>\n"
                + "<GroupIndex>0</GroupIndex>\n"
                + "<Document>\n"
                + "<ParentFolderIndex>" + folderIndex + "</ParentFolderIndex>\n"
                + "<NoOfPages>" + noOfPages + "</NoOfPages>\n"
                + "<AccessType>S</AccessType>\n"
                + "<DocumentName>" + uploadType + "</DocumentName>\n"
                + "<CreatedByAppName>" + appName + "</CreatedByAppName>\n"
                + "<DocumentSize>" + docSize + "</DocumentSize>\n"
                + "<ISIndex>" + strISIndex + "</ISIndex>\n"
                + "<DocumentType>" + docType + "</DocumentType>\n"
                + "<Comment>" + uploadType + "</Comment>\n"
                + "<EnableLog>Y</EnableLog>\n"
                + "<FTSFlag>PP</FTSFlag>\n"
                + "</Document>\n"
                + "</NGOAddDocument_Input>";
    }

    public static String getConnectCabinetXml(String cabinetName, String userName, String password) {
        builder.append("<?xml version=1.0?>");
        builder.append("<WMConnect_input>");
        builder.append("<Option>WMConnect</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<ApplicationInfo>127.0.0.1</ApplicationInfo>");
        builder.append("<Participant>");
        builder.append("<Name>").append(userName).append("</Name>");
        builder.append("<Password>").append(password).append("</Password>");
        builder.append("<Scope></Scope>");
        builder.append("<UserExist>Y</UserExist>");
        builder.append("<ParticipantType>U</ParticipantType>");
        builder.append("</Participant>");
        builder.append("<WMConnect_input>");

        return builder.toString();
    }

    public static String getDisconnectCabinetXml(String cabinetName, String sessionId) {
        builder.append("<?xml version=1.0?>");
        builder.append("<WMDisConnect_Input>");
        builder.append("<Option>WMDisConnect</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionID>").append(sessionId).append("</SessionID>");
        builder.append("</WMDisConnect_Input>");
        return builder.toString();
    }

    public static String getCreateWorkItemXml1(String cabinetName, String sessionId, String processDefId, String queueId, String attributes) {
        builder.append("<?xml version=1.0?>");
        builder.append("<WFUploadWorkItem_Input>");
        builder.append("<Option>WFUploadWorkItem</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionId>").append(sessionId).append("</SessionId>");
        builder.append("<ProcessDefId>").append(processDefId).append("</ProcessDefId>");
        builder.append("<VariantId></VariantId>");
        builder.append("<QueueId>").append(queueId).append("</QueueId>");
        builder.append("<InitiateFromActivityId></InitiateFromActivityId>");
        builder.append("<InitiateAlso>Y</InitiateAlso>");
        builder.append("<Attributes>").append(attributes).append("</Attributes>");
        builder.append("<Documents></Documents>");
        builder.append("</WFUploadWorkItem_Input>");
        return builder.toString();
    }

    public static String getCreateWorkItemXml(String cabinetName, String sessionId, String processDefId, String queueId, String attributes, String initiateFlag) {
        builder.append("<?xml version=1.0?>");
        builder.append("<WFUploadWorkItem_Input>");
        builder.append("<Option>WFUploadWorkItem</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionId>").append(sessionId).append("</SessionId>");
        builder.append("<ProcessDefId>").append(processDefId).append("</ProcessDefId>");
        builder.append("<QueueId>").append(queueId).append("</QueueId>");
        builder.append("<DataDefName></DataDefName>");
        builder.append("<UserDefVarFlag>Y</UserDefVarFlag>");
        builder.append("<Fields></Fields>");
        builder.append("<InitiateAlso>").append(initiateFlag).append("</InitiateAlso>");
        builder.append("<InitiateFromActivityId/>");
        builder.append("<Attributes>").append(attributes).append("</Attributes>");
        builder.append("<Documents></Documents>");
        builder.append("</WFUploadWorkItem_Input>");
        return builder.toString();
    }

    public static String getAddToMailQueue(String cabinetName, String sessionId, String processDefId, String activityId, String processInstanceId, String mailFrom, String mailTo, String mailCC, String mailSubject, String mailMessage) {
        builder.append("<?xml version=1.0?>");
        builder.append("<WFAddToMailQueue_Input>");
        builder.append("<Option>WFAddToMailQueue</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionId>").append(sessionId).append("</SessionId>");
        builder.append("<ProcessDefId>").append(processDefId).append("</ProcessDefId>");
        builder.append("<ActivityId>").append(activityId).append("<ActivityId>");
        builder.append("<ProcessInstanceId>").append(processInstanceId).append("</ProcessInstanceId>");
        builder.append("<WorkItemId>1</WorkItemId>");
        builder.append("<MailFrom>").append(mailFrom).append("</MailFrom>");
        builder.append("<MailTo>").append(mailTo).append("</MailTo>");
        builder.append("<MailCC>").append(mailCC).append("</MailCC>");
        builder.append("<MailSubject>").append(mailSubject).append("</MailSubject>");
        builder.append("<MailMessage>").append(mailMessage).append("</MailMessage>");
        builder.append("</WFAddToMailQueue_Input>");
        return builder.toString();
    }

    public static String getLockWorkItemInputXml(String cabinetName, String sessionId, String processInstanceId) {
        return "<?xml version=\"1.0\" ?>\n"
                + "<WMGetWorkItem_Input>\n"
                + "<Option>WMGetWorkItem</Option>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>\n"
                + "<WorkItemId>1</WorkItemId>\n"
                + "<Admin>Y</Admin>"
                + "</WMGetWorkItem_Input>";
    }

    public static String getUnlockWorkItemXml(String cabinetName, String sessionId, String processInstanceId) {
        return "<?xml version=\"1.0\" ?>\n"
                + "<WMUnlockWorkItem_Input>\n"
                + "<Option>WMUnlockWorkItem</Option>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>\n"
                + "<WorkItemId>1</WorkItemId>\n"
                + "<Admin>Y</Admin>"
                + "</WMUnlockWorkItem_Input>";
    }

    public static String getCompleteWorkItemXml(String cabinetName,
                                                String sessionId, String processInstanceId) {
        return "<?xml version=\"1.0\"?>\n"
                + "<WMCompleteWorkItem_Input>\n"
                + "<Option>WMCompleteWorkItem</Option>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>\n"
                + "<WorkItemId>1</WorkItemId>\n"
                + "<AuditStatus></AuditStatus>\n"
                + "<Comments></Comments>\n"
                + "</WMCompleteWorkItem_Input>\n";
    }

    public static String getFetchWorkListXml(String cabinetName, String sessionId, String queueId, String batchLimit) {

        builder.append("<?xml version='1.0'?>");
        builder.append("<WMFetchWorkList_Input>");
        builder.append("<Option>WMFetchWorkList</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionId>").append(sessionId).append("</SessionId>");
        builder.append("<CountFlag>Y</CountFlag>");
        builder.append("<DataFlag>Y</DataFlag>");
        builder.append("<ZipBuffer>N</ZipBuffer>");
        builder.append("<FetchLockedFlag>N</FetchLockedFlag>");
        builder.append("<Filter><QueueId>").append(queueId).append("</QueueId>");
        builder.append("<Type>256</Type>");
        builder.append("<Comparison>0</Comparison>");
        builder.append("<FilterString></FilterString>");
        builder.append("</Filter>");
        builder.append("<BatchInfo>");
        builder.append("<NoOfRecordsToFetch>").append(batchLimit).append("</NoOfRecordsToFetch>");
        builder.append("<OrderBy>1</OrderBy>");
        builder.append("<SortOrder>A</SortOrder>");
        builder.append("</BatchInfo>");
        builder.append("<QueueType>N</QueueType>");
        builder.append("</WMFetchWorkList_Input>");

        return builder.toString();
    }

    public static String getAssignAttributeXml(String cabinetName, String sessionId, String wiName, String attributeName, String value) {

        builder.append("<?xml version='1.0'?>");
        builder.append("<WMAssignWorkItemAttribute_Input>");
        builder.append("<Option>WMAssignWorkItemAttribute</Option>");
        builder.append("<EngineName>").append(cabinetName).append("</EngineName>");
        builder.append("<SessionId>").append(sessionId).append("</SessionId>");
        builder.append("<ProcessInstanceId>").append(wiName).append("</ProcessInstanceId>");
        builder.append("<WorkItemId>1</WorkItemId>");
        builder.append("<Attributes>");
        builder.append("<Attribute>");
        builder.append("<Name>").append(attributeName).append("</Name>");
        builder.append("<Type>10</Type>");
        builder.append("<Value>").append(value).append("</Value>");
        builder.append("</Attribute>");
        builder.append("</Attributes>");


        return builder.toString();
    }

    public static String getSelectQueryXml(String query, String cabinetName) {
        return "<?xml version=\"1.0\"?>\n"
                + "<APSelect_Input>\n"
                + "<Option>APSelectWithColumnNames</Option>\n"
                + "<Query>" + query + "</Query>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "</APSelect_Input>\n";
    }

    public static String getInsertQueryXml(String engineName,
                                           String sessionId, String tableName, String columns, String values) {
        return "<?xml version=\"1.0\"?>\n"
                + "<APInsert_Input>\n"
                + "<Option>APInsert</Option>\n"
                + "<TableName>" + tableName + "</TableName>\n"
                + "<ColName>" + columns + "</ColName>\n"
                + "<Values>" + values + "</Values>\n"
                + "<EngineName>" + engineName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "</APInsert_Input>";
    }

    public static String getUpdateQueryXml(String engineName,
                                           String sessionId, String tableName, String columnName,
                                           String values, String where) {
        return "<?xml version=\"1.0\"?>\n"
                + "<APUpdate_Input>\n"
                + "<Option>APUpdate</Option>\n"
                + "<TableName>" + tableName + "</TableName>\n"
                + "<ColName>" + columnName + "</ColName>\n"
                + "<Values>" + values + "</Values>\n"
                + "<WhereClause>" + where + "</WhereClause>\n"
                + "<EngineName>" + engineName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "</APUpdate_Input>\n";
    }

    public static String getDeleteQueryXml(String engineName,
                                           String sessionId, String tableName, String where) {
        return "<?xml version=\"1.0\"?>"
                + "<APDelete_Input><Option>APDelete</Option>" + "<TableName>"
                + tableName + "</TableName>" + "<WhereClause>" + where
                + "</WhereClause>" + "<EngineName>" + engineName
                + "</EngineName>" + "<SessionId>" + sessionId + "</SessionId>"
                + "</APDelete_Input>";
    }

    private static String connectCabinetXML(String strCabinetName, String strUserName, String strPassword) {

        builder.append("<?xml version=1.0?>");
        builder.append("<NGOConnectCabinet_Input>");
        builder.append("<Option>NGOConnectCabinet</Option>");
        builder.append("<CabinetName>").append(strCabinetName).append("</CabinetName>");
        builder.append("<UserName>" + strUserName + "</UserName><UserPassword>" + strPassword + "</UserPassword>");
        builder.append("<UserExist>N</UserExist><ListSysFolder>N</ListSysFolder>");
        builder.append("<UserType>U</UserType>");
        builder.append("</NGOConnectCabinet_Input>");

        return builder.toString();

    }

    private String getFetchWorkItemAttributesXml(String processInstanceId,
                                                 String workItemId, String sessionId, String cabinetName) {
        return "<?xml version=\"1.0\" ?>\n"
                + "<WMFetchWorkItemAttributes_Input>\n"
                + "<Option>WMFetchWorkItemAttributes</Option>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>\n"
                + "<WorkItemId>" + workItemId + "</WorkItemId>\n"
                + "</WMFetchWorkItemAttributes_Input>";
    }

    private String getGetWorkItemAttributeValueXml(String processInstanceId,
                                                   String workItemId, String sessionId, String cabinetName, String attributeName) {
        return "<?xml version=\"1.0\" ?>\n"
                + "<WMGetWorkItemAttributeValue_Input>\n"
                + "<Option>WMGetWorkItemAttributeValue</Option>\n"
                + "<EngineName>" + cabinetName + "</EngineName>\n"
                + "<SessionID>" + sessionId + "</SessionID>\n"
                + "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>\n"
                + "<WorkItemID>" + workItemId + "</WorkItemID>\n"
                + "<Attribute>\n"
                + "<Name>" + attributeName + "</Name>\n"
                + "</Attribute>\n"
                + "</ WMGetWorkItemAttributeValue_Input>";
    }

    private String getAPProcedureInputXml(String engineName,
                                          String sessionId, String param, String procName) {
        return "<?xml version=\"1.0\"?>" + "<APProcedure_Input>"
                + "<Option>APProcedure</Option>" + "<SessionId>" + sessionId
                + "</SessionId>\n" + "<ProcName>" + procName + "</ProcName>\n"
                + "<Params>" + param + "</Params>" + "<EngineName>"
                + engineName + "</EngineName>" + "<APProcedure_Input>";

    }

    private String getAPProcedureInputXML(String engineName,
                                          String sessionId, String param, String procName, String noOfCols) {
        return "<?xml version=\"1.0\"?>"
                + "<APProcedure_Input>"
                + "<Option>APProcedure</Option>"
                + "<SessionId>" + sessionId + "</SessionId>\n"
                + "<ProcName>" + procName + "</ProcName>\n"
                + "<Params>" + param + "</Params>"
                + "<EngineName>" + engineName + "</EngineName>"
                + "<NoOfCols>" + noOfCols + "</NoOfCols>"
                + "<APProcedure_Input>";

    }

    private String getAPDeleteExtdInputXml(String engineName,
                                           String tableName, String where) {
        return "<?xml version=\"1.0\"?>"
                + "<APDeleteExtd_Input>"
                + "<Option>APDeleteExtd</Option>"
                + "<TableName>" + tableName + "</TableName>"
                + "<WhereClause>" + where + "</WhereClause>"
                + "<EngineName>" + engineName + "</EngineName>"
                + "</APDeleteExtd_Input>";
    }


    private String getAPProcedureExtdInputXml(String engineName,
                                              String param, String procName) {
        return "<?xml version=\"1.0\"?>"
                + "<APProcedureExtd_Input>"
                + "<Option>APProcedureExtd</Option>"
                + "<ProcName>" + procName + "</ProcName>\n"
                + "<Params>" + param + "</Params>"
                + "<EngineName>" + engineName + "</EngineName>"
                + "<APProcedureExtd_Input>";

    }


    private String getAPUpdateExtdInputXml(String engineName,
                                           String tableName, String columnName,
                                           String values, String where) {
        return "<?xml version=\"1.0\"?>\n"
                + "<APUpdateExtd_Input>\n"
                + "<Option>APUpdateExtd</Option>\n"
                + "<TableName>" + tableName + "</TableName>\n"
                + "<ColName>" + columnName + "</ColName>\n"
                + "<Values>" + values + "</Values>\n"
                + "<WhereClause>" + where + "</WhereClause>\n"
                + "<EngineName>" + engineName + "</EngineName>\n"
                + "</APUpdateExtd_Input>\n";
    }

    private String getAPInsertExtdInputXml(String engineName,
                                           String tableName, String columns, String values) {
        return "<?xml version=\"1.0\"?>"
                + "<APInsertExtd_Input>"
                + "<Option>APInsertExtd</Option>"
                + "<TableName>" + tableName + "</TableName>"
                + "<ColName>" + columns + "</ColName>"
                + "<Values>" + values + "</Values>"
                + "<EngineName>" + engineName + "</EngineName>"
                + "</APInsertExtd_Input>";
    }
}
