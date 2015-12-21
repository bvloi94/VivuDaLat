package com.loibv.vivudalat.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.loibv.vivudalat.R;

public class ViewPlaceActivity extends AppCompatActivity {

    public static String PLACE_BACKGROUND = "place_background";
    public static String PLACE_EXPLAIN = "place_explain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }

        int imgId = getIntent().getIntExtra(PLACE_BACKGROUND, 0);
        String explainText = getIntent().getStringExtra(PLACE_EXPLAIN);

        TextView placeExplain = (TextView) findViewById(R.id.tvPlaceExplain);
        ImageView placeBackground = (ImageView) findViewById(R.id.ivPlaceBackground);

        placeExplain.setText(explainText);
        placeBackground.setImageResource(imgId);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
        placeExplain.setTypeface(tf);
    }
}
