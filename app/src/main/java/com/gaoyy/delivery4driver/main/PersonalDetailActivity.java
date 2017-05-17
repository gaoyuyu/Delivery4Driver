package com.gaoyy.delivery4driver.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.base.BaseActivity;

public class PersonalDetailActivity extends BaseActivity
{

    private Toolbar personalDetailToolbar;
    private LinearLayout activityPersonalDetail;
    private TextView personalDetailName;
    private TextView personalDetailGender;
    private TextView personalDetailAccount;
    private TextView personalDetailAge;
    private TextView personalDetailPhoneNumber;
    private TextView personalDetailId;
    private TextView personalDetailPlateNumber;
    private TextView textView;
    private TextView personalDetailDriverLicense;
    private TextView personalDetailDlExpiredDate;
    private TextView personalDetailInsuranceDate;
    private TextView personalDetailAddress;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_personal_detail);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        personalDetailToolbar = (Toolbar) findViewById(R.id.personal_detail_toolbar);
        activityPersonalDetail = (LinearLayout) findViewById(R.id.activity_personal_detail);
        personalDetailName = (TextView) findViewById(R.id.personal_detail_name);
        personalDetailGender = (TextView) findViewById(R.id.personal_detail_gender);
        personalDetailAccount = (TextView) findViewById(R.id.personal_detail_account);
        personalDetailAge = (TextView) findViewById(R.id.personal_detail_age);
        personalDetailPhoneNumber = (TextView) findViewById(R.id.personal_detail_phone_number);
        personalDetailId = (TextView) findViewById(R.id.personal_detail_id);
        personalDetailPlateNumber = (TextView) findViewById(R.id.personal_detail_plate_number);
        textView = (TextView) findViewById(R.id.textView);
        personalDetailDriverLicense = (TextView) findViewById(R.id.personal_detail_driver_license);
        personalDetailDlExpiredDate = (TextView) findViewById(R.id.personal_detail_dl_expired_date);
        personalDetailInsuranceDate = (TextView) findViewById(R.id.personal_detail_insurance_date);
        personalDetailAddress = (TextView) findViewById(R.id.personal_detail_address);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(personalDetailToolbar,"个人详情",true,-1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();
        SharedPreferences courierInfo = getSharedPreferences("courier", Activity.MODE_PRIVATE);

        personalDetailName.setText(courierInfo.getString("name",""));
        if(courierInfo.getString("sex","").equals("1"))
        {
            personalDetailGender.setText("male");
        }
        else
        {
            personalDetailGender.setText("female");
        }
        personalDetailAccount.setText(courierInfo.getString("userName",""));
        personalDetailAge.setText(courierInfo.getString("age",""));
        personalDetailPhoneNumber.setText(courierInfo.getString("tel",""));
        personalDetailId.setText(courierInfo.getString("idCard",""));
        personalDetailPlateNumber.setText("plate");
        personalDetailDriverLicense.setText(courierInfo.getString("driverNumber",""));
        personalDetailDlExpiredDate.setText(courierInfo.getString("driverDate",""));
        personalDetailInsuranceDate.setText(courierInfo.getString("carInsurance",""));
        personalDetailAddress.setText(courierInfo.getString("addr",""));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
