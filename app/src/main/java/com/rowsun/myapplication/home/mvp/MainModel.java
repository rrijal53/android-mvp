package com.rowsun.myapplication.home.mvp;

import android.util.Log;

import com.rowsun.myapplication.pojo.Hello;

public class MainModel implements MainMvp.MainModel {
   private Hello h;

    @Override
    public void getData(final OnFinishedListener listener) {
        h = new Hello(1, "Hello MVP");
        Log.d("TAG", "getData: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Log.d("TAG", "inside thread");

                    listener.onSuccess(h.getText());
                } catch (InterruptedException e) {
                    listener.onFailure(h.getText());
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
