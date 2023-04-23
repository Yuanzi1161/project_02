package com.etoak.java.dao;

import com.etoak.java.bean.CityNumber;
import com.etoak.java.bean.EtEmployeeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EtEmployeeInfoDao {

    // 添加员工信息
    int addEmployee(EtEmployeeInfo e);

    // 查询全部员工信息
    List<EtEmployeeInfo> getAllEmployees();

    // 查询工作年限小于指定值的员工信息
    List<EtEmployeeInfo> getEmployeeByWorkTime(Integer workTime);

    // 根据城市和在职状态查询
    List<EtEmployeeInfo> getEmployeeByCityAndStatus(
            @Param("city") String city,
            @Param("status") String status);

    List<CityNumber> getCityNumber();

    int updateStatusById(Integer id);

    int deleteByStatus();

    int deleteById(Integer id);

    EtEmployeeInfo getEmployeeInfoById(Integer id);

    int updateByID(EtEmployee id);
}
