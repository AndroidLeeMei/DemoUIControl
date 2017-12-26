package com.example.auser.demouicontrol;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditTextEx extends AppCompatActivity {
    //加入偏好設定
    public static final String PREF="DemoUI_PREF";  //在shared_ref存檔的檔名
    public static final String PREF_USERNAME="BMI_USERNAME";
    public static final String PREF_PASSWORD="BMI_PASSWORD";
    EditText fieldUserName,fieldPasswrod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViews();
    }



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

    void findViews(){
        fieldUserName = (EditText) findViewById(R.id.editUserName);
        fieldPasswrod = (EditText) findViewById(R.id.editPassword);
    }
    @Override
    protected void onPause() {
        super.onPause();

        //Save user preferences. use Editor object to make changes.
        SharedPreferences settings=getSharedPreferences(PREF,0);
        settings.edit().putString(PREF_USERNAME,
                fieldUserName.getText().toString()).commit();
        settings.edit().putString(PREF_PASSWORD,
                fieldPasswrod.getText().toString()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d(TAG,"Bmi.onResume");
        restorePrefs();
    }


    public void save(View target){

        onPause();
    }
}
