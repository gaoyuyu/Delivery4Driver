package com.gaoyy.delivery4driver.main.driver;


import android.support.v4.app.Fragment;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DriverFragment extends BaseFragment
{


    public DriverFragment()
    {
        // Required empty public constructor
    }

    public static DriverFragment newInstance()
    {
        DriverFragment fragment = new DriverFragment();
        return fragment;
    }


    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_driver;
    }
}
