package com.rowsun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.myapplication.home.mvp.MainModel;
import com.rowsun.myapplication.home.mvp.MainMvp;
import com.rowsun.myapplication.home.mvp.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainMvp.MainView {

    MainPresenter presenter;
    TextView tvHello;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = findViewById(R.id.tv_hello);
        pbar = findViewById(R.id.pbar);
        presenter = new MainPresenter(this, new MainModel());
        presenter.getHelloWorld();
    }

    @Override
    public void showLoading() {
        pbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void setHelloWorld(String s) {
        tvHello.setText(s);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
