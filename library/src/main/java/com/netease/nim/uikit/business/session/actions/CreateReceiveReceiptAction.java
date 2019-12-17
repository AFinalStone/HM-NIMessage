package com.netease.nim.uikit.business.session.actions;

import com.hm.iou.router.Router;
import com.netease.nim.uikit.R;

/**
 * 打收条
 *
 * @author syl
 * @time 2019/4/17 9:02 PM
 */
public class CreateReceiveReceiptAction extends BaseAction {

    public CreateReceiveReceiptAction() {
        super(R.mipmap.nim_ic_dst, R.string.input_panel_create_receive_receipt);
    }

    @Override
    public void onClick() {
        Router.getInstance()
                .buildWithUrl("hmiou://m.54jietiao.com/iou_create/elec_receive_create_or_modic_receipt")
                .navigation(getActivity());
    }
}

