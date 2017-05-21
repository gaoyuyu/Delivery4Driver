package com.gaoyy.delivery4driver.changepwd;


import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.base.BaseFragment;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.login.LoginActivity;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;

import java.util.HashMap;
import java.util.Map;

public class ChangePwdFragment extends BaseFragment implements ChangePwdContract.View
{
    private static final String LOG_TAG = ChangePwdFragment.class.getSimpleName();

    private TextInputLayout changeOldpwdTextinputlayout;
    private TextInputEditText changeOldpwd;
    private TextInputLayout changeNewpwdTextinputlayout;
    private TextInputEditText changeNewpwd;

    private ChangePwdContract.Presenter mChangePwdPresenter;
    private CustomDialogFragment loading;
    public ChangePwdFragment()
    {
        // Required empty public constructor
    }

    public static ChangePwdFragment newInstance()
    {
        ChangePwdFragment fragment = new ChangePwdFragment();
        return fragment;
    }
    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_change_pwd;
    }


    @Override
    protected void assignViews(View rootView)
    {
        super.assignViews(rootView);
        changeOldpwdTextinputlayout = (TextInputLayout) rootView.findViewById(R.id.change_oldpwd_textinputlayout);
        changeOldpwd = (TextInputEditText) rootView.findViewById(R.id.change_oldpwd);
        changeNewpwdTextinputlayout = (TextInputLayout) rootView.findViewById(R.id.change_newpwd_textinputlayout);
        changeNewpwd = (TextInputEditText) rootView.findViewById(R.id.change_newpwd);
    }

    /**
     * 校验输入
     */
    public void validate()
    {
        CommonUtils.textInputLayoutSetting(changeOldpwd,changeOldpwdTextinputlayout,"Can't be empty");
        CommonUtils.textInputLayoutSetting(changeNewpwd,changeNewpwdTextinputlayout,"Can't be empty");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        activity.getMenuInflater().inflate(R.menu.change_pwd, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_change_pwd:
                validate();
                Map<String,String> params = new HashMap<>();
                params.put("loginName",CommonUtils.getLoginName(activity));
                params.put("randomCode",CommonUtils.getRandomCode(activity));
                params.put("password",changeOldpwd.getText().toString());
                params.put("newPassword",changeNewpwd.getText().toString());
                mChangePwdPresenter.changePwd(params);
                break;
        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onResume()
    {
        super.onResume();
        mChangePwdPresenter.start();
    }

    @Override
    public boolean isActive()
    {
        return isAdded();
    }

    @Override
    public void showLoading()
    {
        loading = DialogUtils.showLoadingDialog(activity);
    }

    @Override
    public void hideLoading()
    {
        if (loading != null)
        {
            loading.dismiss();
        }
    }

    @Override
    public void showToast(String msg)
    {
        CommonUtils.showToast(activity, msg);
    }

    @Override
    public void redirectToLogin()
    {
        Intent login = new Intent(activity, LoginActivity.class);
        startActivity(login);
    }

    @Override
    public void setPresenter(ChangePwdContract.Presenter presenter)
    {
        Log.i(Constant.TAG, LOG_TAG + "  setPresenter");
        if (presenter != null)
        {
            mChangePwdPresenter = presenter;
        }
    }
}
