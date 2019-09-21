package com.example.template.Delegate;

import android.content.Context;

interface DelegateContract {

    interface View {

    }

    interface Presenter {
        void startSessionListener();

        void initFirebase(Context applicationContext);

        void showAlert(String title, String message);

        void showLoader();

        void hideLoader(Hidehandler handler);

        void showScreen(Boolean value);
    }

    interface Interactor {
        void initFirebase(Context applicationContext);

        void startSessionListener();
    }

    interface InteractorOutput {
        void activeSessionResult(Boolean result);

    }

    interface Router {
        void showAlert(String title, String message);

        void showLoader();

        void hideLoader(Hidehandler handler);

        void activeSessionResult(Boolean result);
    }

    interface Hidehandler {
        void loaderCompleted();
    }

    interface Delegate {
        void showLogin();
    }
}
