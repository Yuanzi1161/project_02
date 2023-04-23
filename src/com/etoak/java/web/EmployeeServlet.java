package com.etoak.java.web;

import com.alibaba.fastjson.JSONObject;
import com.etoak.java.bean.EtEmployeeInfo;
import com.etoak.java.service.EtEmployeeInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EtEmployeeInfoService service = new EtEmployeeInfoService();
        // 设置返回类型格式
        resp.setContentType("application/json;charset=utf-8");
        // 取参数
        String method = req.getParameter("method");
        if("getList".equals(method)){
            // 获取所有的员工列表
            List<EtEmployeeInfo> resultList = service.getAllEmployees();
            // 组装返回数据
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",resultList);

            // 将resultMap -> json类型
            String resultJson = JSONObject.toJSONString(resultMap);

            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();
        }
        if("delete".equals(method)){
            // 删除功能
            String id = req.getParameter("id");
            int result = service.deleteById(Integer.parseInt(id));
            Map<String,Object> resultMap = new HashMap<>();
            if(result > 0){
                resultMap.put("code",200);
                resultMap.put("msg","删除成功");
            }else{
                resultMap.put("code",500);
                resultMap.put("msg","删除失败");
            }
            String resultJson = JSONObject.toJSONString(resultMap);
            PrintWriter pw = resp.getWriter();
            pw.write(resultJson);
            pw.flush();
            pw.close();
        }
        if('info'.equals(method)){
            String id=req.getParameter('id');
            EtEmployeeInfo info=service.getEmployeeInfoById(Integer.parseInt(id));
            Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("code",200);
                resultMap.put("msg","查询成功");
                resultMap.put("data",info);

                String resultJson=JSONObject.toJSONString(resultMap);
                PrintWriter pw=resp.getWriter();
        }
    }
}
