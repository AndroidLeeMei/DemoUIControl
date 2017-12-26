package com.example.auser.demouicontrol;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarEx extends AppCompatActivity {
    ProgressBar progressBarH,progressBar,progressBarS;
    TextView tvPercent,tvPercentS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBarH=(ProgressBar)findViewById(R.id.progressBarH);
        progressBarS=(ProgressBar)findViewById(R.id.myProgressBarS);
        tvPercent=(TextView)findViewById(R.id.percent);
        tvPercentS=(TextView)findViewById(R.id.percentS);
//        progressBarH.setProgress(10);
//        progressBarH.setProgress(50);
//        progressBarH.setProgress(80);
        //建立一個物件,並開始執行,用  XXX.execute()
        new MyAsyncTask().execute("開始下載");

    }



    //建立一個內部類別,處理多執行緒,AsyncTask<填入3種型別,任意>也可以是<Void,Void,Void>,不任任何資料傳遞
    private  class MyAsyncTask extends AsyncTask<String,Integer,String>{


        @Override  //使用背景執行緒,,return會被傳入onPostExecute(String s)
        protected String doInBackground(String... params) {
            if (params[0].equals("開始下載"))
            for (int i=0;i<=100;i++){

                //Method setText must be called from the UI thread
                //要再code /@Override onProgressUpdate(){}
//                progressBarH.setProgress(i);
//                tvPercent.setText(i+"%");
                try {
                    Thread.sleep(100);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
//            Toast().show();
//            return null;
            return "下載完畢";
        }
        @Override  //使用UI執行緒
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarH.setProgress(values[0]);
            tvPercent.setText(values[0]+"%");

            progressBarH.setSecondaryProgress(90);


            progressBarS.setMax(10);
            if (values[0]%10==0)
                progressBarS.setProgress(10);
            else
                progressBarS.setProgress(values[0]%10);

            tvPercentS.setText(values[0]/10 + "/10");



            //progressBar設定setProgress無效
//            progressBar.setProgress(values[0]);

        }

        @Override//UI背景執行,在執行緒開始前要先做些什麼事
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ProgressBarEx.this,"開始下載",Toast.LENGTH_SHORT).show();
        }

        @Override//UI背景執行,在執行緒完成後要先做些什麼事
//        參數s類型取決於(String... params),在 new MyAsyncTask().execute()時傳入
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(ProgressBarEx.this,result,Toast.LENGTH_SHORT).show();

        }
    }

    //建立一個內部類別,處理多執行緒,AsyncTask<填入3種型別,任意>也可以是<Void,Void,Void>,不任任何資料傳遞
    private  class MyAsyncTask1 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            return null;
        }
    }


}



