package com.citi.group.poweru;

import com.citi.group.poweru.module.domain.vo.BindVo;
import com.citi.group.poweru.module.domain.vo.PowerGenerationRecordVo;
import com.citi.group.poweru.module.service.AdminService;
import com.citi.group.poweru.module.service.UploaderService;
import com.citi.group.poweru.module.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 施武轩
 * @version 1.0
 * @date 2020/10/16 11:33
 * @lastEditor
 */
@SpringBootTest
public class ServiceTest {
    @Resource
    AdminService adminService;

    @Resource
    UploaderService uploaderService;

    @Resource
    private UserService userService;

    @Test
    public void userServiceTest(){
        System.out.println(userService.queryPointsInfoByUser((long)1));
    }


    @Test
    public void uploadTest(){
        PowerGenerationRecordVo generationRecord = new PowerGenerationRecordVo();
        generationRecord.setElectricQuantity(100.0);
        generationRecord.setPointId((long)3);
        generationRecord.setTimeInterval(4);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        generationRecord.setUploadTime(sdf.format(new Date()));
        uploaderService.uploadRecord(generationRecord);
    }

    @Test
    public void adminTest(){
        System.out.println(adminService.queryPointInfoByAdmin((long)2020001));
    }

    @Test
    public void bindTest(){
        BindVo bindVo = new BindVo();
        bindVo.setActivationCode("s004");
        bindVo.setAddress("广八路");
        bindVo.setName("5号基点");
        bindVo.setUserId((long)2);
        userService.userBindPoint(bindVo);
    }
}
