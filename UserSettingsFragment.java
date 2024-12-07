package com.example.multifragmentapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UserSettingsFragment extends Fragment {

    private EditText usernameEditText, emailEditText, passwordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_settings, container, false);

        usernameEditText = view.findViewById(R.id.edit_username);
        emailEditText = view.findViewById(R.id.edit_email);
        passwordEditText = view.findViewById(R.id.edit_password);

        view.findViewById(R.id.btn_save).setOnClickListener(v -> savePreferences());
        view.findViewById(R.id.btn_reset).setOnClickListener(v -> resetPreferences());

        return view;
    }

    private void savePreferences() {
        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences preferences = requireActivity().getSharedPreferences("UserPrefs", 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(getActivity(), "Preferences saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void resetPreferences() {
        SharedPreferences preferences = requireActivity().getSharedPreferences("UserPrefs", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Toast.makeText(getActivity(), "Preferences reset successfully!", Toast.LENGTH_SHORT).show();
    }
}
