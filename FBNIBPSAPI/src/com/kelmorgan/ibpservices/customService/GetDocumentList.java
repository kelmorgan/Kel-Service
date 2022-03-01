package com.kelmorgan.ibpservices.customService;

import com.kelmorgan.ibpservices.controller.Controller;
import com.kelmorgan.ibpservices.utils.Constants;
import com.kelmorgan.ibpservices.utils.XmlParser;

import java.util.*;

public class GetDocumentList implements Constants {

    private final String wiName;
    private final String sessionId;
    private final Controller controller;
    private final String noOfRecord;
    private final XmlParser parser = new XmlParser();

    private final List<Map<String, String>> documents = new ArrayList<>();

    public GetDocumentList(String wiName, String sessionId, Controller controller, String noOfRecord) {
        this.wiName = wiName;
        this.sessionId = sessionId;
        this.controller = controller;
        this.noOfRecord = noOfRecord;
    }

    public List<Map<String, String>> getDocuments() {
        try {

            String documentOutput = controller.getDocumentListAttached(sessionId, wiName, noOfRecord);

            if (!documentOutput.isEmpty()) {
                parser.setInputXML(documentOutput);

                if (isSuccess(parser.getValueOf("Status"))) {
                    if (doesRecordExists(parser.getValueOf("NoOfRecordsFetched"))) {
                        Set<Map<String, String>> documentRecords = parser.getXMLData(documentOutput, "Document");
                        processDocumentResponse(documentRecords);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in getDocument method");
        }
        return documents;
    }

    private boolean isSuccess(String status) {
        return status.equalsIgnoreCase("0");
    }

    private boolean doesRecordExists(String noOfRecord) {
        return Integer.parseInt(noOfRecord) > 0;
    }

    private void processDocumentResponse(Set<Map<String ,String>> documentRecords){
        for (Map<String, String> record : documentRecords) {
            Map<String,String> document = new HashMap<>();
            String docIndex = record.get("DocumentIndex");
            String docName = record.get("DocumentName");
            String ownerIndex = record.get("OwnerIndex");
            String uploadDate = record.get("CreationDateTime");
            String revisedDate = record.get("RevisedDateTime");
            String isIndex = record.get("ISIndex");
            String docSize = record.get("DocumentSize");
            String fileName = record.get("Comment");
            String fileExtension = record.get("CreatedByAppName");

            document.put(docIndexKey,docIndex);
            document.put(docNameKey,docName);
            document.put(ownerIndexKey,ownerIndex);
            document.put(uploadDateKey,uploadDate);
            document.put(revisedDateKey,revisedDate);
            document.put(isIndexKey,isIndex);
            document.put(docSizeKey,docSize);
            document.put(fileNameKey,fileName);
            document.put(fileExtensionKey,fileExtension);

            documents.add(document);
        }
    }
}
