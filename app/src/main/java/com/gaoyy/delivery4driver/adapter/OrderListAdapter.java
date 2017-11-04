package com.gaoyy.delivery4driver.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.base.recycler.BaseViewHolder;
import com.gaoyy.delivery4driver.base.recycler.RecyclerBaseAdapter;
import com.gaoyy.delivery4driver.main.MainActivity;

import java.util.List;

/**
 * Created by gaoyy on 2016/8/24 0024.
 */
public class OrderListAdapter extends RecyclerBaseAdapter<OrderListInfo.BodyBean.PageBean.ListBean>
{

    private TextView itemOrderStatus;
    private TextView itemOrderStatusDate;
    private LinearLayout itemOrderOperationLayout;
    private AppCompatButton itemOrderPickUpBtn;
    private AppCompatButton itemOrderFinishBtn;
    private CardView itemOrderCardView;

    public OrderListAdapter(Context context, List<OrderListInfo.BodyBean.PageBean.ListBean> data)
    {
        super(context, R.layout.item_order, data);
    }

    @Override
    protected void bindData(BaseViewHolder holder, OrderListInfo.BodyBean.PageBean.ListBean itemData, int position)
    {
        holder.getView(R.id.item_order_card_view).setTag(itemData);
        int orderStatus = itemData.getStatus();
        List<DriverInfo.BodyBean.DictStatusBean> dictStatus = MainActivity.dictStatus;

        holder.setText(R.id.item_order_starting_point, itemData.getHotelAddr())
                .setText(R.id.item_order_destination, itemData.getCustomerAddr())
                .setText(R.id.item_order_customer_phone, itemData.getCustomerTel())
                .setText(R.id.item_order_restaurant_phone, itemData.getHotelTel())
                .setText(R.id.item_order_no, itemData.getOrderNo())
                .setText(R.id.item_order_finished_time, itemData.getFinishedTime());


        Log.d(Constant.TAG, position + "==status==" + itemData.getStatus());

        itemOrderStatus = holder.getView(R.id.item_order_status);
        itemOrderStatusDate = holder.getView(R.id.item_order_status_date);
        itemOrderOperationLayout = holder.getView(R.id.item_order_operation_layout);
        itemOrderPickUpBtn = holder.getView(R.id.item_order_pick_up_btn);
        itemOrderFinishBtn = holder.getView(R.id.item_order_finish_btn);
        itemOrderCardView = holder.getView(R.id.item_order_card_view);

        setUpStatusBtn(itemData, orderStatus, dictStatus);

        //设置btn的点击监听器
        if (onItemClickListener != null)
        {
            itemOrderPickUpBtn.setOnClickListener(new BasicOnClickListener(holder, itemData));
            itemOrderFinishBtn.setOnClickListener(new BasicOnClickListener(holder, itemData));
            itemOrderCardView.setOnClickListener(new BasicOnClickListener(holder, itemData));
        }
    }

    private void setUpStatusBtn(OrderListInfo.BodyBean.PageBean.ListBean itemData, int orderStatus, List<DriverInfo.BodyBean.DictStatusBean> dictStatus)
    {
        for (int i = 0; i < dictStatus.size(); i++)
        {
            int value = Integer.valueOf(dictStatus.get(i).getValue());
            //司机段订单列表不显示Wait状态下的订单
            //Accept
            if ((orderStatus == value) && (value == 1))
            {
                itemOrderStatus.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                itemOrderStatus.setText(R.string.status_accept);
                itemOrderStatusDate.setText(itemData.getCreateDate());

                //显示按钮组
                itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //显示PickUp按钮隐藏Finish按钮
                itemOrderPickUpBtn.setVisibility(View.VISIBLE);
                itemOrderFinishBtn.setVisibility(View.GONE);

            }
            //Delivery
            else if ((orderStatus == value) && (value == 2))
            {
                itemOrderStatus.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                itemOrderStatus.setText(R.string.status_delivery);
                itemOrderStatusDate.setText(itemData.getCreateDate());
                //显示按钮组
                itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //隐藏PickUp按钮显示Finish按钮
                itemOrderPickUpBtn.setVisibility(View.GONE);
                itemOrderFinishBtn.setVisibility(View.VISIBLE);
            }
            //Finish
            else if ((orderStatus == value) && (value == 3))
            {
                itemOrderStatus.setBackgroundColor(mContext.getResources().getColor(android.R.color.darker_gray));
                itemOrderStatus.setText(R.string.status_finish);
                itemOrderStatusDate.setText(itemData.getCreateDate());

                //不显示按钮
                itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Cancel
            else if ((orderStatus == value) && (value == 4))
            {
                itemOrderStatus.setBackgroundColor(mContext.getResources().getColor(android.R.color.darker_gray));
                itemOrderStatus.setText(R.string.status_cancle);
                itemOrderStatusDate.setText(itemData.getCreateDate());

                //不显示按钮
                itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Back
            else if ((orderStatus == value) && (value == 5))
            {
                itemOrderStatus.setBackgroundColor(mContext.getResources().getColor(android.R.color.darker_gray));
                itemOrderStatus.setText(R.string.status_cancle);
                itemOrderStatusDate.setText((String) itemData.getCancelDate());

                //不显示按钮
                itemOrderOperationLayout.setVisibility(View.GONE);
            }
        }
    }

    private class BasicOnClickListener implements View.OnClickListener
    {
        private BaseViewHolder vh;
        private OrderListInfo.BodyBean.PageBean.ListBean order;

        public BasicOnClickListener(BaseViewHolder vh, OrderListInfo.BodyBean.PageBean.ListBean order)
        {
            this.vh = vh;
            this.order = order;
        }

        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.item_order_pick_up_btn:
                    onItemClickListener.onItemClick(vh.getView(R.id.item_order_pick_up_btn), vh.getLayoutPosition(), order);
                    break;
                case R.id.item_order_finish_btn:
                    onItemClickListener.onItemClick(vh.getView(R.id.item_order_finish_btn), vh.getLayoutPosition(), order);
                    break;
                case R.id.item_order_card_view:
                    onItemClickListener.onItemClick(vh.getView(R.id.item_order_card_view), vh.getLayoutPosition(), order);
                    break;
            }
        }
    }
}