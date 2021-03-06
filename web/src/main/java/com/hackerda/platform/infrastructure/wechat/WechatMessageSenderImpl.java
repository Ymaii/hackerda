package com.hackerda.platform.infrastructure.wechat;

import com.hackerda.platform.config.wechat.WechatMpConfiguration;
import com.hackerda.platform.domain.wechat.WechatMessageSender;
import com.hackerda.platform.domain.wechat.WechatTemplateMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WechatMessageSenderImpl implements WechatMessageSender {

    @Autowired
    private WechatMpConfiguration wechatMpConfiguration;

    @Override
    public void sendTemplateMessage(WechatTemplateMessage wechatTemplateMessage) {
        String appId = wechatTemplateMessage.getSendApp();
        WxMpService wxService = wechatMpConfiguration.getMpService(appId);

        try {
            wxService.getTemplateMsgService().sendTemplateMsg(wechatTemplateMessage.genMpTemplateMessage());
        } catch (WxErrorException e) {
            log.error("message {} send error",wechatTemplateMessage, e);
        }
    }
}
