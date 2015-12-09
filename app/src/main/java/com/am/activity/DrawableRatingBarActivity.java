package com.am.activity;

import android.app.Activity;
import android.os.Bundle;

import com.am.widget.R;
import com.am.widget.drawableratingbar.DrawableRatingBar;

/**
 * 星标评级
 * Created by Alex on 2015/8/31.
 */
public class DrawableRatingBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawableratingbar);
        DrawableRatingBar drBar = (DrawableRatingBar) findViewById(R.id.ratingbar);
        drBar.setRating(3);
    }
}
