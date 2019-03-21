package com.rrcc.mac.thirdframe.model;

import com.rrcc.mac.thirdframe.bean.OrderListBean;

import java.util.List;

/**
 * Created by mac on 2019/3/20.
 */

public interface OrderListListenter {
    public void onSuccess(List<OrderListBean.DataBean> datas);
    public void onError();
}
