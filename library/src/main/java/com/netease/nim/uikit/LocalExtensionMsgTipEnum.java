package com.netease.nim.uikit;

/**
 * Created by syl on 2019/4/18.
 */

public enum LocalExtensionMsgTipEnum {
    /**
     * 非好友
     */
    is_no_friend(2, "不是好友"),
    /**
     * 黑名单
     */
    in_black_name(1, "黑名单");

    Integer type;
    String desc;

    LocalExtensionMsgTipEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
