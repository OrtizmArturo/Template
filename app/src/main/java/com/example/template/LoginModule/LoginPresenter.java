package com.example.template.LoginModule;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.InteractorOutput {

    LoginFragment view;
    LoginContract.Interactor interactor = new LoginInteractor(this);
    LoginContract.Router router;

    public LoginPresenter(LoginFragment view) {
        this.view = view;
        this.router = new LoginRouter(view);
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
    public void hideLoader(final LoginContract.Hidehandler handler) {
        router.hideLoader(new LoginContract.Hidehandler() {
            @Override
            public void loaderCompleted() {
                handler.loaderCompleted();
            }
        });
    }

}
