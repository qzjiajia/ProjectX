package com.am.activity;

import android.app.Activity;
import android.os.Bundle;

import com.am.widget.R;

/**
 * 自动换行布局
 * Created by Alex on 2015/9/17.
 */
public class WrapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wraplayout);
    }
}
