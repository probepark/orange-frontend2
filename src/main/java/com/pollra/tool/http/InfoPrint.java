package com.pollra.tool.http;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class InfoPrint {
    public InfoPrint() {
    }

    public static void headersPrint(HttpServletRequest request){
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = (String)headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
        System.out.println("");
        Enumeration params = request.getParameterNames();
        while(params.hasMoreElements()){
            String name2 = (String)params.nextElement();
            String value2 = request.getParameter(name2);
            System.out.println(name2 + " : " + value2);
        }

        /*Enumeration attribute = request.getAttributeNames();
        while(attribute.hasMoreElements()){
            String name3 = (String)attribute.nextElement();
            String value3 = (String) request.getAttribute(name3);
            System.out.println(name3 + " : " + value3);
        }
        System.out.println("");*/
    }
}
