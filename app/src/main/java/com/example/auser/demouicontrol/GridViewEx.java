package com.example.auser.demouicontrol;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_ex);
        gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));



    }

    //自訂一個imageadapter,BaseAdaptera是android內建的基本adapter類型
    class ImageAdapter extends BaseAdapter{
        int[] imageResids={//建立圖片資料陣列
                R.drawable.img001,
                R.drawable.img002,
                R.drawable.img003,
                R.drawable.img004,
                R.drawable.img005,
                R.drawable.img006,
                R.drawable.img007,
                R.drawable.img008,
                R.drawable.img009,
                R.drawable.img010,
                R.drawable.img011,
                R.drawable.img012
        };

        //手動建構adapter 的context//配合底下getView()可傳入comtext參數
        Context mCtx;
        ImageAdapter(Context context){
            mCtx=context;
        }
        @Override
        public int getCount() {//傳回資料項目個數,或幾個icon圖示
            return imageResids.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override //設定圖片
        public View getView(int position, View convertView, ViewGroup parent) {
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

//        TextView TextView1 = (TextView)findViewById(R.id.TextView01);
//        TextView1.setText("手機銀幕大小為 "+metrics.widthPixels+" X "+metrics.heightPixels);
//            Log.d("手機銀幕大小為",+metrics.widthPixels+" X "+metrics.heightPixels);

            ImageView imageView=new ImageView(mCtx);
            imageView.setLayoutParams(new GridView.LayoutParams((metrics.widthPixels-200)/4,200));//參數可換成營暮width
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
            imageView.setImageResource(imageResids[position]);//加上圖片設定
//            imageView
            return imageView;
        }
    }
}
