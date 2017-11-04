package com.gaoyy.delivery4driver.base.recycler;

import android.widget.ImageView;

/**
 * Created by gaoyy on 2017/10/28 0028.
 */

public class ImageLoader extends BaseViewHolder.ImageLoaderManager
{

    public ImageLoader(String path)
    {
        super(path);
    }

    @Override
    public void loadImage(ImageView iv, String path)
    {
        //加载网络图片
    }
}
