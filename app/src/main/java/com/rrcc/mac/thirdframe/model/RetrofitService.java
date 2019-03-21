package com.rrcc.mac.thirdframe.model;

import com.rrcc.mac.thirdframe.bean.OrderListBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mac on 2019/3/15.
 */

public interface RetrofitService {
    @GET("data/order_list.json")
  Call<OrderListBean> getOrderList();  //Retrofit
}
