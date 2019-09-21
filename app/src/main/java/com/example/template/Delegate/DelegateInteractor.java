package com.example.template.Delegate;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.template.Constants.FirebaseInit;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

public class DelegateInteractor implements DelegateContract.Interactor {

    DelegateContract.InteractorOutput output;

    public DelegateInteractor(DelegateContract.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void initFirebase(Context applicationContext) {
        try {
            FirebaseApp.getInstance();
        }catch (IllegalStateException ex){
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setApplicationId(FirebaseInit.GoogleAppID) // Required for Analytics.
                    .setApiKey(FirebaseInit.ApiKey) // Required for Auth.
                    .setProjectId(FirebaseInit.ProjectID)
                    .setDatabaseUrl(FirebaseInit.DatabaseURL) // Required for RTDB.
                    .setStorageBucket(FirebaseInit.StorageBucket)
                    .build();
            FirebaseApp.initializeApp(applicationContext, options);
        }
    }

    @Override
    public void startSessionListener() {
        try {
            FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if (firebaseAuth.getCurrentUser() == null){
                        Log.d("GPA", "onAuthStateChanged: NO USER");
                    }else{
                        Log.d("GPA", "onAuthStateChanged: "+ firebaseAuth.getCurrentUser().getEmail());
                        output.activeSessionResult(true);
                    }
                }
            });
        } catch (Exception ex) {
            Log.d("TG", ex.getLocalizedMessage());
        }
    }

}