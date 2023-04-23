package com.etoak.java.web;

import com.etoak.java.service.EtEmployeeInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete.do")
public class DeleteEtoakEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先去获取到要删除的员工id
        Integer id = Integer.parseInt(req.getParameter("id"));
        EtEmployeeInfoService service = new EtEmployeeInfoService();
        // 调用删除方法
        int result = service.deleteById(id);

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        if(result > 0){
            pw.write("删除成功！");
        }else{
            pw.write("删除失败！");
        }
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        EtEmployeeInfoService service = new EtEmployeeInfoService();
        // 调用删除方法
        int result = service.deleteById(id);

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        if(result > 0){
            pw.write("删除成功！");
        }else{
            pw.write("删除失败！");
        }
        pw.flush();
        pw.close();
    }
}
