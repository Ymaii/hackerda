package com.hackerda.platform.domain.student;

import com.hackerda.platform.domain.constant.SubscribeScene;
import com.hackerda.platform.domain.wechat.UnionId;

import java.util.Collection;
import java.util.List;

public interface StudentRepository {

    WechatStudentUserBO findWetChatUser(StudentAccount account);

    WechatStudentUserBO findWetChatUser(UnionId unionId);

    StudentUserBO find(StudentAccount account);

    List<WechatStudentUserBO> getByAccountList(Collection<Integer> accountList);

    List<WechatStudentUserBO> getSubscribe(SubscribeScene subscribeScene);

    void save(WechatStudentUserBO studentUser);

}
