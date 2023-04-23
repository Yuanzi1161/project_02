package com.etoak.java;

import com.etoak.java.bean.CityNumber;
import com.etoak.java.bean.EtEmployeeInfo;
import com.etoak.java.service.EtEmployeeInfoService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        EtEmployeeInfoService service = new EtEmployeeInfoService();

        EtEmployeeInfo e = new EtEmployeeInfo();
        e.setName("高俊");
        e.setEtoakNo("ET349");
        e.setGender("1");
        e.setAge(20);
        e.setWorkTime(5);
        e.setCity("青岛");
        e.setWorkPlace("青岛大学");
        e.setSalary(10000);
        e.setStatus("0");
        service.addEmployee(e);


        List<CityNumber> resultList
                = service.getCityNumberList();
        for(CityNumber c : resultList){
            System.out.println(c.getCity() + ":" + c.getNumber()+"人");
        }
    }
}
