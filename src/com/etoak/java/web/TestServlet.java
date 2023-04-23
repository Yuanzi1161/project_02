package com.etoak.java.web;

import com.etoak.java.bean.EtEmployeeInfo;
import com.etoak.java.service.EtEmployeeInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 一个普通类 继承了 HttpServlet 那他就具有了Servlet的能力
 *
 */
//@WebServlet(urlPatterns = "/test.du")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EtEmployeeInfoService service = new EtEmployeeInfoService();
        List<EtEmployeeInfo> resultList =
                service.getAllEmployees();
        for(EtEmployeeInfo e : resultList){
            System.out.println(e.getName() + ":" + e.getSalary());
        }
        super.doGet(req, resp);
    }
}
