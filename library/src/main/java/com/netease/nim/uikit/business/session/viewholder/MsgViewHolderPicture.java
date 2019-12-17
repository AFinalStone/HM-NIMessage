package com.netease.nim.uikit.business.session.viewholder;

import android.content.Intent;
import android.text.TextUtils;

import com.hm.iou.base.ImageGalleryActivity;
import com.hm.iou.logger.Logger;
import com.netease.nim.uikit.R;
import com.netease.nim.uikit.common.ui.recyclerview.adapter.BaseMultiItemFetchLoadAdapter;
import com.netease.nimlib.sdk.msg.attachment.FileAttachment;

/**
 * Created by zhoujianghua on 2015/8/4.
 */
public class MsgViewHolderPicture extends MsgViewHolderThumbBase {

    public MsgViewHolderPicture(BaseMultiItemFetchLoadAdapter adapter) {
        super(adapter);
    }

    @Override
    protected int getContentResId() {
        return R.layout.nim_message_item_picture;
    }

    @Override
    protected void onItemClick() {
        FileAttachment msgAttachment = (FileAttachment) message.getAttachment();
        String imagePath = msgAttachment.getPath();
        if (!TextUtils.isEmpty(imagePath)) {
            imagePath = "file://" + imagePath;
        } else {
            imagePath = msgAttachment.getUrl();
        }
        String[] arrImagePath = {imagePath};
        Intent intent = new Intent(context, ImageGalleryActivity.class);
        intent.putExtra(ImageGalleryActivity.EXTRA_KEY_IMAGES, arrImagePath);
        context.startActivity(intent);
        Logger.d("图片链接==" + arrImagePath);
    }

    @Override
    protected String thumbFromSourceFile(String path) {
        return path;
    }
}
