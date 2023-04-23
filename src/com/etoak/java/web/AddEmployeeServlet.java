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
import java.util.Map;

@WebServlet(urlPatterns = "/addEmployee",name = "AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String etoakNo = req.getParameter("etoakNo");
        String workPlace = req.getParameter("workPlace");
        String city = req.getParameter("city");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        Integer workTime = Integer.parseInt(req.getParameter("workTime"));
        String gender = req.getParameter("gender");
        // 组装员工对象
        EtEmployeeInfo etInfo =
                new EtEmployeeInfo();
        etInfo.setName(name);
        etInfo.setGender(gender);
        etInfo.setAge(age);
        etInfo.setSalary(salary);
        etInfo.setWorkPlace(workPlace);
        etInfo.setWorkTime(workTime);
        etInfo.setEtoakNo(etoakNo);
        etInfo.setCity(city);
        // 调用 service中的添加员工方法
        EtEmployeeInfoService service
                = new EtEmployeeInfoService();
        int result = service.addEmployee(etInfo);
        // 规范返回结果
        Map<String,Object> resultMap = new HashMap<>();
        if(result > 0){
            // 新增成功
            resultMap.put("code",200);
            resultMap.put("msg","新增成功");
            resultMap.put("data",result);
        }else{
            // 新增失败
            resultMap.put("code",500);
            resultMap.put("msg","新增失败");
            resultMap.put("data",result);
        }
        // 设置返回结果为 JSON格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 将resultMap 转换为JSON字符串
        String resultJson = JSONObject.toJSONString(resultMap);
        writer.write(resultJson);
        writer.flush();
        writer.close();
    }
}
