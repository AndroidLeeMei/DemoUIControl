package com.example.auser.demouicontrol;

import android.app.DatePickerDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerDialogEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_ex);
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,listener,calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));  //選第三個
        datePickerDialog.show();
    }
    DatePickerDialog.OnDateSetListener listener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(DatePickerDialogEx.this
                    ,"您選擇的日期:" + year + "/" + (month+1) +"/" + dayOfMonth
                    ,Toast.LENGTH_SHORT).show();
        }
    };
}
