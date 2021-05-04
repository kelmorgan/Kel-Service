package com.fbn.api;

import com.fbn.utils.ConstantsI;
import com.fbn.utils.LoadProp;
import com.newgen.wfdesktop.xmlapi.WFCallBroker;

public class Api implements ConstantsI {

    public static String executeCall (String request) throws Exception {
        return WFCallBroker.execute(request, LoadProp.appServerIp, Integer.parseInt(LoadProp.serverWrapperPort), 1);
    }
}
