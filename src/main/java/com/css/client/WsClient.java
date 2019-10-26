package com.css.client;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WsClient {

    public static void main(String[] args) throws DatatypeConfigurationException {
        //生成客户端代码
        //wsimport.exe -p com.css.client -d D:\my-codes\ http://localhost:8080/service/sayHi?wsdl
        SayHiService service = new SayHiServiceImpService().getSayHiServiceImpPort();

        service.sayHiDefault();
        service.sayHi("ccc");

        // checktime
        // 这里主要说一下时间日期的xml传递，方法还略显复杂
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        System.out.println(service.checkTime(xmldate));
    }
}
