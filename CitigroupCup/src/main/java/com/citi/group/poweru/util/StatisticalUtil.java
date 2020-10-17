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
     *
     * @param
     * @return
     */
    public static Map.Entry<Integer,Double> getMax(Map<Integer,Double> dataMap){
        Map<Integer,Double> map = new HashMap<Integer,Double>(1);

        List<Map.Entry<Integer,Double>> list = new ArrayList(dataMap.entrySet());
        Collections.sort(list, (o1, o2) -> (int) (o1.getValue() - o2.getValue()));

        /*Integer key = list.get(list.size() - 1).getKey();
        Double value = list.get(list.size() - 1).getValue();

        map.put(key,value);*/
        return list.get(list.size()-1);

    }


    public static Map.Entry<Integer,Double> getMin(Map<Integer,Double> dataMap){
        if (dataMap == null) {
            return null;
        }
        Map<Integer,Double> map = new HashMap<Integer,Double>(1);

        List<Map.Entry<Integer,Double>> list = new ArrayList(dataMap.entrySet());
        Collections.sort(list, (o1, o2) -> (int) (o1.getValue() - o2.getValue()));

        /*Integer key = list.get(0).getKey();
        Double value = list.get(0).getValue();*/

//        map.put(key,value);
        return list.get(0);
    }

    public static Double getAverage(Map<Integer,Double> dataMap,int n){
        Double sum = 0.0;
        for (Double e:dataMap.values()){
            sum+=e;
        }
//        System.out.println(dataMap);
        return sum/n;
    }


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
