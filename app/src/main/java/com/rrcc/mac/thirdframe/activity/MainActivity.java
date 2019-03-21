package com.rrcc.mac.thirdframe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.rrcc.mac.thirdframe.R;
import com.rrcc.mac.thirdframe.adapter.DailyPagerAdapter;
import com.rrcc.mac.thirdframe.bean.OrderListBean;
import com.rrcc.mac.thirdframe.model.OrderListListenter;
import com.rrcc.mac.thirdframe.model.OrdersModelImpl;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OrderListListenter{
    public static final String BASE_URL = "http://mock.fulingjie.com/mock-android/";
    private RecyclerView mRecyclerView;
    private DailyPagerAdapter mDailyPagerAdapter = null;
    private List<OrderListBean.DataBean> mList = new ArrayList<OrderListBean.DataBean>();
    private OrdersModelImpl ordersModel =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ordersModel = new OrdersModelImpl();
        ordersModel.getOrderList(this);
    }


    private void initView(){
        mRecyclerView = findViewById(R.id.pager_shopping_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mDailyPagerAdapter = new DailyPagerAdapter(this,mList);
        mRecyclerView.setAdapter(mDailyPagerAdapter);
        mDailyPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(List<OrderListBean.DataBean> datas) {
        mList.clear();
        mList.addAll(datas);
        mDailyPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError() {

    }


}
