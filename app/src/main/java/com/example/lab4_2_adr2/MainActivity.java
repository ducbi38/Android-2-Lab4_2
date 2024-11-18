package com.example.lab4_2_adr2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopFragment topFragment = new TopFragment();
        BottomFragment bottomFragment = new BottomFragment();

        // Thêm hai Fragment vào giao diện
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentTop, topFragment)
                .replace(R.id.fragmentBottom, bottomFragment)
                .commit();

        // Thiết lập giao tiếp giữa BottomFragment và TopFragment
        bottomFragment.setOnSendTextListener(new BottomFragment.OnSendTextListener() {
            @Override
            public void onSendText(String text) {
                topFragment.updateText(text);
            }
        });
    }
}
