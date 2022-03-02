package com.kelmorgan.ibpservices.generateXml;

public class RequestXml {

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

        return "<?xml version=1.0?>" +
                "<WMConnect_input>" +
                "<Option>WMConnect</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<ApplicationInfo>127.0.0.1</ApplicationInfo>" +
                "<Participant>" +
                "<Name>" + userName + "</Name>" +
                "<Password>" + password + "</Password>" +
                "<Scope></Scope>" +
                "<UserExist>Y</UserExist>" +
                "<ParticipantType>U</ParticipantType>" +
                "</Participant>" +
                "<WMConnect_input>";
    }

    public static String getDisconnectCabinetXml(String cabinetName, String sessionId) {

        return "<?xml version=1.0?>" +
                "<WMDisConnect_Input>" +
                "<Option>WMDisConnect</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionID>" + sessionId + "</SessionID>" +
                "</WMDisConnect_Input>";
    }

    public static String getCreateWorkItemXml1(String cabinetName, String sessionId, String processDefId, String queueId, String attributes) {

        return "<?xml version=1.0?>" +
                "<WFUploadWorkItem_Input>" +
                "<Option>WFUploadWorkItem</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionId>" + sessionId + "</SessionId>" +
                "<ProcessDefId>" + processDefId + "</ProcessDefId>" +
                "<VariantId></VariantId>" +
                "<QueueId>" + queueId + "</QueueId>" +
                "<InitiateFromActivityId></InitiateFromActivityId>" +
                "<InitiateAlso>Y</InitiateAlso>" +
                "<Attributes>" + attributes + "</Attributes>" +
                "<Documents></Documents>" +
                "</WFUploadWorkItem_Input>";
    }

    public static String getCreateWorkItemXml(String cabinetName, String sessionId, String processDefId, String queueId, String attributes, String initiateFlag) {

        return "<?xml version=1.0?>" +
                "<WFUploadWorkItem_Input>" +
                "<Option>WFUploadWorkItem</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionId>" + sessionId + "</SessionId>" +
                "<ProcessDefId>" + processDefId + "</ProcessDefId>" +
                "<QueueId>" + queueId + "</QueueId>" +
                "<DataDefName></DataDefName>" +
                "<UserDefVarFlag>Y</UserDefVarFlag>" +
                "<Fields></Fields>" +
                "<InitiateAlso>" + initiateFlag + "</InitiateAlso>" +
                "<InitiateFromActivityId/>" +
                "<Attributes>" + attributes + "</Attributes>" +
                "<Documents></Documents>" +
                "</WFUploadWorkItem_Input>";
    }

    public static String getAddToMailQueue(String cabinetName, String sessionId, String processDefId, String activityId, String processInstanceId, String mailFrom, String mailTo, String mailCC, String mailSubject, String mailMessage) {

        return "<?xml version=1.0?>" +
                "<WFAddToMailQueue_Input>" +
                "<Option>WFAddToMailQueue</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionId>" + sessionId + "</SessionId>" +
                "<ProcessDefId>" + processDefId + "</ProcessDefId>" +
                "<ActivityId>" + activityId + "<ActivityId>" +
                "<ProcessInstanceId>" + processInstanceId + "</ProcessInstanceId>" +
                "<WorkItemId>1</WorkItemId>" +
                "<MailFrom>" + mailFrom + "</MailFrom>" +
                "<MailTo>" + mailTo + "</MailTo>" +
                "<MailCC>" + mailCC + "</MailCC>" +
                "<MailSubject>" + mailSubject + "</MailSubject>" +
                "<MailMessage>" + mailMessage + "</MailMessage>" +
                "</WFAddToMailQueue_Input>";
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

        return "<?xml version='1.0'?>" +
                "<WMFetchWorkList_Input>" +
                "<Option>WMFetchWorkList</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionId>" + sessionId + "</SessionId>" +
                "<CountFlag>Y</CountFlag>" +
                "<DataFlag>Y</DataFlag>" +
                "<ZipBuffer>N</ZipBuffer>" +
                "<FetchLockedFlag>N</FetchLockedFlag>" +
                "<Filter><QueueId>" + queueId + "</QueueId>" +
                "<Type>256</Type>" +
                "<Comparison>0</Comparison>" +
                "<FilterString></FilterString>" +
                "</Filter>" +
                "<BatchInfo>" +
                "<NoOfRecordsToFetch>" + batchLimit + "</NoOfRecordsToFetch>" +
                "<OrderBy>1</OrderBy>" +
                "<SortOrder>A</SortOrder>" +
                "</BatchInfo>" +
                "<QueueType>N</QueueType>" +
                "</WMFetchWorkList_Input>";
    }

    public static String getAssignAttributeXml(String cabinetName, String sessionId, String wiName, String attributeName, String value) {


        return "<?xml version='1.0'?>" +
                "<WMAssignWorkItemAttribute_Input>" +
                "<Option>WMAssignWorkItemAttribute</Option>" +
                "<EngineName>" + cabinetName + "</EngineName>" +
                "<SessionId>" + sessionId + "</SessionId>" +
                "<ProcessInstanceId>" + wiName + "</ProcessInstanceId>" +
                "<WorkItemId>1</WorkItemId>" +
                "<Attributes>" +
                "<Attribute>" +
                "<Name>" + attributeName + "</Name>" +
                "<Type>10</Type>" +
                "<Value>" + value + "</Value>" +
                "</Attribute>" +
                "</Attributes>";
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

        return "<?xml version=1.0?>" +
                "<NGOConnectCabinet_Input>" +
                "<Option>NGOConnectCabinet</Option>" +
                "<CabinetName>" + strCabinetName + "</CabinetName>" +
                "<UserName>" + strUserName + "</UserName><UserPassword>" + strPassword + "</UserPassword>" +
                "<UserExist>N</UserExist><ListSysFolder>N</ListSysFolder>" +
                "<UserType>U</UserType>" +
                "</NGOConnectCabinet_Input>";

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
