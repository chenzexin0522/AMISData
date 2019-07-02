package com.amis.entity.dto;

import com.amis.entity.TabResult;
import lombok.Data;

import java.util.List;

/**
 * @ClassName InertTabResultList
 * @Description
 * @Author chenzexin
 * @Date 2019/7/1 17:56
 **/
@Data
public class InertTabResultList {

    List<TabResult> tabResultsList;

    String tab_result;
}
