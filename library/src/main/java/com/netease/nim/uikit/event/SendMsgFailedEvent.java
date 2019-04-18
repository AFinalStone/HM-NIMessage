package com.netease.nim.uikit.event;

import com.netease.nimlib.sdk.msg.model.IMMessage;

/**
 * Created by syl on 2019/4/18.
 */

public class SendMsgFailedEvent {

    private IMMessage message;
    int failedCode;//错误码

    public SendMsgFailedEvent() {
    }

    public IMMessage getMessage() {
        return message;
    }

    public void setMessage(IMMessage message) {
        this.message = message;
    }

    public int getFailedCode() {
        return failedCode;
    }

    public void setFailedCode(int failedCode) {
        this.failedCode = failedCode;
    }
}
