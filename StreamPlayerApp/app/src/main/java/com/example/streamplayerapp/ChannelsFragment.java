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

public class ChannelsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channels, container, false);

        EditText xtreamCodeInput = view.findViewById(R.id.xtream_code_input);
        EditText macCodeInput = view.findViewById(R.id.mac_code_input);
        EditText m3uUrlInput = view.findViewById(R.id.m3u_url_input);
        Button connectButton = view.findViewById(R.id.connect_button);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xtreamCode = xtreamCodeInput.getText().toString();
                String macCode = macCodeInput.getText().toString();
                String m3uUrl = m3uUrlInput.getText().toString();

                if (!xtreamCode.isEmpty()) {
                    connectToXtreamCode(xtreamCode);
                } else if (!macCode.isEmpty()) {
                    connectToMacPortal(macCode);
                } else if (!m3uUrl.isEmpty()) {
                    connectToM3u(m3uUrl);
                } else {
                    Toast.makeText(getContext(), "Please enter at least one connection method", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void connectToXtreamCode(String xtreamCode) {
        // Implementation for Xtream code connection
        Toast.makeText(getContext(), "Connecting to Xtream: " + xtreamCode, Toast.LENGTH_SHORT).show();
    }

    private void connectToMacPortal(String macCode) {
        // Implementation for MAC Portal connection
        Toast.makeText(getContext(), "Connecting to MAC Portal: " + macCode, Toast.LENGTH_SHORT).show();
    }

    private void connectToM3u(String m3uUrl) {
        // Implementation for M3U connection
        Toast.makeText(getContext(), "Connecting to M3U: " + m3uUrl, Toast.LENGTH_SHORT).show();
    }
}