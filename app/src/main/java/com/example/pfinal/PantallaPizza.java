package com.example.pfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaPizza extends AppCompatActivity {

    private Button botPagar;

    private TextView nombrePrint;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private EditText cuponText;

    private CheckBox checkJamon, checkPepperoni, checkPinia;
    private CheckBox checkJalapenio, checkChorizo, checkTocino;

    private Switch orillaQueso;

    private OrdenPizza pizza;

    private String nombrePedido;
    private int tamanio;
    private boolean conJamon = false;
    private boolean conPepperoni = false;
    private boolean conPinia = false;
    private boolean conJalapenio = false;
    private boolean conChorizo = false;
    private boolean conTocino = false;
    private boolean conOrillaQueso = false;
    private String cupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pizza);

        Context contexto = this;

        // Nombre pedido
        nombrePrint = (TextView) findViewById(R.id.nombre_print);
        Intent intent = getIntent();
        nombrePedido = intent.getStringExtra("Nombre");
        nombrePrint.setText("Pedido: " + nombrePedido);

        // Radio button
        radioGroup = findViewById(R.id.group_size_pizza);

        // Check box
        checkJamon = (CheckBox) findViewById(R.id.pizza_ingr_jamon);
        checkPepperoni = (CheckBox) findViewById(R.id.pizza_ingr_pepperoni);
        checkPinia = (CheckBox) findViewById(R.id.pizza_ingr_pinia);
        checkJalapenio = (CheckBox) findViewById(R.id.pizza_ingr_jalapenio);
        checkChorizo = (CheckBox) findViewById(R.id.pizza_ingr_chorizo);
        checkTocino = (CheckBox) findViewById(R.id.pizza_ingr_tocino);

        // Edit text
        cuponText = (EditText) findViewById(R.id.edit_cupon);

        // Switch
        orillaQueso = findViewById(R.id.switch_orilla_queso);

        // Boton para pago
        botPagar = (Button) findViewById(R.id.buttonPay);
        botPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tamanio piza
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                // Log.d(">>>", tamanio);
                String tamanioAux = radioButton.getText().toString();
                switch (tamanioAux) {
                    case "Chica":
                        tamanio = 1;
                        break;
                    case "Mediana":
                        tamanio = 2;
                        break;
                    default:
                        tamanio = 3;
                }

                // Ingredientes
                if (checkJamon.isChecked()) {
                    conJamon = true;
                }
                if (checkPepperoni.isChecked()) {
                    conPepperoni = true;
                }
                if (checkPinia.isChecked()) {
                    conPinia = true;
                }
                if (checkJalapenio.isChecked()) {
                    conJalapenio = true;
                }
                if (checkChorizo.isChecked()) {
                    conChorizo = true;
                }
                if (checkTocino.isChecked()) {
                    conTocino = true;
                }
                //Log.d(">>>", ingredientes);

                // Cupon
                cupon = cuponText.getText().toString();
                //Log.d(">>>", cupon);

                if (orillaQueso.isChecked()) {
                    conOrillaQueso = true;
                }
                // Log.d(">>>", orilla);

                pizza = new OrdenPizza(nombrePedido, tamanio, conJamon, conPepperoni, conPinia, conJalapenio,
                        conChorizo, conTocino, conOrillaQueso, cupon);

                String ticket = pizza.toString();
                ReadWriteOrder rwOrder = new ReadWriteOrder(contexto);
                rwOrder.writeTicket(contexto, pizza.toSave());

                //Intent i = new Intent(PantallaPizza.this, PagoPizza.class);
                //startActivity(i);
                Intent intent = new Intent(getApplicationContext(), PagoPizza.class);
                intent.putExtra("Ticket", ticket);
                startActivity(intent);
            }
        });
    }
}