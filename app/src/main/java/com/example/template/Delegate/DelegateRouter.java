package com.example.template.Delegate;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.template.HomeModule.HomeFragment;
import com.example.template.LoginModule.LoginFragment;
import com.example.template.R;

public class DelegateRouter implements DelegateContract.Router {

    DelegateActivity view;

    LoginFragment loginFragment;
    HomeFragment homeFragment;

    public DelegateRouter(DelegateActivity view) {
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
    public void hideLoader(final DelegateContract.Hidehandler handler) {
        //TODO: hide you custom loader; on completion call: handler.loaderCompleted();
    }

    @Override
    public void activeSessionResult(Boolean result) {
        if (result) {
            presentHome();
        }else{
            presentLogin();
        }
    }

    void presentHome() {
        Thread homeThread = new Thread() {
            public void run() {
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                replaceFragmentCenter(homeFragment);
            }
        };
        homeThread.start();
    }

    void presentLogin() {
        Thread loginThread = new Thread() {
            public void run() {
                if (loginFragment == null){
                    loginFragment = new LoginFragment();
                }
                replaceFragmentCenter(loginFragment);
            }
        };
        loginThread.start();
    }

    public void replaceFragmentCenter(final Fragment frag) {
        FragmentManager manager = view.getSupportFragmentManager();
        if (manager != null){
            manager.popBackStack();
            FragmentTransaction t = manager.beginTransaction();
            Fragment currentFrag = manager.findFragmentById(R.id.frameContent);
            //Check if the new Fragment is the same
            //If it is, don't add to the back stack
            if (currentFrag != null && currentFrag.getClass().equals(frag.getClass())) {
                t.replace(R.id.frameContent, frag).commit();
            } else {
                t.replace(R.id.frameContent, frag).addToBackStack(null).commit();
            }
        }
    }

}
