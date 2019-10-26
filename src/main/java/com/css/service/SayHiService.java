package com.css.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SayHiService {
    @WebMethod
    void sayHiDefault();
    @WebMethod
    void sayHi(@WebParam(name = "name") String name);
    @WebMethod
    @WebResult(name = "valid")
    int checkTime(@WebParam(name = "clientTime") Date clientTime);
}
