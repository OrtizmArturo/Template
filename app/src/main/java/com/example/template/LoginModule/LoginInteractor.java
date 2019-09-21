package com.example.template.LoginModule;

public class LoginInteractor implements LoginContract.Interactor {

    LoginContract.InteractorOutput output;

    public LoginInteractor(LoginContract.InteractorOutput output) {
        this.output = output;
    }

}