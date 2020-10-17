package com.citi.group.poweru;

import com.citi.group.poweru.module.dao.MachineMapper;
import com.citi.group.poweru.module.dao.PointMapper;
import com.citi.group.poweru.module.dao.PowerGenerationMapper;
import com.citi.group.poweru.module.dao.RelationMapper;
import com.citi.group.poweru.module.domain.dto.QueryRankDto;
import com.citi.group.poweru.module.domain.entity.PointInfoEntity;
import com.citi.group.poweru.module.domain.entity.PowerGenerationRecordEntity;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import com.citi.group.poweru.module.service.UploaderService;
import com.citi.group.poweru.module.service.UserService;
import kotlin.collections.ArrayDeque;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/15 14:21
 * @lastEditor
 */
@SpringBootTest
public class MapperTest {
    @Resource
    private MachineMapper machineMapper;

    @Resource
    private RelationMapper relationMapper;

    @Resource
    private PointMapper pointMapper;

    @Resource
    private UserService userService;

    @Resource
    PowerGenerationMapper powerGenerationMapper;
    @Test
    public void StatisticalDataOfDayGenerationTest(){
        QueryRankVo vo=new QueryRankVo();
        List<Integer> months = new ArrayList<Integer>();
        months.add(9);
        months.add(10);
        vo.setUserId((long)1);
        vo.setYear(2020);
        System.out.println(userService.queryStatisticalDataOfMonthGeneration(vo));
    }

    @Test
    public void PointMapperTest()
    {
        System.out.println(pointMapper.queryPointInfo((long) 1));
        System.out.println(powerGenerationMapper.getTotalGenerationPerPoint(1));
    }

    @Test
    void insertRecordTest(){
        PowerGenerationRecordEntity entity = new PowerGenerationRecordEntity((long)0,(long)3,100.0,"2020-10-16 12:00:00",4);
        powerGenerationMapper.uploadRecord(entity);

    }

    @Test
    public void generationMapperTest(){
        System.out.println(powerGenerationMapper.queryDayGeneration(1,2020,10,14));
    }


    @Test
    public void insertRelationTest(){
        relationMapper.insertUserAndPointRelation((long)2,(long)3);
    }

    @Test
    public void machineTest(){
        System.out.println(machineMapper.selectMachineId("s004"));
    }


    @Test
    public void relationTest(){
        System.out.println(relationMapper.queryUserIdByAdmin((long)2020001));
    }


    @Test
    public void insertPoint(){
        PointInfoEntity entity = new PointInfoEntity();
        entity.setAddress("九华山");
        entity.setMachineId((long)1004);
        entity.setName("2号");
        entity.setStatus("关闭");
        pointMapper.insertPoint(entity);
    }
}
