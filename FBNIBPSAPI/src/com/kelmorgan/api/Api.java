package com.kelmorgan.api;


import com.kelmorgan.utils.LoadProp;
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
