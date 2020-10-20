package com.citi.group.poweru;

import com.citi.group.poweru.module.controller.AdminController;
import com.citi.group.poweru.module.controller.UploaderController;
import com.citi.group.poweru.module.controller.UserController;
import com.citi.group.poweru.module.domain.dto.PowerGenerationRecordDto;
import com.citi.group.poweru.module.domain.vo.BindVo;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;
import com.citi.group.poweru.module.domain.vo.QueryRankVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/18 10:59
 * @lastEditor
 */
@SpringBootTest
public class ControllerTest {
    @Resource
    private AdminController adminController;

    @Resource
    private UserController userController;

    @Resource
    private UploaderController uploaderController;

    @Test
    public void adminTest(){
        System.out.println(adminController.queryPointInfo((long) 2020001));
    }

    @Test
    public void userQueryPointsTest(){
        System.out.println(userController.queryPointInfo((long)1));
        System.out.println(userController.queryPointInfo((long)2));
    }

    @Test
    public void userQueryRankTest(){
        QueryRankVo vo = new QueryRankVo((long)1,2020);
        System.out.println(userController.queryGenerationRank(vo));
    }

    @Test
    public void bindTest(){
        BindVo vo = new BindVo((long)3,"002", "南昌南","s006");
        System.out.println(userController.bindMachine(vo));
    }

    @Test
    public void uploadTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PowerGenerationRecordVo vo = new PowerGenerationRecordVo((long)13,300.0,"2020-10-20 14:00:00",4);
        System.out.println(uploaderController.uploadGenerationRecord(vo));
    }
}
