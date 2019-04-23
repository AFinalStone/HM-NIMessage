package com.netease.nim.uikit;

import com.hm.iou.logger.Logger;
import com.netease.nim.uikit.event.SendMsgFailedEvent;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by syl on 2019/4/18.
 */

public class NIMClientHelper {

    public static void sendMsg(final IMMessage message, boolean resend) {
        NIMClient.getService(MsgService.class).sendMessage(message, resend).setCallback(new RequestCallback<Void>() {
            @Override
            public void onSuccess(Void param) {
                Logger.d("发送成功");
            }

            @Override
            public void onFailed(int code) {
                SendMsgFailedEvent sendMsgFailedEvent = new SendMsgFailedEvent();
                sendMsgFailedEvent.setFailedCode(code);
                sendMsgFailedEvent.setMessage(message);
                EventBus.getDefault().post(sendMsgFailedEvent);
            }

            @Override
            public void onException(Throwable exception) {
                Logger.d("发生异常" + exception.getMessage());
            }
        });
    }
}
