package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewEx extends AppCompatActivity {
    ListView listView;
    String[] arrays={"網路概論","通訊概論","通訊網路實驗"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ex);
//
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,arrays);//準備好adapter物件
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//simple_list_item_single_choice的類型是使用checkedTextView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewEx.this
                        ,"第" + (position+1) + "項" + ((CheckedTextView)view).getText().toString()
                        ,Toast.LENGTH_SHORT).show();
            }
        });


    }

}
