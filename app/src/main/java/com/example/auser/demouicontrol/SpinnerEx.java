package com.example.auser.demouicontrol;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerEx extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ex);

        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.cards,android.R.layout.simple_spinner_item);//1.context,2.下拉式  3.未下拉之前的LAYOT  因為資源是做在xml的字串陣列,不是用new,
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//設定下接時所需外觀,每個細項所使用的LAYOUT形
//        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);//畫面會有radio button
//        adapter.setDropDownViewResource(R.layout.自己內建的layout);//畫面會有radio button
        adapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice);//畫面會有checkbox



        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spStr = String.valueOf(parent.getSelectedItem());  //取得選取的ID ; 若要取得選取的文字,可改用getSelectedItem()
                Toast.makeText(SpinnerEx.this, spStr,
                        Toast.LENGTH_SHORT).show();
//                Toast.makeText(SpinnerEx.this,"您選擇的是第" + parent.getSelectedItem +(position+1)+"項",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(SpinnerEx.this,"您沒選擇",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override//在action bar上面放選單,來源是menu文件
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner_menu,menu);
        MenuItem item=menu.findItem(R.id.actionbar_spinner);
        Spinner ab_spinner=(Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.cards,android.R.layout.simple_spinner_item);//1.context,2.下拉式  3.未下拉之前的LAYOT  因為資源是做在xml的字串陣列,不是用new,
        adapter.setDropDownViewResource(R.layout.select_dialog_multichoice);//畫面會有checkbox


        ab_spinner.setAdapter(adapter);
        ab_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerEx.this,"您選擇的是第" + (position+1)+"項",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(SpinnerEx.this,"您沒選擇",Toast.LENGTH_SHORT).show();

            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
