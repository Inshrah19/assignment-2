package com.example.multifragmentapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileViewFragment extends Fragment {

    private TextView usernameTextView, emailTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_view, container, false);

        usernameTextView = view.findViewById(R.id.text_username);
        emailTextView = view.findViewById(R.id.text_email);

        loadPreferences();

        return view;
    }

    private void loadPreferences() {
        SharedPreferences preferences = requireActivity().getSharedPreferences("UserPrefs", 0);

        String username = preferences.getString("username", "No Username Set");
        String email = preferences.getString("email", "No Email Set");

        usernameTextView.setText(username);
        emailTextView.setText(email);
    }
}
