package com.hackerda.platform.infrastructure.wechat.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubscribeGradeData {

    @JSONField(name = "name1")
    private SubscribeValue name;
    @JSONField(name = "thing4")
    private SubscribeValue courseName;
    @JSONField(name = "number5")
    private SubscribeValue score;
    @JSONField(name = "thing6")
    private SubscribeValue remark;
}
