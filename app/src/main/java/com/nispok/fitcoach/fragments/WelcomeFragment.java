package com.nispok.fitcoach.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nispok.fitcoach.R;

public class WelcomeFragment extends Fragment {

    private Button signInButton;
    private Button dontSignInButton;

    private WelcomeFragmentListener listener;

    public interface WelcomeFragmentListener {

        public void onSignIn();

        public void onSignInSkipped();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (WelcomeFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + WelcomeFragmentListener.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpSignInButton(view);
        setUpDontSignInButton(view);
    }

    private void setUpSignInButton(View view) {
        signInButton = (Button) view.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSignIn();
            }
        });
    }

    private void setUpDontSignInButton(View view) {
        dontSignInButton = (Button) view.findViewById(R.id.dont_sign_in_button);
        dontSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSignInSkipped();
            }
        });
    }
}
