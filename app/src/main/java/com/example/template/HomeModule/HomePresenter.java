package com.example.template.HomeModule;

public class HomePresenter implements HomeContract.Presenter, HomeContract.InteractorOutput {

    HomeFragment view;
    HomeContract.Interactor interactor = new HomeInteractor(this);
    HomeContract.Router router;

    public HomePresenter(HomeFragment view) {
        this.view = view;
        this.router = new HomeRouter(view);
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
    public void hideLoader(final HomeContract.Hidehandler handler) {
        router.hideLoader(new HomeContract.Hidehandler() {
            @Override
            public void loaderCompleted() {
                handler.loaderCompleted();
            }
        });
    }

}
