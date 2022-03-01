package com.kelmorgan.ibpservices.utils;

public interface Constants {
    String apiSuccess = "success";
    String apiFailed = "failed";
    String empty = "";
    String logName = "Service Logger";

    //config mandatory fields
    String appServerIpField = "APPSERVERIP";
    String cabinetNameField = "CABINETNAME";
    String wrapperPortField = "WRAPPERPORT";
    String usernameField = "USERNAME";
    String passwordField = "PASSWORD";
    String logPathField = "LOGPATH";

    String docIndexKey = "documentIndex";
    String docNameKey = "documentName";
    String ownerIndexKey = "ownerIndex";
    String uploadDateKey = "uploadDate";
    String revisedDateKey ="revisedDate";
    String isIndexKey = "isIndex";
    String docSizeKey = "documentSize";
    String fileNameKey = "fileName";
    String fileExtensionKey = "fileExtension";
}
