package com.gaoyy.delivery4driver.base.recycler;

import android.view.View;

/**
 * Created by gaoyy on 2017/10/28 0028.
 */

public interface OnItemClickListener<T>
{
    void onItemClick(View view, int position, T itemData);
}
