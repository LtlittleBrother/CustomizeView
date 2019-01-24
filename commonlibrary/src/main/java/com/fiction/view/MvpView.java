package com.fiction.view;

public interface MvpView {

    void showSuccess(String strMsg);

    void showFailure(int errorNo, String strMsg);

}
