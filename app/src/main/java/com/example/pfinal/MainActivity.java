package com.example.pfinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String ORDER_NAME = "Nombre del pedido";
    private EditText nomPedido;
    private Button opPizza;
    private Button opHamburguesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setTitle(some_string);

        // Nombre del pedido
        nomPedido = (EditText) findViewById(R.id.editOrderName);

        // Boton para pizza
        opPizza = (Button) findViewById(R.id.buttonPizza);
        opPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomPedido.getText().toString();
                Intent intent = new Intent(getApplicationContext(), PantallaPizza.class);
                intent.putExtra("Nombre", name);
                startActivity(intent);
                //Intent i = new Intent(MainActivity.this, PantallaPizza.class);
                //startActivity(i);
            }
        });

        // Boton para hamburguesa
        opHamburguesa = (Button) findViewById(R.id.buttonRecibos);
        opHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomPedido.getText().toString();
                Intent intent = new Intent(getApplicationContext(), PantallaRecibos.class);
                intent.putExtra("Nombre", name);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save_order :
                Log.d("HomeActivity", (String) "-> save_order");
                return true;
            case R.id.split_payment :
                Log.d("HomeActivity", (String) "-> split_payment");
                return true;
            case R.id.use_coupon :
                Log.d("HomeActivity", (String) "-> use_coupon");
                return true;
            case R.id.change_direction :
                Log.d("HomeActivity", (String) "-> change_direction");
                return true;
            case R.id.service_number :
                Log.d("HomeActivity", (String) "-> service_number");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    public  void pantallaPizza(View view) {
        Intent pPizza = new Intent(this, PantallaPizza.class);
        startActivity(pPizza);
    }*/
}