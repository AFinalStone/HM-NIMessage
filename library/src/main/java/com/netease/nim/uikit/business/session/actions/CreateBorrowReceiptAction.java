package com.netease.nim.uikit.business.session.actions;

import com.hm.iou.router.Router;
import com.netease.nim.uikit.R;

/**
 * 打借条
 *
 * @author syl
 * @time 2019/4/17 9:02 PM
 */
public class CreateBorrowReceiptAction extends BaseAction {

    public CreateBorrowReceiptAction() {
        super(R.mipmap.nim_ic_djt, R.string.input_panel_create_borrow_receipt);
    }

    @Override
    public void onClick() {
        Router.getInstance()
                .buildWithUrl("hmiou://m.54jietiao.com/facecheck/checkLiveness")
                .withString("url", "hmiou://m.54jietiao.com/iou_create/elec_borrow_create_prepare")
                .navigation(getActivity());
    }
}

