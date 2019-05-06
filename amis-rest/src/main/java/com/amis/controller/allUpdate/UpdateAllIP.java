package com.amis.controller.allUpdate;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.entity.Edition;
import com.amis.service.RestAdminService;
import com.amis.service.UpdateAllIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UpdateAllIP
 * @Description
 * @Author chenzexin
 * @Date 2019/5/6 17:18
 **/
@RestController
@RequestMapping(value = "updateAll")
public class UpdateAllIP {

    @Autowired
    UpdateAllIPService updateAllIPService;


    /**
     * @Author chenzexin
     * @Date 2019/4/11 15:58
     * @param s
     * @return com.amis.common.ResponseVO
     * @Description        (开放)更新本地APK地址
     **/
    @ResponseBody
    @RequestMapping(value = "updateAPK",method = RequestMethod.POST)
    public ResponseVO updateAPK(@RequestBody Edition edition) throws Exception {
        updateAllIPService.updateAPKURL(edition);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }




}
