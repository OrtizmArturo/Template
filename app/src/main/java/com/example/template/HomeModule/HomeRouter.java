package com.example.template.HomeModule;

public class HomeRouter implements HomeContract.Router {

    HomeFragment view;

    public HomeRouter(HomeFragment view) {
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
    public void hideLoader(final HomeContract.Hidehandler handler) {
        //TODO: hide you custom loader; on completion call: handler.loaderCompleted();
    }

}
