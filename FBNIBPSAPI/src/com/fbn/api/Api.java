package com.fbn.api;


import com.fbn.utils.LoadProp;
import com.newgen.wfdesktop.xmlapi.WFCallBroker;

public class Api  {

    public static String executeCall (String request) throws Exception {
        return WFCallBroker.execute(request, LoadProp.serverIp, Integer.parseInt(LoadProp.serverWrapperPort), 1);
    }
}
