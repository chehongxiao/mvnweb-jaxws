package com.css.service.impl;

import com.css.service.SayHiService;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebService(endpointInterface = "com.css.service.SayHiService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SayHiServiceImp implements SayHiService {
    @Override
    public void sayHiDefault() {
        System.out.println("Hi, Johness!");
    }

    @Override
    public void sayHi(String name) {
        System.out.println("Hi, " + name + "!");
    }

    @Override
    public int checkTime(Date clientTime) {
        // 精确到秒
        String dateServer = new java.sql.Date(System.currentTimeMillis())
                .toString()
                + " "
                + new java.sql.Time(System.currentTimeMillis());
        String dateClient = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(clientTime);
        return dateServer.equals(dateClient) ? 1 : 0;
    }
}
