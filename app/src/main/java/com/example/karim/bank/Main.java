package com.example.karim.bank;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    CardView bankomats;
    CardView valutes;
    CardView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bankomats = findViewById(R.id.CwBankomats);
        bankomats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Bankomats.class);
                startActivity(intent);
            }
        });

        valutes = findViewById(R.id.CwValuts);
        valutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Valutes.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.CwSing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
