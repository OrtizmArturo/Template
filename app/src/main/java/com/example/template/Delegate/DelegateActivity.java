package com.example.template.Delegate;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.template.HomeModule.HomeFragment;
import com.example.template.LoginModule.LoginFragment;
import com.example.template.R;
import com.google.firebase.FirebaseApp;

public class DelegateActivity extends AppCompatActivity implements DelegateContract.View,
        LoginFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener {

    public DelegateContract.Presenter presenter = new DelegatePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_delegate);
        presenter.showScreen(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}