package com.gaoyy.delivery4driver.main;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.base.BaseActivity;

public class SearchActivity extends BaseActivity
{
    private Toolbar searchToolbar;
    private EditText searchEdit;
    private RecyclerView searchRv;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_search);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        searchToolbar = (Toolbar) findViewById(R.id.search_toolbar);
        searchEdit = (EditText) findViewById(R.id.search_edit);
        searchRv = (RecyclerView) findViewById(R.id.search_rv);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(searchToolbar,"",true,-1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();
        String inputText = getIntent().getStringExtra("inputingText");
        searchEdit.setText(inputText);
        //将光标移至文字末尾
        searchEdit.setSelection(inputText.length());
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
