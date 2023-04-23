package com.etoak.java.service;

import com.etoak.java.bean.CityNumber;
import com.etoak.java.bean.EtEmployeeInfo;
import com.etoak.java.dao.EtEmployeeInfoDao;
import com.etoak.java.utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EtEmployeeInfoService {

    private EtEmployeeInfoDao dao =
            MybatisUtil.getSqlSession().getMapper(EtEmployeeInfoDao.class);

    /**
     * 添加员工信息
     * @param e
     * @return
     */
    public int addEmployee(EtEmployeeInfo e){
        return dao.addEmployee(e);
    }

    /**
     * 查询全部员工信息
     * @return
     */
    public List<EtEmployeeInfo> getAllEmployees(){
        return dao.getAllEmployees();
    }

    public List<EtEmployeeInfo> getEmployeeByWorkTime(Integer workTime){
        return dao.getEmployeeByWorkTime(workTime);
    }

    /**
     * 获取不同城市的员工数量
     *
     *
     * 张三  青岛
     * 王五  青岛
     * 赵六  济南
     */
    public Map<String,Integer> getCityNumbers(){
        // 存储处理完之后的数据结果
        Map<String,Integer> resultMap = new HashMap<>();
        // 1.获取到所有的员工信息
        List<EtEmployeeInfo> all = getAllEmployees();
        // 2.在Java中处理员工信息
        if(all != null && all.size() > 0){
            for(EtEmployeeInfo e : all){
                // 当前员工所在城市
                String currentCity = e.getCity()!=null? e.getCity():"";
                if(resultMap.containsKey(currentCity)){
                    // 包含了相同的key
                    Integer currentNumber = resultMap.get(currentCity);
                    currentNumber++;
                    resultMap.put(currentCity,currentNumber);
                }else{
                    // 没有包含相同的key
                    resultMap.put(currentCity,1);
                }
            }
        }
        return resultMap;
    }

    // 第二种实现方式
    public List<CityNumber> getCityNumberList(){
        return dao.getCityNumber();
    }

    public Map<String,Integer> getAwardList(){
        Map<String,Integer> resultMap = new HashMap<>();
        // 获取所有员工信息
        List<EtEmployeeInfo> all = getAllEmployees();
        if(all != null && all.size() > 0){
            for(EtEmployeeInfo e : all){
                if(e.getWorkTime() < 1){
                    resultMap.put(e.getEtoakNo(),0);
                }else if(e.getWorkTime() >= 1 && e.getWorkTime() < 3){
                    resultMap.put(e.getEtoakNo(),10000);
                }else if(e.getWorkTime() >= 3){
                    resultMap.put(e.getEtoakNo(),20000);
                }
            }
        }
        return resultMap;
    }

    /**
     * 根据id 删除指定员工
     * @param id
     * @return
     */
    public int deleteById(Integer id){
        return dao.deleteById(id);
    }

    public EtEmployeeInfo getEmployeeInfoById(Integer id){
        return dao.getEmployeeInfoById(id);
    }
    public int
}
