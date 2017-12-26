package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar ra1,ra2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        ra1=(RatingBar)findViewById(R.id.ratingBar1);
        ra2=(RatingBar)findViewById(R.id.ratingBar2);
        ra2.setOnRatingBarChangeListener(listener);

    }
    RatingBar.OnRatingBarChangeListener listener=new RatingBar.OnRatingBarChangeListener(){
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Toast.makeText(RatingBarActivity.this,"您目前的分數是:" + (int)rating, Toast.LENGTH_SHORT).show();
        }
    };
}

