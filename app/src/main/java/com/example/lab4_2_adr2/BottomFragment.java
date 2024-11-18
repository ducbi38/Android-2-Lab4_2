package com.example.lab4_2_adr2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BottomFragment extends Fragment {
    private EditText editText;
    private Button btnSend;

    private OnSendTextListener listener;

    public interface OnSendTextListener {
        void onSendText(String text);
    }

    public void setOnSendTextListener(OnSendTextListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        editText = view.findViewById(R.id.editText);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    String text = editText.getText().toString();
                    listener.onSendText(text);
                }
            }
        });

        return view;
    }
}

