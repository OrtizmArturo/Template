package com.example.template.HomeModule;

public class HomeInteractor implements HomeContract.Interactor {

    HomeContract.InteractorOutput output;

    public HomeInteractor(HomeContract.InteractorOutput output) {
        this.output = output;
    }

}