package com.gaoyy.delivery4driver.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
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
        int orderStatus = order.getStatus();
        List<DriverInfo.BodyBean.DictStatusBean> dictStatus = MainActivity.dictStatus;
        vh.itemOrderAddress.setText(order.getId()+"===="+order.getCustomerAddr());
        vh.itemOrderDriverName.setText(order.getCourierName());
        vh.itemOrderCustomerPhone.setText(order.getCustomerTel());
        vh.itemOrderNo.setText(order.getOrderNo());
        vh.itemOrderNotes.setText(order.getRemarks());
        vh.itemOrderOthers.setText(order.getRemark());
        vh.itemOrderFinishedTime.setText(order.getFinishedTime());

        Log.d(Constant.TAG,position+"==status=="+order.getStatus());

        for (int i = 0; i < dictStatus.size(); i++)
        {
            int value = Integer.valueOf(dictStatus.get(i).getValue());
            //Wait
            if ((orderStatus == value) && (value == 0))
            {
                Log.d(Constant.TAG, "adapter order status is Wait");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_dark));
                vh.itemOrderStatus.setText("Wait");
                vh.itemOrderStatusDate.setText(order.getCreateDate());
                //隐藏司机名字
                vh.itemOrderDriverNameLayout.setVisibility(View.GONE);

                //显示按钮组
                vh.itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //显示Cancle按钮和resubmit按钮
                vh.itemOrderCancleBtn.setVisibility(View.VISIBLE);
                if(order.getIsTimeout() == 1)
                {
                    vh.itemOrderResubmitBtn.setVisibility(View.VISIBLE);
                }
                else
                {
                    vh.itemOrderResubmitBtn.setVisibility(View.GONE);
                }
                vh.itemOrderDeliveryBtn.setVisibility(View.GONE);
                vh.itemOrderCancleAfterDeliveryBtn.setVisibility(View.GONE);

            }
            //Accept
            else if ((orderStatus == value) && (value == 1))
            {
                Log.d(Constant.TAG,"adapter order status is Accept");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_dark));
                vh.itemOrderStatus.setText("Accept");
                vh.itemOrderStatusDate.setText(order.getAcceptDate());

                //显示按钮组
                vh.itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //显示Cancle按钮和Delivery按钮
                vh.itemOrderCancleBtn.setVisibility(View.VISIBLE);
                vh.itemOrderResubmitBtn.setVisibility(View.GONE);
                vh.itemOrderDeliveryBtn.setVisibility(View.VISIBLE);
                vh.itemOrderCancleAfterDeliveryBtn.setVisibility(View.GONE);

            }
            //Delivery
            else if ((orderStatus == value) && (value == 2))
            {
                Log.d(Constant.TAG,"adapter order status is Delivery");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_dark));
                vh.itemOrderStatus.setText("Delivery");
                vh.itemOrderStatusDate.setText(order.getDeliveryDate());
                //显示按钮组
                vh.itemOrderOperationLayout.setVisibility(View.VISIBLE);
                //显示CancleAfterDelivery按钮
                vh.itemOrderCancleBtn.setVisibility(View.GONE);
                vh.itemOrderResubmitBtn.setVisibility(View.GONE);
                vh.itemOrderDeliveryBtn.setVisibility(View.GONE);
                vh.itemOrderCancleAfterDeliveryBtn.setVisibility(View.VISIBLE);
            }
            //Finish
            else if((orderStatus == value) && (value == 3))
            {
//                Log.d(Constant.TAG,"adapter order status is Finish");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText("Finish");
                vh.itemOrderStatusDate.setText(order.getFinishDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Cancel
            else if ((orderStatus == value) && (value == 4))
            {
//                Log.d(Constant.TAG,"adapter order status is Cancel");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText("Cancel");
                vh.itemOrderStatusDate.setText((String) order.getCancelDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
            //Back
            else if ((orderStatus == value) && (value == 5))
            {
//                Log.d(Constant.TAG,"adapter order status is Back");
                vh.itemOrderStatus.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                vh.itemOrderStatus.setText("Back");
                vh.itemOrderStatusDate.setText((String) order.getCancelDate());

                //不显示按钮
                vh.itemOrderOperationLayout.setVisibility(View.GONE);
            }
        }


        //设置btn的点击监听器
        if(onItemClickListener != null)
        {
            vh.itemOrderCancleBtn.setOnClickListener(new BasicOnClickListener(vh,order));
            vh.itemOrderResubmitBtn.setOnClickListener(new BasicOnClickListener(vh,order));
            vh.itemOrderDeliveryBtn.setOnClickListener(new BasicOnClickListener(vh,order));
            vh.itemOrderCancleAfterDeliveryBtn.setOnClickListener(new BasicOnClickListener(vh,order));
        }
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }


    public static class OrderListViewHolder extends RecyclerView.ViewHolder
    {
        private TextView itemOrderStatus;
        private TextView itemOrderStatusDate;
        private TextView itemOrderAddress;
        private LinearLayout itemOrderDriverNameLayout;
        private TextView itemOrderDriverName;
        private LinearLayout itemOrderCustomerPhoneLayout;
        private TextView itemOrderCustomerPhone;
        private LinearLayout itemOrderOrdernoLayout;
        private TextView itemOrderNo;
        private LinearLayout itemOrderNotesLayout;
        private TextView itemOrderNotes;
        private LinearLayout itemOrderOthersLayout;
        private TextView itemOrderOthers;
        private LinearLayout itemOrderFinishedTimeLayout;
        private TextView itemOrderFinishedTime;
        private LinearLayout itemOrderOperationLayout;
        private AppCompatButton itemOrderCancleBtn;
        private AppCompatButton itemOrderResubmitBtn;
        private AppCompatButton itemOrderDeliveryBtn;
        private AppCompatButton itemOrderCancleAfterDeliveryBtn;

        private void assignViews(View itemView)
        {
            itemOrderStatus = (TextView) itemView.findViewById(R.id.item_order_status);
            itemOrderStatusDate = (TextView) itemView.findViewById(R.id.item_order_status_date);
            itemOrderAddress = (TextView) itemView.findViewById(R.id.item_order_address);
            itemOrderDriverNameLayout = (LinearLayout) itemView.findViewById(R.id.item_order_driver_name_layout);
            itemOrderDriverName = (TextView) itemView.findViewById(R.id.item_order_driver_name);
            itemOrderCustomerPhoneLayout = (LinearLayout) itemView.findViewById(R.id.item_order_customer_phone_layout);
            itemOrderCustomerPhone = (TextView) itemView.findViewById(R.id.item_order_customer_phone);
            itemOrderOrdernoLayout = (LinearLayout) itemView.findViewById(R.id.item_order_orderno_layout);
            itemOrderNo = (TextView) itemView.findViewById(R.id.item_order_no);
            itemOrderNotesLayout = (LinearLayout) itemView.findViewById(R.id.item_order_notes_layout);
            itemOrderNotes = (TextView) itemView.findViewById(R.id.item_order_notes);
            itemOrderOthersLayout = (LinearLayout) itemView.findViewById(R.id.item_order_others_layout);
            itemOrderOthers = (TextView) itemView.findViewById(R.id.item_order_others);
            itemOrderFinishedTimeLayout = (LinearLayout) itemView.findViewById(R.id.item_order_finished_time_layout);
            itemOrderFinishedTime = (TextView) itemView.findViewById(R.id.item_order_finished_time);
            itemOrderOperationLayout = (LinearLayout) itemView.findViewById(R.id.item_order_operation_layout);
            itemOrderCancleBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_cancle_btn);
            itemOrderResubmitBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_resubmit_btn);
            itemOrderDeliveryBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_delivery_btn);
            itemOrderCancleAfterDeliveryBtn = (AppCompatButton) itemView.findViewById(R.id.item_order_cancle_after_delivery_btn);
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
        data.add(position,order);
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
                case R.id.item_order_cancle_btn:
                    onItemClickListener.onItemClick(vh.itemOrderCancleBtn, vh.getLayoutPosition(),order);
                    break;
                case R.id.item_order_resubmit_btn:
                    onItemClickListener.onItemClick(vh.itemOrderResubmitBtn, vh.getLayoutPosition(),order);
                    break;
                case R.id.item_order_delivery_btn:
                    onItemClickListener.onItemClick(vh.itemOrderDeliveryBtn, vh.getLayoutPosition(),order);
                    break;
                case R.id.item_order_cancle_after_delivery_btn:
                    onItemClickListener.onItemClick(vh.itemOrderCancleAfterDeliveryBtn, vh.getLayoutPosition(),order);
                    break;
            }
        }
    }

}
