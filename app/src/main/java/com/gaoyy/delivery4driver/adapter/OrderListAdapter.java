package com.gaoyy.delivery4driver.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.main.MainActivity;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by gaoyy on 2016/8/24 0024.
 */
public class OrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private LayoutInflater inflater;
    private LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> data;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener
    {
        void onItemClick(View view, int position, OrderListInfo.BodyBean.PageBean.ListBean order);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.onItemClickListener = listener;
    }


    public OrderListAdapter(Context context, LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> data)
    {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View rootView = inflater.inflate(R.layout.item_order, parent, false);
        OrderListViewHolder vh = new OrderListViewHolder(rootView);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        OrderListViewHolder vh = (OrderListViewHolder) holder;
        OrderListInfo.BodyBean.PageBean.ListBean order = data.get(position);
        //设置Tag
        vh.itemOrderCardView.setTag(order);
        int orderStatus = order.getStatus();
        List<DriverInfo.BodyBean.DictStatusBean> dictStatus = MainActivity.dictStatus;

        vh.itemOrderStartingPoint.setText(order.getHotelAddr());
        vh.itemOrderDestination.setText(order.getCustomerAddr());
        vh.itemOrderCustomerPhone.setText(order.getCustomerTel());
        vh.itemOrderRestaurantPhone.setText(order.getHotelTel());
        vh.itemOrderNo.setText(order.getOrderNo());
        vh.itemOrderFinishedTime.setText(order.getFinishedTime());

        Log.d(Constant.TAG, position + "==status==" + order.getStatus());

        for (int i = 0; i < dictStatus.size(); i++)
        {
            int value = Integer.valueOf(dictStatus.get(i).getValue());
            //司机段订单列表不显示Wait状态下的订单
            //Accept
            if ((orderStatus == value) && (value == 1))
            {
                Log.d(Constant.TAG, "adapter order status is Accept");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_dark));
                vh.itemOrderStatus.setText(R.string.status_accept);
                vh.itemOrderStatusDate.setText(order.getAcceptDate());

                //显示按钮组
                vh.itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //显示PickUp按钮隐藏Finish按钮
                vh.itemOrderPickUpBtn.setVisibility(View.VISIBLE);
                vh.itemOrderFinishBtn.setVisibility(View.GONE);

            }
            //Delivery
            else if ((orderStatus == value) && (value == 2))
            {
                Log.d(Constant.TAG, "adapter order status is Delivery");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_dark));
                vh.itemOrderStatus.setText(R.string.status_delivery);
                vh.itemOrderStatusDate.setText(order.getDeliveryDate());
                //显示按钮组
                vh.itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //隐藏PickUp按钮显示Finish按钮
                vh.itemOrderPickUpBtn.setVisibility(View.GONE);
                vh.itemOrderFinishBtn.setVisibility(View.VISIBLE);
            }
            //Finish
            else if ((orderStatus == value) && (value == 3))
            {
//                Log.d(Constant.TAG,"adapter order status is Finish");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText(R.string.status_finish);
                vh.itemOrderStatusDate.setText(order.getFinishDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Cancel
            else if ((orderStatus == value) && (value == 4))
            {
//                Log.d(Constant.TAG,"adapter order status is Cancel");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText(R.string.status_cancle);
                vh.itemOrderStatusDate.setText(order.getCancelDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Back
            else if ((orderStatus == value) && (value == 5))
            {
//                Log.d(Constant.TAG,"adapter order status is Back");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText(R.string.status_cancle);
                vh.itemOrderStatusDate.setText((String) order.getCancelDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
        }


        //设置btn的点击监听器
        if (onItemClickListener != null)
        {
            vh.itemOrderPickUpBtn.setOnClickListener(new BasicOnClickListener(vh, order));
            vh.itemOrderFinishBtn.setOnClickListener(new BasicOnClickListener(vh, order));
            vh.itemOrderCardView.setOnClickListener(new BasicOnClickListener(vh, order));
        }
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }


    public static class OrderListViewHolder extends RecyclerView.ViewHolder
    {
        private CardView itemOrderCardView;
        private TextView itemOrderStatus;
        private TextView itemOrderStatusDate;
        private LinearLayout itemOrderDriverStartingPointLayout;
        private TextView itemOrderStartingPoint;
        private LinearLayout itemOrderDriverDestinationLayout;
        private TextView itemOrderDestination;
        private LinearLayout itemOrderCustomerPhoneLayout;
        private TextView itemOrderCustomerPhone;
        private LinearLayout itemOrderRestaurantPhoneLayout;
        private TextView itemOrderRestaurantPhone;
        private LinearLayout itemOrderFinishedTimeLayout;
        private TextView itemOrderFinishedTime;
        private LinearLayout itemOrderOrdernoLayout;
        private TextView itemOrderNo;
        private LinearLayout itemOrderOperationLayout;
        private AppCompatButton itemOrderPickUpBtn;
        private AppCompatButton itemOrderFinishBtn;

        private void assignViews(View itemView)
        {
            itemOrderCardView = (CardView)itemView.findViewById(R.id.item_order_card_view);
            itemOrderStatus = (TextView) itemView.findViewById(R.id.item_order_status);
            itemOrderStatusDate = (TextView) itemView.findViewById(R.id.item_order_status_date);
            itemOrderDriverStartingPointLayout = (LinearLayout) itemView.findViewById(R.id.item_order_driver_starting_point_layout);
            itemOrderStartingPoint = (TextView) itemView.findViewById(R.id.item_order_starting_point);
            itemOrderDriverDestinationLayout = (LinearLayout) itemView.findViewById(R.id.item_order_driver_destination_layout);
            itemOrderDestination = (TextView) itemView.findViewById(R.id.item_order_destination);
            itemOrderCustomerPhoneLayout = (LinearLayout) itemView.findViewById(R.id.item_order_customer_phone_layout);
            itemOrderCustomerPhone = (TextView) itemView.findViewById(R.id.item_order_customer_phone);
            itemOrderRestaurantPhoneLayout = (LinearLayout) itemView.findViewById(R.id.item_order_restaurant_phone_layout);
            itemOrderRestaurantPhone = (TextView) itemView.findViewById(R.id.item_order_restaurant_phone);
            itemOrderFinishedTimeLayout = (LinearLayout) itemView.findViewById(R.id.item_order_finished_time_layout);
            itemOrderFinishedTime = (TextView) itemView.findViewById(R.id.item_order_finished_time);
            itemOrderOrdernoLayout = (LinearLayout) itemView.findViewById(R.id.item_order_orderno_layout);
            itemOrderNo = (TextView) itemView.findViewById(R.id.item_order_no);
            itemOrderOperationLayout = (LinearLayout) itemView.findViewById(R.id.item_order_operation_layout);
            itemOrderPickUpBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_pick_up_btn);
            itemOrderFinishBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_finish_btn);
        }


        public OrderListViewHolder(View itemView)
        {
            super(itemView);
            assignViews(itemView);
        }

    }

    /**
     * 第一次加载
     *
     * @param s
     */
    public void updateData(LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> s)
    {
        this.data = s;
        notifyDataSetChanged();
    }

    /**
     * 下拉加载更多
     *
     * @param newDatas
     */
    public void addMoreItem(LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> newDatas)
    {
        Log.d(Constant.TAG, "newDatas-->" + newDatas.size());

        for (int i = 0; i < newDatas.size(); i++)
        {
            data.addLast(newDatas.get(i));
        }
        Log.d(Constant.TAG, "data-->" + data.size());
        notifyItemRangeInserted(getItemCount(), newDatas.size());
        notifyItemRangeChanged(getItemCount(), getItemCount() - newDatas.size());
    }

    public void singleItemUpdate(int position, OrderListInfo.BodyBean.PageBean.ListBean order)
    {
        data.remove(position);
        data.add(position, order);
        notifyItemChanged(position);
    }

    private class BasicOnClickListener implements View.OnClickListener
    {
        private OrderListViewHolder vh;
        private OrderListInfo.BodyBean.PageBean.ListBean order;

        public BasicOnClickListener(OrderListViewHolder vh, OrderListInfo.BodyBean.PageBean.ListBean order)
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
                    onItemClickListener.onItemClick(vh.itemOrderPickUpBtn, vh.getLayoutPosition(), order);
                    break;
                case R.id.item_order_finish_btn:
                    onItemClickListener.onItemClick(vh.itemOrderFinishBtn, vh.getLayoutPosition(), order);
                    break;
                case R.id.item_order_card_view:
                    onItemClickListener.onItemClick(vh.itemOrderCardView, vh.getLayoutPosition(), order);
                    break;
            }
        }
    }

}
