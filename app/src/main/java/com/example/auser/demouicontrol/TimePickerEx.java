package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerEx extends AppCompatActivity {
    TimePicker timePicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_ex);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(onTimeChangedListener);

        button=(Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour=timePicker.getCurrentHour();  //getMinute,getHour是新方法,手機要6.0以上才支援
                int minute=timePicker.getCurrentMinute();
                Toast.makeText(TimePickerEx.this,"您選擇的時間是:" + hour + ":" + minute,Toast.LENGTH_SHORT).show();
            }
        });
    }

//    TimePicker.OnTimeChangedListener
    TimePicker.OnTimeChangedListener onTimeChangedListener= new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(TimePickerEx.this,"您選擇的時間是:" + hourOfDay + ":" + minute,Toast.LENGTH_SHORT).show();

        }
    };
}
