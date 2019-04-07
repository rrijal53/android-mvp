package com.rowsun.myapplication.home.mvp;

public interface MainMvp {

    public interface MainView {
        void showLoading();

        void hideLoading();

        void setHelloWorld(String s);

        void showError(String error);
        ///and other stuff
    }

    public interface MainPresenter {
        void onLoaded();

        void onDestroy();

        void getHelloWorld();

        void getOtherStuffs();

        void onSomethingOnClik(int id);

        void andManyMore();
    }

    public interface MainModel {
        interface OnFinishedListener {
            void onSuccess(String s);

            void onFailure(String error);
        }

        void getData(OnFinishedListener listener);
    }

}
