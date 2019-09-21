package com.example.template.Delegate;

import android.content.Context;

public class DelegatePresenter implements DelegateContract.Presenter, DelegateContract.InteractorOutput {

    DelegateActivity view;
    DelegateContract.Interactor interactor = new DelegateInteractor(this);
    DelegateContract.Router router;

    public DelegatePresenter(DelegateActivity view) {
        this.view = view;
        this.router = new DelegateRouter(view);
    }

    @Override
    public void startSessionListener() {
        interactor.startSessionListener();
    }

    @Override
    public void initFirebase(Context applicationContext) {
        interactor.initFirebase(applicationContext);
    }

    @Override
    public void showScreen(Boolean value) {
        router.activeSessionResult(value);
    }

    @Override
    public void showAlert(String title, String message) {
        router.showAlert(title, message);
    }

    @Override
    public void showLoader() {
        router.showLoader();
    }

    @Override
    public void hideLoader(final DelegateContract.Hidehandler handler) {
        router.hideLoader(new DelegateContract.Hidehandler() {
            @Override
            public void loaderCompleted() {
                handler.loaderCompleted();
            }
        });
    }

    @Override
    public void activeSessionResult(Boolean result) {
        router.activeSessionResult(result);
    }
}
