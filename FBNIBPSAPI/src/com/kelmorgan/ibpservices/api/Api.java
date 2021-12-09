package com.kelmorgan.ibpservices.api;


import com.kelmorgan.ibpservices.utils.LoadProp;
import com.newgen.wfdesktop.xmlapi.WFCallBroker;

public class Api {
    private final LoadProp loadProp;

    public Api(LoadProp loadProp) {
        this.loadProp = loadProp;
    }

    public  String executeCall (String request) throws Exception {
        return WFCallBroker.execute(request, loadProp.getServerIp(), Integer.parseInt(loadProp.getServerWrapperPort()), 1);
    }
}
