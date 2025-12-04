package com.example.streamplayerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfilesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profiles, container, false);

        EditText profileNameInput = view.findViewById(R.id.profile_name_input);
        Button saveProfileButton = view.findViewById(R.id.save_profile_button);

        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String profileName = profileNameInput.getText().toString();
                if (!profileName.isEmpty()) {
                    saveProfile(profileName);
                } else {
                    Toast.makeText(getContext(), "Please enter a profile name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void saveProfile(String profileName) {
        // Implementation for saving profile
        Toast.makeText(getContext(), "Profile saved: " + profileName, Toast.LENGTH_SHORT).show();
    }
}