package com.rrcc.mac.thirdframe.model;

import com.rrcc.mac.thirdframe.bean.OrderListBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by mac on 2019/3/20.
 */

public class OrdersModelImpl implements OrdersModel {
    public static final String BASE_URL = "http://mock.fulingjie.com/mock-android/";
    private List<OrderListBean.DataBean> mFruitList = new ArrayList<OrderListBean.DataBean>();

    @Override
    public void getOrderList(final OrderListListenter mListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //获取接口实例
        RetrofitService service = retrofit.create(RetrofitService.class);
        //调用方法得到一个Call
        Call<OrderListBean> call = service.getOrderList();
        //进行网络请求
        call.enqueue(new Callback<OrderListBean>() {
            @Override
            public void onResponse(Call<OrderListBean> call, Response<OrderListBean> response) {
                try {
                    String message = response.body().getMessage();
                    mFruitList.clear();
                    mFruitList.addAll(response.body().getData());
                    if (null != message && message.equals("OK")) {
                        mListener.onSuccess(mFruitList);
                    }
                   }
                  catch (Exception e){
                    e.printStackTrace();
                }
             
            }

            @Override
            public void onFailure(Call<OrderListBean> call, Throwable t) {
                t.printStackTrace();
                mListener.onError();
            }
        });
    }
}
