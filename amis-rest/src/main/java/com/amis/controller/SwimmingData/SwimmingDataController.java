package com.amis.controller.SwimmingData;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.entity.MotionDataEntity;
import com.amis.service.SwimmingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName SwimmingDataController
 * @Description
 * @Author chenzexin
 * @Date 2019/9/10 18:42
 **/
@RestController
@RequestMapping(value = "swimmingData")
public class SwimmingDataController {


    @Autowired
    private SwimmingDataService swimmingDataService;

    private int ao;

    /**
     * @Author chenzexin
     * @Date 2019/9/10 18:48
     * @param motionDataEntity
     * @return com.amis.common.ResponseVO
     * @Description        插入游泳数据
     **/
    @RequestMapping(value = "/insertSwimmingData", method = RequestMethod.POST)
    public ResponseVO insertSwimmingData(@RequestBody MotionDataEntity motionDataEntity) {
        int ye = swimmingDataService.insertSwimmingData(motionDataEntity);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setId(ye);
        ao++;
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/9/10 20:46
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        获取总接收次数
     **/
    @RequestMapping(value = "/getAo", method = RequestMethod.POST)
    public ResponseVO getAo() {
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setId(ao);
        ao = 0;
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/9/10 20:45
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        清空游泳表数据
     **/
    @RequestMapping(value = "/truncateTable", method = RequestMethod.POST)
    public ResponseVO truncateTable() {
        swimmingDataService.truncateTable();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


}
