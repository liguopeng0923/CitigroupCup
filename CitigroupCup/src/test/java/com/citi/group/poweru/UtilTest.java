package com.citi.group.poweru;

import com.citi.group.poweru.util.StatisticalUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 13:26
 * @lastEditor
 */
@SpringBootTest
public class UtilTest {
    @Test
    public void utilTest(){
        Map<Integer,Double> map = new HashMap<Integer,Double>();
        map.put(2,2.9);
        map.put(9,0.1);
        Map<Integer,Double> map2 = new HashMap<Integer,Double>(1);
        map2.put(1,0.0);
        map.putAll(map2);
//        System.out.println(StatisticalUtil.getMax(map));
//        System.out.println(StatisticalUtil.getMin(map));
//        System.out.println(StatisticalUtil.getAverage(map));
    }
}
