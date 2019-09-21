package com.example.template.LoginModule;

public class LoginRouter implements LoginContract.Router {

    LoginFragment view;

    public LoginRouter(LoginFragment view) {
        this.view = view;
    }

    @Override
    public void showAlert(String title, String message) {
        //TODO: present you custom alert
    }

    @Override
    public void showLoader() {
        //TODO: present you custom loader
    }

    @Override
    public void hideLoader(final LoginContract.Hidehandler handler) {
        //TODO: hide you custom loader; on completion call: handler.loaderCompleted();
    }

}
