package com.amis.controller.classTable;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.Task;
import com.amis.entity.dto.ReturnTaskListDTO;
import com.amis.entity.dto.SelectStudentTaskDetails;
import com.amis.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TaskController
 * @Description 作业
 * @Author chenzexin
 * @Date 2019/4/8 17:09
 **/
@RestController
@RequestMapping(value = "task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * @Author chenzexin
     * @Date 2019/4/8 18:14
     * @param task
     * @return com.amis.common.ResponseVO
     * @Description        插入单条作业
     **/
    @RequestMapping(value = "insertTask",method = RequestMethod.POST)
    public ResponseVO insertTask(@RequestBody Task task) throws AmisException {
        if (task.getTc_id() == 0 || task.getU_id() == 0) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        taskService.insertTask(task);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/8 19:09
     * @param task
     * @return com.amis.common.ResponseVO
     * @Description        查询作业列表
     **/
    @RequestMapping(value = "selectTaskList",method = RequestMethod.POST)
    public ResponseVO selectTaskList(@RequestBody Task task) throws AmisException {
        if (task.getU_id() == 0 ) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<ReturnTaskListDTO> returnTaskListDTOS = taskService.selectTaskList(task.getU_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnTaskListDTOS);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/8 23:45
     * @param task
     * @return com.amis.common.ResponseVO
     * @Description        查询完成及未完成学生
     **/
    @RequestMapping(value = "selectStudentTask",method = RequestMethod.POST)
    public ResponseVO selectStudentTask(@RequestBody Task task) throws AmisException {
        if (task.getTc_id() == 0 ) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
       SelectStudentTaskDetails selectStudentTask = taskService.selectStudentTask(task.getTc_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(selectStudentTask);
        return responseVO;
    }

}
