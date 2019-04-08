package com.netease.im.demo;

import android.content.Context;

import com.hm.iou.logger.Logger;
import com.netease.nim.uikit.api.model.location.LocationProvider;

/**
 * Created by syl on 2019/4/4.
 */

public class BaiduLociationProvider implements LocationProvider {

    public BaiduLociationProvider() {
//        EventBus.getDefault().register(this);
    }

    @Override
    public void requestLocation(Context context, Callback callback) {
        Logger.d("开始请求定位信息");
    }

    @Override
    public void openMap(Context context, double longitude, double latitude, String address) {
        Logger.d("开始打开地图");
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventLocation(LocationData location) {
//        try {
//            String city = location.getCity();    //获取城市
//            //获取具体的经纬度信息
//            double latitude = location.getLatitudeX();    //获取纬度信息
//            double longitude = location.getLongitudeY();    //获取经度信息
//            searchPOI(city, latitude, longitude);
//        } catch (Exception e) {
//            if (mIsRefresh) {
//                mView.hidePullDownRefresh();
//                mView.showRefreshFailed();
//            } else {
//                mView.showInitFailed();
//            }
//        }
//    }
}
