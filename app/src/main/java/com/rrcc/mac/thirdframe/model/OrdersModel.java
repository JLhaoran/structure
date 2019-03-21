package com.rrcc.mac.thirdframe.model;

import com.rrcc.mac.thirdframe.bean.OrderListBean;

import java.util.List;

/**
 * Created by mac on 2019/3/20.
 */

public interface OrdersModel {

    void getOrderList(final OrderListListenter mlistener);
}
