package com.gaoyy.delivery4driver.main;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.ScoreInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.CommonUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreActivity extends BaseActivity
{

    private Toolbar scoreToolbar;
    private LinearLayout scoreLayout;
    private TextView scoreOne;
    private TextView scoreTwo;
    private TextView scoreThree;
    private TextView scoreFour;
    private TextView scoreFive;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_score);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        scoreToolbar = (Toolbar) findViewById(R.id.score_toolbar);
        scoreLayout = (LinearLayout) findViewById(R.id.score_layout);
        scoreOne = (TextView) findViewById(R.id.score_one);
        scoreTwo = (TextView) findViewById(R.id.score_two);
        scoreThree = (TextView) findViewById(R.id.score_three);
        scoreFour = (TextView) findViewById(R.id.score_four);
        scoreFive = (TextView) findViewById(R.id.score_five);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(scoreToolbar,R.string.menu_score,true,-1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();

        Map<String,String> params = new HashMap<>();
        params.put("loginName", CommonUtils.getLoginName(this));
        params.put("language", CommonUtils.getSysLanguage());
        params.put("random", CommonUtils.getRandomCode(this));
        Call<ScoreInfo> call = RetrofitService.sApiService.score(params);
        call.enqueue(new Callback<ScoreInfo>()
        {
            @Override
            public void onResponse(Call<ScoreInfo> call, Response<ScoreInfo> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    ScoreInfo scoreInfo = response.body();
                    if(scoreInfo.isSuccess())
                    {
                        scoreOne.setText("number:"+scoreInfo.getBody().getOneStar());
                        scoreTwo.setText("number:"+scoreInfo.getBody().getTwoStar());
                        scoreThree.setText("number:"+scoreInfo.getBody().getThreeStar());
                        scoreFour.setText("number:"+scoreInfo.getBody().getFourStar());
                        scoreFive.setText("number:"+scoreInfo.getBody().getFiveStar());

                    }
                }
            }

            @Override
            public void onFailure(Call<ScoreInfo> call, Throwable t)
            {

            }
        });
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
