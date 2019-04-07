package com.rowsun.myapplication.home.mvp;

public class MainPresenter implements MainMvp.MainPresenter, MainMvp.MainModel.OnFinishedListener {

    private MainMvp.MainView mainView;
    private MainMvp.MainModel mainModel;


    public MainPresenter(MainMvp.MainView mainView, MainMvp.MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void onLoaded() {
        // TODO: 4/7/19 initialize something in view
    }

    @Override
    public void onDestroy() {
        mainView = null;
        mainModel = null;
    }

    @Override
    public void getHelloWorld() {
        if (mainView != null) {
            mainView.showLoading();
            mainModel.getData(this);
        }
    }

    @Override
    public void getOtherStuffs() {

    }

    @Override
    public void onSomethingOnClik(int id) {

    }

    @Override
    public void andManyMore() {

    }

    @Override
    public void onSuccess(String s) {
        if (mainView != null) {
            mainView.hideLoading();
            mainView.setHelloWorld(s);
        }
    }

    @Override
    public void onFailure(String error) {
        if (mainView != null) {
            mainView.hideLoading();
            mainView.showError(error);
        }
    }
}
