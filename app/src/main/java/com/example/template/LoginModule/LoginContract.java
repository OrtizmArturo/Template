package com.example.template.LoginModule;

interface LoginContract {

    interface View {

    }

    interface Presenter {
        void showAlert(String title, String message);

        void showLoader();

        void hideLoader(Hidehandler handler);
    }

    interface Interactor {

    }

    interface InteractorOutput {

    }

    interface Router {
        void showAlert(String title, String message);

        void showLoader();

        void hideLoader(Hidehandler handler);
    }

    interface Hidehandler {
        void loaderCompleted();
    }
}
