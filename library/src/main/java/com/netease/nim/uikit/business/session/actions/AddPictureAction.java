package com.netease.nim.uikit.business.session.actions;

import android.content.Intent;
import android.text.TextUtils;

import com.hm.iou.base.photo.CompressPictureUtil;
import com.hm.iou.router.Router;
import com.netease.nim.uikit.R;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * 打借条
 *
 * @author syl
 * @time 2019/4/17 9:02 PM
 */
public class AddPictureAction extends BaseAction {

    private static final int REQ_OPEN_SELECT_PIC = 100;

    public AddPictureAction() {
        super(R.mipmap.nim_ic_pic, R.string.input_panel_photo);
    }

    @Override
    public void onClick() {
        Router.getInstance()
                .buildWithUrl("hmiou://m.54jietiao.com/select_pic/index")
                .withString("enable_select_max_num", "1")
                .navigation(getActivity(), REQ_OPEN_SELECT_PIC);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQ_OPEN_SELECT_PIC == requestCode && RESULT_OK == resultCode) {
            String firstPath = data.getStringExtra("extra_result_selection_path_first");
            if (TextUtils.isEmpty(firstPath)) {
                CompressPictureUtil.compressPic(getActivity(), firstPath, new CompressPictureUtil.OnCompressListener() {
                    @Override
                    public void onCompressPicSuccess(File file) {
                        IMMessage message = MessageBuilder.createImageMessage(getAccount(), getSessionType(), file, file.getName());
                        sendMessage(message);
                    }
                });
            }
        }
    }
}

