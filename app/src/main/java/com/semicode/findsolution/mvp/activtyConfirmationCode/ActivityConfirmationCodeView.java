package com.semicode.findsolution.mvp.activtyConfirmationCode;

public interface ActivityConfirmationCodeView {
    void onCounterStarted(String time);
    void onCounterFinished();
    void onCodeFailed(String msg);

    void onLogin();
//    void onFailed();
//    void onLoad();
//    void onFinishLoad();
}
