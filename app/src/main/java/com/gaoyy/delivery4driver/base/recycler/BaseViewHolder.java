package com.gaoyy.delivery4driver.base.recycler;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gaoyy on 2017/10/28 0028.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder
{

    //存储View数据，同HashMap
    private SparseArrayCompat<View> mViews;

    public BaseViewHolder(View itemView)
    {
        super(itemView);
        mViews = new SparseArrayCompat<>();
    }

    public <T extends View> T getView(int viewId)
    {
        // 先从缓存中找
        View view = mViews.get(viewId);
        if (view == null)
        {
            // 直接从ItemView中找
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    //==============通用=======================

    /**
     * 设置文本，支持链式调用
     *
     * @param viewId
     * @param str
     * @return BaseViewHolder
     */
    public BaseViewHolder setText(int viewId, String str)
    {
        TextView tv = getView(viewId);
        tv.setText(str);
        return this;
    }

    /**
     * 设置文本，支持链式调用
     *
     * @param viewId
     * @param stringId
     * @return BaseViewHolder
     */
    public BaseViewHolder setTextById(int viewId, int stringId)
    {
        TextView tv = getView(viewId);
        tv.setText(stringId);
        return this;
    }

    /**
     * 设置可见，支持链式调用
     *
     * @param viewId
     * @param visibility View.GONE | View.INVISIBLE | View.VISIBLE
     */
    public BaseViewHolder setVisibility(int viewId, int visibility)
    {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    /**
     * 设置本地图片资源，支持链式调用
     *
     * @param viewId
     * @param resourceId
     * @return BaseViewHolder
     */
    public BaseViewHolder setImageResource(int viewId, int resourceId)
    {
        ImageView iv = getView(viewId);
        iv.setImageResource(resourceId);
        return this;
    }

    /**
     * 加载网络图片，支持链式调用
     *
     * @param viewId
     * @param imageLoaderManager
     * @return
     */
    public BaseViewHolder setImagePath(int viewId, ImageLoaderManager imageLoaderManager)
    {
        ImageView iv = getView(viewId);
        imageLoaderManager.loadImage(iv, imageLoaderManager.getPath());
        return this;
    }

    /**
     * 统一的网络图片加载规范
     */
    public abstract static class ImageLoaderManager
    {
        private String path;

        public String getPath()
        {
            return path;
        }

        public ImageLoaderManager(String path)
        {
            this.path = path;
        }

        public abstract void loadImage(ImageView iv, String path);
    }


    /**
     * 对整一个item设置点击事件
     */
    public void setOnItemLayoutClickListener()
    {
    }

    /**
     * 对整一个item设置长按事件
     */
    public void setOnItemLayoutLongClickListener()
    {

    }


}
