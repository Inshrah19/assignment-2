package com.example.multifragmentapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the default fragment (UserSettingsFragment)
        if (savedInstanceState == null) {
            switchFragment(new UserSettingsFragment());
        }

        // Set up button click listeners for navigation
        findViewById(R.id.btn_user_settings).setOnClickListener(v ->
                switchFragment(new UserSettingsFragment()));

        findViewById(R.id.btn_profile_view).setOnClickListener(v ->
                switchFragment(new ProfileViewFragment()));
    }

    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
