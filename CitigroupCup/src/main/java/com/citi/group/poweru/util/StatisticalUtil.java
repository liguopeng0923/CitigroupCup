package com.citi.group.poweru.util;

import org.apache.tomcat.jni.Mmap;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/14 18:16
 * @lastEditor
 */
public class StatisticalUtil {

    /**
     * 获取map中最大值的键和值
     * @param dataMap 数据集合
     * @return 最大值键值对
     */
    public static Map.Entry<Integer,Double> getMax(Map<Integer,Double> dataMap){
        Map<Integer,Double> map = new HashMap<>(1);
        List<Map.Entry<Integer,Double>> list = new ArrayList(dataMap.entrySet());
        Collections.sort(list, (o1, o2) -> (int) (o1.getValue() - o2.getValue()));
        return list.get(list.size()-1);
    }


    /**
     * 获取map中最小值的键和值
     * @param dataMap 数据集
     * @return 最小值键值对
     */
    public static Map.Entry<Integer,Double> getMin(Map<Integer,Double> dataMap){
        if (dataMap == null) {
            return null;
        }
        Map<Integer,Double> map = new HashMap<>(1);
        List<Map.Entry<Integer,Double>> list = new ArrayList(dataMap.entrySet());
        Collections.sort(list, (o1, o2) -> (int) (o1.getValue() - o2.getValue()));
        return list.get(0);
    }


    /**
     * 获取map值的平均数
     * @param dataMap 数据集
     * @param n 计算平均值的分母
     * @return 平均值
     */
    public static Double getAverage(Map<Integer,Double> dataMap,int n){
        Double sum = 0.0;
        for (Double e:dataMap.values()){
            sum+=e;
        }
        return sum/n;
    }


    /**
     * 获取某个月份有多少天
     * @param year 年份
     * @param month 月份
     * @return 该月有多少天
     */
    public static Integer getDaysOfMonth(Integer year, Integer month){
        if(month==2){
            if (year%4==0)
            {
                return 29;
            }
            else {
                return 28;
            }
        }
        else if (month==4||month==6||month==9||month==11){
            return 30;
        }
        else {
            return 31;
        }
    }
    
}
