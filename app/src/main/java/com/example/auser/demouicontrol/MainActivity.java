package com.example.auser.demouicontrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //加入偏好設定
    public static final String PREF="DemoUI_PREF";  //在shared_ref存檔的檔名
    public static final String PREF_USERNAME="BMI_USERNAME";
    public static final String PREF_PASSWORD="BMI_PASSWORD";
    EditText fieldUserName,fieldPasswrod;

    ListView listView;
    String[] activityNames={"GridViewEx","SpinnerEx","EditTextEx","RadioEx","CheckBoxEx","ToggleButtonEx","ProgressBarEx","RatingBarActivity","DatePickerEx","DatePicker2Ex","TimePickerEx","DatePickerDialogEx","Main2Activity","ListViewEx"};
    Class[] activityClass={GridViewEx.class,SpinnerEx.class,EditTextEx.class,RadioEx.class,CheckBoxEx.class
            ,ToggleButtonEx.class,ProgressBarEx.class,
            RatingBarActivity.class,DatePickerEx.class,DatePicker2Ex.class,
            TimePickerEx.class,DatePickerDialogEx.class,Main2Activity.class,ListViewEx.class};
    Class<?>[] activityClasss={GridViewEx.class,SpinnerEx.class,MainActivity.class
            ,EditTextEx.class,RadioEx.class,CheckBoxEx.class
            ,ToggleButtonEx.class,ProgressBarEx.class,
            RatingBarActivity.class,DatePickerEx.class,DatePicker2Ex.class,
            TimePickerEx.class,DatePickerDialogEx.class,Main2Activity.class
            ,ListViewEx.class};

    //Restore preferences
    private void restorePrefs(){
        SharedPreferences settings=getSharedPreferences(PREF,0);
        String pref_password=settings.getString(PREF_PASSWORD,"");
        String pref_username=settings.getString(PREF_USERNAME,"");


        if (!"".equals(pref_password)){
            fieldPasswrod.setText(pref_password);
            fieldUserName.requestFocus();
        }

        if (!"".equals(pref_username)){
            fieldUserName.setText(pref_username);
            fieldUserName.requestFocus();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
////
////        //Save user preferences. use Editor object to make changes.
//        SharedPreferences settings=getSharedPreferences(PREF,0);
//        settings.edit().putString(PREF_USERNAME,
//                fieldUserName.getText().toString()).commit();
////        settings.edit().putString(PREF_PASSWORD,
////                fieldPasswrod.getText().toString()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d(TAG,"Bmi.onResume");
        restorePrefs();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
//        Log.d("length=",""+activityNames.length);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this
                ,android.R.layout.simple_list_item_1
                ,getActivityNames());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this
//                        ,"第" + (position+1) + "項" + activityClass[position].getClass()
//                        ,Toast.LENGTH_SHORT).show();

                //將畫面指向另一個java頁面
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,activityClass[position]);
                startActivity(intent);


                //將畫面指向另一個java頁面
//                Intent intent=new Intent();
//                intent.setClass(MainActivity.this,getActivityNames[position]);
//                startActivity(intent);

            }
        });

    }

    String[] getActivityNames(){
        String[] activityNames=new String[activityClass.length];
        for (int i=0;i<activityClass.length;i++)
            activityNames[i]=activityClasss[i].getSimpleName();
        return activityNames;
    }
    void findViews(){
        fieldUserName = (EditText) findViewById(R.id.editUserName);
        fieldPasswrod = (EditText) findViewById(R.id.editPassword);
        listView=(ListView)findViewById(R.id.listView);

    }

    public void save(View target){
        onPause();
    }
    public void openUserData(View target){
//        System.out.println("openAllTool");
        Intent intent=new Intent();
        intent.setClass( this,EditTextEx.class);
        startActivity(intent);
    }


}
