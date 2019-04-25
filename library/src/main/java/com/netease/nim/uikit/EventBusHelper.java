package com.netease.nim.uikit;

import com.netease.nim.uikit.event.UpdateChatListEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @author syl
 * @time 2018/5/19 下午2:59
 */

public class EventBusHelper {

    /**
     * 更新会话列表
     */
    public static void postUpdateChatListEvent() {
        EventBus.getDefault().post(new UpdateChatListEvent());
    }

}
