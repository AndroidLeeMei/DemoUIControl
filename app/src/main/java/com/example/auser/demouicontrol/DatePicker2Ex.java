package com.example.auser.demouicontrol;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePicker2Ex extends AppCompatActivity {
    DatePicker datePicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker2_ex);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        button=(Button)findViewById(R.id.button3);

        Calendar calendar=Calendar.getInstance();

        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH),onDateChangedListener);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int year=datePicker.getYear();
                int month=datePicker.getMonth();
                int day=datePicker.getDayOfMonth();
                Toast.makeText(DatePicker2Ex.this
                        ,"您選擇的日期:" + year + "/" + (month+1) +":" + day
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OpenDate(View target){
                        int year=datePicker.getYear();
                int month=datePicker.getMonth();
                int day=datePicker.getDayOfMonth();
                Toast.makeText(DatePicker2Ex.this
                        ,"您選擇的日期:" + year + "/" + month +":" + day
                        ,Toast.LENGTH_SHORT).show();

    }

    DatePicker.OnDateChangedListener onDateChangedListener=new DatePicker.OnDateChangedListener(){

        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Toast.makeText(DatePicker2Ex.this
                    ,"您選擇的日期:" + year + "/" + (monthOfYear+1) + ":" + dayOfMonth
                    ,Toast.LENGTH_SHORT).show();
        }
    };
}
