package com.netease.nim.uikit.business.session.viewholder;

import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.netease.nim.uikit.R;
import com.netease.nim.uikit.business.session.emoji.MoonUtil;
import com.netease.nim.uikit.business.session.helper.TeamNotificationHelper;
import com.netease.nim.uikit.common.ui.recyclerview.adapter.BaseMultiItemFetchLoadAdapter;

public class MsgViewHolderNotification extends MsgViewHolderBase {

    public MsgViewHolderNotification(BaseMultiItemFetchLoadAdapter adapter) {
        super(adapter);
    }

    protected TextView notificationTextView;

    @Override
    protected int getContentResId() {
        return R.layout.nim_message_item_notification;
    }

    @Override
    protected void inflateContentView() {
        notificationTextView = view.findViewById(R.id.message_item_notification_label);
    }

    @Override
    protected void bindContentView() {
        handleTextNotification(getDisplayText());
    }

    protected String getDisplayText() {
        return TeamNotificationHelper.getTeamNotificationText(message, message.getSessionId());
    }

    private void handleTextNotification(String text) {
        MoonUtil.identifyFaceExpressionAndATags(context, notificationTextView, text, ImageSpan.ALIGN_BOTTOM);
        notificationTextView.setMovementMethod(LinkMovementMethod.getInstance());
//        if (context.getString(R.string.no_friend_send_tip).equals(text)) {
//            String noFriend = "您还不是他(她)的好友，请先添加朋友，才能继续聊天。\n添加好友";
//            SpannableString msp = new SpannableString(noFriend);
//            //设置字体大小（绝对值,单位：像素）
//            msp.setSpan(new ForegroundColorSpan(0x2782E2), noFriend.length() - 4, noFriend.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            notificationTextView.setText(msp);
//        }
    }

    @Override
    protected boolean isMiddleItem() {
        return true;
    }
}

