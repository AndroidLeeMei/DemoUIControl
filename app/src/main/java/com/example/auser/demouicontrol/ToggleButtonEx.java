package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ToggleButtonEx extends AppCompatActivity {
    ToggleButton toggleButton,toggleButton2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);
        findViews();
        setListeners();
    }

    private void findViews(){
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
        toggleButton2=(ToggleButton)findViewById(R.id.toggleButton1);
        imageView=(ImageView)findViewById(R.id.imageView);

    }
    private void setListeners(){
        toggleButton.setOnCheckedChangeListener(listener);
        toggleButton2.setOnCheckedChangeListener(listener);


    }
    ToggleButton.OnCheckedChangeListener listener= new ToggleButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                imageView.setImageResource(R.drawable.tip_bright);
            else
                imageView.setImageResource(R.drawable.tip_dark);
        }
    };
}
