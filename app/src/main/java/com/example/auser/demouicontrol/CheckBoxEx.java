package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckBoxEx extends AppCompatActivity {
//    RadioGroup rg1,rg2,rg3;
    CheckBox cb11,cb12,cb13,cb21,cb22,cb23;
    Button submit;
    TextView result,result1;
    String text="您喜歡的顏色是:\n";
    String text1= "您喜歡的休閒活動是:\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        findViews();
        setListeners();

    }


    private void findViews(){
        cb11=(CheckBox) findViewById(R.id.checkBox11);
        cb12=(CheckBox) findViewById(R.id.checkBox12);
        cb13=(CheckBox) findViewById(R.id.checkBox13);
        cb21=(CheckBox) findViewById(R.id.checkBox21);
        cb22=(CheckBox) findViewById(R.id.checkBox22);
        cb23=(CheckBox) findViewById(R.id.checkBox23);
        submit=(Button)findViewById(R.id.submit);
        result=(TextView)findViewById(R.id.result);
        result1=(TextView)findViewById(R.id.result1);
    }

    private  void setListeners(){
        submit.setOnClickListener(btnListener);
        cb11.setOnCheckedChangeListener(cbkListener);
        cb12.setOnCheckedChangeListener(cbkListener);
        cb13.setOnCheckedChangeListener(cbkListener);
        cb21.setOnCheckedChangeListener(cbkListener);
        cb22.setOnCheckedChangeListener(cbkListener);
        cb23.setOnCheckedChangeListener(cbkListener);
    }

    View.OnClickListener btnListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {




            if (cb11.isChecked())
                text = text + cb11.getText() + ",";
            if (cb12.isChecked())
                text = text + cb12.getText()+ ",";
            if (cb13.isChecked())
                text = text + cb13.getText()+ ",";



            if (cb21.isChecked())
                text1 = text1 + cb21.getText() + ",";
            if (cb22.isChecked())
                text1 = text1 + cb22.getText()+ ",";
            if (cb23.isChecked())
                text1 = text1 + cb23.getText()+ ",";

            showResult(text,text1);

        }
    };


    CheckBox.OnCheckedChangeListener cbkListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            if (buttonView==cb11||buttonView==cb12||buttonView==cb13) {
                if (isChecked) {
                    text=text+buttonView.getText().toString() + ",";

                }
                else {
                    text=text.replace(buttonView.getText().toString() + ",", "");

                }
            }else  {
                if (isChecked) {
                    text1 = text1 + buttonView.getText().toString() + ",";

                }
                else {
                    text1=text1.replace(buttonView.getText().toString() + ",", "");
                }
            }


            showResult(text,text1);
        }
    };

    private void showResult(String text,String text1){

        if (text.endsWith(","))
            result.setText(text.substring(0,text.length()-1));
        else
            result.setText(text);

        if (text1.endsWith(","))
            result1.setText(text1.substring(0,text1.length()-1));
        else
            result1.setText(text1);

    }
}
