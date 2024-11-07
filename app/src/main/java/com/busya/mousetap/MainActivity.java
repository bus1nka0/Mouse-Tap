package com.busya.mousetap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    int counter = 0;
    int x = 1;
    TextView textCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textCounter = findViewById(R.id.TapCount);
    }

    public void TapShop(View view) {
        Intent intent = new Intent(getApplicationContext(), Activity_Shop.class);
        startActivity(intent);
    }

    public void TapMouse(View view) {
        counter += x;
        String s = "You click " + counter + " times";
        textCounter.setText(s);


    }

    public void Reset(View view) {
        counter = 0;
        x = 1;
        String s = "You click " + counter + " times";
        textCounter.setText(s);

    }

    public void LevelUp(View view) {
        x +=2;
        String s = "Now you click" + x + " per one tap";
        textCounter.setText(s);

    }
}