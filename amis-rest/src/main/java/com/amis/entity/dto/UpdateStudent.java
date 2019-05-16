package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UpdateStudent
 * @Description
 * @Author chenzexin
 * @Date 2019/5/13 22:41
 **/
@Data
public class UpdateStudent {

        private int uc_id;
        private String uc_name;
        private String uc_phone;
        private String eq_mac;
        private String tc_name;
        private int tc_id;
        private List<AdminClass> adminClassList;
}
