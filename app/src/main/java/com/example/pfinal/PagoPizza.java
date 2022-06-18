package com.example.pfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PagoPizza extends AppCompatActivity {

    private TextView pizzaPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_pizza);
        // Ticket pizza
        pizzaPrint = (TextView) findViewById(R.id.pizza_print);
        Intent intent = getIntent();
        String text = intent.getStringExtra("Ticket");
        pizzaPrint.setText(text);
    }
}