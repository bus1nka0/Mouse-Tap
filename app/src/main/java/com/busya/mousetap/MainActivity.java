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
        String y;
        int lastTwoDigits = counter % 100;
        int lastDigit = counter % 10;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            y = " раз"; // For numbers 11-14
        } else if (lastDigit == 1) {
            y = " раз"; // For numbers ending in 1 (except 11)
        } else if (lastDigit >= 2 & lastDigit <= 4 && (lastTwoDigits < 10 || lastTwoDigits >= 20)) {
            y = " раза"; // For numbers ending in 2, 3, or 4 (except 12-14)
        } else {
            y = " раз"; // Default case for other numbers
        }
        counter += 1;
        String s = "Вы тапнули " + counter + y;
        textCounter.setText(s);


    }
}