package com.rowsun.myapplication.home.mvp;

import android.os.AsyncTask;
import android.util.Log;

import com.rowsun.myapplication.pojo.Hello;

public class MainModel implements MainMvp.MainModel {
   private Hello h;

    @Override
    public void getData(final OnFinishedListener listener) {
        h = new Hello(1, "Hello MVP");
        Log.d("TAG", "getData: ");
       new AsyncTask<Void, Void, String>(){

           @Override
           protected String doInBackground(Void... voids) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();

               }
               return h.getText();
           }

           @Override
           protected void onPostExecute(String s) {
               super.onPostExecute(s);
               if (s.isEmpty()){
                   listener.onFailure("Something went wrong");
               }else {

                   listener.onSuccess(s);
               }
           }
       }.execute();
    }
}
