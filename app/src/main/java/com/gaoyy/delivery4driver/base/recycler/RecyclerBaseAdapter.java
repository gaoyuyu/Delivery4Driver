package com.gaoyy.delivery4driver.base.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaoyy on 2017/10/28 0028.
 */

public abstract class RecyclerBaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>
{
    //item layout id
    private int mLayoutId;

    //数据
    protected List<T> mData;

    protected LayoutInflater mLayoutInflater;

    protected Context mContext;

    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.onItemClickListener = listener;
    }


    public RecyclerBaseAdapter(Context context, int layoutId, List<T> data)
    {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
        this.mData = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemView = mLayoutInflater.inflate(mLayoutId, parent, false);
        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position)
    {
        bindData(holder, mData.get(position), position);
    }

    protected abstract void bindData(BaseViewHolder holder, T itemData, int position);


    @Override
    public int getItemCount()
    {
        return mData.size();
    }


    /**
     * 第一次加载
     *
     * @param data
     */
    public void updateData(List<T> data)
    {
        this.mData = data;
        notifyDataSetChanged();
    }

    /**
     * 下拉加载更多
     *
     * @param newDatas
     */
    public void addMoreItem(List<T> newDatas)
    {
        for (int i = 0; i < newDatas.size(); i++)
        {
            ((LinkedList) mData).addLast(newDatas.get(i));
        }
        notifyItemRangeInserted(getItemCount(), newDatas.size());
        notifyItemRangeChanged(getItemCount(), getItemCount() - newDatas.size());
    }

    /**
     * 单个item刷新
     *
     * @param position
     * @param item
     */
    public void singleItemUpdate(int position, T item)
    {
        mData.remove(position);
        mData.add(position, item);
        notifyItemChanged(position);
    }

    /**
     * 移除单个item
     *
     * @param position
     */
    public void removeSingleItem(int position)
    {
        mData.remove(position);//删除数据源
        notifyItemRemoved(position);//刷新被删除的地方
        notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
    }
}
